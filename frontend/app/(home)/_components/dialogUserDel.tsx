"use client"

import {
  AlertDialog,
  AlertDialogContent,
  AlertDialogHeader,
  AlertDialogTitle,
  AlertDialogDescription,
  AlertDialogFooter,
  AlertDialogCancel,
  AlertDialogAction,
  AlertDialogTrigger,
} from "@/components/ui/alert-dialog"
import { ReactNode } from "react"
import useUserDel from "../_hooks/useUserDel"
import { User } from "@/lib/api/types/user.types"

const DialogUserDel = ({
  trigger,
  user,
}: {
  trigger: ReactNode
  user: User | null
}) => {
  const {
    isDeleteAlertOpen,
    setIsDeleteAlertOpen,
    handleDeleteConfirm,
    loading,
  } = useUserDel({ userId: user?.id || 0 })

  return (
    <AlertDialog open={isDeleteAlertOpen} onOpenChange={setIsDeleteAlertOpen}>
      <AlertDialogTrigger asChild>{trigger}</AlertDialogTrigger>
      <AlertDialogContent>
        <AlertDialogHeader>
          <AlertDialogTitle>Deletar {user?.name || "usuário"}?</AlertDialogTitle>
          <AlertDialogDescription>
            Você tem certeza que deseja deletar o usuário{" "}
            <span className="font-semibold">{user?.name || "usuário"}</span>? Esta ação não
            pode ser desfeita.
          </AlertDialogDescription>
        </AlertDialogHeader>
        <AlertDialogFooter>
          <AlertDialogCancel>Cancelar</AlertDialogCancel>
          <AlertDialogAction
            variant="destructive"
            onClick={handleDeleteConfirm}
            disabled={loading}
          >
            {loading ? "Deletando..." : "Deletar"}
          </AlertDialogAction>
        </AlertDialogFooter>
      </AlertDialogContent>
    </AlertDialog>
  )
}

export default DialogUserDel
