<template>
  <div class="card m-2" style="width: 20rem; height: 12rem">
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
      
    <!-- TODO: router-link to details page -->
    <div class="d-flex gap-2">
      <custom-button @click="handleDetailsPage()" title="View details" type="button" class="btn btn-dark"></custom-button>
      <custom-button title="Contact" type="button" class="btn btn-primary">
      </custom-button>
     
    </div>
      
    </div>
  </div>
</template>
<script setup lang="ts">
import type { Coach } from '@/types/CoachType'
import CustomButton from './customComponents/CustomButton.vue';

import type { PropType } from 'vue'

import { useRouter } from 'vue-router';

const router = useRouter()

defineProps({
  coach: {
    type: Object as PropType<Coach>
  }
})

const handleDetailsPage = () => {
router.push({path: '/details'})
}
</script>
