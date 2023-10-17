<template>
  <div class="p-2">
    <h2 class="all-coaches__header">Find your coach:</h2>
      <filter-checkboxes @handle-filters="handleFilters" ></filter-checkboxes>
    <coach-list :filteredCoaches="filteredCoaches" :filters="filter"></coach-list>
  </div>
</template>
<script setup lang="ts">
import FilterCheckboxes from '@/components/FilterCheckboxes.vue';
import CoachList from '@/components/cardsComponents/CoachList.vue';

import { ref } from 'vue';
import { getFilteredCoaches } from '@/services/CoachService';
import type { Coach } from '@/types/CoachType';

const filteredCoaches = ref<Coach[]>([])
const filter = ref<string[]>([])

const handleFilters = async (filters: string[]) => {
  filteredCoaches.value = await getFilteredCoaches(filters) 
  filter.value = filters
}
</script>
<style>

.all-coaches__header {
  display: inline-block;
  background-image: linear-gradient(to right, rgba(226, 152, 112, 0.874), rgb(227, 84, 18));
  -webkit-background-clip: text;
  color: transparent;
  
  animation-name: leftToRight;
    animation-duration: 1s;
    animation-timing-function: ease-out;

}
</style>
@/types/Coach