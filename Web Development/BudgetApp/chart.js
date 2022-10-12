    // NEW FUNCTION
    // UPDATE CHART
    // 

    const chart = document.querySelector(".chart");

    const canvas = document.createElement("canvas");
    canvas.width = 80;
    canvas.height = 80;

    chart.appendChild(canvas);
    const ctx = canvas.getContext("2d");
    // ctx.arc(x,y,Radius,startAngle,endAngle,anticlockwise);
    // Circle Radius 20px
    ctx.lineWidth=12;
    const R = 32;

    function drawCircle(color, ratio, anticlockwise) {
        ctx.strokeStyle = color;
        ctx.beginPath();
        ctx.arc(canvas.width / 2, canvas.height / 2, R, 0, ratio * 2 * Math.PI, anticlockwise);
        ctx.stroke();
    }
    function updateChart(income, outcome) {
        ctx.clearRect(0, 0, canvas.width, canvas.height);
        let ratio = income / (income + outcome);
        drawCircle("#FFFFFF", -ratio, true);
        drawCircle("#F0624D", 1 - ratio, false)
    }
    //