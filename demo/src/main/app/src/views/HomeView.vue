<script setup lang="ts">
import Header from '@/components/Header.vue'
import CoachList from '@/components/CoachList.vue';
import HomeCarousel from '@/components/HomeCarousel.vue';
import FilterCheckboxes from '@/components/FilterCheckboxes.vue';

</script>

<template>
  <main>
    <Header></Header>
    <h5 class="text-center mb-4">OUR MOST WANTED COACHES</h5>
   <coach-list :slice=3></coach-list>
    <home-carousel></home-carousel>
  </main>
</template>
