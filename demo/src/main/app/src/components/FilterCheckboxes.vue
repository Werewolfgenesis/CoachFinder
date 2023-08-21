<template>
  <div class="d-flex">
    <div v-for="area in allAreas" :key="area.code">
      <div class="form-check m-2">
        <input v-model="areasSelected" class="form-check-input" type="checkbox" :value="area.code" id="flexCheckDefault" />
        <label class="form-check-label" for="flexCheckDefault"> {{ area.desc }} </label>
      </div>
    </div>
  </div>
</template>
<script setup lang="ts">
import { mockedCoaches } from '@/mockData'
import { computed, onMounted, ref } from 'vue'
import { getAllAreas } from '@/services/CoachService';
import type { area } from '@/types/CoachType';

onMounted(async() => {
  allAreas.value = await getAllAreas()
  
})

const allAreas = ref<area[]>([])
const areasSelected = ref<string[]>([])



// const allCoachesAreas = ref(mockedCoaches.map((coach) => coach.areas))

// const coachAreas = ref<string[]>([])
// const displayedAreas = computed(() => new Set(coachAreas.value))


// for (let i = 0; i < allCoachesAreas.value.length; i++) {
//   for (let el = 0; el < allCoachesAreas.value[i].length; el++) {
//     coachAreas.value.push(allCoachesAreas.value[i][el].desc)
//   }
// }
</script>
