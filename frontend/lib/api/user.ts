import { apiFetch, ApiResponse } from "../fetch"
import {
  User,
  CreateUserData,
  UpdateUserData,
  UserResponse,
} from "./types/user.types"

export const getUsers = async (): Promise<ApiResponse<User[]>> => {
  return apiFetch("/users", {
    method: "GET",
  })
}

export const createUser = async (
  data: CreateUserData
): Promise<ApiResponse<UserResponse>> => {
  return apiFetch("/users", {
    method: "POST",
    body: JSON.stringify(data),
  })
}

export const updateUser = async (
  id: number,
  data: UpdateUserData
): Promise<ApiResponse<UserResponse>> => {
  return apiFetch(`/users/${id}`, {
    method: "PUT",
    body: JSON.stringify(data),
  })
}

export const deleteUser = async (
  id: number
): Promise<ApiResponse<UserResponse>> => {
  return apiFetch(`/users/${id}`, {
    method: "DELETE",
  })
}