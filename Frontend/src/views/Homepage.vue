<template>
    <div>
       <!-- header  -->
    <BlogHeader></BlogHeader>
    <!-- content -->
        <div class="m-container m-padding-tb-larger ">
        <!-- container可以自动适应网页 -->
        <div class="ui container">
            <div class="ui  stackable grid">
                <!-- left content -->
                <div class="eleven wide column animate__animated animate__bounceInLeft">
                    <!-- header  -->
                    <div class="ui top attached segment">
                        <div class="ui middle two column grid">
                            <div class="column">
                                <h3 class="ui black header">Blog</h3>
                            </div>
                            <div class="right aligned column">
                                Total <h3 class="ui orange header m-inline-block" >  {{ num }}  </h3> Blogs
                            </div>
                        </div>
                    </div>

                    <!-- content  -->
                    <div class="ui attached segment m-container " v-for="blog in dataShow" :key="blog.id" >
                        <div class="ui padded vertical segment">
                            <div class="ui mobile reversed stackable grid">
                                <div class="eleven wide column">
                                    <h3 class="ui headert m-header"><RouterLink :to="'/BlogPage/' + blog.id" > {{ blog.title }}</RouterLink></h3>
                                    <sui-divider clearing />
                                        <p class=" m-text"> {{ blog.introduction }}</p>
                                    <!-- <sui-divider hidden/> -->
                                    <div class="ui grid">
                                        <div class="eleven wide column">
                                            <div class="ui horizontal link list">

                                                <div class="item">
                                                    <img :src="blog.iconUrl" alt="" width="30" height="30" class="ui avatar image">
                                                    <div class="cotent m-inline-block m-text-indent" ><a href="">{{ blog.username }}</a></div>
                                                </div>
                                                
                                                <div class="item">
                                                    <i class="calendar icon"></i>{{ blog.createdTime }} 
                                                </div>
                                                <div class="item">
                                                    <i class="eye icon">{{ blog.views }}</i>
                                                </div>
                                            </div>
                                            
                                        </div>

                                        <div class="right aligned five wide column">
                                            <a href="" target="" class="ui label">{{ blog.blogType }}</a>
                                        </div>

                                    </div>
                                </div>

                                <div class="five wide column">
                                    
                                    <a href="" target="_blank">
                                        <img :src="blog.firstPicture" alt="" class="ui rounded image">
                                    </a>
                                </div>
                            </div>      
                        </div>
                    
                    </div>

                    <!-- footer  -->
                    <div class="ui bottom attached segment">
                        <div class="ui  middle aligned two column grid">
                            <div class="column" @click="prePage">
                                <a href=""  class="ui mini black basic button" >Last Page</a>
                            </div>
                            <div class="right aligned column" @click="nextPage">
                                <a href="" class="ui mini black basic button" >Next Page</a>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- right content  -->
                <div class="five wide column animate__animated animate__bounceInRight">
                    <!-- catagory  -->
                    <div class="ui segment">
                        <div class="ui secondary segment">
                            <div class="ui two column grid">
                                <div class="column">
                                    <i class="idea icon"></i>Catagory
                                </div>
                                <div class="right aligned column">
                                    <a href="" class="">More <i class="angle double right icon"></i></a>
                                </div>
                            </div>
                        </div>
                        <div class="ui segment" >
                            <div class="ui fluid vertical menu" >
                            <a href="" class="item" v-for="catagory in categories" :key="catagory.id">
                                {{ catagory.name }}
                                <div class="ui label">13</div>
                            </a>
                        </div>
                        </div>
                    </div>
                    <!-- tags -->
                    <div class="ui segment m-margin-top">
                        <div class="ui secondary segment">
                            <div class="ui two column grid">
                                <div class="column">
                                    <i class="idea icon"></i>Tags
                                </div>
                                <div class="right aligned column">
                                    <a href="" class="">More <i class="angle double right icon"></i></a>
                                </div>
                            </div>
                        </div>
                        <div class="ui segment">
                            <a href="" class="ui basic left pointing label m-margin-tb-tiny" v-for="tag in tags" :key="tag.id">{{ tag.name }}</a>
                        </div>
                    </div>
                    <!-- new element -->
                    <div class="ui segment m-margin-top">
                        <div class="ui secondary segment">
                            Waiting to build...
                        </div>
                    </div>
                    <div class="ui segment m-margin-top">
                        <div class="ui secondary segment">
                            <div class="column">
                                    <i class="idea icon"></i>Contact Me
                            </div>
                            <div class="ui segment">
                                <div class="ui fluid vertical menu">
                                    <a href="https://github.com/ChaofanHu" class="item">
                                        Github
                                        <i class="github icon"></i>
                                        
                                        <!-- icon -->
                                    </a>
                                    <a href="www.linkedin.com/in/chaofan-hu" class="item">
                                        <i class="linkedin icon"></i>Linkedin
                                        <!-- icon -->
                                    </a>
                                    <!-- <a href="" class="item">
                                        
                                
                                    </a>
                -->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
    </div>
        </div>
        <!-- bottom -->
       <BLogFooter></BLogFooter>
        <RouterView></RouterView>
    </div>
    
</template>

<script>
import BlogHeader from "../components/blogHeader.vue";
import BLogFooter from "../components/BlogFooter.vue";

export default{
    name: 'homePage',
    components:{
        BlogHeader,
        BLogFooter
    },
    data () {
        return{
            //total categories
            categories:[],
            //total tags
            tags:[],
            //the number of blogs
            num: 10,
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
            });
            this.axios.get("http://localhost:8090/getAllCategory")
            .then(function (resp) {
                console.log(resp.data)
                _this.categories = resp.data;
            });
            this.axios.get("http://localhost:8090/getAllTags")
            .then(function (resp) {
                console.log(resp.data)
                _this.tags = resp.data;
            })
        }
    },
    created: function(){
        this.selectAll();
    }

}
</script>

<style scoped>
@import "../assets/css/me.css";
@import "../../node_modules/animate.css/animate.css";
</style>