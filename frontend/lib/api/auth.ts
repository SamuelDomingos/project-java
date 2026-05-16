import { apiFetch, ApiResponse } from "../fetch"
import {
  LoginData,
  LoginResponse,
  LogoutResponse,
} from "./types/auth.types"

export const login = async (
  data: LoginData
): Promise<ApiResponse<LoginResponse>> => {
  return apiFetch("/auth/login", {
    method: "POST",
    body: JSON.stringify(data),
  })
}

export const logout = async (): Promise<ApiResponse<LogoutResponse>> => {
  return apiFetch("/auth/logout", {
    method: "POST",
  })
}