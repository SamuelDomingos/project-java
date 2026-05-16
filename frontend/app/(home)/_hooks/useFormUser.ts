import { zodResolver } from "@hookform/resolvers/zod"
import { UserCreateFormData, userCreateSchema } from "../_schema/userSchema"
import { useForm } from "react-hook-form"
import { useState } from "react"
import { createUser, updateUser } from "@/lib/api/user"
import { User } from "@/lib/api/types/user.types"
import { toast } from "sonner"
import { useRouter } from "next/navigation"

const useFormUser = ({
  onSuccess,
  user,
}: {
  onSuccess?: () => void
  user?: User | null
}) => {
  const [isLoading, setIsLoading] = useState(false)
  const [showPassword, setShowPassword] = useState(false)
  const [isOpen, setIsOpen] = useState(false)

  const router = useRouter()

  const isEditMode = !!user

  const form = useForm<UserCreateFormData>({
    resolver: zodResolver(userCreateSchema),
    mode: "onChange",
    defaultValues: {
      name: user?.name ?? "",
      login: user?.login ?? "",
      password: "",
      active: user ? Number(user.active) : 1,
    },
  })

  const handleSubmit = async (data: UserCreateFormData) => {
    try {
      setIsLoading(true)

      if (isEditMode && user) {
        const response = await updateUser(user.id, {
          name: data.name,
          login: data.login,
          password: data.password,
          active: data.active,
        })

        if (response?.data) {
          toast.success("Usuário atualizado com sucesso")
          router.refresh()
          onSuccess?.()
        } else {
          toast.error(response.error)
        }
      } else {
        const response = await createUser({
          name: data.name,
          login: data.login,
          password: data.password,
          active: data.active,
        })
        
        if (response?.data) {
          toast.success("Usuário criado com sucesso")
          form.reset()
          router.refresh()
          onSuccess?.()
        } else {
          toast.error(response.error)
        }
      }
    } catch (error) {
      toast.error("Erro ao conectar com o servidor")
    } finally {
      setIsLoading(false)
    }
  }

  return {
    form,
    isOpen,
    setIsOpen,
    showPassword,
    setShowPassword,
    handleSubmit: form.handleSubmit(handleSubmit),
    isLoading,
    isEditMode,
  }
}

export default useFormUser
