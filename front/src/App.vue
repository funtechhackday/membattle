<template>
  <div id="app">
    <b-navbar toggleable="md" type="dark" variant="info" class="navbar">
      <b-container class="bv-example-row">
      <b-nav-toggle target="nav_collapse"></b-nav-toggle>
      <b-collapse is-nav id="nav_collapse">
        <b-nav>
          <b-nav-item  href="#/">На главную</b-nav-item>
          <b-nav-item href="#/rules" class="text">Правила</b-nav-item>
          <b-nav-item href="#/about" class="text">О нас</b-nav-item>
        </b-nav>
      </b-collapse>
      <b-nav-text class="text">{{ username }} </b-nav-text>
      <b-nav-text class="text"><img src="./assets/coin.png" alt="coin" class="coin"></b-nav-text>
      <b-nav-text class="text">{{ coins }}</b-nav-text>
        <b-nav>
          <b-nav-item href="#/" class="sm" v-b-modal.userModal><img :src= "avatar" alt="Avatar" class="avatar"></b-nav-item>
        </b-nav>
        </b-container>
</b-navbar>
    <div class="content">
    <router-view/>
    </div>
    <footer class="footer" id="bottom-footer">
      <b-container class="bv-example-row">
    <b-row class="text-center">
      <b-col><img src="./assets/Pacman.svg" alt="logo" width="75px"></b-col>
      <b-col><ul>
        <li><a href="#/about" class="text">О нас</a></li>
        <li><a href="#/rules" class="text">Правила</a></li>
      </ul>
      </b-col>
        <b-col>
        <p class="text">Следи за нами в соц сетях:</p>
        <a href="http://vk.com/" target="__blank"><i class="text fa fa-vk fa-2x" aria-hidden="true"></i></a>
        <a href="http://facebook.com/" target="__blank"><i class="text fa fa-facebook fa-2x" aria-hidden="true"></i></a>
        <a href="http://twitter.com" target="__blank"><i class="text fa fa-twitter fa-2x" aria-hidden="true"></i></a>
        </b-col>
        <div class="w-100"></div>
        <b-col><p class="text under">Сделанно специально для FunTech Hackaton</p></b-col>
    </b-row>
    </b-container>
  </footer>
    <user-modal>
    </user-modal>
</div>
</template>

<script>
import UserModal from './components/UserModal.vue';

export default {
  name: 'app',
  components: {
      UserModal
  },
  computed: {
    avatar(){
      return this.$store.getters.avatar;
    },
    username(){
      return this.$store.getters.username;
    },
    coins(){
      return this.$store.getters.coins;
    }
  }
}
</script>

<style>
#app {
  font-family: 'Roboto', Helvetica;
}
.avatar{
  height: 65px;
  border-radius: 100%;
}

.navbar{
  padding: 4px !important;
}
.nav{
  padding: 0px !important;
}

.navbar{
  background-color: #000000 !important;
}
a.nav-link {
    padding: 3px 16px 3px 16px !important;
}
.text{
  color: #3d60e3 !important;
  padding-left: 5px;
}
.text:hover{
  text-decoration: none;

}
footer{
  padding-top: 5px;
}
footer li{
  list-style: none;
  text-decoration: underline;
}
footer .text{
  color: white !important;
}
.coin{
  height: 20px;
}
footer{
  background-color: #000000 !important;
  /* position: absolute; */
  bottom: 0;
  width: 100%;
}
footer .text.under{
  color: #484c5e !important;
  margin: 5px !important;

}
</style>
