import NextAuth, { DefaultSession, NextAuthOptions } from "next-auth"
import CredentialsProvider from "next-auth/providers/credentials"
import { login } from "@/lib/api/auth"

declare module "next-auth" {
  interface Session {
    user: DefaultSession["user"] & {
      login: string
    }
  }
}

declare module "next-auth/jwt" {
  interface JWT {
    login: string
  }
}

export const authOptions: NextAuthOptions = {
  providers: [
    CredentialsProvider({
      name: "credentials",

      credentials: {
        user: {
          label: "User",
          type: "text",
        },
        password: {
          label: "Senha",
          type: "password",
        },
      },

      async authorize(credentials) {
        if (!credentials?.user || !credentials?.password) {
          return null
        }

        const response = await login({
          user: credentials.user,
          password: credentials.password,
        })
        
        if (!response.data) {
          throw new Error(response.error)
        }

        const user = response.data

        return {
          id: user.login,
          name: user.login,
        }
      },
    }),
  ],

  callbacks: {
    async jwt({ token, user }) {
      if (user) {
        token.login = user.name || ""
      }

      return token
    },

    async session({ session, token }) {
      session.user.login = token.login
      return session
    },
  },

  pages: {
    signIn: "/auth",
    error: "/auth",
  },

  session: {
    strategy: "jwt",
  },

  secret: process.env.NEXTAUTH_SECRET,
}

const handler = NextAuth(authOptions)

export { handler as GET, handler as POST }
