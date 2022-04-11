const canvas = document.getElementById("canvas");
const ctx = canvas.getContext("2d");

let img = new Image();
let fileName = "";

const downloadBtn = document.getElementById("download-btn");
const uploadFile = document.getElementById("upload-file");
const revertBtn = document.getElementById("revert-btn");


document.addEventListener("click", (e) => {
    if (e.target.classList.contains("filter-btn")) {
        if (e.target.classList.contains("brightness-add")) {
            Caman("#canvas", img, function() {
                this.brightness(5).render();
            });
        } else if (e.target.classList.contains("brightness-remove")) {
            Caman("#canvas", img, function() {
                this.brightness(-5).render();
            });
        } else if (e.target.classList.contains("contrast-add")) {
            Caman("#canvas", img, function() {
                this.contrast(5).render();
            });
        } else if (e.target.classList.contains("contrast-remove")) {
            Caman("#canvas", img, function() {
                this.contrast(-5).render();
            });
        } else if (e.target.classList.contains("saturation-add")) {
            Caman("#canvas", img, function() {
                this.saturation(5).render();
            });
        } else if (e.target.classList.contains("saturation-remove")) {
            Caman("#canvas", img, function() {
                this.saturation(-5).render();
            });
        } else if (e.target.classList.contains("vibrance-add")) {
            Caman("#canvas", img, function() {
                this.vibrance(5).render();
            });
        } else if (e.target.classList.contains("vibrance-remove")) {
            Caman("#canvas", img, function() {
                this.vibrance(-5).render();
            });
        } else if (e.target.classList.contains("vintage-add")) {
            Caman("#canvas", img, function() {
                this.vintage().render();
            });
        } else if (e.target.classList.contains("lomo-add")) {
            Caman("#canvas", img, function() {
                this.lomo().render();
            });
        } else if (e.target.classList.contains("clarity-add")) {
            Caman("#canvas", img, function() {
                this.clarity().render();
            });
        } else if (e.target.classList.contains("sincity-add")) {
            Caman("#canvas", img, function() {
                this.sinCity().render();
            });
        } else if (e.target.classList.contains("crossprocess-add")) {
            Caman("#canvas", img, function() {
                this.crossProcess().render();
            });
        } else if (e.target.classList.contains("pinhole-add")) {
            Caman("#canvas", img, function() {
                this.pinhole().render();
            });
        } else if (e.target.classList.contains("nostalgia-add")) {
            Caman("#canvas", img, function() {
                this.nostalgia().render();
            });
        } else if (e.target.classList.contains("hermajesty-add")) {
            Caman("#canvas", img, function() {
                this.herMajesty().render();
            });
        }
    }
});

revertBtn.addEventListener("click", (e) => {
    Caman("#canvas", img, function() {
        this.revert();
    });
});

uploadFile.addEventListener("change", () => {

    const file = document.getElementById("upload-file").files[0];

    const reader = new FileReader();


    if (file) {

        fileName = file.name;

        reader.readAsDataURL(file);
    }


    reader.addEventListener(
        "load",
        () => {

            img = new Image();

            img.src = reader.result;

            img.onload = function() {
                canvas.width = img.width;
                canvas.height = img.height;
                ctx.drawImage(img, 0, 0, img.width, img.height);
                canvas.removeAttribute("data-caman-id");
            };
        },
        false
    );
});


downloadBtn.addEventListener("click", () => {

    const fileExtension = fileName.slice(-4);

    let newFilename;

    if (fileExtension === ".jpg" || fileExtension === ".png") {

        newFilename = fileName.substring(0, fileName.length - 4) + "-edited.jpg";
    }


    download(canvas, newFilename);
});


function download(canvas, filename) {

    let e;

    const link = document.createElement("a");


    link.download = filename;
    link.href = canvas.toDataURL("image/jpeg", 0.8);

    e = new MouseEvent("click");

    link.dispatchEvent(e);
}