<template>
    <button class="btn-secondary text-white" :type='type'>  
      <slot>{{ title }}</slot>
  </button>
</template>
<script setup lang="ts">
import type { PropType } from 'vue'


type Button = 'button' | 'submit' | 'reset';

defineProps({
  type: {
      type: String as PropType<Button>,
      required: true
  },
  title: {
      type: String,
  }
})
</script>