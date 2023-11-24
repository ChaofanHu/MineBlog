import Vue from 'vue'
import App from './App.vue'
import SuiVue from '../node_modules/semantic-ui-vue';
import router from './router';
import axios from "../node_modules/axios"
import vueaxios  from "../node_modules/vue-axios"
import QS from "../node_modules/qs"

Vue.prototype.$qs = QS;
Vue.use(vueaxios,axios);

Vue.config.productionTip = false
Vue.use(SuiVue);
new Vue({
  router:router,
  render: h => h(App),
}).$mount('#app')
