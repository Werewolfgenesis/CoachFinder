import axios from 'axios'
import { BASE_URL } from '@/constants'

export const getAllAreas = async () => {
    try {
      const response = await axios.get(BASE_URL + 'areas')
      return response.data
    } catch (err: any) {
      console.log('Error:', err)
    }
  }