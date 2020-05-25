import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import CrearPlataforma from "../views/CrearPlataforma.vue";
import store from '@/store/index.js'

Vue.use(VueRouter)

  const routes = [
    {
      path: "/",
      name: "Home",
      component: Home,
      beforeEnter: (to, from, next) => {
        !store.getters.isLogged ? next("/login") : next();
      },
    },
    {
      path: "/login",
      name: "Login",
      component: Login,
    },
    {
      path: "/crear-plataforma",
      name: "CrearPlataforma",
      component: CrearPlataforma,
    },
    // { path: '*', redirect: '/' }
  ];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
