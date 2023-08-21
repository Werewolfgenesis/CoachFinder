<template>
  <div>
    <div class="text-center m-4">
      <h2 style="color: #ff7730;">REGISTER A COACH, NOW! </h2>
    </div>
    <form>
      <div class="row">
        <div class="mx-auto col-10 col-md-8 col-lg-6">
          <div class="mb-3">
            <label for="firstName" class="form-label">First Name <span>*</span></label>
            <input
              v-model="firstName"
              type="text"
              class="form-control"
              id="firstName"
              aria-describedby="emailHelp"
            />
            <div class="input-errors" v-for="error of v$.firstName.$errors" :key="error.$uid">
              <div class="text-danger">{{ error.$message }}</div>
            </div>
          </div>
          <div class="mb-3">
            <label for="lastName" class="form-label">Last Name <span>*</span></label>
            <input
              v-model="lastName"
              type="text"
              class="form-control"
              id="lastName"
              aria-describedby="emailHelp"
            />
            <div class="input-errors" v-for="error of v$.lastName.$errors" :key="error.$uid">
              <div class="text-danger">{{ error.$message }}</div>
            </div>
          </div>
          <div class="mb-3">
            <label for="description" class="form-label">Description <span>*</span></label>
            <textarea
              v-model="description"
              class="form-control rounded-0"
              id="exampleFormControlTextarea2"
              rows="3"
            ></textarea>
            <div class="input-errors" v-for="error of v$.description.$errors" :key="error.$uid">
              <div class="text-danger">{{ error.$message }}</div>
            </div>
          </div>
          <div class="mb-3">
            <label for="hourlyRate" class="form-label">Hourly Rate <span>*</span></label>
            <input
              v-model="hourlyRate"
              type="number"
              class="form-control"
              id="hourlyRate"
              aria-describedby="emailHelp"
            />
            <div class="input-errors" v-for="error of v$.hourlyRate.$errors" :key="error.$uid">
              <div class="text-danger">{{ error.$message }}</div>
            </div>
          </div>
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
import { onMounted, reactive, ref } from 'vue'
import { useRouter } from 'vue-router'
import { useVuelidate } from '@vuelidate/core'
import { required, minValue } from '@vuelidate/validators'

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
  firstName: { required }, // Matches state.firstName
  lastName: { required }, // Matches state.lastName
  description: { required },
  hourlyRate: { required: required, minValue: minValue(0) },
  areas: { required }
  // Matches state.contact.email
}

const v$ = useVuelidate(rules, {
  firstName: firstName,
  lastName: lastName,
  description: description,
  hourlyRate: hourlyRate,
  areas: skillsSelected
})

const handleSubmit = async (e) => {

  
    const result = await v$.value.$validate()
    if(!result){
      return
    }
  
  await registerCoach({
    firstName: firstName.value,
    lastName: lastName.value,
    rate: hourlyRate.value,
    areas: skillsSelected.value
  })
  router.push({ name: 'all' })
}
</script>
