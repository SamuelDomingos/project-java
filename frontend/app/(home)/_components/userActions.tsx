"use client"

import { MoreHorizontal, Trash2, Edit2 } from "lucide-react"

import {
  DropdownMenu,
  DropdownMenuContent,
  DropdownMenuItem,
  DropdownMenuTrigger,
} from "@/components/ui/dropdown-menu"

import { Button } from "@/components/ui/button"

import DialogUser from "./dialogUser"
import DialogUserDel from "./dialogUserDel"

import { User } from "@/lib/api/types/user.types"

const UserActions = ({ user }: { user: User }) => {
  return (
    <DropdownMenu>
      <DropdownMenuTrigger asChild>
        <Button variant="ghost" className="h-8 w-8 p-0">
          <MoreHorizontal className="h-4 w-4" />
        </Button>
      </DropdownMenuTrigger>

      <DropdownMenuContent align="end">
        <DialogUser
          user={user}
          trigger={
            <DropdownMenuItem onSelect={(e) => e.preventDefault()}>
              <div className="flex items-center gap-2">
                <Edit2 className="h-4 w-4" />
                Editar
              </div>
            </DropdownMenuItem>
          }
        />

        <DialogUserDel
          user={user}
          trigger={
            <DropdownMenuItem
              onSelect={(e) => e.preventDefault()}
              variant="destructive"
            >
              <div className="flex items-center gap-2">
                <Trash2 className="h-4 w-4" />
                Deletar
              </div>
            </DropdownMenuItem>
          }
        />
      </DropdownMenuContent>
    </DropdownMenu>
  )
}

export default UserActions
