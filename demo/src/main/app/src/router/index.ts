import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import AllCoachesView from '../views/AllCoachesView.vue'
import DetailsView from '../views/DetailsView.vue'
import RegisterView from '../views/RegisterView.vue'
import type { PropType } from 'vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/all-coaches',
      name: 'all',
      component: AllCoachesView
    },
    {
      path: '/details',
      name: 'details',
      component: DetailsView,
    },
    {
      path: '/register',
      name: 'register',
      component: RegisterView,
    }
  ]
})

export default router
