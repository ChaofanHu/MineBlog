<template>
     <div class="background">
      <sui-grid centered vertical-align="middle">
        <sui-grid-column>
          <h2 is="sui-header" color="black" image>
            <sui-image  src="https://search.usi.ch/img/bollino-usi.svg" />
            
            <sui-header-content >Log-in</sui-header-content>
          </h2>

          <sui-form>
            <sui-segment stacked>
              <sui-form-field>
                <sui-input
                  type="email"
                  placeholder="E-mail address "
                  icon="user"
                  icon-position="left"
                  v-model="login.email"
                />
              </sui-form-field>
              <sui-form-field>
                <sui-input
                  type="password"
                  placeholder="Password"
                  icon="lock"
                  icon-position="left"
                  v-model="login.password"
                />
              </sui-form-field>
              <sui-button size="large" color="black" fluid @click="submit">Login</sui-button>
            </sui-segment>
          </sui-form>

          <sui-message>New to us? <a href="#">Sign Up</a></sui-message>
        </sui-grid-column>
      </sui-grid>
  </div>
</template>

 <script>
//  import axios from "../../node_modules/axios"
//  import QS from"../../node_modules/qs"
  export default{
    data(){
      return{
        login:{
          email:"",
          password:""
        }
      }
    },
    methods:{
      submit(){  
        var _this = this;
        this.axios.post("http://localhost:8090/admin/login",
        this.$qs.stringify({
          email:_this.login.email,
          password:_this.login.password
        })).then(function(resp){
          if(resp.data.code == 200){
             _this.$router.push({path:'/Admin/BlogManPage'})
            localStorage.setItem('token', resp.data.data);
            localStorage.setItem('id', resp.data.msg)
          }else{
            alert("please check your email or password")
          }
        })
        }
      }
    }
</script>

<style lang="css" scoped>
.background {
  background-color: #dadada !important;
  height: 100vh;
  margin: 1em 0;
}

.grid {
  height: 100%;
}

.column {
  max-width: 450px;
  text-align: center !important;
}
</style>