import { GalleryVerticalEnd } from "lucide-react"
import { Suspense } from "react"
import AuthForm from "./_components/authForm"
import { ModeToggle } from "@/components/modeToggle"

const PageAuth = () => {
  return (
    <div className="grid min-h-screen lg:grid-cols-2">
      <div className="relative hidden flex-col justify-between overflow-hidden bg-[#030712] p-12 text-white lg:flex">
        <div className="absolute inset-0">
          <div className="absolute top-[20%] left-[-10%] h-125 w-125 rounded-full bg-primary/40 blur-3xl" />

          <div className="absolute right-[-10%] bottom-[-20%] h-100 w-100 rounded-full bg-primary/20 blur-3xl" />
        </div>

        <div className="relative z-10 flex items-center gap-3">
          <div className="flex size-10 items-center justify-center rounded-xl bg-white/10 backdrop-blur-sm">
            <GalleryVerticalEnd className="size-5" />
          </div>

          <span className="text-lg font-semibold tracking-wide italic">
            Project Java
          </span>
        </div>

        <div className="relative z-10 max-w-md">
          <h1 className="text-6xl leading-tight font-light tracking-tight text-white/90 italic">
            Welcome.
            <br />
            Start your journey
            <br />
            now with our
            <br />
            management
            <br />
            system!
          </h1>
        </div>
      </div>

      <div className="relative flex items-center justify-center bg-background p-6 md:p-12">
        <div className="absolute top-4 right-4">
          <ModeToggle />
        </div>

        <div className="w-full max-w-md">
          <Suspense>
            <AuthForm />
          </Suspense>
        </div>
      </div>
    </div>
  )
}

export default PageAuth
