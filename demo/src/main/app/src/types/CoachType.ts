export type Area = {
    code: string,
    desc: string
}

export type Coach = {
    id: number,
    firstName: string,
    lastName: string,
    description: string | null,
    areas: Area[],
    rate: number,
    requests: []
}

export type CoachRequest = {
    email: string,
    message: string,
    coach: Coach
}