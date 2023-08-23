export type area = {
    code: string,
    desc: string
}

export type Coach = {
    id: number,
    firstName: string,
    lastName: string,
    description: string,
    areas: area[],
    rate: number
}

export type CoachRequest = {
    email: string,
    message: string,
    coach: Coach
}