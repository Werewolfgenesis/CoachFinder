<script setup lang="ts">
const props = defineProps({
  email: {
    type: String,
    required: true
  },
  message: {
    type: String,
    required: true
  }
})
</script>

<template>
  <div class="custom-card mb-4">
    <div class="custom-card__side custom-card__side--front container text-center">
      <div class="row pt-4 pb-2">
        <div class="col text-center">
          <h5 class="card-title fs-3">Request</h5>
          <div class="fs-4"><strong>Email</strong> {{ props.email }}</div>
          <div class="fs-4"><strong>Message</strong> {{ props.message }}</div>
        </div>
      </div>
    </div>
  </div>
</template>
