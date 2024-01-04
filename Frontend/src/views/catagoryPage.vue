<template>
    <div>
      <!-- head -->
      <BlogHeader></BlogHeader>
  
      <div class="m-container-small m-padding-tb-larger">
        <div class="ui container">
          <div class="ui top attached segment">
            <div class="ui middle aligned two column grid">
              <div class="column">
                <h3 class="ui teal header">Category</h3>
              </div>
              <div class="right aligned column">
                Total <h3 class="ui orange header m-inline-block">{{ num }}</h3> Blogs
              </div>
            </div>
          </div>
  
          <!-- Category Buttons -->
          <div class="ui attached segment">
            <div class="ui labeled button" v-for="category in categories" :key="category.id">
               <h class="ui basic teal button m-margin-tiny">
                {{ category.name }}
                </h>
              <div class="ui basic teal left pointing label">{{ category.count }}</div>
            </div>
          </div>
  
          <!-- Blog List -->
          <div class="ui segment" v-for="blog in dataShow" :key="blog.id">
            <div class="ui attached segment m-container">
              <div class="ui padded vertical segment">
                <div class="ui mobile reversed stackable grid">
                  <div class="eleven wide column">
                    <h3 class="ui header">
                      <router-link :to="`/homePage/blogPage/${blog.id}`">{{ blog.title }}</router-link>
                    </h3>
                    <sui-divider />
                    <p class="m-text">{{ blog.introduction }}</p>
                    <sui-divider hidden />
                    <div class="ui stackable grid">
                      <div class="eleven wide column">
                        <div class="ui horizontal link list">
                          <div class="item">
                            <img :src="blog.icon" alt="" width="30" height="30" class="ui avatar image">
                            <div class="content m-inline-block m-text-indent">
                              <router-link :to="`/author/${blog.name}`">{{ blog.name }}</router-link>
                            </div>
                          </div>
                          <div class="item">
                            <i class="calendar icon"></i> {{ blog.date }}
                          </div>
                          <div class="item">
                            <i class="eye icon">{{ blog.view }}</i>
                          </div>
                        </div>
                      </div>
                      <div class="right aligned five wide column">
                        <router-link :to="`/tags/${blog.tag}`" class="ui label">{{ blog.tag }}</router-link>
                      </div>
                    </div>
                  </div>
                  <div class="five wide column">
                    <router-link :to="`/blogPage/${blog.id}`" target="_blank">
                      <img :src="blog.picture" alt="" class="ui rounded image">
                    </router-link>
                  </div>
                </div>      
              </div>
            </div>
          </div>
  
          <!-- Pagination -->
          <div class="ui segment">
            <div class="ui bottom attached segment">
              <div class="ui middle aligned two column grid">
                <div class="column">
                  <router-link to="/previousPage" class="ui mini black basic button">Last Page</router-link>
                </div>
                <div class="right aligned column">
                  <router-link to="/nextPage" class="ui mini black basic button">Next Page</router-link>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <BLogFooter></BLogFooter>
    </div>
  </template>
  
  <script>
  import BlogHeader from "../components/blogHeader.vue";
  import BLogFooter from "../components/BlogFooter.vue";
  
  export default {
    components: {
      BlogHeader,
      BLogFooter
    },
    data () {
        return{
            //number of the blogs
            num: 10,
            //total categories
            categories: [],
            // 后台传来的数据源
            data: [],
            // 所有页面的数据
            totalPage: [],
            // 每页显示数量
            pageSize: 5,
            // 共几页
            pageNum: 1,
            // 当前显示的数据
            dataShow: "",
            // 默认当前显示第一页
            currentPage: 0
        }
    },
    methods:{
        dividePage(){
            this.pageNum = Math.ceil(this.data.length / this.pageSize) || 1;//计算有多少页数据，默认为1
            // 循环页面
            for (let i = 0; i < this.pageNum; i++) {
            // 每一页都是一个数组 形如 [['第一页的数据'],['第二页的数据'],['第三页数据']]
            // 根据每页显示数量 将后台的数据分割到 每一页,假设pageSize为2， 则第一页是1-2条，即slice(0,2)，第二页是3-4条，即slice(3,4)以此类推
            this.totalPage[i] = this.data.slice(this.pageSize * i, this.pageSize * (i + 1))
            }
            // 获取到数据后默认显示第一页内容
            this.dataShow = this.totalPage[this.currentPage];
        },
        // 下一页
        nextPage() {
        if (this.currentPage === this.pageNum - 1) return ;
            this.dataShow = this.totalPage[++this.currentPage];
        },
        // 上一页
        prePage() {
            if (this.currentPage === 0) return ;
              this.dataShow = this.totalPage[--this.currentPage];
        },
        selectAll(){
            var _this = this;
            this.axios.get("http://localhost:8090/getAllBlogs")
            .then(function(resp){
                _this.data = resp.data;
                // alert(resp.data)
                _this.dividePage();
                _this.num = resp.data.length;
            })
            this.axios.get("http://localhost:8090/getAllCategory")
            .then(function (resp) {
                console.log(resp.data)
                _this.categories = resp.data;
            })
        }
    },
    created: function(){
        this.selectAll();
    }
  }
  </script>
  