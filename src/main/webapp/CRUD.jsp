<%@ include file="header.jsp" %>

    <nav class="navbar navbar-expand-lg" id="navPrincipal">
        <div class="container-fluid">
          <a class="navbar-brand" href="#">GameLet</a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="#">Home</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">Sobre o Sistema</a>
              </li>
                <ul class="dropdown-menu">
                  <li><a class="dropdown-item" href="#">Action</a></li>
                  <li><a class="dropdown-item" href="#">Another action</a></li>
                  <li><hr class="dropdown-divider"></li>
                  <li><a class="dropdown-item" href="#">Something else here</a></li>
                </ul>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">Login</a>
              </li>
            </ul>
            <form class="d-flex" role="search">
              <input class="form-control me-2" type="search" placeholder="Buscar" aria-label="Search"/>
              <button class="btn btn-outline-success" type="submit" id="btn-buscar">Buscar</button>
            </form>
          </div>
        </div>
      </nav>

      <div class="container" id="container">

      <button type="button" class="btn btn-primary btn-lg" id="btn-adicionar">Adicionar Jogo</button>

      <table class="table" id="tabela">
        <thead>
          <tr>
            <th scope="col">ID</th>
            <th scope="col">Título</th>
            <th scope="col">Gênero</th>
            <th scope="col">Ano</th>
            <th scope="col">Ação</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <th scope="row">1</th>
            <td>Marvel Spider Man 2</td>
            <td>Ação/Aventura</td>
            <td>2023</td>

            <td>
            <img src="imagens/highlighter.svg" alt="editar">
            <img src="imagens/backspace.svg" alt="Excluir">
            </td>

          </tr>
          <tr>
            <th scope="row">2</th>
            <td>GTA IV</td>
            <td>Ação</td>
            <td>2025</td>
            
            <td>
            <img src="imagens/highlighter.svg" alt="editar">
            <img src="imagens/backspace.svg" alt="Excluir">
            </td>

          </tr>
          <tr>
            <th scope="row">3</th>
            <td>The Witcher 3: Wild Hunt</td>
            <td>Ação</td>
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