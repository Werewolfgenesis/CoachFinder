import axios from 'axios'
import { BASE_URL } from '@/constants'

export const postRequest = async (email: string, message: string, id: Number) => {
    try {
      await axios
        .post(BASE_URL + 'coaches/add-request', {
          email: email,
          message: message,
          id: id
        })
        .then(() => {
          alert('Success')
          window.location.replace('/all-requests')
        })
    } catch (err: any) {
      console.log('Error:', err)
    }
  }
  
  export const getAllRequests = async () => {
    try {
      const response = await axios.get(BASE_URL + 'requests')
      return response.data
    } catch (err: any) {
      console.log('Error:', err)
    }
  }