<template>
  <div v-if='checked'>
    <b-container class="bv-example-row">
        <b-row>
            <h1>
                Победители раунда:
            </h1>
        </b-row>
      <b-row class="text-center">
         <b-col v-for="memes in winners_memes" :key="memes.id">
             <b-img :src="memes.url" alt="meme" rounded height="350px"/>
         </b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
  export default {
    name: 'GameTable',
  data () {
    return {}
  },
    computed: {
        checked() {
            return this.$store.getters.timer;
      },    
      winners_memes(){
        return this.$store.getters.winners_memes;
        },
    }
  }

</script>

<style>
img.memes-img{
    padding-bottom: 20px;
}
</style>
