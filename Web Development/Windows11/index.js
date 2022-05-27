let startmenu=document.getElementsByClassName('startmenu')[0];
let taskbar=document.getElementsByClassName('taskbar')[0];
taskbar.addEventListener('click',()=>{
    if(startmenu.style.bottom=="-655px"){
        startmenu.style.bottom="45px";
    }
    else{
        startmenu.style.bottom="-655px";
    }
})