import { Plus } from "lucide-react"
import {
  Table,
  TableBody,
  TableCell,
  TableHead,
  TableHeader,
  TableRow,
} from "@/components/ui/table"
import { User } from "@/lib/api/types/user.types"
import { Badge } from "@/components/ui/badge"
import { Button } from "@/components/ui/button"
import DialogUser from "./dialogUser"
import UserActions from "./userActions"

const TableUsers = ({ users }: { users: User[] }) => {
  return (
    <div className="flex flex-col gap-6">
      <DialogUser
        trigger={
          <Button type="button" className="ml-auto w-fit gap-2">
            <Plus className="h-4 w-4" />
            Criar usuário
          </Button>
        }
      />

      <div className="overflow-hidden border">
        <Table className="bg-background">
          <TableHeader>
            <TableRow>
              <TableHead>ID</TableHead>
              <TableHead>Nome</TableHead>
              <TableHead>Login</TableHead>
              <TableHead>Status</TableHead>
              <TableHead className="text-right font-semibold">Ações</TableHead>
            </TableRow>
          </TableHeader>
          <TableBody>
            {users.map((user) => (
              <TableRow key={user.id}>
                <TableCell className="font-medium">#{user.id}</TableCell>
                <TableCell>{user.name}</TableCell>
                <TableCell>{user.login}</TableCell>
                <TableCell>
                  {user.active === 1 ? (
                    <Badge>Ativo</Badge>
                  ) : (
                    <Badge variant="destructive">Inativo</Badge>
                  )}
                </TableCell>
                <TableCell className="text-right">
                  <UserActions user={user} />
                </TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </div>
    </div>
  )
}

export default TableUsers
