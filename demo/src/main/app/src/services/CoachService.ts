import axios from 'axios'
import { BASE_URL } from '@/constants'


//COACH REQ-S
export const getAllCoaches = async () => {
  try {
    const response = await axios.get(BASE_URL + 'coaches/all')
    console.log(response.data);
    
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

export const getFilteredCoaches = async (areas: string[], pageNumber: number, itemsPerPage: number) => {
  try {
    
    const params = {
      areas: areas.join(','),
      pageNo: pageNumber,
      pageSize: itemsPerPage
    }
    console.log(params);
    
    const response = await axios.get(BASE_URL + 'coaches/filter', {params})
    console.log(response.data);
    
    return response.data
  } catch (err: any) {
    console.log('Error:', err)
  }
}




