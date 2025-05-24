<%@ include file="header.jsp" %>

<div id="main-content">
  <div class="container mt-5" id="sobre-container">
    <h1 class="mb-4 text-center">SOBRE O SISTEMA</h1>
    
    <p><strong>CRUD - Jogos Eletrônicos</strong> é um sistema web desenvolvido para gerenciar um catálogo de jogos eletrônicos. Ele permite que usuários autenticados possam cadastrar, visualizar, editar e excluir jogos.</p>
    
    <h4 class="mt-4">Funcionalidades:</h4>
    <ul>
      <li>Cadastro completo de jogos com informações detalhadas.</li>
      <li>Visualização de jogos para todos os usuários.</li>
      <li>Edição e remoção disponíveis apenas para usuários logados.</li>
      <li>Página inicial com destaques, novidades e lançamentos.</li>
      <li>Redirecionamento para página de erro em acessos não autorizados.</li>
    </ul>

    <h4 class="mt-4">Menu de Navegação:</h4>
    <ul>
      <li><strong>Home</strong>: Página inicial com jogos em destaque.</li>
      <li><strong>Sobre o Sistema</strong>: Esta página explicativa sobre a aplicação.</li>
      <li><strong>Login</strong>: Permite que usuários se autentiquem.</li>
      <li><strong>Após login</strong>: Opções adicionais como adicionar jogos, configurações pessoais e lista de jogos.</li>
    </ul>

    <h4 class="mt-4">Tecnologias Utilizadas:</h4>
    <ul>
      <li>Java com Servlets e JSP</li>
      <li>HTML5, CSS3 e Bootstrap</li>
      <li>Banco de Dados Relacional (ex: MySQL)</li>
    </ul>
  </div>
</div>

<%@ include file="footer.jsp" %>
