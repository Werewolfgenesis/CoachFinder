import axios from "axios";

const BASE_URL = '/private/api/coaches'

export const getAllCoaches =async () => {
    try {
        const response = await axios.get(BASE_URL + '/all');
        return response.data;
    } catch (err: any) {
       console.log(err);
       
    }
}