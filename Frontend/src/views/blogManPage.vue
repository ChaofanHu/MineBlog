<template>
    <div>
            <!-- head  -->
        <BlogHeader></BlogHeader>
    <!-- secondary header  -->
        <SecondHeader></SecondHeader>
        <!-- <SecondHeader></SecondHeader> -->

    <!-- content  -->
    <div class="m-container-small m-padding-tb">
        <div class="ui container">
            <sui-form>
                <sui-header dividing>Search</sui-header>
                <sui-form-fields fields="three">
                    <sui-form-field>
                    <input
                        type="text"
                        name="shipping[first-name]x"
                        placeholder="Title"
                        v-model="Title"
                    />
                    </sui-form-field>
                    <sui-form-field>
                    <sui-dropdown
                        placeholder="Catagory"
                        selection
                        :options="optionsCatagory"
                        v-model="Catagory"
                        />
                    </sui-form-field>
                 
                        <sui-button color="teal" type="submit" >Search</sui-button>

                    
                </sui-form-fields>
                
             </sui-form>
            
        
            <table class="ui celled table">
                <thead>
                    <tr><th>Title</th>
                    <th>Catagory</th>
                    <th>Date</th>
                    <th>Operation</th>
                </tr></thead>
                <tbody>
                    <tr v-for="blog in dataShow" :key="blog.id">
                        <td data-label="Title">{{blog.title}}</td>
                        <td data-label="Catagory">{{ blog.category }}</td>
                        <td data-label="Date">{{ blog.createdTime }}</td>
                        <td data-label="Operation"><a href="" class="ui mini teal button">Edit</a><a href="" class="ui mini teal button">Delete</a></td>
                    </tr>
                </tbody>
                <tfoot>
                    <tr><th colspan="5">
                        <div class="ui right floated pagination menu">
                            <a class="icon item">
                            <i class="left chevron icon" @click="prePage"></i>
                            </a>
                         
                            <a class="icon item">
                            <i class="right chevron icon" @click="nextPage"></i>
                            </a>
                        </div>
                        <a href="" class="ui mini floating teal basic button">Add</a>
                        </th>
                    </tr>
                </tfoot>
            </table>
        </div>
    </div>

        <!-- bottom -->
        <BlogFooter></BlogFooter>
    </div>
    
</template>

<script>
import BlogHeader from "../components/blogHeader.vue";
import SecondHeader from "../components/SecondHeader.vue"
import BlogFooter from "../components/BlogFooter.vue"


export default {
    components:{
        BlogHeader,
        SecondHeader,
        BlogFooter
    }, 
   data() {
    return {
        Title:"",
        Catagory: null,
        Date: null,
        optionsCatagory: [
        {
          text: 'Backend',
          value: 1,
        },
        {
          text: 'Frontend',
          value: 2,
        },
        {
          text: 'DAO',
          value: 3,
        },
        {
          text: 'BUGS',
          value: 4,
        }
        ],
        numberToWordMap : {
            1: 'One',
            2: 'Two',
            3: 'Three',
            // 可以继续添加其他映射
        },
       // 假设这是后台传来的数据来源
    //    data:[],
    data: [
        // {Id:1,Title:"Java",Catagory:"Backend",Date:"2022-02-02"},
        // {Id:2,Title:"Java",Catagory:"Backend",Date:"2022-02-02"},
        // {Id:3,Title:"Java",Catagory:"Backend",Date:"2022-02-02"},
        // {Id:4,Title:"Java",Catagory:"Backend",Date:"2022-02-02"},
        // {Id:5,Title:"Java",Catagory:"Backend",Date:"2022-02-02"},
        // {Id:6,Title:"Java",Catagory:"Backend",Date:"2022-02-02"},
        // {Id:7,Title:"Java",Catagory:"Backend",Date:"2022-02-02"},
        // {Id:8,Title:"Java",Catagory:"Backend",Date:"2022-02-02"}
       ],
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
    };
    },
    created(){
        this.selectAll();
    },
    methods:{
        //get all blogs 
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
        selectAll(){
            var _this = this
            this.axios.get("http://localhost:8090/admin/blogManage"
            ,{
                headers: {
                    'Content-Type': 'application/json',
                    'token': localStorage.getItem('token')
                }
            }
            )
            .then(function(resp){
                _this.data = resp.data;
                _this.dividePage();
            })
            
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
            }
    }

    
};
</script>

<style>
@import "../assets/css/me.css";
</style>