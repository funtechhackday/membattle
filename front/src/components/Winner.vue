<template>
    <div>
        <b-container class="bv-example-row">
            <b-row class="text-center">
              <h1>
                  Победил мем:
              </h1>
        </b-row>
        <b-row>
        <img :src="winners_memes" alt="meme" height="500px"/>
        </b-row>
        </b-container>
    </div>
</template>

<script>
    export default {
        name: 'Winner',
         data() {
            return {
//        image: ''
            }
        },
        computed: {
      winners_memes(){
        return this.$store.getters.winner_url;
        },
        }
    }
</script>

<style>


</style>