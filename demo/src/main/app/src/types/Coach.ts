import type { Area } from "./Area"

export type Coach = {
    id: number,
    firstName: string,
    lastName: string,
    description: string | null,
    areas: Area[],
    rate: number,
    requests: []
}

