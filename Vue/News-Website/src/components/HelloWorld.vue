<template>
  <div class="hello">
    <nav class="bg-gray-200 flex ml-5 mt-6">
      <div class="ert">
        <img src="../assets/logo.png" alt="" class="image">
      </div>
      <div class="flex space-x-8" id="nav-it">
        <a href="#" id="link" class="text-gray-400 px-3 py-2 text-sm font-medium" aria-current="page" v-bind:class="[ho?'foc':'']" @click="general">Home</a>

            <a href="#" id="link" class="text-gray-400 px-3 py-2 rounded-md text-sm font-medium" v-bind:class="[w?'foc':'']" @click="world">World</a>

            <a href="#" id="link" class="text-gray-400 px-3 py-2 rounded-md text-sm font-medium" v-bind:class="[b?'foc':'']" @click="business">Business</a>

            <a href="#" id="link" class="text-gray-400 px-3 py-2 rounded-md text-sm font-medium" v-bind:class="[t?'foc':'']" @click="technology">Technology</a>

            <a href="#" id="link" class="text-gray-400 px-3 py-2 rounded-md text-sm font-medium" v-bind:class="[e?'foc':'']" @click="entertainment">Entertainment</a>

            <a href="#" id="link" class="text-gray-400 px-3 py-2 rounded-md text-sm font-medium" v-bind:class="[sp?'foc':'']" @click="sports">Sports</a>

            <a href="#" id="link" class="text-gray-400 px-3 py-2 rounded-md text-sm font-medium" v-bind:class="[sc?'foc':'']" @click="science">Science</a>

            <a href="#" id="link" class="text-gray-400 px-3 py-2 rounded-md text-sm font-medium" v-bind:class="[he?'foc':'']" @click="health">Health</a>
      </div>
    </nav>
    <br>
    <c-text fontSize="6xl" style="margin-left: 7%;" color="vue.400">{{ query }}</c-text>
    <br>
    <br>
      <c-box  background="" height="80px" style="margin-left: 7%;">
      <c-flex >
        <c-box>
          <c-image v-bind:src="news[6].urlToImage" h="410px" w="1420px" style="border-radius: 10px;" alt="Jonathan Bakebwa" />
        </c-box>
        <c-box style="margin:0 20px;margin-right: 5%;">
          <c-text fontSize="sm" color="gray.500" >{{ news[6].publishedAt.split("T")[0] }}</c-text>
        <c-text fontSize="4xl" color="gray.900" style="margin-right:1%">{{ news[6].title }} </c-text>
        <c-text fontSize="sm" color="gray.600">{{ news[6].description }}</c-text>
        </c-box>
       </c-flex>
       </c-box>
   
    <br>
    <br>
    <br>
  <c-simple-grid :columns="3" :spacing="2" style="margin-left: 7%;">
    <c-box height="80px" v-for="(neww,index) in news" :key="index" style="margin-top: 50vh;" class="tollf">
      <c-box>
          <c-image v-bind:src="neww.urlToImage" h="180px" w="320px" style="border-radius: 10px;" alt="Jonathan Bakebwa" />
      </c-box>
      <c-text fontSize="sm" color="gray.500" style="padding-right:10%;">{{ neww.publishedAt.split("T")[0] }}</c-text>
      <c-text fontSize="xl" color="gray.900" style="padding-right:10%;">{{ neww.title }}</c-text>
      <span><c-text fontSize="sm" color="gray.600" style="padding-right: 10%;">{{ neww.description }} <br><a :href="neww.url">Read More</a></c-text></span>
    </c-box>
</c-simple-grid>

<footer class="bg-gray-200" style="margin-top:55vh;">
  <h2 style="font-size: 45px;text-align:center;"><span style="color: #41B883;">Vue</span> News</h2>
</footer>
  </div>
</template>

<script>
import { CSimpleGrid,CImage,CText,CFlex,CBox } from '@chakra-ui/vue'
export default {
  name: 'HelloWorld',
  components:{
    CSimpleGrid,
    CImage,
    CText,
    CFlex,
    CBox
  },
  data () {
    return{
      api_key: '7893b2ce00eb479fab951d6beda30c25',
      headspo: '',
      worldsurl: 'https://newsapi.org/v2/top-headlines/sources?&apiKey=',
      businessurl: 'https://newsapi.org/v2/top-headlines?country=in&category=business&apiKey=',
      entertainurl: 'https://newsapi.org/v2/top-headlines?country=in&category=entertainment&apiKey=',
      healthurl: 'https://newsapi.org/v2/top-headlines?country=in&category=health&apiKey=',
      scienceurl: 'https://newsapi.org/v2/top-headlines?country=in&category=science&apiKey=',
      sportsurl: 'https://newsapi.org/v2/top-headlines?country=in&category=sports&apiKey=',
      techurl: 'https://newsapi.org/v2/top-headlines?country=in&category=technology&apiKey=',
      genurl: 'https://newsapi.org/v2/top-headlines?country=in&apiKey=',
      query: '',
      news: {},
      ho: true,
      he:false,
      w:false,
      b:false,
      t:false,
      e:false,
      sp:false,
      sc:false,
    }
  },
  methods:{
    fetchbus(){
        fetch(`https://newsapi.org/v2/top-headlines?country=in&category=business&apiKey=${this.api_key}`).then(res=>{
          return res.json();
        }).then(this.setResults);
        
        this.value="";
      },
    fetchsci(){
        fetch(`https://newsapi.org/v2/top-headlines?country=in&category=science&apiKey=${this.api_key}`).then(res=>{
          return res.json();
        }).then(this.setResults);
        
        this.value="";
      },
    fetchtech(){
        fetch(`https://newsapi.org/v2/top-headlines?country=in&category=technology&apiKey=${this.api_key}`).then(res=>{
          return res.json();
        }).then(this.setResults);
        
        this.value="";
      },
    fetchheal(){
        fetch(`https://newsapi.org/v2/top-headlines?country=in&category=health&apiKey=${this.api_key}`).then(res=>{
          return res.json();
        }).then(this.setResults);
        
        this.value="";
      },
    fetchenter(){
        fetch(`https://newsapi.org/v2/top-headlines?country=in&category=entertainment&apiKey=${this.api_key}`).then(res=>{
          return res.json();
        }).then(this.setResults);
        
        this.value="";
      },
    fetchgen(){
        fetch(`https://newsapi.org/v2/top-headlines?country=in&category=general&apiKey=${this.api_key}`).then(res=>{
          return res.json();
        }).then(this.setResults);
        
        this.value="";
      },
    fetchspo(){
        fetch(`https://newsapi.org/v2/top-headlines?country=in&category=sports&apiKey=${this.api_key}`).then(res=>{
          return res.json();
        }).then(this.setResults);
        
        this.value="";
      },
    fetchwor(){
        fetch(`https://newsapi.org/v2/top-headlines?country=us&category=general&apiKey=${this.api_key}`).then(res=>{
          return res.json();
        }).then(this.setResults);
        
        this.value="";
      },
      setResults(results){
        this.news = results.articles;
      },
      business(){
        this.query="Business";
        this.ho=false;
        this.he=false;
        this.w=false;
        this.b=true;
        this.t=false;
        this.e=false;
        this.sp=false;
        this.sc=false;
        this.fetchbus();
      },
      technology(){
        this.query="Technology";
        this.ho=false;
        this.he=false;
        this.w=false;
        this.t=true;
        this.b=false;
        this.e=false;
        this.sp=false;
        this.sc=false;
        this.fetchtech();
      },
      science(){
        this.query="Science";
        this.ho=false;
        this.he=false;
        this.w=false;
        this.b=false;
        this.t=false;
        this.e=false;
        this.sp=false;
        this.sc=true;
        this.fetchsci();
      },
      sports(){
        this.query="Sports";
        this.ho=false;
        this.he=false;
        this.w=false;
        this.b=false;
        this.t=false;
        this.e=false;
        this.sp=true;
        this.sc=false;
        this.fetchspo();
      },
      health(){
        this.query="Health";
        this.ho=false;
        this.he=true;
        this.w=false;
        this.b=false;
        this.t=false;
        this.e=false;
        this.sp=false;
        this.sc=false;
        this.fetchheal();
      },
      general(){
        this.query="Headlines";
        this.ho=true;
        this.he=false;
        this.w=false;
        this.b=false;
        this.t=false;
        this.e=false;
        this.sp=false;
        this.sc=false;
        this.fetchgen();
      },
      entertainment(){
        this.query="Entertainment";
        this.ho=false;
        this.he=false;
        this.w=false;
        this.b=false;
        this.t=false;
        this.e=true;
        this.sp=false;
        this.sc=false;
        this.fetchenter();
      },
      world(){
        this.query="World";
        this.ho=false;
        this.he=false;
        this.w=true;
        this.b=false;
        this.t=false;
        this.e=false;
        this.sp=false;
        this.sc=false;
        this.fetchwor();
      }
  },
  created(){
    this.query="Headlines";
    this.fetchgen();
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Fredoka&display=swap');
.hello{
  font-family: 'Fredoka', sans-serif !important;
}
#nav-it{
  margin-left:24%; 
}
#nav-it ul{
  position: absolute;
  width: 400px; height: 50px;
  top: 50%; left: 50%;
  margin-top: -25px; margin-left: -200px;
  padding: 0px;
  list-style: none;
  text-align: center;
  
}

#nav-it li{
  position: relative;
  font-size: 20px;
  display: inline-block;
  padding: 0px 15px;
  
}
.tollf:hover {
  transform: scale(1.05);
  overflow:visible;
  background-color: #E5E7EB; 
}
#nav-it a{
  text-decoration: none;
  
}


#nav-it #link{
  position: relative;
}

#nav-it #link:after{
  content: '';
  position: absolute;
  width: 0; height: 3px;
  display: block;
  margin-top: 5px;
  right: 0;
  background: #41B883;
  border-radius:20%;
  transition: width .2s ease;
  -webkit-transition: width .2s ease;
}
 
#nav-it #link:hover:after{
  width: 100%;
  left: 0;
  background: #41B883;
  border-radius:20%;
}
.foc #link:after{
  width: 100%;
  left: 0;
  background: #41B883;
  border-radius:20%;
}
.foc{
  color: #41B883;
}
#nav-it a:hover {
  text-decoration: none;
  color: #41B883;
}

.image{
  width: 30px;
  height: 30px;
  margin-top: 5px;
  margin-left: 2px;
}
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
/*a {
  color: #42b983;
}*/
.ert{
  border-radius: 50%;
  border:3px solid #41B883;
  width: 40px;
  height: 40px;
}
</style>
