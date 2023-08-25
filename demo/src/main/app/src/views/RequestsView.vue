<template>
  <div class="container mb-4 section-cards">
    <div class="row justify-content-center">
      <div class="col col-6 col-md-3 col-sm-2" v-for="req in requests" :key="req.coach.id">
        <RequestCard :email="req.email" :message="req.message"></RequestCard>
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
