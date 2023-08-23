<template>
  <div class="">
    <h2 style="color: #ff7730;">Find your coach:</h2>
      <filter-checkboxes @handle-filters="handleFilters" ></filter-checkboxes>
    <coach-list :filteredCoaches="filteredCoaches"></coach-list>
  </div>
</template>
<script setup lang="ts">
import FilterCheckboxes from '@/components/FilterCheckboxes.vue';
import CoachList from '@/components/CoachList.vue';

import { ref } from 'vue';
import { getFilteredCoaches } from '@/services/CoachService';
import type { Coach } from '@/types/CoachType';

const filteredCoaches = ref<Coach[]>([])

const handleFilters = async (filters: string[]) => {
  filteredCoaches.value = await getFilteredCoaches(filters) 
  console.log(filteredCoaches.value);
  
}


</script>
<style>

</style>
