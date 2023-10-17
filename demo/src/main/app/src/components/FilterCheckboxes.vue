<template>
  <div class="d-flex">
    <div v-for="area in allAreas" :key="area.code">
      <div class="form-check m-2">
        <input v-model="areasSelected" @change="handleFilters" class="form-check-input" type="checkbox" :value="area.code" id="flexCheckDefault" />
        <label class="form-check-label" for="flexCheckDefault"> {{ area.desc }} </label>
      </div>
    </div>
      <custom-button @click="handleRefresh" type="button" title="REFRESH"></custom-button>
    </div>
</template>
<script setup lang="ts">
import { computed, onMounted, ref } from 'vue'
import { getAllAreas } from '@/services/AreaService';
import type { Area } from '@/types/Area';

import CustomButton from './customComponents/CustomButton.vue';

onMounted(async() => {
  allAreas.value = await getAllAreas()
  
})

const allAreas = ref<Area[]>([])
const areasSelected = ref<string[]>([])


const emit = defineEmits(['handleFilters'])

const handleFilters = () => {
emit('handleFilters', areasSelected.value)
}

const handleRefresh = () => {
  areasSelected.value = []
  handleFilters()
}

</script>