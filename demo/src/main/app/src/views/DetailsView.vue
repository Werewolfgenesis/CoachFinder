<template>
   <div class="container">
    <div class="row justify-content-center text-center">
      <div class="col">
        <h2>Name</h2>
        <h4>30$</h4>
      </div>
    </div>
    <div class="row mb-4">
        <div class="col">
            <h4>Interested? Reach out now!</h4>
            <custom-button title="Contact" type="button"></custom-button>
        </div>
        <div class="col text-center">
            <ul class="d-flex flex-row gap-2">
                <div>examle</div>
                <div>examle</div>
                <div>examle</div>
            </ul>
        </div>
    </div>
    <div class="row text-center">
        <p>Description</p>
    </div>
  </div>
</template>
<script setup lang="ts">
import CustomButton from '@/components/customComponents/CustomButton.vue';
import type { Coach } from '@/types/CoachType';

</script>
@/types/Coach