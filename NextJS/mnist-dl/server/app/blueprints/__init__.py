
from flask import Blueprint, make_response, jsonify, request
from PIL import Image
from app.model.model import model, device, preprocess_img, predict_digit
import io

blueprint = Blueprint("blueprint", __name__)

@blueprint.route('/mnist', methods=["POST"])
def classify_mnist_digit():
    data = {"success": False}
    if request.method == "POST":
        if request.files.get("image"):
            # read the image in PIL format
            image = request.files.get("image").read()
            image = Image.open(io.BytesIO(image))

            # preprocess the image
            image = preprocess_img(image)
            preds = predict_digit(model, device, image)
            data["success"] = True
            data["predictions"] = preds  
        else:
            data["success"] = True
            data["predictions"] = None
    return make_response(jsonify(data)), 200