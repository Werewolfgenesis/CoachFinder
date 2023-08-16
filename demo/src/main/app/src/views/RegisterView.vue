<template>
  <div>
    <div class="text-center m-4"> 
        <h2>REGISTER A COACH, NOW!</h2>
    </div>
    <form>
      <div class="row">
        <div class="mx-auto col-10 col-md-8 col-lg-6">
          <div class="mb-3">
            <label for="firstName" class="form-label">First Name</label>
            <input v-model="firstName" type="text" class="form-control" id="firstName" aria-describedby="emailHelp" />
          </div>
          <div class="mb-3">
            <label for="lastName" class="form-label">Last Name</label>
            <input v-model="lastName" type="text" class="form-control" id="lastName" aria-describedby="emailHelp" />
          </div>
          <div class="mb-3">
            <label for="description" class="form-label">Description</label>
            <textarea v-model="description"
              class="form-control rounded-0"
              id="exampleFormControlTextarea2"
              rows="3"
            ></textarea>
          </div>
          <div class="mb-3">
            <label for="hourlyRate" class="form-label">Hourly Rate</label>
            <input
              v-model="hourlyRate"
              type="number"
              class="form-control"
              id="hourlyRate"
              aria-describedby="emailHelp"
            />
          </div>
          <div v-for="(area, indx) in areas" :key="indx">
            <div class="form-check m-2">
              <input
                v-model="skillsSelected"
                class="form-check-input"
                type="checkbox"
                :value="area"
                id="flexCheckDefault"
              />
              <label class="form-check-label" for="flexCheckDefault"> {{ area }} </label>
            </div>
          </div>
        </div>
      </div>
      <div class="text-center mb-4"> 
          <custom-button @click="handleSubmit" title="Submit" type="submit" class="btn btn-md btn-primary"></custom-button>
      </div>
    </form>
  </div>
</template>
<script setup lang="ts">
import CustomButton from '@/components/customComponents/CustomButton.vue';

import { ref } from 'vue'

const areas = ref<string[]>(['Frontend Developer', 'Backend Developer', 'Career Advisory'])
const skillsSelected = ref<string[]>([])

const handleSubmit = () => {
    
}
</script>
