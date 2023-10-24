<template>
  <main>
    <Header></Header>
    <h5 class="text-center mb-4 title_animation" style="color: #ff7730;">OUR MOST WANTED COACHES</h5>
    <div v-if="coaches.length">
      <coach-list :coaches="coaches.slice(-3)"></coach-list>
    </div>
    <h5 class="text-center" style="color:  #ff7730;" v-else>LOADING...</h5>
    <home-carousel></home-carousel>
  </main>
</template>
<script setup lang="ts">
import Header from '@/components/Header.vue'
import CoachList from '@/components/cardsComponents/CoachList.vue';
import HomeCarousel from '@/components/HomeCarousel.vue';
import { onMounted, ref } from 'vue';
import type { Coach } from '@/types/Coach';
import { getAllCoaches } from '@/services/CoachService';

const coaches = ref<Coach[]>([])

onMounted(async() => {
coaches.value = await getAllCoaches()
})
</script>
<style scoped>
  @keyframes moveInBottom {
    0% {
      opacity: 0;
      transform: translateY(4rem);
    }
  
    100% {
      opacity: 1;
      transform: translate(0);
    }
  }
.title_animation {
  animation: moveInBottom  ease-out 0.75s;
}
</style>