export interface User {
  id: number
  name: string
  login: string
  active: number
}

export interface CreateUserData {
  name: string
  login: string
  password: string
  active: number
}

export interface UpdateUserData {
  name: string
  login: string
  password: string
  active: number
}

export interface UserResponse {
  message: string
}