import { z } from "zod"

export const loginSchema = z.object({
  user: z.string().min(3, "User inválido"),
  password: z.string().min(4, "Senha deve ter pelo menos 4 caracteres"),
})
