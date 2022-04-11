import firebase from "firebase";

var firebaseConfig = {
    apiKey: "AIzaSyBBS_S4ABudwXwkbz6onhe20yw80eO8DdM",
    authDomain: "todo-app-9da99.firebaseapp.com",
    projectId: "todo-app-9da99",
    storageBucket: "todo-app-9da99.appspot.com",
    messagingSenderId: "818481636206",
    appId: "1:818481636206:web:ac0fda8fad4faea913577f"
  };
  
  firebase.initializeApp(firebaseConfig);
  const db = firebase.firestore();
  export {db}