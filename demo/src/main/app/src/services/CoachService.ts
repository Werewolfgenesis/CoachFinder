import type { Coach, Area } from "@/types/CoachType";
import axios from "axios";

const BASE_URL ='/private/api/'

//COACH REQ-S
export const getAllCoaches =async () => {
    try {
        
        const response = await axios.get(BASE_URL + 'coaches/all')
        return response.data;
    } catch (err: any) {
       console.log('Error:', err);
       
    }
}

export const registerCoach = async (coach: any) => {
    try {
        const response = await axios.post(BASE_URL + 'coaches', coach)
        return response.data;
    } catch (err: any) {
       console.log('Error:', err);
       
    }
}

export const getFilteredCoaches = async (chosedAreas: string[]) => {
    try {
        const response = await axios.post(BASE_URL + 'coaches/filter', chosedAreas)
        return response.data;
    } catch (err: any) {
       console.log('Error:', err);
       
    }
}


//AREAS REQ-S
export const getAllAreas = async () => {
    try {
        const response = await axios.get(BASE_URL + 'areas')
        return response.data;
    } catch (err: any) {
       console.log('Error:', err);
       
    }
}

export const getAllRequests = async () => {
    try {
        const response = await axios.get(BASE_URL + 'requests')
        return response.data;
    } catch (err: any) {
       console.log('Error:', err);
       
    }
}

