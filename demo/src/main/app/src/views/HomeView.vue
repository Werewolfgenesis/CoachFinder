<script setup lang="ts">
import Header from '@/components/Header.vue'
import CoachList from '@/components/cardsComponents/CoachList.vue';
import HomeCarousel from '@/components/HomeCarousel.vue';

</script>

<template>
  <main>
    <Header></Header>
    <h5 class="text-center mb-4 title_animation" style="color: #ff7730;">OUR MOST WANTED COACHES</h5>
   <coach-list :slice=3></coach-list>
    <home-carousel></home-carousel>
  </main>
</template>
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