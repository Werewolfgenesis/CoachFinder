
import { defineStore } from 'pinia'


export const useCoachStore = defineStore('coach', {
  state: () => ({ 
    filters: [] as string[]
  }),
  getters: {
    getFilters: (state) => state.filters
  },
  
actions: {
  setFilters(newFilter: []) {
    this.filters = newFilter
  },
}
})


