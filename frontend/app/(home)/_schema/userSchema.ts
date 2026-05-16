import z from "zod"

export const userCreateSchema = z.object({
  name: z.string().min(3, "Nome deve ter no mínimo 3 caracteres"),
  login: z.string().min(3, "Login deve ter no mínimo 3 caracteres"),
  password: z
    .string()
    .min(4, "Senha deve ter pelo menos 4 caracteres")
    .or(z.literal("")),
  active: z.number().int(),
})

export type UserCreateFormData = z.infer<typeof userCreateSchema>
export type UserUpdateFormData = z.infer<typeof userCreateSchema>