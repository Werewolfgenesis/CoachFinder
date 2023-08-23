<template>
    <div>
        <div class="text-center"> 
            <h2 class="text-center"  style="color: #ff7730">Login to our site!</h2>
            <router-link style="  color: #ff7730;" class="" to="/register">Already have an account?</router-link>
        </div>
      
      <form>
        <div class="row">
          <div class="mx-auto col-10 col-md-8 col-lg-6">
            <base-input v-model="username" label="Username" :errors="v$.username.$errors"></base-input>
            <base-input v-model="password" type="password" :errors="v$.password.$errors" label="Password"></base-input>
            <base-input v-model="repeatPassword" type="password" :errors="v$.repeatPassword.$errors" label="Confirm password"></base-input>
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
  import BaseInput from '@/components/customComponents/BaseInput.vue'
  import CustomButton from '@/components/customComponents/CustomButton.vue'
  import { ref } from 'vue'
  import { useVuelidate } from '@vuelidate/core'
import { required, minValue, sameAs, helpers, minLength } from '@vuelidate/validators'

  
  const username = ref<string>('')
  const password = ref<string>('')
  const repeatPassword = ref<string>('')

  const rules = {
  username: { required }, 
  password: {
    required,
    minLength: helpers.withMessage('The password must be at least 6 symbols', minLength(6)),
    
},
  repeatPassword: {required, sameAsPassword: helpers.withMessage('The password confirmation does not pass', sameAs(password)) }
}
  
const v$ = useVuelidate(rules, {
 username: username,
 password: password,
 repeatPassword
})

  const handleSubmit = async () => {
    
  const result = await v$.value.$validate()
  if (!result) {
    return
  }

  console.log("Login");
  
  }


  </script>
  