# 👥 User Management System

Sistema completo de gerenciamento de usuários desenvolvido com Java (Backend) e Next.js (Frontend), com suporte a autenticação segura, CRUD de usuários e interface moderna.

![License](https://img.shields.io/badge/license-MIT-green?style=for-the-badge)
![Java Version](https://img.shields.io/badge/Java-8%2B-orange?style=for-the-badge)
![Next.js](https://img.shields.io/badge/Next.js-16.1.7-black?style=for-the-badge)
![Status](https://img.shields.io/badge/status-active-success?style=for-the-badge)

## 📖 Sobre o Projeto

O **User Management System** é uma aplicação web completa para gerenciamento de usuários. Com uma arquitetura moderna composta por um backend robusto em Java com Spark Framework e um frontend responsivo em Next.js, a aplicação oferece uma experiência segura e intuitiva para criar, listar, atualizar e deletar usuários.

## ✨ Funcionalidades Principais

- **Autenticação de Usuários:** Sistema de login seguro com suporte a sessão.
- **Gerenciamento de Usuários:** CRUD completo (Create, Read, Update, Delete) com validações.
- **Interface Responsiva:** Frontend moderno com Tailwind CSS e componentes Shadcn UI.
- **Validação de Formulários:** Validação robusta com Zod e React Hook Form.
- **Temas:** Suporte a tema claro e escuro com Next Themes.
- **API RESTful:** Backend escalável com Spark Framework e GSON para serialização JSON.
- **Banco de Dados:** Persistência de dados com MySQL.
- **CORS Configurado:** Comunicação segura entre frontend e backend.
- **Notificações:** Feedback visual com Sonner Toast.
- **Ícones Modernos:** Lucide React para ícones escaláveis.

## 🛠️ Tecnologias Utilizadas

### Backend
- **Framework:** Spark Framework 2.9.4 (microframework REST)
- **Linguagem:** Java 8+
- **Banco de Dados:** MySQL 8.0.33
- **Serialização:** GSON 2.10.1
- **Build:** Maven 3
- **Variáveis de Ambiente:** Java Dotenv 5.2.2

### Frontend
- **Framework:** Next.js 16.1.7 (App Router)
- **Linguagem:** TypeScript
- **Estilização:** Tailwind CSS v4, Shadcn UI, Radix UI
- **Autenticação:** NextAuth.js 4.24.14
- **Validação:** Zod, React Hook Form
- **Temas:** Next Themes
- **Notificações:** Sonner
- **Ícones:** Lucide React
- **Build Tool:** Turbopack

## 📂 Estrutura do Projeto

```
project-java-main/
├── backend/
│   ├── src/main/java/projectJava/
│   │   ├── Main.java                  # Ponto de entrada da aplicação
│   │   ├── auth/
│   │   │   └── Login.java             # Lógica de autenticação
│   │   ├── config/
│   │   │   └── CorsConfig.java        # Configuração de CORS
│   │   ├── controllers/
│   │   │   ├── AuthController.java    # Controlador de autenticação
│   │   │   └── UserController.java    # Controlador de usuários
│   │   ├── db/
│   │   │   ├── ConnectionFactory.java # Factory de conexão com BD
│   │   │   └── DatabaseInit.java      # Inicialização do banco
│   │   ├── dto/
│   │   │   └── LoginRequest.java      # DTO para login
│   │   ├── models/
│   │   │   ├── User.java              # Modelo de usuário
│   │   │   └── Auth.java              # Modelo de autenticação
│   │   ├── routes/
│   │   │   ├── UserRoutes.java        # Rotas de usuário
│   │   │   └── AuthRoutes.java        # Rotas de autenticação
│   │   ├── users/
│   │   │   ├── UserList.java          # Listagem de usuários
│   │   │   ├── UserInsert.java        # Inserção de usuários
│   │   │   ├── UserUpdate.java        # Atualização de usuários
│   │   │   └── UserDelete.java        # Deleção de usuários
│   │   └── utils/
│   │       └── ResponseUtils.java     # Utilitários de resposta
│   ├── pom.xml                        # Configuração Maven
│   └── .env.example                   # Exemplo de variáveis de ambiente
│
├── frontend/
│   ├── app/
│   │   ├── (home)/                   # Páginas autenticadas
│   │   │   ├── page.tsx              # Página principal
│   │   │   ├── _components/          # Componentes locais
│   │   │   │   ├── dialogUser.tsx    # Dialog para criar/editar usuário
│   │   │   │   ├── tableUsers.tsx    # Tabela de usuários
│   │   │   │   └── userActions.tsx   # Ações de usuário
│   │   │   ├── _hooks/               # Hooks customizados
│   │   │   │   ├── useFormUser.ts    # Hook do formulário
│   │   │   │   └── useUserDel.ts     # Hook de deleção
│   │   │   └── _schema/              # Schemas Zod
│   │   │       └── userSchema.ts     # Validação de usuário
│   │   ├── auth/                     # Páginas de autenticação
│   │   │   ├── page.tsx              # Página de login/registro
│   │   │   ├── _components/
│   │   │   │   └── authForm.tsx      # Formulário de autenticação
│   │   │   ├── _hooks/
│   │   │   │   └── useAuthForm.ts    # Hook do formulário
│   │   │   └── _schema/
│   │   │       └── authForm.ts       # Validação de autenticação
│   │   ├── api/
│   │   │   └── auth/[...nextauth]/
│   │   │       └── route.ts          # Configuração NextAuth
│   │   ├── layout.tsx                # Layout raiz
│   │   └── globals.css               # Estilos globais
│   ├── components/
│   │   ├── modeToggle.tsx            # Toggle de tema
│   │   ├── theme-provider.tsx        # Provedor de tema
│   │   └── ui/                       # Componentes Shadcn UI
│   ├── lib/
│   │   ├── api/
│   │   │   ├── auth.ts               # Funções de autenticação
│   │   │   ├── user.ts               # Funções de usuário
│   │   │   └── types/                # Tipos TypeScript
│   │   ├── fetch.ts                  # Wrapper de fetch autenticado
│   │   └── utils.ts                  # Utilitários gerais
│   ├── middleware.ts                 # Middleware de proteção
│   ├── package.json                  # Dependências
│   └── .env.example                  # Exemplo de variáveis de ambiente
│
└── README.md                         # Este arquivo
```

## 📋 Pré-requisitos

Antes de começar, certifique-se de ter instalado:

- **Node.js** (versão 18 ou superior)
- **npm**, yarn, pnpm ou bun
- **Java** (versão 8 ou superior)
- **Maven** (para build do backend)
- **MySQL** (versão 5.7 ou superior)

## 🚀 Guia de Início Rápido

### 1. Clonar o Repositório

```bash
git clone https://github.com/seu-usuario/project-java-main.git
cd project-java-main
```

### 2. Configurar o Backend

#### 2.1 Configurar Variáveis de Ambiente

Crie um arquivo `.env` na raiz da pasta `backend` baseado no `.env.example`:

```env
DB_URL=jdbc:mysql://localhost:3306/user_management?useSSL=false&serverTimezone=UTC
DB_USER=seu_usuario_mysql
DB_PASS=sua_senha_mysql
```

**Variáveis importantes:**
- `DB_URL`: URL de conexão com o MySQL
- `DB_USER`: Usuário do banco de dados
- `DB_PASS`: Senha do banco de dados

#### 2.2 Compilar o Projeto

```bash
cd backend
mvn compile
```

Este comando irá baixar as dependências e compilar o projeto Java.

#### 2.3 Executar o Backend

```bash
mvn exec:java
```

O servidor iniciará em `http://localhost:4567` e a tabela de usuários será criada automaticamente.

Você verá a saída:
```
=================================
Iniciando servidor...
=================================
Tabela tb_users pronta
Banco inicializado com sucesso
=================================
Servidor rodando!
=================================
API:
http://localhost:4567
```

> **Nota:** O banco de dados `user_management` e a tabela `tb_users` são criados automaticamente pelo `DatabaseInit.java` na primeira execução. Não é necessário criar manualmente.

### 3. Configurar o Frontend

#### 3.1 Instalar Dependências

```bash
cd ../frontend
npm install
# ou yarn install / pnpm install / bun install
```

#### 3.2 Configurar Variáveis de Ambiente

Crie um arquivo `.env.local` na raiz da pasta `frontend` baseado no `.env.example`:

```env
NEXTAUTH_SECRET=seu_segredo_super_seguro_aqui
NEXTAUTH_URL=http://localhost:3000
NEXT_PUBLIC_API_URL=http://localhost:4567
```

**Variáveis importantes:**
- `NEXTAUTH_SECRET`: Chave secreta para NextAuth (gere uma segura em produção)
- `NEXTAUTH_URL`: URL da aplicação frontend
- `NEXT_PUBLIC_API_URL`: URL da API backend

#### 3.3 Executar o Servidor de Desenvolvimento

```bash
npm run dev
```

Acesse [http://localhost:3000](http://localhost:3000) no seu navegador.

## ⚙️ Scripts Disponíveis

### Backend

| Comando | Descrição |
|---|---|
| `mvn compile` | Compila o projeto e baixa as dependências |
| `mvn exec:java` | Executa o servidor na porta 4567 |
| `mvn clean` | Limpa arquivos compilados |

### Frontend

| Comando | Descrição |
|---|---|
| `npm run dev` | Inicia servidor de desenvolvimento com Turbopack |
| `npm run build` | Gera o build de produção |
| `npm run start` | Inicia o servidor em modo produção |
| `npm run lint` | Executa o ESLint |
| `npm run format` | Formata o código com Prettier |
| `npm run typecheck` | Verifica os tipos TypeScript |

## 🔌 Endpoints da API

### ⚠️ Importante

O campo de autenticação foi padronizado como `user` (não `login`). Certifique-se de usar o campo correto ao fazer requisições de login.

**POST** `/auth/login` - Fazer login na aplicação

```json
{
  "user": "admin",
  "password": "admin123"
}
```

Resposta de sucesso:
```json
{
  "success": true,
  "message": "Login realizado com sucesso"
}
```

Resposta de erro:
```json
{
  "error": "Usuário ou senha inválidos",
  "status": 401
}
```

**POST** `/auth/logout` - Fazer logout da aplicação

Resposta de sucesso:
```json
{
  "success": true,
  "message": "Logout realizado com sucesso"
}
```

> **Credenciais padrão:** As variáveis `USER` e `PASS` do `.env` definem as credenciais do administrador inicial. Por padrão, use `user: admin` e `password: admin123` (ou os valores configurados no `.env`).

### Usuários

**GET** `/users` - Listar todos os usuários

Resposta:
```json
[
  {
    "id": 1,
    "name": "Admin",
    "login": "admin",
    "password": "admin123",
    "active": 1
  }
]
```

**GET** `/users/{id}` - Obter um usuário específico

Resposta:
```json
{
  "id": 1,
  "name": "Admin",
  "login": "admin",
  "password": "admin123",
  "active": 1
}
```

**POST** `/users` - Criar novo usuário

Request:
```json
{
  "name": "João Silva",
  "login": "joao.silva",
  "password": "senha123",
  "active": 1
}
```

Resposta de sucesso:
```json
{
  "success": true,
  "message": "Usuário criado"
}
```

**PUT** `/users/{id}` - Atualizar usuário

Request:
```json
{
  "name": "João Silva Atualizado",
  "login": "joao.silva",
  "password": "nova_senha",
  "active": 1
}
```

Resposta de sucesso:
```json
{
  "success": true,
  "message": "Usuário atualizado com sucesso"
}
```

**DELETE** `/users/{id}` - Deletar usuário

Resposta de sucesso:
```json
{
  "success": true,
  "message": "Usuário deletado com sucesso"
}
```

## 📸 Fluxo da Aplicação

1. **Acesso Inicial:** Usuário acessa http://localhost:3000
2. **Autenticação:** Se não autenticado, é redirecionado para página de login
3. **Login:** Credenciais são enviadas para o backend via API
4. **Sessão:** NextAuth.js gerencia a sessão do usuário
5. **Dashboard:** Após login, usuário pode ver, criar, editar e deletar usuários
6. **Logout:** Usuário pode fazer logout da aplicação

## 🔒 Segurança

- ✅ CORS configurado para aceitar apenas origens permitidas
- ✅ Validação de entrada em formulários com Zod
- ✅ Autenticação com NextAuth.js
- ✅ Proteção de rotas com middleware
- ✅ Senhas armazenadas (recomendado usar hash em produção)

## 🤝 Como Contribuir

Contribuições são muito bem-vindas! Se você tiver sugestões, encontrar bugs ou quiser implementar novas funcionalidades:

1. Abra uma [issue](https://github.com/seu-usuario/project-java-main/issues)
2. Faça um fork do repositório
3. Crie uma branch para sua feature (`git checkout -b feature/minha-feature`)
4. Commit suas alterações (`git commit -m 'feat: minha nova feature'`)
5. Push para a branch (`git push origin feature/minha-feature`)
6. Abra um [Pull Request](https://github.com/seu-usuario/project-java-main/pulls)

## 📋 Checklist para Deployments

- [ ] Todas as variáveis de ambiente configuradas (`.env` no backend e `.env.local` no frontend)
- [ ] MySQL rodando e acessível
- [ ] Backend compilado com `mvn compile`
- [ ] Backend testado localmente com `mvn exec:java`
- [ ] Frontend testado localmente com `npm run dev`
- [ ] CORS configurado corretamente em `CorsConfig.java`
- [ ] NextAuth.js secret gerado com segurança (`openssl rand -base64 32`)
- [ ] Verificação de tipos TypeScript passou (`npm run typecheck`)
- [ ] Build do frontend compilou sem erros (`npm run build`)
- [ ] Tabela `tb_users` criada automaticamente no MySQL
- [ ] Acesso com credenciais padrão (admin/admin123) funciona
- [ ] Endpoints testados com ferramentas como Postman ou Insomnia

## 🐛 Troubleshooting

### Erro: "Connection refused" no backend
- Verifique se o MySQL está rodando e acessível
- Confirme as credenciais no `.env` (`DB_USER`, `DB_PASS`)
- Teste a conexão com: `mysql -u usuario -p -h localhost`
- Certifique-se de que o banco de dados `user_management` existe

### Erro: "CORS error" no frontend
- Verifique se o backend está rodando na porta 4567
- Confirme `NEXT_PUBLIC_API_URL` no `.env.local` (deve ser `http://localhost:4567`)
- Verifique a configuração de CORS no `CorsConfig.java`
- Limpe o cache do navegador

### Erro ao fazer login: "Campos obrigatórios"
- Verifique se está enviando os campos `user` e `password` (não `login`)
- Confirme que os campos não estão vazios na requisição

### Erro: "Invalid NextAuth Secret"
- Gere um novo secret: `openssl rand -base64 32`
- Atualize o `.env.local` com o novo valor em `NEXTAUTH_SECRET`

### Erro ao executar `mvn exec:java`
- Certifique-se de ter executado `mvn compile` antes
- Verifique se Java está corretamente instalado: `java -version`
- Limpe o projeto: `mvn clean` e compile novamente
- Verifique se a porta 4567 não está em uso: `netstat -tlnp | grep 4567`

### Tabela não está sendo criada
- A tabela `tb_users` é criada automaticamente pelo `DatabaseInit.java`
- Se não funcionar, verifique se o MySQL está rodando
- Verifique as credenciais do banco no `.env`
- Verifique as permissões do usuário MySQL para criar tabelas

### Erro: "Usuário ou senha inválidos"
- Confirme que está usando as credenciais corretas do `.env` (`USER` e `PASS`)
- Por padrão: `user: admin` e `password: admin123`
- Verifique se digitou corretamente sem espaços

## 📜 Licença

Este projeto está licenciado sob a Licença MIT. Veja o arquivo `LICENSE` para mais detalhes.

## 👤 Autor

**Francisco Samuel Crispim Domingos** — [GitHub](https://github.com/seu-usuario) | [LinkedIn](https://www.linkedin.com/in/seu-perfil/)

## 📞 Suporte

Se tiver dúvidas ou precisa de ajuda:
- Consulte a documentação do [Spark Framework](http://www.sparkjava.com/)
- Consulte a documentação do [Next.js](https://nextjs.org/docs)
- Abra uma [issue](https://github.com/seu-usuario/project-java-main/issues) no repositório

---

**Desenvolvido com ❤️ usando Java e Next.js**
