from app.api import app
from flask import make_response, jsonify
from app.blueprints import blueprint
app.register_blueprint(blueprint, url_prefix="/api")

# class AppConfig:
#     PORT = 3001
#     DEBUG = False
    
@app.route('/', methods=["GET"])
def meta():
    meta ={
        "programmer": "@crispengari",
        "main": "computer vision (cv)",
        "description": "given a hand written image of a digit, the goal is to classify the digit on the image from zero to nine.",
        "language": "python",
        "library": "pytorch"
    }
    return make_response(jsonify(meta)), 200

# if __name__ == "__main__":
#     app.run(debug=AppConfig().DEBUG, port=AppConfig().PORT, )