import { User } from "@/lib/api/types/user.types"
import { deleteUser } from "@/lib/api/user"
import { useRouter } from "next/navigation"
import { useState } from "react"
import { toast } from "sonner"

const useUserDel = ({ userId }: { userId: number }) => {
  const router = useRouter()
  const [isDeleteAlertOpen, setIsDeleteAlertOpen] = useState(false)
  const [loading, setLoading] = useState(false)

  const handleDeleteConfirm = async () => {
    try {
      setLoading(true)
      const response = await deleteUser(userId)

      if (response?.data) {
        toast.success("Usuário deletado com sucesso")
        setIsDeleteAlertOpen(false)
        router.refresh()
      } else {
        toast.error(response.error || "Erro ao deletar usuário")
      }
    } catch (error) {
      console.error("Erro ao deletar:", error)
      toast.error("Erro ao conectar com o servidor")
    } finally {
      setLoading(false)
    }
  }

  return {
    isDeleteAlertOpen,
    setIsDeleteAlertOpen,
    handleDeleteConfirm,
    loading,
  }
}

export default useUserDel
