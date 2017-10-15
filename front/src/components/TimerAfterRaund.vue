<template>
  <div v-if='checked'>
    <b-container class="bv-example-row">
      <b-row class="text-center">
        <b-col>
          <h1>До следующего раунда: </h1>
        </b-col>
        <b-col>
          <div class="timer">
            <ul id=timer-ones>
              <li>9</li>
              <li>8</li>
              <li>7</li>
              <li>6</li>
              <li>5</li>
              <li>4</li>
              <li>3</li>
              <li>2</li>
              <li>1</li>
              <li>0</li>
            </ul>
          </div>
        </b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
  export default {
    name: 'TimerRaund',
    data() {
      return {
        //        image: ''
      }
    },
    computed: {
      checked() {
        return this.$store.getters.timer;
      },
    }
  }

</script>

<style>
  .timer {
    display: inline-block;
    height: 2.5rem;
    overflow: hidden;
  }

  .timer li {
    color: #FFF;
    font-family: 'Roboto', Helvetica;
    font-size: 2.5rem;
  }

  .timer ul {
    display: inline-block;
    list-style-type: none;
    width: 2.5rem;
    padding-left: 0;
    margin-top: 0;
    position: relative;
    top: -2.5rem;
    line-height: 2.5rem;
  }

  @keyframes rollover {
    0% {
      top: 0px;
    }
    10% {
      top: -2.5rem;
    }
    20% {
      top: -5rem;
    }
    30% {
      top: -7.5rem;
    }
    40% {
      top: -10rem;
    }
    50% {
      top: -12.5rem;
    }
    60% {
      top: -15rem;
    }
    70% {
      top: -17.5rem;
    }
    80% {
      top: -20rem;
    }
    90% {
      top: -22.5rem;
    }
    100% {
      top: -25rem;
    }
  }

  #timer-ones {
    animation: rollover 10s cubic-bezier(1.000, 0.005, 0.995, 0.090) infinite;
  }

</style>
