import type { Coach } from "./Coach"

export type CoachRequest = {
    email: string,
    message: string,
    coach: Coach
}