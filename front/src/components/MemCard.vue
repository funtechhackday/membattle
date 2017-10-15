<template>
  <div>
     <b-card no-body
            style="max-width: 35em; margin: 0px 0px 0px 0px;"
            class="text-center"
            id="warped"
            >
      <span v-if="typeof mem.likeCount !== 'undefined'" class="meme-likes">Проголосовало: <br> {{ mem.likeCount }}</span>
      <span v-if="mem.isWinner" class="text-white font-weight-bold">Победитель!</span>
      <a @click="choose" class="meme-btn">
          <b-img :src="mem.url" alt="meme" rounded class="meme-img" />
          <!-- <b-button href="#" variant="primary" class="btn dark">Test button</b-button> -->
      </a>
    </b-card>
  </div>
</template>


<script>
  export default {
    name: 'UserModal',
    props: ['position'],
    data() {
      return {}
    },
    computed: {
      mem() {
        if (this.position === 'left') {
          return this.$store.getters.currentLeft;
        } else if (this.position === 'right') {
          return this.$store.getters.currentRight;
        }
      },
    },
    methods: {
      choose() {
        this.$store.dispatch('socket_chooseMem', this.mem.id);
      }
    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  /* .wrapper{

  } */
  a{
    text-decoration: none;
  }
  #warped{
    background-color: #000000;
  margin: 0px 0px 25px 0px !important;
}
.meme-img{
  height: 350px;
  object-fit: cover;
}
.meme-btn{
  padding: 0px !important;
  border: 3px solid #000 !important;
  display: block;
}
a.meme-btn:active{
  border: 3px solid #fff !important;
  display: block !important;
  line-height: 105% !important;
  -moz-transition: all 0.5s ease-in-out !important;
-webkit-transition: all 0.5s ease-in-out !important;
-moz-transition: all 0.5s ease-in-out !important;
-o-transition: all 0.5s ease-in-out !important;
  transition: all 0.5s ease-in-out !important;
}
a.meme-btn:hover{
  border: 3px solid #fff !important;
  display: block !important;
  line-height: 105% !important;
  -moz-transition: all 0.5s ease-in-out !important;
-webkit-transition: all 0.5s ease-in-out !important;
-moz-transition: all 0.5s ease-in-out !important;
-o-transition: all 0.5s ease-in-out !important;
  transition: all 0.5s ease-in-out !important;
}

span.meme-likes {
    display:inline-block;
    position:absolute;
    /*top: 0;*/
    z-index: 2;
    color:#FFF;
    font-family: 'Roboto', Helvetica;
    font-size:30px;

    background-color:rgba(0,0,0,.4);
    height: 100%;
    width: 100%;
}
</style>
