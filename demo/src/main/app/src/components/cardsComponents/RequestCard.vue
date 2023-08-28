<template>
     <div class="custom-card mb-4">
          <div class="custom-card__side custom-card__side--front container text-center">
            <div class="row pt-4 pb-2">
              <div class="col text-start">
                <div class="card-title">Request for:</div>
                <h5 class=""> {{ request?.coach.firstName }} {{ request?.coach.lastName }}</h5>
                <div class="card-title">From:</div>
                <h5 class="">{{ request?.email }}</h5>
              </div>
            </div>
           
          </div>
          <div class="custom-card__side custom-card__side--back d-flex align-items-center">
            <div class="m-auto container">
              <div class="row">     
                  <p class="text-center">{{ request?.message }}</p>
              </div>
              <div class="row">
                <div class="text-center">
                  <custom-button title="Contact" type="button"></custom-button>
                </div>
              </div>
            </div>
          </div>
        </div>
</template>
<script setup lang="ts">
import type { CoachRequest } from "@/types/CoachType";
import { PropType } from "vue";


defineProps({
    request: {
        type: Object as PropType<CoachRequest>
    }
})
</script>