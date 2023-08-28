<template>
  <div v-if="mockedRequests.length" class="container mb-4 section-cards">
    <div class="row justify-content-center">
      <div class="col col-6 col-md-3 col-sm-2" v-for="req in mockedRequests" :key="req.email">
        <request-card :request="req"/>
      </div>
    </div>
  </div>
  <div v-else>THERE AREN'T REQUESTS AT THE MOMENT</div>
</template>
<script setup lang="ts">
import { onMounted, ref } from 'vue'

import type { CoachRequest } from '@/types/CoachType'
import { getAllRequests } from '@/services/CoachService'

import RequestCard from '@/components/cardsComponents/RequestCard.vue';

const requests = ref<CoachRequest | null>(null)

const mockedRequests: CoachRequest[] = [
  {
    email: 'jrekjrek@abv.bg',
    message: 'Hello',
    coach: {
      id: 1,
      firstName: 'mitko',
      lastName: 'sotirov',
      rate: 30.0,
      description: null,
      areas: [],
      requests: []
    }
  },
  {
    email: 'vanq@abg.bg',
    message: 'Hello I am interested in this course',
    coach: {
      id: 1,
      firstName: 'mitko',
      lastName: 'sotirov',
      rate: 30.0,
      description: null,
      areas: [],
      requests: []
    }
  }
]

onMounted(async () => {
  requests.value = await getAllRequests()
})
</script>
<style scoped>


.custom-card {
  perspective: 150rem;
  -moz-perspective: 150rem;
  position: relative;
  height: 20rem;
}

.custom-card__side {
  color: white;

  height: 20rem;
  transition: all 0.8s ease;
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  backface-visibility: hidden;
  border-radius: 3px;
  box-shadow: 0 1.5rem 4rem rgba(rgb(2, 2, 2), 0.15);
}

.custom-card:hover .custom-card__side {
  transform: rotateY(180deg);
}

/* FRONT SIDE */
.custom-card__side--front {
  background-image: linear-gradient(to bottom right, #ff7f30, #bbb);
}

.custom-card:hover .custom-card__side--front {
  transform: rotateY(-180deg);
}

/* BACK SIDE */
.custom-card__side--back {
  background-image: linear-gradient(to right bottom, #bbb, #ff7730);
  transform: rotateY(180deg);
}

.custom-card:hover .custom-card__side--back {
  transform: rotateY(0);
}
</style>