export type area = {
    code: string,
    desc: string
}

export type Coach = {
    id: number,
    firstName: string,
    lastName: string,
    areas: area[],
    rate: number
}