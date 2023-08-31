<script setup lang="ts">
import type { CoachRequest } from "@/types/CoachType";
import type { PropType } from "vue";

const props = defineProps({

  request: {
    type: Object as PropType<CoachRequest>
  }
})
</script>

<template>
  <div class="custom-card mb-4">
    <div class="custom-card__side custom-card__side--front">
      <div class="row pt-4 pb-2">
        <div class="col text-start p-4">
          <h4 class="fs-2">Request</h4>
          <p class="fs-5 border-bottom">From: {{ request?.email }}</p>
          <p class="fs-5 border-bottom">For: {{ request?.coach.firstName}} {{request?.coach.lastName}}</p>
        </div>
      </div>
    </div>
    <div class="custom-card__side custom-card__side--back">
      <div class="row pt-4 pb-2">
        <div class="col text-start p-4">
          <div class="fs-3">Message: 
            <p class="fs-5">{{ request?.message }}</p>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<style scoped>
.custom-card {
  perspective: 150rem;
  -moz-perspective: 150rem;
  position: relative;
  height: 18rem;
}

.custom-card__side {
  color: white;

  margin-top: 2rem;
  height: 18rem;
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
</style>
