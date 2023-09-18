import axios from 'axios'
import { BASE_URL } from '@/constants'


//COACH REQ-S
export const getAllCoaches = async () => {
  try {
    const response = await axios.get(BASE_URL + 'coaches/all')
    return response.data
  } catch (err: any) {
    console.log('Error:', err)
  }
}

export const registerCoach = async (coach: any) => {
  try {
    const response = await axios.post(BASE_URL + 'coaches', coach)
    return response.data
  } catch (err: any) {
    console.log('Error:', err)
  }
}

export const getFilteredCoaches = async (chosedAreas: string[]) => {
  try {
    const response = await axios.post(import.meta.env.BASE_URL + 'coaches/filter', chosedAreas)
    return response.data
  } catch (err: any) {
    console.log('Error:', err)
  }
}




