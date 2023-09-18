<template>
  <div class="container mb-4 section-cards">
    <h3 class="requests-header text-center p-2">All requests</h3>
    <div class="row justify-content-center">
      <div v-if="requests.length">
        <div class="col col-6 col-md-3 col-sm-2" v-for="req in requests" :key="req.coach.id">
          <RequestCard :request="req"></RequestCard>
        </div>
      </div>
      <div class="text-center" style="color: #ef5e10;" v-else>There aren't any requests</div>
    </div>
  </div>
</template>
<script setup lang="ts">
import { onMounted, ref } from 'vue'

import RequestCard from '@/components/cardsComponents/RequestCard.vue'
import { getAllRequests } from '@/services/CoachRequestService'
import type { CoachRequest } from '@/types/CoachRequest'
const requests = ref<CoachRequest[]>([])

onMounted(async () => {
  requests.value = await getAllRequests()
})
</script>
<style scoped>
.requests-header {
  background-image: linear-gradient(to right, rgb(222, 175, 139), #ef5e10);
  -webkit-background-clip: text;
  color: transparent;
  text-transform: uppercase;

  animation-name: leftToRight;
  animation-duration: 1s;
  animation-timing-function: ease-out;
}
</style>
@/types/Coach