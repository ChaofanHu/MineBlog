<template>
       <!-- head  -->
       <nav class="ui inverted attached segment m-padding-tb-mini"> <!-- my-padding-tb-classname  for css-->
            <div class="container">
                <div class = "ui inverted stackable menu">
                    <h2 class="ui teal header item">MineBlog</h2>
                    <a href="" class="item m-mobile-hide" >
                        <i class="home icon"></i>
                        <router-link to="/" replace>Homepage</router-link>
                    </a>
                    <a href="" class="item m-mobile-hide" >
                        <i class="idea icon"></i>
                        <router-link  to="/CatagoryPage" replaace>Catalogue</router-link>
                        <!-- <router-link to="/catagoryPage" >Catalogue</router-link> -->
                    </a>
                     <a href="" class="item m-mobile-hide" >
                        <i class="tags icon"></i>
                        <router-link to="/TagPage" replace>Tag</router-link>
                    </a>
                    <a href="" class="item m-mobile-hide" >
                        <i class="info icon"></i>
                        <router-link to="/AboutMe" repalce>About Me</router-link>
                    </a>
                    <!-- <a href="" class="item m-mobile-hide" @click="debounceNavigation('/blogManPage')">
                        <i class="info icon"></i>
                        <router-link :to="{ path: '/blogManPage' }" >Manage Blogs</router-link>
                    </a> -->
                    <!-- <a href=""  class="item  m-mobile-hide" ><i class="home icon"></i><router-link to="/homePage" >Homepage</router-link></a>
                    <a href=""  class="item  m-mobile-hide" ><i class="idea icon"></i><router-link to="/catagoryPage">Catalogue</router-link></a>
                    <a href=""  class="item  m-mobile-hide" ><i class="tags icon"></i><router-link to="/tagPage">Tag</router-link></a>
                    <a href=""  class="item  m-mobile-hide" ><i class="info icon"></i><router-link to="/aboutme">About Me</router-link></a>
                    <a href=""  class="item  m-mobile-hide" ><i class="info icon"></i><router-link to="/blogManPage">Manage Blogs</router-link></a> -->
                    <div class="right item">
                        <div class="ui search">
                            <div class="ui icon input">
                              <input class="prompt" type="text" placeholder="Common passwords...">
                              <i class="search icon"></i>
                            </div>
                          <div class="results"></div>
                     </div>
                  </div>
              </div>
             
          </div>
      </nav>
</template>
<script>
</script>