import styles from "../styles/Home.module.css";
import { NextPage } from "next";
import Header from "../components/Header/Header";
import Footer from "../components/Footer/Footer";
import React from "react";
import CanvasDraw from "react-canvas-draw";
import {
  Chart as ChartJS,
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  Tooltip,
  Legend,
} from "chart.js";
import { Bar } from "react-chartjs-2";

ChartJS.register(
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  Tooltip,
  Legend
);

const options = {
  responsive: true,
  plugins: {
    legend: {
      position: false,
    },
    title: {
      display: true,
      text: "Probability Distribution",
    },
  },
  scales: {
    x: {
      grid: {
        display: false,
      },
    },
    y: {
      grid: {
        display: false,
      },
    },
  },
};
const data = {
  labels: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9],
  datasets: [
    {
      data: Array(10)
        .fill(0)
        .map((e) => Math.random()),
      backgroundColor: "#1bc096",
    },
  ],
};

const dataURLtoFile = (dataurl, filename) => {
  var arr = dataurl.split(","),
    mime = arr[0].match(/:(.*?);/)[1],
    bstr = atob(arr[1]),
    n = bstr.length,
    u8arr = new Uint8Array(n);
  while (n--) {
    u8arr[n] = bstr.charCodeAt(n);
  }
  return new File([u8arr], filename, { type: mime });
};
const Home: NextPage = ({}) => {
  const canvasRef = React.useRef<any>(null);
  const [data, setData] = React.useState(null);
  const [predicted, setPredicted] = React.useState<any>();
  return (
    <div className={styles.app}>
      <Header />
      <div className={styles.app}>
        <div className={styles.app__main}>
          <div className={styles.app__main__canvas}>
            <p>Draw a number at the center of the canvas.</p>
            <div className={styles.app__main__canvas__buttons}>
              <button
                onClick={() => {
                  canvasRef.current?.clear();
                }}
              >
                CLEAR
              </button>
            </div>
            <CanvasDraw
              className={styles.app__main__board}
              ref={canvasRef}
              style={{
                width: 300,
                height: 300,
                backgroundColor: "black",
              }}
              brushColor="white"
              catenaryColor="black"
              brushRadius={5}
              mouseZoomFactor={0.001}
              hideGrid={true}
              onChange={async (e) => {
                const base64 = canvasRef.current?.getDataURL("jpeg");
                const file = await dataURLtoFile(base64, "number");
                let formData = new FormData();
                formData.append("image", file);
                await fetch("http://localhost:3001/api/mnist", {
                  method: "POST",
                  body: formData,
                })
                  .then((res) => res.json())
                  .then((data) => {
                    setPredicted(data.predictions.prediction);
                    setData({
                      labels: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9],
                      datasets: [
                        {
                          data: data.predictions.all.map(
                            (ele) => ele.probability
                          ),
                          backgroundColor: "#1bc096",
                        },
                      ],
                    });
                  });
              }}
            />
            {predicted ? (
              <div className={styles.app__main__label}>
                <h1>{`${predicted.class_name} (${predicted.label})`}</h1>
                <p>{`${predicted.probability.toFixed(2)} chance of being a (${
                  predicted.label
                }).`}</p>
              </div>
            ) : (
              <p>Draw a number first.</p>
            )}
          </div>
          <div className={styles.app__main__chart}>
            <h1>Probability of Numbers.</h1>
            {!data ? (
              <p>Draw a number first.</p>
            ) : (
              <Bar
                style={{
                  width: 300,
                }}
                options={options as any}
                data={data}
              />
            )}
          </div>
        </div>
      </div>
      <Footer />
    </div>
  );
};

export default Home;
