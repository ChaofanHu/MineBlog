<template>
    <!-- head  -->
    <nav class="ui inverted attached segment m-padding-tb-mini">
      <!-- my-padding-tb-classname for css-->
      <div class="container">
        <div class="ui inverted stackable menu">
            <h2 class="ui teal header item">MineBlog</h2>
            <RouterLink to="/" class="item m-mobile-hide">
                <i class="home icon"></i>HomePage
            </RouterLink>
            <RouterLink to="/CatagoryPage" class="item m-mobile-hide">
                <i class="idea icon"></i>Catogory
                </RouterLink>
            <RouterLink to="/TagPage" class="item m-mobile-hide">
                <i class="tags icon"></i>Tags
                </RouterLink>
            <RouterLink to="/AboutMe" class="item m-mobile-hide">
                <i class="info icon"></i>AboutMe
            </RouterLink>`
          <!-- 其他链接 -->
          <div class="right item">
            <div class="ui search">
              <div class="ui icon input">
                <input class="prompt" type="text" placeholder="Search...">
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

  // 如果有需要，这里可以添加JavaScript代码
  </script>
  