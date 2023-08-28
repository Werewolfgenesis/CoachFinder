<template>
    <div v-if="coaches.length" class="container mb-4 section-cards">
      <div class="row  justify-content-center">
        <div class="col col-6 col-md-3 col-sm-2 "
        v-for="coach in filteredCoaches?.length ? filteredCoaches : coaches" 
        :key="coach.id">
          <CoachCard :coach="coach"></CoachCard>
        </div> 
      </div>
    </div>
    <div v-else class="text-center mb-2" style="color: #ff7730;">THERE AREN'T COACHES AT THE MOMENT</div>
</template>
<script setup lang="ts">
import CoachCard from './CoachCard.vue';

import { getAllCoaches } from '@/services/CoachService';
import { onMounted, PropType, ref } from 'vue'
import { mockedCoaches } from '@/mockData';
import type { Coach } from '@/types/CoachType';

const coaches = ref<Coach[]>([])

onMounted(async () => {
 coaches.value = await getAllCoaches()
 
})

defineProps({
    slice: {
        type: Number,
        required: false
    },
    filteredCoaches: {
      type: Object,
      required: false,
    }
})



</script>
<style scoped>
.section-cards {
 padding: 3rem 0;
}


  

</style>