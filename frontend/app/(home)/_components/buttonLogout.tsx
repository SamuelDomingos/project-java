"use client"

import { signOut } from "next-auth/react"
import { LogOut } from "lucide-react"

import { Button } from "@/components/ui/button"

const ButtonLogout = () => {
  return (
    <Button
      variant="outline"
      className="gap-2"
      onClick={() =>
        signOut({
          callbackUrl: "/login",
        })
      }
    >
      <LogOut className="h-4 w-4" />
      Sair
    </Button>
  )
}

export default ButtonLogout
