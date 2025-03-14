import { createRouter, createWebHistory } from 'vue-router';
import HomeView from '@/views/HomeView.vue';
// import ArticleView from '@/views/ArticleView.vue';
import TxForm from '@/components/TxForm.vue';
// import EditArticleView from '@/components/EditArticleView.vue';
import AddTx from '@/components/AddTx.vue';
// import PreviewView from '@/views/PreviewView.vue';

const routes = [
  {
    path: '/',
    name: 'Home',
    component: HomeView
  },
  // {
  //   path: '/article/:id',
  //   name: 'ArticleDetail',
  //   component: ArticleView,
  //   props: true
  // },
  // {
  //   path: '/article/new',
  //   name: 'NewArticle',
  //   component: ArticleForm
  // },
  { 
    path: '/add-tx', 
    name: 'AddTx',
    component: AddTx,
    props: true 
  },
  // { 
  //   path: '/article/edit/:id', 
  //   name: 'EditArticle',
  //   component: EditArticleView,
  //   props: true 
  // },
  // { 
  //   path: '/article/preview', 
  //   name: 'PreviewView',
  //   component: PreviewView,
  //   props: true 
  // }
];

const router = createRouter({
  history: createWebHistory(),
  routes
});

export default router;