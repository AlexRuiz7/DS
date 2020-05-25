import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import vuetify from './plugins/vuetify';
import '@babel/polyfill'
import 'roboto-fontface/css/roboto/roboto-fontface.css'
import '@mdi/font/css/materialdesignicons.css'
//Importamos el componente Login globalmente
import Login from "./components/Login.vue";
//Lo registramos con un nombre para el tag
Vue.component("login", Login);
//Importamos el componente Login globalmente
import ListaEntidades from "./components/ListaEntidades.vue";
//Lo registramos con un nombre para el tag
Vue.component("listaEntidades", ListaEntidades);
//Importamos el componente Login globalmente
import EntidadValorable from "./components/EntidadValorable.vue";
//Lo registramos con un nombre para el tag
Vue.component("entidadValorable", EntidadValorable);
//Importamos el componente Login globalmente
import ObjetoValorable from "./components/ObjetoValorable.vue";
//Lo registramos con un nombre para el tag
Vue.component("objetoValorable", ObjetoValorable);


Vue.config.productionTip = false

new Vue({
  router,
  store,
  vuetify,
  render: h => h(App)
}).$mount('#app')

