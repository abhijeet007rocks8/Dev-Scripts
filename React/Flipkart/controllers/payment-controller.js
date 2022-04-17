const https = require("https");
const Order = require("../models/orderSchema");
const Cart = require("../models/cartSchema");
var PaytmChecksum = require("../paytm/PaytmChecksum");
require("dotenv").config({ path: "./.env" });

const hostName = process.env.HOST_NAME;

const paytmGatway = async (req, res) => {
  try {
    let paytmMerchantkey = process.env.MERCHANT_KEY;
    let paytmParams = {};
    paytmParams["MID"] = process.env.MID;
    paytmParams["WEBSITE"] = process.env.WEBSITE;
    paytmParams["CHANNEL_ID"] = process.env.CHANNEL_ID;
    paytmParams["INDUSTRY_TYPE_ID"] = process.env.INDUSTRY_TYPE;
    paytmParams["ORDER_ID"] = req.body?.orderId.toString();
    paytmParams["CUST_ID"] = req.body?.custId.toString();
    paytmParams["TXN_AMOUNT"] = req.body?.totalAmount.toString();
    paytmParams["CALLBACK_URL"] = `${hostName}/payment/paytmresponse`;
    paytmParams["MOBILE_NO"] = req.body?.phone.toString();

    let paytmCheckSum = await PaytmChecksum.generateSignature(
      paytmParams,
      paytmMerchantkey
    );
    let params = {
      ...paytmParams,
      CHECKSUMHASH: paytmCheckSum,
    };

    res.json(params);
  } catch (error) {
    console.log(error);
    res.status(400).json(error);
  }
};

const paytmDataResponse = async (req, res) => {
  let paytmCheckSum = req.body.CHECKSUMHASH;
  delete req.body.CHECKSUMHASH;

  var isVerifySignature = PaytmChecksum.verifySignature(
    req.body,
    process.env.MERCHANT_KEY,
    paytmCheckSum
  );

  if (isVerifySignature) {
    var paytmParams = {};
    paytmParams["MID"] = req.body.MID;
    paytmParams["ORDERID"] = req.body.ORDERID;

    PaytmChecksum.generateSignature(paytmParams, process.env.MERCHANT_KEY).then(
      function (checksum) {
        paytmParams["CHECKSUMHASH"] = checksum;

        var post_data = JSON.stringify(paytmParams);

        var options = {
          hostname: "securegw-stage.paytm.in",
          port: 443,
          path: "/order/status",
          method: "POST",
          headers: {
            "Content-Type": "application/json",
            "Content-Length": post_data.length,
          },
        };

        var response = "";
        var post_req = https.request(options, function (post_res) {
          post_res.on("data", function (chunk) {
            response += chunk;
          });

          post_res.on("end", async function () {
            let result = JSON.parse(response);

            if (result.STATUS === "TXN_SUCCESS") {
              try {
                //update payment Status and transaction id

                await Order.updateOne(
                  { _id: result.ORDERID },
                  { transactionId: result.TXNID, paymentStatus: "Completed" }
                );

                //CLear Cart
                const { userId } = await Order.findOne({ _id: result.ORDERID });
                await Cart.deleteMany({ userId: userId });
              } catch (error) {
                console.log(error);
              } finally {
                res.redirect(`${hostName}/order-success`);
              }
            } else {
              try {
                await Order.deleteOne({ _id: result.ORDERID });
              } catch (error) {
                console.log(error);
              } finally {
                res.redirect(`${hostName}/order-failed`);
              }
            }
          });
        });
        post_req.write(post_data);
        post_req.end();
      }
    );
  } else {
    console.log("Checksum Mismatched");
  }
};

module.exports = { paytmGatway, paytmDataResponse };
