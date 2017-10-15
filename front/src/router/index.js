import Vue from 'vue'
import Router from 'vue-router'
import MemeGame from '@/components/MemeGame'
import About from '@/components/About'
import Rules from '@/components/Rules'
import UserChooseModal from '@/components/UserModal'

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: '/',
      name: 'game',
      component: MemeGame
    },
    {
      path: '/user',
      name: 'user',
      component: UserChooseModal
    },
    {
      path: '/about',
      name: 'about',
      component: About
    },
    {
      path: '/rules',
      name: 'rules',
      component: Rules
    }
  ]
})
