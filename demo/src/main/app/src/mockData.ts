
import type {Coach} from '@/types/Coach'

export const mockedCoaches: Coach[] = [
    {
      id: 1,
      firstName: 'Dimitar',
      lastName: 'Sotirov',
      areas: [{code: 'BE', desc: "Backend"}, {code: 'FE', desc: "Frontend"}],
      rate: 60
    },
    {
      id: 2,
      firstName: 'Reni',
      lastName: 'Ilcheva',
      areas: [{code: 'FT', desc: "Fitness"}],
      rate: 60
    },
    {
      id: 3,
      firstName: 'Maria',
      lastName: 'Ivanova',
      areas: [{code: 'BE', desc: "Backend"}],
      rate: 40
    },
    {
      id: 4,
      firstName: 'Gosho',
      lastName: 'Bandita',
      areas: [{code: 'PM', desc: "Project Manager"}],
      rate: 30
    }
  ]