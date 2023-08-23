<template>
  <div class="mb-3">
    <label class="form-label">{{ label }}</label>
    <input
      class="form-control"
      :type="type"
      :value="modelValue"
      @input="$emit('update:modelValue', $event.target.value)"
      :placeholder="label"
    />
   
      <div class="input-errors" v-for="error of errors" :key="error.$uid">
        <div class="text-danger">{{ error.$message }}</div>
      </div>
    </div>

</template>
<script setup lang="ts">
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
