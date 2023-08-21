<template>
  <div class="card m-auto" >
    <div class="container p-2">
      <div class="row">
        <div class="col align-items-center"> 
           <h5 class="card-title">{{ coach?.firstName }} {{ coach?.lastName }}</h5>
          <div class="pb-4">${{ coach?.rate }}/hour</div>
        </div>
      </div>
    <div class="row" style="height: 3rem;">
      <div class="col-6 align-items-center" v-for="skill in coach?.areas" :key="skill.code">
        <div>{{ skill.desc }}</div>
      </div>
    </div>
    <div v-if="toggleDetails" class="row" >
      <div class="col align-items-center ">
        <p>I'm Reni. Frontend ethusiast with lot of skills which I'm ready to share!</p>
      </div>
    </div>
      
    <!-- TODO: router-link to details page -->
    <div class="row gap-1">     
      <custom-button @click="handleDetailsPage()" title="View details" type="button"  class="btn btn-dark"></custom-button>
      <custom-button title="Contact" type="button" class="btn btn-primary"></custom-button>
    </div>
      
    </div>
  </div>
</template>
<script setup lang="ts">
import type { Coach } from '@/types/CoachType'
import CustomButton from './customComponents/CustomButton.vue';

import {type PropType, ref } from 'vue'

import { useRouter } from 'vue-router';

const router = useRouter()
const toggleDetails = ref(false)

defineProps({
  coach: {
    type: Object as PropType<Coach>
  }
})

const handleDetailsPage = () => {
toggleDetails.value = !toggleDetails.value
}
</script>
<style scoped>

</style>