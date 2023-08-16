<template>
    <div v-if="mockedCoaches.length" class="container mb-4">
      <div class="row">
        <div class="col col-6 col-md-4 col-sm-2 align-items-center justify-content-center" v-for="coach in slice ? mockedCoaches.slice(-slice) : mockedCoaches" :key="coach.id">
          <CoachCard :coach="coach"></CoachCard>
        </div> 
      </div>
    </div>
    <div v-else>THERE AREN'T COACHES AT THE MOMENT</div>
</template>
<script setup lang="ts">
import CoachCard from './CoachCard.vue';

import { getAllCoaches } from '@/services/CoachService';
import { onMounted } from 'vue'
import { mockedCoaches } from '@/mockData';

// TODO: call service
onMounted(() => {
const coaches = getAllCoaches()
console.log(coaches);

})

defineProps({
    slice: {
        type: Number,
        required: false
    }
})



</script>