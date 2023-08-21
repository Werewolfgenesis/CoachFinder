<template>
  <div class="">
    <h2 style="color: #ff7730;">Find your coach:</h2>
    <filter-checkboxes></filter-checkboxes>
    <coach-list></coach-list>
  </div>
</template>
<script setup lang="ts">
import { useCoachStore } from '@/stores/CouchStore';
import FilterCheckboxes from '@/components/FilterCheckboxes.vue';
import CoachList from '@/components/CoachList.vue';

import { mockedCoaches } from '@/mockData';
import { ref } from 'vue';

//TODO: api call for all coaches onMouted




</script>
<style>

</style>
