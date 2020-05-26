import Vue from 'vue'
import Vuex from 'vuex'
import router from '@/router/index.js'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    isLogged: true,
    validUser: {
      email: 'defaultUser@domain.com',
      password: 'user',
    }
  },

  mutations: {
    login(state) {
      state.isLogged = true;
    },

    logout(state) {
      state.isLogged = false;
    }
  },

  actions: {
    login(context) {
        context.commit('login');
        router.replace('/');
    },

    logout(context) {
      context.commit('logout');
      router.replace('/login');
    }
  },

  getters: {
    isLogged: (state) => {
      return state.isLogged;
    }
  }
})
