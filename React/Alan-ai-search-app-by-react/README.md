```
Install  Dependencies:

npm i @alan-ai/alan-sdk-web

```

```
Quick start:

To run this app , do npm i to install all the dependencies, then follow these steps:

1. git clone https://github.com/abhijeet007rocks8/Dev-Scripts.git

2. cd React

3. cd Alan-ai-search-app-by-react

4. Go to Alan Ai official website, Link:  https://alan.app/

5. create a account

6. create a project and paste the given code to make your assistant understand and response on  some particular questions , you can add further more responses to make your assistant more intelligent.


intent('What does this app do?','What can I do here?',
      reply('This is Voice search Application.'));

let savedArticles=[];

//intent("Start a command",(p)=>{
  //    p.play('Hello,I understood your command.');
//})
const API_KEY="883556aea8aa4b4dae50c25d25cf2c00";

// News by search

intent("Give me the news from $(source* (.*))",(p)=>{
    let NEWS_API_URL=`https://newsapi.org/v2/top-headlines?apiKey=${API_KEY}`;
    
    if(p.source.value){
        NEWS_API_URL=`${NEWS_API_URL}&sources=${p.source.value.toLowerCase().split(" ").join('-')}`
    }
    api.request(NEWS_API_URL,(error,response,body)=>{
        const {articles}= JSON.parse(body);
        
        if(!articles.length){
            p.play('Sorry,please try searching from different source');
            return;
        }
        savedArticles=articles;
        
        p.play({command:"newHeadlines",articles});
        p.play(`Here are the (latest|recent) ${p.source.value}.`);
        
         p.play("Would you like me to read the headlines?");
        p.then(confirmation);
    });
})
//news by Term
intent("what\'s up with $(term* (.*))",(p)=>{
    let NEWS_API_URL=`https://newsapi.org/v2/everything?apiKey=${API_KEY}`;
    
    if(p.term.value){
        NEWS_API_URL=`${NEWS_API_URL}&q=${p.term.value}`
    }
    api.request(NEWS_API_URL,(error,response,body)=>{
        const {articles}= JSON.parse(body);
        
        if(!articles.length){
            p.play('Sorry,please try searching for something else.');
            return;
        }
        savedArticles=articles;
        
        p.play({command:"newHeadlines",articles});
        p.play(`Here are the (latest|recent) articles on ${p.term.value}.`);
        
         p.play("Would you like me to read the headlines?");
        p.then(confirmation);
    });
})

//news by category

const CATEGORIES = ['business', 'entertainment', 'general', 'health', 'science', 'sports', 'technology'];
const CATEGORIES_INTENT = `${CATEGORIES.map((category) => `${category}~${category}`).join('|')}|`;

intent(`(show|what is|tell me|what's|what are|what're|read) (the|) (recent|latest|) $(N news|headlines) (in|about|on|) $(C~ ${CATEGORIES_INTENT})`,
  `(read|show|get|bring me|give me) (the|) (recent|latest) $(C~ ${CATEGORIES_INTENT}) $(N news|headlines)`, (p) => {
    

    let NEWS_API_URL=`https://newsapi.org/v2/top-headlines?apiKey=${API_KEY}`;
    
    if(p.C.value){
        NEWS_API_URL=`${NEWS_API_URL}&category=${p.C.value}`
    }
    api.request(NEWS_API_URL,(error,response,body)=>{
        const {articles}= JSON.parse(body);
        
        if(!articles.length){
            p.play('Sorry,please try searching for something else.');
            return;
        }
        savedArticles=articles;
        
        p.play({command:"newHeadlines",articles});
        if (p.C.value){
        p.play(`Here are the (latest|recent) articles on ${p.C.value}.`);           
        }
        else{
        p.play(`Here are the (latest|recent) news.`);           
        }
        p.play("Would you like me to read the headlines?");
        p.then(confirmation);
    });
});
const confirmation =context(()=>{
    intent('yes', async(p)=>{
       for(let i=0;i<savedArticles.length;i++){
           p.play({command:'highlight',article:savedArticles[i]});
           p.play(`${savedArticles[i].title}`);
       } 
    })
    intent('no',(p)=>{
        p.play('Sure,It sounds good to me.');
    })
    
})
```


```
Working video:

https://user-images.githubusercontent.com/82238106/170539675-954cecab-c8de-467e-a5bb-d6e88326ec0d.mp4

```






