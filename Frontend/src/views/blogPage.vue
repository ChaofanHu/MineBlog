<template>
    <div>
            <!-- head  -->
     <BlogHeader></BlogHeader>
        <div class="m-container-small m-padding-tb-larger">
            <sui-container>
                    <!-- header  -->
                    <div class="ui top attached segment">
                    <div class="ui horizontal link list">
                        <div class="item ">
                            <img  :src="header.iconUrl" alt="" width="30" height="30" class="ui avatar image">
                            <div class="cotent m-inline-block m-text-indent" ><a href="">{{header.username}}</a></div>
                        </div>

                        <div class="item">
                            <i class="calendar icon"></i>{{ header.updatedTime }}
                        </div>
                        <div class="item">
                            <i class="eye icon">{{ header.views }}</i>
                        </div>
                        </div>
                    </div>

                      
                    <!-- picture  -->
                <div class="ui attached segment ">
                    <img class="animate__animated animate__bounceIn m-aligncenter" :src="header.firstPicture" alt="" width="700" >
                </div>

                <!-- content  -->
                <sui-segment attached>
                    <div class="ui right aligned basic segment"><div class="ui orange basic label">{{ header.blogType }}</div></div>
                    <h2 class="ui center aligned header">{{ blog.title }}</h2>
                    <div id="wrapper" class="typo typo-selection m-padding-lr m-padding-tb" v-html="blog.content">
                      
                    </div>


                </sui-segment>

                <!-- tags  -->
                <!-- <div class="m-padding-lr m-padding-tb">  -->
                    <sui-segment>
                        <div class="ui basic left pointing label ">Java</div>
                    </sui-segment>
                    
                <!-- </div> -->

                <!-- <div class="ui attached positive message m-pad-tb-large" >
                    <div class="ui grid">
                        <div class="eleven wide column">
                            <ul class="list">
                                <li>作者：<span>山内有樱名为良</span></li>
                                <li>发表时间：<span>{{blog.updateTime | formatDate("YYYY-MM-DD")}}</span></li>
                                <li>版权声明：自由转载-非商用-非衍生-保持署名（创意共享3.0许可证）</li>
                                <li>转载声明：如果是转载博主文章，请附上原文链接</li>
                            </ul>
                        </div>
                    </div>
                </div> -->

                <div class="ui attached positive message">
                    <!-- blog information -->
                    <div class="ui grid">
                        <div class="ui eleven wide column">
                            <div class="eleven wide column">
                            <ul class="list">
                                <li>Author：<span>{{ header.username}}</span></li>
                                <li>Published Date：<span> {{  header.createdTime }}</span></li>
                                <li>版权声明：自由转载-非商用-非衍生-保持署名（创意共享3.0许可证）</li>
                                <li>转载声明：如果是转载博主文章，请附上原文链接</li>
                            </ul>
                        </div>
                        </div>
                        <div class="ui five wide column"></div>
                    </div>
                </div>
            </sui-container>
        </div>      
    </div>
</template>

<script>
import BlogHeader from "../components/blogHeader.vue";


export default {
    props:['id'],
    components:{
        BlogHeader
    },
    data(){
        return {
            blog: {},
            header: {}
        }
    },
    methods:{
        selectById(){
            var _this = this;
            this.axios.get("http://localhost:8090/getBlogById",{
                params:{
                    id : _this.id
                }
            }).then(function(resp){
                console.log(resp.data);
                _this.blog = resp.data;
            })

        },
        getBlogHeader(){
            var _this = this;
            this.axios.get("http://localhost:8090/getBlogHeader",{
                params:{
                    id: _this.id
                }
            }).then(function(resp){
                _this.header = resp.data;
            })
        }
    },
    created: function(){
        this.selectById();
        this.getBlogHeader();
    }
}
</script>
<style scoped>
    code{ color:#1abc9c; }
    html{ background:#eee; }
    body{ width:90%; max-width: 960px; background:#fff; margin:3em auto 0; padding-top:2em;border:1px solid #ddd;border-width:0 1px;}
    pre{white-space:pre-wrap;}
@import "../assets/css/me.css";
@import "../assets/css/typo.css";
@import "../../node_modules/animate.css/animate.css";
</style>