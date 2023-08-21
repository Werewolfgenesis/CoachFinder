<template>
  <div class="custom-card m-auto">
    <div class="custom-card__side custom-card__side--front container text-center">
      <div class="row pt-4 pb-2">
        <div class="col text-center">
          <h5 class="card-title fs-3">{{ coach?.firstName }} {{ coach?.lastName }}</h5>
          <div class="fs-4">${{ coach?.rate }}/hour</div>
        </div>
      </div>
      <div class="row">
        <div class="col" v-for="skill in coach?.areas" :key="skill.code">
          <div>{{ skill.desc }} eerer </div>
        </div>
        <div> eerer </div>
          <div> eerer </div>
      </div>
    </div>
    <div class="custom-card__side custom-card__side--back d-flex align-items-center">
      <div class="m-auto container">
        <div class="row">
          <!-- <div class="col"> -->
          <p class="card-description text-center">I'm Reni. ethusiast with lot of skills which 'm Reni.rontend ethusiast with lot of skills which 'm Reni. Frontend ethusiast with lot of skills which I'm ready to share!</p>
          <!-- </div> -->
        </div>
        <div class="row">
          <div class="text-center">
            <custom-button title="Contact" type="button" class="btn btn-primary"></custom-button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script setup lang="ts">
import type { Coach } from '@/types/CoachType'
import CustomButton from './customComponents/CustomButton.vue'

import { type PropType, ref } from 'vue'

// const toggleDetails = ref(false)

defineProps({
  coach: {
    type: Object as PropType<Coach>
  }
})

// const handleDetailsPage = () => {
//   toggleDetails.value = !toggleDetails.value
// }
</script>
<style>
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
  background-image: linear-gradient(to bottom right, #ff7730, #bbb);
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

.btn--orange {
  background-color: #ff7730 !important;
  border: 0 !important;
}
.btn--orange:hover {
  background-color: #f0661c !important;
}



/* .animation:hover{
  position: absolute;
  top: 50%;
  left:50%;
transform: translate(-50%, -50%);
} */
</style>
