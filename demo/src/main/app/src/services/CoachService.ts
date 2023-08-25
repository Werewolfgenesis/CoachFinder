import axios from 'axios'

const BASE_URL = '/private/api/'

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

export const getAllAreas = async () => {
  try {
    const response = await axios.get(BASE_URL + 'areas')
    return response.data
  } catch (err: any) {
    console.log('Error:', err)
  }
}

export const postRequest = async (email: string, message: string, id: string) => {
  try {
    await axios
      .post(BASE_URL + 'coaches/add-request', {
        email: email,
        message: message,
        id: id
      })
      .then(() => {
        alert('Success')
      })
  } catch (err: any) {
    console.log('Error:', err)
  }
}
