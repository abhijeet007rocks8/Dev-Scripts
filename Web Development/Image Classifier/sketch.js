const img = document.getElementById("img"); // The image we want to classify
const inputFile_img = document.getElementById("input_img");
const upload_img = document.getElementById("upload_img");

const prediction_img = document.getElementById("prediction_img"); // The result tag in the HTML

inputFile_img.onchange = function () {
  let input = this.files[0];
  //Displaying the Uploaded Image
  img.src = window.URL.createObjectURL(input);
  upload_img.innerHTML = "Image Uploaded Successfully!";
  img.style.border = "auto";
  prediction_img.innerHTML = "Prediction Loading ...";

  //Loading model

  // Initialize the Image Classifier method with MobileNet
  ml5
    .imageClassifier("MobileNet")
    .then((classifier) => classifier.classify(img))
    .then((results) => {
      console.log(results);
      prediction_img.innerHTML =
        results[0].label + results[0].confidence.toFixed(4);
    });
};

const video = document.getElementById("video"); // The video we want to classify
const upload_vid = document.getElementById("upload_vid");

const prediction_vid = document.getElementById("prediction_vid"); // The result tag in the HTML
upload_vid.onclick = function () {
  upload_vid.innerHTML = "WebCam detected video Successfully!";
  video.style.border = "auto";
  prediction_vid.innerHTML = "Prediction Loading ...";

  // Create a webcam capture
  navigator.mediaDevices.getUserMedia({ video: true }).then((stream) => {
    video.srcObject = stream;
    video.play();
  });

  const loop = (classifier) => {
    classifier.classify().then((results) => {
      prediction_vid.innerText =
        results[0].label + results[0].confidence.toFixed(4);
      loop(classifier); // Call again to create a loop
    });
  };

  // Initialize the Image Classifier method with MobileNet passing the video as the
  // second argument and the getClassification function as the third
  ml5
    .imageClassifier("MobileNet", video)
    .then((classifier) => loop(classifier));
};
