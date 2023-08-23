<template>
    <div>
        <ul v-for="req in requests" :key="req.coach.id">
        <li>{{ req }}</li>
        </ul>
        
    </div>
</template>
<script setup lang="ts">
import { onMounted, ref } from 'vue';

import type {CoachRequest} from '@/types/CoachType' 
import { getAllRequests } from '@/services/CoachService';

import BaseInput from '@/components/customComponents/formComponents/BaseInput.vue'

const requests = ref<CoachRequest | null>(null)

onMounted(async() => {
    requests.value = await getAllRequests()
})

</script>