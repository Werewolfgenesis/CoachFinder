<template>
  <div class="d-flex">
    <div v-for="area in allAreas" :key="area.code">
      <div class="form-check m-2">
        <input v-model="areasSelected" @change="handleFilters" class="form-check-input" type="checkbox" :value="area.code" id="flexCheckDefault" />
        <label class="form-check-label" for="flexCheckDefault"> {{ area.desc }} </label>
      </div>
    </div>
  </div>
</template>
<script setup lang="ts">
import { mockedCoaches } from '@/mockData'
import { computed, onMounted, ref } from 'vue'
import { getAllAreas } from '@/services/CoachService';
import type { Area } from '@/types/CoachType';

onMounted(async() => {
  allAreas.value = await getAllAreas()
  
})

const allAreas = ref<Area[]>([])
const areasSelected = ref<string[]>([])

const emit = defineEmits(['handleFilters'])

const handleFilters = () => {

emit('handleFilters', areasSelected.value)
}

</script>
 