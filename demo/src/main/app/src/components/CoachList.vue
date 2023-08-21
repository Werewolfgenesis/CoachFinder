<template>
    <div v-if="mockedCoaches.length" class="container mb-4">
      <div class="row  justify-content-center">
        <div class="col col-6 col-md-3 col-sm-2 " v-for="coach in slice ? coaches.slice(-slice) : coaches" :key="coach.id">
          <CoachCard :coach="coach"></CoachCard>
        </div> 
      </div>
    </div>
    <div v-else>THERE AREN'T COACHES AT THE MOMENT</div>
</template>
<script setup lang="ts">
import CoachCard from './CoachCard.vue';

import { getAllCoaches } from '@/services/CoachService';
import { onMounted, ref } from 'vue'
import { mockedCoaches } from '@/mockData';

const coaches = ref([])

onMounted(async () => {
 coaches.value = await getAllCoaches()
})

defineProps({
    slice: {
        type: Number,
        required: false
    }
})



</script>