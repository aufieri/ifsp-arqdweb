<%@ include file="header.jsp" %>

      <div class="container" id="container">
      
      <button type="button" class="btn btn-primary btn-lg" id="btn-adicionar" onclick="window.location.href='adicionarjogo.jsp'">Adicionar Jogo</button>

      <table class="table" id="tabela">
        <thead>
          <tr>
            <th scope="col">ID</th>
            <th scope="col">T�tulo</th>
            <th scope="col">G�nero</th>
            <th scope="col">Ano</th>
            <th scope="col">A��o</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <th scope="row">1</th>
            <td>Marvel Spider Man 2</td>
            <td>A��o/Aventura</td>
            <td>2023</td>

            <td>
            <img src="imagens/highlighter.svg" alt="editar">
            <img src="imagens/backspace.svg" alt="Excluir">
            </td>

          </tr>
          <tr>
            <th scope="row">2</th>
            <td>GTA IV</td>
            <td>A��o</td>
            <td>2025</td>
            
            <td>
            <img src="imagens/highlighter.svg" alt="editar">
            <img src="imagens/backspace.svg" alt="Excluir">
            </td>

          </tr>
          <tr>
            <th scope="row">3</th>
            <td>The Witcher 3: Wild Hunt</td>
            <td>A��o</td>
            <td>2015</td>
            
            <td>
            <img src="imagens/highlighter.svg" alt="editar">
            <img src="imagens/backspace.svg" alt="Excluir">
            </td>

          </tr>
        </tbody>
      </table>
      </div>

      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"></script>



<%@include file="footer.jsp" %>