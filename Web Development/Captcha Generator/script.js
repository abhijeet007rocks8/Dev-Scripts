let captcha = document.querySelector('.captcha_text');
let reloadbtn = document.querySelector('.reload_btn');
let inputfield= document.querySelector('.captcha_check');
let checkbtn = document.querySelector('.check_btn');
let status = document.querySelector('.status');

let captchacharcter = ['A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',0,1,2,3,4,5,6,7,8,9];

function generatecaptcha(){
    captcha.innerHTML='';
    for(var i=0;i<6;i++){
        var randomcaptcha = captchacharcter[Math.floor(Math.random()*captchacharcter.length)];
       captcha.innerHTML+= ' '+randomcaptcha;
    }
}

function checkcaptcha(){
    rightcaptcha = captcha.innerText;
    usercaptcha = inputfield.value;

    if(usercaptcha.replaceAll(' ','')==rightcaptcha.replaceAll(' ','')){
        status.style.display='block';
        status.innerHTML='Matched';
        status.style.color='green';
        
    }
    else{
        status.style.display='block';
        status.innerHTML='Not Matched.Try Again!';
        status.style.color='red';
    }
}
generatecaptcha();