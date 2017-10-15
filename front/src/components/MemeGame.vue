<template>
  <div>
    <div v-if="stage === 1">
      <!-- Raund -->
    <b-container class="bv-example-row">
      <timer-raund>
      </timer-raund>
    </b-container>
    <b-container class="bv-example-row" center>
      <b-row align-h="center">
    <b-card-group deck>
      <b-col align-self="start">
      <mem-card position="left">
      </mem-card>
      </b-col>
      <b-col align-self="end">
      <mem-card position="right">
      </mem-card>
      </b-col>
    </b-card-group>
      </b-row>
    </b-container>
    </div>
    <div v-if="stage === 2">
      <!-- After raund -->
      <timer-after-raund>
      </timer-after-raund>
      <game-table>
      </game-table>
    </div>
        <div v-if="stage === 3">
      <!-- Show winner -->
      <winner></winner>  
    </div>
  </div>
</template>

<script>
import MemCard from './MemCard';
import TimerAfterRaund from './TimerAfterRaund';
import TimerRaund from './TimerRaund';
import GameTable from './GameTable';
import Winner from './Winner';

export default {
  name: 'MemeGame',
  components: {
    MemCard,
    TimerAfterRaund,
    TimerRaund,
    GameTable,
    Winner,
  },
  data () {
    return {}
  },
  computed: {
  stage() {
    return this.$store.getters.stage;
      },
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
