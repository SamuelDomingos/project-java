import { Suspense } from "react"
import TableUsers from "./_components/tableUsers"
import { getUsers } from "@/lib/api/user"
import { AlertCircle } from "lucide-react"
import TableUsersSkeleton from "./_components/tableUsersSkeleton"
import { ModeToggle } from "@/components/modeToggle"
import ButtonLogout from "./_components/buttonLogout"

const PageHome = async () => {
  const response = await getUsers()

  const users = response ? response.data : []
  const hasError = response.error

  return (
    <div className="relative h-screen w-full overflow-hidden">
      <div className="absolute inset-0 -z-10 overflow-hidden">
        <div className="absolute top-[20%] left-[-10%] h-125 w-125 rounded-full bg-primary/40 blur-3xl" />

        <div className="absolute right-[-10%] bottom-[-20%] h-100 w-100 rounded-full bg-primary/20 blur-3xl" />
      </div>

      <div className="container mx-auto px-4 py-8">
        <div className="mb-8 flex items-center justify-between">
          <div>
            <h1 className="text-3xl font-bold tracking-tight">
              Gerenciamento de Usuários
            </h1>
            <p className="mt-2 text-slate-600">
              Visualize, edite e delete usuários da sua plataforma
            </p>
          </div>

          <div className="flex items-center gap-2">
            <ModeToggle />
            <ButtonLogout />
          </div>
        </div>
        {hasError ? (
          <div className="flex items-center gap-4 rounded-lg border border-destructive/20 bg-destructive/50 p-6">
            <AlertCircle className="h-6 w-6 text-destructive/60" />
            <div>
              <h3 className="font-semibold text-destructive/90">
                Erro ao carregar usuários
              </h3>
              <p className="mt-1 text-sm text-destructive/70">
                {response.error || "Não foi possível conectar com o servidor"}
              </p>
            </div>
          </div>
        ) : (
          <Suspense fallback={<TableUsersSkeleton />}>
            <TableUsers users={users || []} />
          </Suspense>
        )}
      </div>
    </div>
  )
}

export default PageHome
