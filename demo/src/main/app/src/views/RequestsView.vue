<template>
  <div class="container mb-4 section-cards">
    <h3 class="requests-header text-center p-2 header-animation">All requests</h3>
    <div class="row justify-content-center">
      <div class="col col-6 col-md-3 col-sm-2" v-for="req in requests" :key="req.coach.id">
        <RequestCard  :request="req"></RequestCard>
      </div>
    </div>
  </div>
</template>
<script setup lang="ts">
import { onMounted, ref } from 'vue'

import RequestCard from '@/components/cardsComponents/RequestCard.vue'
import { getAllRequests } from '@/services/CoachService'
import type { CoachRequest } from '@/types/CoachType'
const requests = ref<CoachRequest | null>(null)

onMounted(async () => {
  requests.value = await getAllRequests()
})
</script>
<style scoped>

.requests-header{
  background-image: linear-gradient(to right, rgb(222, 175, 139), #ef5e10);
  -webkit-background-clip: text;
  color: transparent;
  text-transform: uppercase;
}

.header-animation {
  animation-name: leftToRight;
    animation-duration: 1s;
    animation-timing-function: ease-out;
}
</style>
