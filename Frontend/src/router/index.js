import Vue from 'vue'
import VueRouter from 'vue-router'

import homePage from '@/views/Homepage'
// import homePage from '../views/user/homePage';
import blogPage from '../views/blogPage';
import catagoryPage from '../views/catagoryPage.vue';
import tagPage from '../views/tagPage.vue';
import aboutme from '../views/aboutMePage'
import blogManPage from '../views/blogManPage'
import blogPublishPage from '../views/blogPublishPage'
import login from '../views/loginPage'
import NewCatagoryAndTags from "../views/NewCatagoryAndTags"
 
Vue.use(VueRouter)
 
const routes = 
[
  
  {
    path: '/Admin',
    component: login,
  },
  {
    path: '/Admin/NewCatogoryAndTags',
    component: NewCatagoryAndTags,
  },
  {
      path: '/Admin/BlogPublishPage',
      component: blogPublishPage
  },
  {
      path: '/Admin/BlogManPage',
      component: blogManPage
  },
  {
    path: '/homepage',
     component: homePage
  },
  {
    path: '/AboutMe',
    component: aboutme
  },
  {
    path: '/TagPage',
     component: tagPage
  },
  {
    path: '/CatagoryPage',
    component: catagoryPage
  },
  {
    path: '/BlogPage/:id',
    component: blogPage,
    props: true
  },
  {
    path:"/",
    redirect:"/homepage"
  }
]
 
export default new VueRouter({
  routes
})
 