<template>
  <div class="p-4">
    <div>
      <div v-if="coaches?.length" class="row justify-content-center">
        <div v-for="coach in coaches" :key="coach.id" class="col col-12 col-xl-2 col-lg-4 col-md-4 col-sm-4">
          <CoachCard :coach="coach"></CoachCard>
        </div>
      </div>
      <div v-else>
        <h5 class="text-center" style="color:  #ff7730;">Sorry, there aren't more coaches :)</h5>
      </div>
    </div>
  </div>
</template>
<script setup lang="ts">
import CoachCard from './CoachCard.vue'

import { type PropType } from 'vue'
import { type Coach } from '@/types/Coach'

const props = defineProps({
  coaches: {
    type: Object as PropType<Coach[]>,
    required: false
  },
  filters: {
    type: Array,
    required: false
  }
})


</script>
<style scoped>
</style>
