import { createRouter, createWebHistory } from 'vue-router';
import HomeView from '../views/HomeView.vue';
import LogInView from '../views/LogInView.vue';
import CreateAccount from '../views/CreateAccountView.vue';
import BlogSection from '../components/BlogSection.vue'
import QuizView from '../views/QuizView.vue'
import CalendarView from '../views/CalendarView.vue';
import LeaderboardView from '../views/LeaderboardView.vue';
import AboutView from '../views/AboutView.vue';
import HomeUser from '../views/HomeUser.vue';
import Contact from '@/views/Contact.vue';
import Recommendation from '@/views/Recommendation.vue';

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: '/',
            name: 'home',
            component: HomeView,
        },
        {
            path: '/login',
            name: 'login',
            component: LogInView,
        },
        {
            path: '/createAccount',
            name: 'createAccount',
            component: CreateAccount,
        },
        {
            path: '/blog', // Default route
            name: 'Blog',
            component: BlogSection, // Render BlogSection on the root path
        },
        {
          path: '/quiz',
          name:'quiz',
          component: QuizView,
        },
        {
          path: '/calendar',
          name:'calendar',
          component: CalendarView,
        },
        {
          path: '/leaderboard',
          name: 'leader',
          component: LeaderboardView,
      },
      {
        path: '/about',
        name: 'about',
        component: AboutView,
    },

    {
      path: '/home1',
      name:'home1',
      component: HomeUser,
    },
    {
      path: '/contact',
      name:'contact',
      component: Contact,
    },
    {
      path: '/recommendation',
      name: 'recommendation',
      component:Recommendation,
    }
    ],
});

export default router;
