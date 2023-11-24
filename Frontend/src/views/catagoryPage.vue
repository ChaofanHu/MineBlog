<template>
    <div>
            <!-- head  -->
        <BlogHeader></BlogHeader>



        <div class="m-container-small m-padding-tb-larger">
            <div class="ui container">
                <div class="ui top attached segment">
                    <div class="ui middle aligned two column grid">
                        <div class="column">
                            <h3 class="ui teal header">
                                Catagory
                            </h3>

                        </div>
                        <div class="right aligned column">
                                Total <h3 class="ui orange header m-inline-block" >  14  </h3> Blogs
                        </div>
                    </div>
                </div>

                <div class="ui attached segment">
                    <div class="ui labeled button">
                        <a href="" class="ui basic teal button m-margin-tiny">Java</a>
                        <div class="ui basic teal left pointing label">1</div>
                    </div>
                    <div class="ui labeled button">
                        <a href="" class="ui basic teal button m-margin-tiny">Java</a>
                        <div class="ui basic teal left pointing label">1</div>
                    </div>
                    <div class="ui labeled button">
                        <a href="" class="ui basic teal button m-margin-tiny">Java</a>
                        <div class="ui basic teal left pointing label">1</div>
                    </div>
                </div>
<!-- 

                <sui-segment>
                    <sui-segment attached class="m-container">
                        <sui-grid >
                            <sui-grid-row>
                                <sui-grid-column :width="11">
                                    <h3 class="ui headert"><RouterLink to="/homePage/blogPage">{{blog.title}}</RouterLink></h3>
                                    <p class="m-text"> {{ blog.introduction }} </p>
                                    <sui-grid-row>

                                    </sui-grid-row>
                                </sui-grid-column>
                            </sui-grid-row>
                        </sui-grid>
                    </sui-segment>
                </sui-segment> -->

                <div class="ui segment " v-for="blog in blogs" :key="blog.id">
                    <div class="ui attached segment m-container">
                        <div class="ui padded vertical segment">
                            <div class="ui mobile reversed stackable grid">
                                <div class="eleven wide column">
                                    <h3 class="ui headert"><RouterLink to="/homePage/blogPage">{{blog.title}}</RouterLink></h3>
                                    <sui-divider />
                                        <p class="m-text"> {{ blog.introduction }} </p>
                                        
                                        
                                        <sui-divider hidden />
                                    <div class="ui stackable grid">
                                        <div class="eleven wide column">
                                            <div class="ui horizontal link list">
                                                

                                                <div class="item">
                                                    <img :src="blog.icon" alt="" width="30" height="30" class="ui avatar image">
                                                    <div class="cotent m-inline-block m-text-indent" ><a href="">{{ blog.name }}</a></div>
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
                                            <a href="" target="" class="ui label">{{ blog.tag }}</a>
                                        </div>

                                    </div>
                                </div>

                                <div class="five wide column">
                                    
                                    <a href="" target="_blank">
                                        <img :src="blog.picture" alt="" class="ui rounded image">
                                    </a>
                                </div>
                            </div>      
                        </div>
                    </div>
                </div>

                <div class="ui segment">
                    <div class="ui bottom attached segment">
                        <div class="ui  middle aligned two column grid">
                            <div class="column">
                                <a href="" class="ui mini black basic button">Last Page</a>
                            </div>
                            <div class="right aligned column">
                                <a href="" class="ui mini black basic button">Next Page</a>
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
import BLogFooter from "../components/BlogFooter.vue"
    export default{
        components:{
            BlogHeader,
            BLogFooter
        },
        data(){
            return {
                blogs: [
                    {id:1, 
                    title:"Enjoy your life", 
                    introduction:"By wisdom I mean truth, insight, ideas. A sentence functioning as an aphorism.", 
                    icon:"https://images.unsplash.com/photo-1682695798522-6e208131916d?ixlib=rb-4.0.3&ixid=M3wxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2340&q=80", 
                    name:"Tony", 
                    date:"2022-02-02", 
                    view:"666", 
                    tag:"Life", 
                    picture:"https://images.unsplash.com/photo-1682695798522-6e208131916d?ixlib=rb-4.0.3&ixid=M3wxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2340&q=80"},

                ]
            }
        },
        method:{

        },
        mounted(){}
    }
</script>