
<template>
  <div>
  <div class="custom-card mb-4">
    <div class="custom-card__side custom-card__side--front container text-center">
      <div class="row pt-4 pb-2"> 
        <div class="col text-center">
          <h5 class="card-title fs-3">{{ coach?.firstName }} {{ coach?.lastName }}</h5>
          <div class="fs-4 card__rate">${{ coach?.rate }}per/hour</div>
        </div>
      </div>
      <ul class="list-group " v-for="skill in coach?.areas" :key="skill.code">
        <li class="card__skill">{{ skill }}</li>
      </ul>
    </div>
    <div class="custom-card__side custom-card__side--back d-flex align-items-center">
      <div class="m-auto container">
        <div class="row card_description">
          <div v-if="coach?.description" class="col">
            <p class="text-center ">{{ coach?.description }}</p>
          </div>
          <div v-else>
            <p class="text-center ">This coach hasn't got description</p>
          </div>
        </div>
        <div class="row">
          <div class="text-center">
            <custom-button
              title="Contact"
              type="button"
              class="btn btn-primary"
              data-bs-toggle="modal"
              :data-bs-target= "'#demo' + coach?.id" 
            ></custom-button>
          </div>
        </div>
      </div>
    </div>
  </div>
  <ContactFormComponent
    :title="coach?.firstName + ' ' + coach?.lastName"
    :target = "'demo' + coach?.id" 
    body="tapak"
    :coachId="coach?.id"
  />
  </div>
</template>

<script setup lang="ts">
import type { Coach } from '@/types/Coach'
import { type PropType } from 'vue'
import ContactFormComponent from '../ContactFormComponent.vue'
import CustomButton from '../customComponents/CustomButton.vue'



const props = defineProps({
  coach: {
    type: Object as PropType<Coach>
    }
  })

</script>

<style>
ul {
  list-style: none;
}

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
  box-shadow:3rem 1.5rem 4rem rgba(black, .15);
}

.custom-card:hover .custom-card__side {
  transform: rotateY(180deg);
}

/* FRONT SIDE */
.custom-card__side--front {
  background-image: linear-gradient(to right bottom, #bbb, #ff7730);
}

.custom-card:hover .custom-card__side--front {
  transform: rotateY(-180deg);
}

/* BACK SIDE */
.custom-card__side--back {
  background-color: #eee;
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

.card__skill {
  border-bottom: 1px solid #f7f7f7;;
}

.card_description {
  background-image: linear-gradient(to right, rgb(222, 175, 139), #ef5e10);
  -webkit-background-clip: text;
  color: transparent;
}

.card__rate {
  background-image: linear-gradient(to right, rgba(246, 237, 237, 0.989), #f7e0d9e7);
  -webkit-background-clip: text;
  color: transparent;
}
</style>
