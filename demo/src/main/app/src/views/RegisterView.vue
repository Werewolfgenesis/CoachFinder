<template>
  <div>
    <div class="text-center m-4">
      <h2 style="color: #ff7730">REGISTER A COACH, NOW!</h2>
    </div>

    <form>
      <div class="row">
        <div class="mx-auto col-10 col-md-8 col-lg-6">
          <base-input v-model="firstName" :errors="v$.firstName.$errors" label="FirstName" />
          <base-input v-model="lastName" :errors="v$.lastName.$errors" label="LastName" />
          <div class="mb-3">
            <label for="description" class="form-label">Description <span>*</span></label>
            <textarea
              v-model="description"
              class="form-control"
              id="exampleFormControlTextarea2"
              rows="3"
            ></textarea>
            <div class="input-errors" v-for="error of v$.description.$errors" :key="error.$uid">
              <div class="text-danger">{{ error.$message }}</div>
            </div>
          </div>
          <base-input
            v-model="hourlyRate"
            :errors="v$.hourlyRate.$errors"
            label="HourlyRate"
            type="number"
          />
          <div v-for="(area, indx) in areas" :key="indx">
            <div class="form-check m-2">
              <input
                v-model="skillsSelected"
                class="form-check-input"
                type="checkbox"
                :value="area.code"
                id="flexCheckDefault"
              />
              <label class="form-check-label" for="flexCheckDefault"> {{ area.desc }} </label>
            </div>
          </div>
          <div class="input-errors" v-for="error of v$.areas.$errors" :key="error.$uid">
              <div class="text-danger">{{ error.$message }}</div>
          </div>
        </div>
      </div>
      <div class="text-center mb-4">
        <custom-button
          @click="handleSubmit"
          title="Submit"
          type="button"
          class="btn btn-md btn-primary"
        ></custom-button>
      </div>
    </form>
  </div>
</template>
<script setup lang="ts">
import CustomButton from '@/components/customComponents/CustomButton.vue'
import { registerCoach, getAllAreas } from '@/services/CoachService'

import type { area } from '@/types/CoachType'
import { onMounted, ref } from 'vue'
import { useRouter } from 'vue-router'
import { useVuelidate } from '@vuelidate/core'
import { required, minValue } from '@vuelidate/validators'

import BaseInput from '@/components/customComponents/BaseInput.vue'

const router = useRouter()

onMounted(async () => {
  const result = await getAllAreas()
  areas.value = result
})

const areas = ref<area[]>([])

const firstName = ref('')
const lastName = ref('')
const description = ref('')
const hourlyRate = ref(0)
const skillsSelected = ref<string[]>([])

const rules = {
  firstName: { required }, 
  lastName: { required }, 
  description: { required },
  hourlyRate: { required: required, minValue: minValue(0) },
  areas: { required }
}

const v$ = useVuelidate(rules, {
  firstName: firstName,
  lastName: lastName,
  description: description,
  hourlyRate: hourlyRate,
  areas: skillsSelected
})

const handleSubmit = async (e) => {
  e.preventDefault()

  const result = await v$.value.$validate()
  if (!result) {
    return
  }

  await registerCoach({
    firstName: firstName.value,
    lastName: lastName.value,
    description: description.value,
    rate: hourlyRate.value,
    areas: skillsSelected.value
  })
  router.push({ name: 'all' })
}
</script>
