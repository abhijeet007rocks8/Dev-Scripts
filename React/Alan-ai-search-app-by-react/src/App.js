import React, { useEffect, useState } from 'react'
import alanBtn from "@alan-ai/alan-sdk-web"

import NewsCards from './components/NewsCards/NewsCards';
import NewsCard from './components/NewsCard/NewsCard';
import useStyles from "./styles.js";

import Ai from "./images/ai.png"

const alanKey="your_alan_key";


function App() {
    const [newsArticles,setNewsArticles]=useState([]);
    const [activeArticle,setActiveArticles]=useState(-1);

    const classes=useStyles();

    useEffect(()=>{
        alanBtn({
            key:alanKey,
            onCommand:({command,articles})=>{
                if(command=== 'newHeadlines'){
                    setNewsArticles(articles);
                    setActiveArticles(-1);
                }
                else if(command === "highlight")
                    setActiveArticles((prevActiveArticle)=>prevActiveArticle+1);
            }
        })
    },[])
  return (
    <div>
    
    <div className={classes.logoContainer}>
            <img src={Ai}/>
       </div>
        <NewsCards
            articles={newsArticles}
            activeArticle={activeArticle}
        />
      
    </div>
  )
}

export default App;