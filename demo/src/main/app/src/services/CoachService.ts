import axios from "axios";

const BASE_URL = import.meta.env.BASE_URL

export const getAllCoaches =async () => {
    try {
        const response = await axios.get('http://localhost:8091/private/api/coaches/all')
        return response.data;
    } catch (err: any) {
       console.log('Error:', err);
       
    }
}