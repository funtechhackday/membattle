<template>
    <div v-if='checked'>
        <b-container class="bv-example-row">
            <b-row class="text-center">
                <b-col>
    <h1>До следующей пары: </h1>
                </b-col>
                <b-col>
        <div class="timer">
        <ul id=timer-ones>
            <li>5</li>
            <li>4</li>
            <li>3</li>
            <li>2</li>
            <li>1</li>
        </ul>
        </div>
       </b-col>
       
    <!-- <b-col>
    <img src="../assets/Pacman.svg"></svg>
    </b-col> -->
    </b-row>
        </b-container>
    </div>
</template>

<script>
    export default {
        name: 'TimerAfterRaund',
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
.timer { display: inline-block; height: 2.5rem; overflow: hidden; }
.timer li{
    color:#FFF;
    font-family: 'Roboto', Helvetica;
    font-size:2.5rem; 
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
     0% { top: 0px; }
    20% { top: -2.5rem; }
    40% { top: -5rem; }
    60% { top: -7.5rem; }
    80% { top: -10rem; }
    100% { top: -12.5rem; }
}
#timer-ones {animation: rollover 5s cubic-bezier(1.000,0.005,0.995,0.090) infinite;}


</style>