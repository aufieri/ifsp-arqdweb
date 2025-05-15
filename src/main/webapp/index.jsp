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

<div id="EditandoCarrossel">


    <div id="carouselExampleCaptions" class="carousel slide">
        <div class="carousel-indicators">
          <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
          <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
          <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
        </div>
        <div class="carousel-inner">
          <div class="carousel-item active">
            <img src="https://i0.wp.com/www.guiadoed.com.br/wp-content/uploads/2025/01/Marvels-Spider-Man-2-1.webp?fit=1016%2C571&ssl=1" class="d-block w-100" alt="homem aranha">
            <div class="carousel-caption d-none d-md-block">
              
            </div>
          </div>
          <div class="carousel-item">
            <img src="https://www.adrenaline.com.br/wp-content/uploads/2024/03/Desenvolvimento-de-GTA-6-esta-atrasado-e-jogo-pode-ser-adiado.jpg" class="d-block w-100" alt="GTA">
            <div class="carousel-caption d-none d-md-block">
        
            </div>
          </div>
          <div class="carousel-item">
            <img src="https://static.cdprojektred.com/cms.cdprojektred.com/crystal-news/f783a9404b08a8f2670f4d9d633b483a9c412e20.png" class="d-block w-100" alt="the Witcher">
            <div class="carousel-caption d-none d-md-block">
           
            </div>
          </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Next</span>
        </button>
      </div>
</div>

  <div class="lista-jogos">

  <div class="linha-de-cards">

  <div class="card" style="width: 18rem;" id="minecraft">
    <img src="https://i0.wp.com/www.guiadoed.com.br/wp-content/uploads/2025/01/Marvels-Spider-Man-2-1.webp?fit=1016%2C571&ssl=1" class="card-img-top" alt="mine">
    <div class="card-body">
      <h5 class="card-title" >Marvel Spider-Man 2</h5>
      <p class="card-text">R$150,00</p>
      <a href="#" class="btn btn-primary" id="btn-jogos">Ver Mais</a>
    </div>
  </div>

  <div class="card" style="width: 18rem;" id="stardew">
    <img src="https://www.adrenaline.com.br/wp-content/uploads/2024/03/Desenvolvimento-de-GTA-6-esta-atrasado-e-jogo-pode-ser-adiado.jpg" class="card-img-top" alt="stardewvalley">
    <div class="card-body">
      <h5 class="card-title">GTA VI</h5>
      <p class="card-text">R$500,00</p>
      <a href="#" class="btn btn-primary" id="btn-jogos">Ver Mais</a>
    </div>
  </div>


  <div class="card" style="width: 18rem;" id="terra">
    <img src="https://static.cdprojektred.com/cms.cdprojektred.com/crystal-news/f783a9404b08a8f2670f4d9d633b483a9c412e20.png" class="d-block w-100" class="card-img-top" alt="terraria">
    <div class="card-body">
      <h5 class="card-title" id="texto-card">The Witcher 3: Wild Hunt</h5>
      <p class="card-text">R$150,00</p>
      <a href="#" class="btn btn-primary" id="btn-jogos">Ver Mais</a>
    </div>
  </div>

  </div>
</div>
		
		 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"></script>

<%@include file="footer.jsp" %>