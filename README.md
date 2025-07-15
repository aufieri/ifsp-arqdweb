# 🎮 Sistema de Gerenciamento de Jogos - Java Web

Aplicação web desenvolvida em **Java** com **Maven**, utilizando **Servlets** e **JSP**, criada por estudantes do curso de Tecnologia em Sistemas para Internet. O sistema permite o gerenciamento completo de um catálogo de jogos eletrônicos, com funcionalidades diferenciadas para administradores e usuários autenticados.

---

## 🚀 Funcionalidades Principais

### 👥 Acesso de Usuários
- Visualização pública de jogos
- Página inicial com carrossel de lançamentos
- Filtros por categoria e busca por título (JS dinâmico)

### 👨‍💼 Acesso do Administrador
- Inserção de novos jogos
- Edição e exclusão de jogos
- Exibição condicional de botões e menus
- Controle de acesso com redirecionamento de rota protegida

---

## 🛠️ Tecnologias Utilizadas

| Camada         | Tecnologias                    |
|----------------|--------------------------------|
| Linguagem      | ☕ Java 17+                     |
| Backend        | 🔁 Servlets + DAO Pattern       |
| Frontend       | 🌐 HTML5, CSS3, Bootstrap 5     |
| Dados          | 📦 JSON (usuários e jogos)      |
| Servidor       | 🛠️ Apache Tomcat                |
| Build Tool     | ⚙️ Maven                        |
| Serialização   | 🧪 GSON (Google JSON Library)   |

---

## 🧱 Estrutura do Projeto

src/
├── main/
│ ├── java/
│ │ ├── controller/ # Servlets (AddGameServlet, ViewGameServlet, etc.)
│ │ ├── dao/ # Acesso a arquivos JSON (DaoJogo, DaoUsuario)
│ │ └── model/ # Entidades como Jogo.java e Usuario.java
│ └── webapp/
│ ├── index.html # Página principal com jogos
│ ├── login.html # Tela de autenticação
│ ├── CRUD.html # Tela de edição/criação de jogo
│ ├── SobreSistema.html # Informações sobre a aplicação
│ └── WEB-INF/
│ └── web.xml # Mapeamento de rotas e configuração web
├── data/
│ ├── jogos.json # Banco de dados simulado de jogos
│ └── usuarios.json # Banco de dados simulado de usuários
├── imagens/ # Imagens dos jogos e ícones
└── pom.xml # Gerenciamento de dependências Maven

---

## 🧠 Melhorias Implementadas

- ✅ Migração de páginas **JSP para HTML** com JS dinâmico
- ✅ Uso de `fetch()` para comunicação com API REST
- ✅ Filtro por categoria e busca por título no front-end
- ✅ Controle de exibição para usuários logados/admins
- ✅ Separação de responsabilidades (Model, DAO, Servlet, View)
- ✅ Modularização de cabeçalho, rodapé e cards via JS

---

## 📷 Imagens (opcional)

Você pode incluir aqui prints do sistema:

- Tela inicial com carrossel e cards
- Tela de login
- Tela de administração (CRUD)
- Filtro por categorias

---

## 👨‍💻 Equipe de Desenvolvimento

Projeto acadêmico desenvolvido por estudantes do IFSP no curso de TSI – 2025.

---

## 📃 Licença

Este projeto é de caráter educacional, sem fins comerciais.
