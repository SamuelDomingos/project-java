"use client"

import { useState } from "react"
import { useForm } from "react-hook-form"
import { zodResolver } from "@hookform/resolvers/zod"
import { signIn } from "next-auth/react"
import { loginSchema } from "../_schema/authForm"
import z from "zod"
import { toast } from "sonner"
import { useRouter } from "next/router"

export const useAuthForm = () => {
  const router = useRouter()
  const [showPassword, setShowPassword] = useState(false)
  const [isLoading, setIsLoading] = useState(false)

  const loginForm = useForm<z.infer<typeof loginSchema>>({
    resolver: zodResolver(loginSchema),
    defaultValues: { user: "", password: "" },
  })

  const onLogin = async (values: z.infer<typeof loginSchema>) => {
    setIsLoading(true)
    try {
      const result = await signIn("credentials", {
        user: values.user,
        password: values.password,
        redirect: false,
      })
      
      if (result?.error) {
        toast.error(result?.error)
        return
      }

      toast.success("Login realizado com sucesso!")
      router.push("/")
    } catch {
      toast.error("Erro ao fazer login")
    } finally {
      setIsLoading(false)
    }
  }

  return {
    loginForm,
    showPassword,
    setShowPassword,
    isLoading,
    onSubmit: loginForm.handleSubmit(onLogin),
  }
}
