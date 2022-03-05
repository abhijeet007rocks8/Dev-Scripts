import Vue from 'vue'
import App from './App.vue'
import Chakra,{ CThemeProvider } from '@chakra-ui/vue'
import customTheme from './custom-theme.js'
import './assets/tailwind.css'



Vue.use(Chakra, {
  extendTheme: customTheme
})

Vue.config.productionTip = false

new Vue({
  render: (h) => h(CThemeProvider,[h(App)]),
}).$mount('#app')
