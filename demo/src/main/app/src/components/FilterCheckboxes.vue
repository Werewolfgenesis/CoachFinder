<template>
  <div class="d-flex">
    <div @change="filteredCoaches" v-for="area in displayedAreas" :key="area">
      <div class="form-check m-2">
        <input v-model="store.filters" class="form-check-input" type="checkbox" :value="area" id="flexCheckDefault" />
        <label class="form-check-label" for="flexCheckDefault"> {{ area }} </label>
      </div>
    </div>
  </div>
</template>
<script setup lang="ts">
import { mockedCoaches } from '@/mockData'
import { computed, ref } from 'vue'
import { useCoachStore } from '@/stores/CouchStore';

const store = useCoachStore()


const allCoachesAreas = ref(mockedCoaches.map((coach) => coach.areas))

const coachAreas = ref<string[]>([])
console.log(coachAreas.value);

const displayedAreas = computed(() => new Set(coachAreas.value))

const filteredCoaches = () => {
  
}

for (let i = 0; i < allCoachesAreas.value.length; i++) {
  for (let el = 0; el < allCoachesAreas.value[i].length; el++) {
    coachAreas.value.push(allCoachesAreas.value[i][el].desc)
  }
}
</script>
