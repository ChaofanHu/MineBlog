<template>
    <div >
        <BlogHeader></BlogHeader>
        <SecondHeader></SecondHeader>
        <div class="m-container-small m-padding-tb">
            <sui-container >

                <sui-divider hidden />
                <sui-segment>
                <sui-form>
                    <!-- <sui-form-fields fields="one"> -->
                        <sui-form-field>
                            <label>Catagory</label>
                            <input type="text" placeholder="Catagory" />
                        </sui-form-field>
                        
<!-- 
                    </sui-form-fields> -->
                    <sui-container text-align="right">
                        <sui-button type="submit" class="teal">Add</sui-button>
                    </sui-container>
                </sui-form>
            </sui-segment>
            <sui-divider hidden />
            <sui-segment>
                <sui-form>
                    <!-- <sui-form-fields> -->
                        <sui-form-field>
                            <label>Tags</label>
                            <input type="text" placeholder="Tags" />
                        </sui-form-field>
                    <!-- </sui-form-fields> -->
                    <sui-container text-align="right">
                        <sui-button type="submit" class="teal">Add</sui-button>
                    </sui-container>
                </sui-form>
            </sui-segment>
                        




            <sui-divider hidden />

            <sui-segment>
                <sui-form>
                    <sui-form-field>
                    <label>Catagory</label>
                    <sui-dropdown
                        placeholder="Catagory"
                        selection
                        :options="optionsCatagory"
                        v-model="Catagory"
                        />
                    </sui-form-field>
                    <!-- </sui-form-fields> -->
                    <sui-container text-align="right">
                        <sui-button type="submit" class="teal">Delete</sui-button>
                    </sui-container>
                </sui-form>
            </sui-segment>

            <sui-divider hidden />

            <sui-segment>
                <sui-form>
                    <sui-form-field>
                    <label>Tags</label>
                    <sui-dropdown
                        placeholder="Tags"
                        selection
                        :options="optionsCatagory"
                        v-model="Catagory"
                        />
                    </sui-form-field>
                    <!-- </sui-form-fields> -->
                    <sui-container text-align="right">
                        <sui-button type="submit" class="teal">Delete</sui-button>
                    </sui-container>
                </sui-form>
            </sui-segment>
            </sui-container>
        </div>
    </div>
</template>

<script>
import BlogHeader from "../components/blogHeader.vue";
import SecondHeader from "../components/SecondHeader.vue"
export default {
    components:{
        BlogHeader,
        SecondHeader
    },
    data(){
        return{
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
        }
    }
}
</script>