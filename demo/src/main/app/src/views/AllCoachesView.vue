<template>
  <div class="p-2">
    <h2 class="all-coaches__header">Find your coach:</h2>
    <filter-checkboxes @handle-filters="handleFilters"  @handle-refresh="handleRefresh"></filter-checkboxes>
    <div>
      <custom-button v-if="filter.length > 0" @click="onPreviosPage" type="button"
        ><span>&lt;</span>previous page
      </custom-button>
      <custom-button
        v-if="filteredCoaches.length !== 0 && filter.length > 0"
        @click="onNextPage"
        type="button">next page<span>&gt;</span>
      </custom-button>
    </div>

    <select v-if="filter.length > 0" v-model="selectedItemsPerPage" style="width: 30%;" class="form-select" aria-label="Default select example">
      <option disabled value="">Items per page</option>
      <option value="3">3</option>
      <option value="5">5</option>
      <option value="10">10</option>
    </select>
    <custom-button
      @click="onFilter"
      type="button"
      title="FILTER"
    ></custom-button>
    <coach-list :coaches="filteredCoaches" :filters="filter"></coach-list>
  </div>
</template>
<script setup lang="ts">
import FilterCheckboxes from '@/components/FilterCheckboxes.vue'
import CoachList from '@/components/cardsComponents/CoachList.vue'

import { onMounted, ref } from 'vue'
import { getFilteredCoaches, getAllCoaches } from '@/services/CoachService'
import type { Coach } from '@/types/Coach'

import CustomButton from '@/components/customComponents/CustomButton.vue'

const allCoaches = ref<Coach[]>([])
const filteredCoaches = ref<Coach[]>([])
const filter = ref<string[]>([])

//PAGINATION
const currentPage = ref<number>(1)
const selectedItemsPerPage = ref<number | null>(null)

onMounted(async () => {
  allCoaches.value = await getAllCoaches()
  filteredCoaches.value = allCoaches.value
})



const handleFilters = async (filters: string[]) => {
  filter.value = filters
}

const handleRefresh = async (filters: string[]) => {
  filter.value = filters
  filteredCoaches.value = allCoaches.value
}

const onFilter = async () => {
  if (filter.value.length == 0) {
    filteredCoaches.value = allCoaches.value
    return
  }

  if (!selectedItemsPerPage.value) {
    selectedItemsPerPage.value = 3
  }
  filteredCoaches.value = await getFilteredCoaches(filter.value, currentPage.value - 1, selectedItemsPerPage.value)
}





const onPreviosPage = () => {
  if (currentPage.value !== 1) {
    currentPage.value -= 1
    onFilter()
  }
}

const onNextPage = () => {
  currentPage.value += 1

  if (!selectedItemsPerPage.value) {
    selectedItemsPerPage.value = 3
  }
  onFilter()
}

// const setItemsPerPage = () => {
  
//   currentPage.value = 0
//   console.log('works', currentPage.value);
// }


</script>
<style>
.all-coaches__header {
  display: inline-block;
  background-image: linear-gradient(to right, rgba(226, 152, 112, 0.874), rgb(227, 84, 18));
  -webkit-background-clip: text;
  color: transparent;

  animation-name: leftToRight;
  animation-duration: 1s;
  animation-timing-function: ease-out;
}
</style>
