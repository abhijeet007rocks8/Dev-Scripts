const wrapper = document.querySelector('.wrapper'), // variables declaration 
qrInput = wrapper.querySelector('.form input'),
generateBtn = wrapper.querySelector('.form button'),
qrImg = wrapper.querySelector('.qr-code img');

//function start 
generateBtn.addEventListener ('click', () => {
    let qrValue = qrInput.value;
    if (!qrValue) return;
    qrImg.src = `https://api.qrserver.com/v1/create-qr-code/?size=170x170&data=${qrValue}`; // qr-code api
    wrapper.classList.add('active');
});
