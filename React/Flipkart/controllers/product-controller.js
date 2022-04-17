const Product = require("../models/productSchema");

const getProducts = async (req, res) => {
  try {
    const result = await Product.find({});
    res.json(result);
  } catch (error) {
    res.status(500).json({ error: error });
  }
};

const getProductsByCategory = async (req, res) => {
  const cName = req.params.categoryName;
  try {
    if (cName === "top deals") {
      const result = await Product.find({}).skip(15);
      res.json(result);
    } else if (cName === "top offers") {
      const result = await Product.find({}).skip(5);
      res.json(result);
    } else {
      const result = await Product.find({ category: cName });
      res.json(result);
    }
  } catch (error) {
    res.status(500).json({ error: error });
  }
};

const getProductById = async (req, res) => {
  const productId = req.params.id;
  try {
    const result = await Product.findById(productId);
    res.json(result);
  } catch (error) {
    res.status(500).json({ error: error });
  }
};

const addProduct = async (req, res) => {
  const productData = {
    url: "https://rukminim1.flixcart.com/image/416/416/kcuug7k0/dining-table/n/g/g/4-seater-rosewood-sheesham-kw-ki128-kendalwood-furniture-natural-original-imaftwyq6jyycg67.jpeg?q=70",
    detailUrl:
      "https://rukminim1.flixcart.com/image/416/416/kcuug7k0/dining-table/n/g/g/4-seater-rosewood-sheesham-kw-ki128-kendalwood-furniture-natural-original-imaftwyrv4zvtez2.jpeg?q=70",
    title: {
      shortTitle: "Kendalwood Furniture Solid Wood 4 Seater Dining Table",
      longTitle:
        "Kendalwood Furniture Solid Wood 4 Seater Dining Table  (Finish Color - Natural Teak, DIY(Do-It-Yourself))",
    },
    price: {
      mrp: 6501,
      cost: 15000,
      discount: "56%",
    },
    discount: "Extra ₹723 off",
    tagline: "Trending",
    category: "furniture",
  };
  try {
    const product = new Product(productData);
    await product.save();
    res.json();
  } catch (error) {
    console.log(error);
    res.status(500).json({ error: error });
  }
};

module.exports = {
  getProducts,
  getProductsByCategory,
  getProductById,
  addProduct,
};
