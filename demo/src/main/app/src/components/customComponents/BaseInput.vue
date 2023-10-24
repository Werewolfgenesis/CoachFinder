<template>
  <div class="mb-3">
    <label class="form-label">{{ label }}</label>
    <input
      class="form-control"
      :type="type"
      v-model="inputValue"
      :placeholder="label"
      @input="onInput"
      />
      <!-- @input="$emit('update:modelValue',  $event.target.value)" -->
   
      <div class="input-errors" v-for="error of errors" :key="error.$uid">
        <div class="text-danger">{{ error.$message }}</div>
      </div>
    </div>

</template>
<script setup lang="ts">
import { ref } from "vue"


const inputValue = ref<string | number | null>(null) 
const emit = defineEmits(['updateValue'])

const onInput = () => {

  emit('updateValue', inputValue.value)
}

defineProps({
  label: {
    type: String
  },
  modelValue: {
    type: [Number, String, Array],
    default: ''
  },
  type: {
    type: String,
    default: 'text'
  },
  errors: {
    type: Object,
    required: false
  },
  area: {
    type: String,
    required: false
  }
})
</script>