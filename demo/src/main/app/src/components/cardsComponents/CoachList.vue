<template>
  <div>
    <div v-if="coaches.length" class="container mb-4 section-cards">
      <div v-if="filters?.length && !filteredCoaches.length" class="text-center mb-2" style="color: #ff7730;">THERE AREN'T COACHES WITH THIS SKILL</div>
      <div v-else>
        <div class="row  justify-content-center">
        <div class="col col-6 col-md-3 col-sm-2"
        v-for="coach in filteredCoaches?.length ? filteredCoaches : (slice ? coaches.slice(-slice) : coaches)" 
        :key="coach.id">
          <CoachCard :coach="coach"></CoachCard>   
        </div> 
      </div>
    </div>
      </div>
    <div v-else class="text-center mb-2" style="color: #ff7730;">THERE AREN'T COACHES AT THE MOMENT</div>
  </div>
  

</template>
<script setup lang="ts">
import CoachCard from './CoachCard.vue';

import { getAllCoaches } from '@/services/CoachService';
import { onMounted, PropType, ref } from 'vue'
import { Coach } from '@/types/CoachType';

const coaches = ref<Coach[]>([])



const props = defineProps({
    slice: {
        type: Number,
        required: false
    },
    filteredCoaches: {
      type: Object as PropType<Coach[]>,
      required: true,
    },
    filters: {
      type: Array,
      required: false
    }
})

onMounted(async () => {
 coaches.value = await getAllCoaches()
 
})

</script>
<style scoped>
.section-cards {
 padding: 3rem 0;
}


</style>