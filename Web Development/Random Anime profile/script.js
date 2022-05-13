const getBtn = document.querySelector('.get-anime')
const animeBox = document.querySelector('.anime-box')
const anime = document.querySelector('.anime')
const animeNamme = document.querySelector('.hero-name')

const api_url = `https://api.catboys.com/img`

getBtn.addEventListener('click', async function () {
    const response = await fetch(api_url)
    const data = await response.json()
    anime.src = data.url
    animeNamme.textContent = data.artist
    animeBox.style.display = 'block'

})