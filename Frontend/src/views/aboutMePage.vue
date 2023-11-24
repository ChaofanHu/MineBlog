<template>
    <div>
            <!-- head  -->
    <BlogHeader></BlogHeader>
       <div class="m-container m-padding-tb">
        <div class="ui container">
            <div class="ui stackable grid">
                <div class="eleven wide column">
                    <img src="https://images.unsplash.com/photo-1682695798522-6e208131916d?ixlib=rb-4.0.3&ixid=M3wxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2340&q=80" alt="" width="600">
                </div>
                <div class="five wide column">
                    <div class="ui segment">
                        <div class="ui header">About Me</div>
                        <div class="ui attached segment">
                            <p class="m-text">My name is Chaofan Hu, a master student majored in informatics at USI, I am keen on learning new frameworks.</p>
                        </div>
                        <div class="ui attached segment">
                            <h4 >Backend</h4>
                            <div class="ui segment">
                            <div class="ui black left pointing label m-margin-tb-tiny">Java EE</div>
                            <div class="ui black left pointing label m-margin-tb-tiny">Mybatis</div>
                            <div class="ui black left pointing label m-margin-tb-tiny">SpringBoot</div>
                            <div class="ui black left pointing label m-margin-tb-tiny">XML</div>
                            </div>
                            
                        </div>
                        <div class="ui attached segment">
                            <h4 >Frontend</h4>
                            <div class="ui segment">
                            <div class="ui black left pointing label m-margin-tb-tiny">Vue</div>
                            <div class="ui black left pointing label m-margin-tb-tiny">Javascript</div>
                            <div class="ui black left pointing label m-margin-tb-tiny">CSS</div>
                            <div class="ui black left pointing label m-margin-tb-tiny">HTML</div>
                            </div>
                            
                        </div>
                        <div class="ui attached segment">
                            <h4 >Database</h4>
                            <div class="ui segment">
                            <div class="ui black left pointing label m-margin-tb-tiny">SQL</div>
                            <div class="ui black left pointing label m-margin-tb-tiny">Mybatis</div>
                            <div class="ui black left pointing label m-margin-tb-tiny">Hibernate</div>
                            <div class="ui black left pointing label m-margin-tb-tiny">Mysql</div>
                            </div>
                        </div>
                        <div class="ui bottom attached segment">
                            <a href="" class="ui circular icon button"> <i class="github icon"></i></a>
                            <a href="" class="ui circular icon button"> <i class="linkedin icon"></i></a>
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
    name: 'homePage',
    components:{
        BlogHeader,
        BLogFooter
    }
}
</script>