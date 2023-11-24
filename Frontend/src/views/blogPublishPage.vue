<template>
    <div>
            <!-- head  -->
        <BlogHeader></BlogHeader>
    <!-- secondary header  -->
    <SecondHeader></SecondHeader>

      <!-- content  -->
      <div class="m-container-small m-padding-tb-big">
        <div class="ui container">
            <sui-form>
                <sui-form-fields>

                    <sui-form-field width="four">
                        <label>Type</label>
                        <sui-form-fields>
                            <sui-form-field>
                                <sui-dropdown
                                placeholder="Original"
                                selection
                                :options="optionsBlogType"
                                v-model="blog.blogType"
                                />
                            </sui-form-field>
                        </sui-form-fields>
                    </sui-form-field>
                    <sui-form-field width="twelve" >
                        <label>Title</label>
                        <input v-model="blog.title" type="text" name="title" placeholder="Please input title" />
                    </sui-form-field>
                </sui-form-fields>

                    <sui-form-field>
                    <label>Introduction</label>
                    <textarea v-model="blog.introduction"></textarea>
                    </sui-form-field>
                    <sui-divider hidden />

                <sui-form-field>
                    <label>Content</label>
                    <mavon-editor 
                        v-model="blog.content"
                        placeholder="Waiting for input...." 
                        @imgAdd="$imgAdd"
                        :toolbars="markdownOption"
                        @change="change"
       
                    />
                    <!-- ref="md"
                                               :subfield="false"
                         -->
                    <!-- <textarea v-model="content" name="content" placeholder="Content" rows="20" cols="50" style="display:none;"></textarea> -->
                </sui-form-field>

                <sui-divider hidden />

                <sui-form-fields fields="two">
                    <sui-form-field >
                       <label for="">Catagory</label>
                        <sui-dropdown
                        placeholder="Catogory"
                        selection
                        :options="catagoryTypes"
                        v-model="blog.categoryType"
                        />
                    </sui-form-field>
                    <sui-form-field >
                        <label for="">Tags</label>
                        <sui-dropdown
                        :options="tagTypes"
                        placeholder="Tags"
                        search
                        selection
                        v-model="blog.tagType"
                        />
                    </sui-form-field>
                </sui-form-fields>

                <sui-divider hidden />

                <sui-form-field width="sixteen">
                    <label>Picture</label>
                    <input type="text" name="" id="" placeholder="URL" v-model="blog.firstPicture">
                </sui-form-field>

                <!-- <sui-button-group color="blue">
                    <sui-button content="One" />
                    <sui-button content="Two" />
                    <sui-button content="Three" />
                </sui-button-group> -->
            </sui-form>
            
            <sui-divider hidden />

            <div class="ui right aligned container">
                    <button type="button" class="ui white button"><RouterLink to="/admin/blogManPage">Back</RouterLink>></button>
                    <button class="ui secondary button" @click="save">Save</button>
                    <button class="ui teal button" @click="establish">Establish</button>
            </div>
        </div>
      </div>
    </div>
</template>

<script>
import BlogHeader from "../components/blogHeader.vue"
import SecondHeader from "../components/SecondHeader.vue"
import { RouterLink } from "vue-router"
import { mavonEditor } from 'mavon-editor'
import '/Users/chaofanhu/Frontend/mineblog/node_modules/mavon-editor/dist/css/index.css'

export default{
    components:{
    BlogHeader,
    RouterLink,
    SecondHeader,
    mavonEditor
    },
    data () {
        return{
            blog:{
                title:"",
                introduction:"",
                content:"",
                blogType:"",
                categoryType:"",
                // tagType:"",
                firstPicture:"",
                userId:""
            },
            html:"",
             
            optionsBlogType:[ {text:"Original", value:"1"},
            {text:"Citation", value:"2"}    
            ],

            catagoryTypes:[],
 
            tagTypes:[],

            markdownOption:{ //自定义文本标签
                bold: true, // 粗体
                italic: true,// 斜体
                strikethrough: true, // 中划线
                underline: true, // 下划线
          }
        }
    },
    created: function(){
        this.getAllCategories();
    },
    methods:{
        // change(value, render) {
        //     //实时获取转成html的数据
        //     this.blog.html = render
        // },
        change(value, render){
            // render 为 markdown 解析后的结果[html]
            this.html = render;
            
        },
        $imgAdd(pos, $file){
            console.log($file)
            let formdata = new FormData();
            formdata.append('file',$file)
            this.$axios.post('上传服务器链接', formdata).then(res => {
                console.log(res.data.url);
                this.$refs.md.$img2Url(pos, res.data.url);
            }).catch(err => {
                console.log(err)
            })
        },
        getAllBlogType(){
            const _this = this;
            this.axios.get("http://localhost:8090/admin/selectAllCategory")
            .then(function(resp){
                _this.optionsBlogType = resp.data;
            })
        }
        ,
        getAllCategories(){
            var _this = this;
            this.axios.get("http://localhost:8090/admin/selectAllCategory")
            .then(function(resp){
                _this.catagoryTypes = resp.data;
                console.log(_this.catagoryTypes)
            })
        },
        save(){
            console.log(localStorage.getItem("user"))
        },
        establish(){
            var _this = this;
            let user = localStorage.getItem("id");
            this.blog.userId = user;
            this.axios.post("http://localhost:8090/admin/establishBlog",
           _this.blog)
            .then(function(resp){
                if(resp.data.code == 200){
                    alert("success")
                }else{
                    alert("wrong");
                    
                }
            })
        },
        // getAllTags(){
        //     const _this = this;
        //     this.axios.get("localhost:8090/admin/selectAllCategory")
        //     .then(function(resp){
        //         _this.tagTypes = resp.data;
        //     })
        // }
    }
   
}
</script>

<style scoped>

</style>