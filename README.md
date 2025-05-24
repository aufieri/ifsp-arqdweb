# 🎮 Sistema de Gerenciamento de Jogos - Java Web

Este projeto é uma aplicação web desenvolvida em **Java**, com o uso do **Maven**, criada por um grupo de estudantes do curso de Tecnologia em Sistemas Para Internet. A aplicação permite o gerenciamento de um catálogo de jogos eletrônicos, com funcionalidades exclusivas para administradores.

---

## 📚 Tecnologias Utilizadas

- ☕ **Java**
- ⚙️ **Maven**
- 🌐 **Servlets**
- 🧠 **DAO (Data Access Object)**
- 🧭 **Controladores (Controllers)**
- 📝 **JSP (JavaServer Pages)**
- 🗃️ **HTML/CSS**
- 🛠️ **Tomcat (Servidor Web)**

---

## 🧩 Funcionalidades

### 👨‍💼 Acesso do Administrador
- Inserção de novos jogos
- Edição de jogos cadastrados
- Exclusão de jogos
- Visualização da lista de jogos

### 🎮 Catálogo de Jogos
- Exibição de todos os jogos cadastrados
- Navegação simples e intuitiva com páginas JSP

---

## 📂 Estrutura do Projeto

├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── controller/       # Servlets de controle (ViewGameServlet, AddGameServlet, etc)
│   │   │   ├── dao/              # Acesso aos dados (DaoJogo.java)
│   │   │   └── model/            # Classe Jogo/Usuarios (representação dos dados)
│   │   └── webapp/
│   │       ├── index.jsp         # Página inicial
│   │       └── WEB-INF/
│   │           └── web.xml       # Configuração da aplicação
├── pom.xml                      # Gerenciador de dependências Maven
