package controller;

import dao.DaoJogo;
import model.Jogo;
import model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.*;
import java.nio.file.*;

import com.google.gson.Gson;

@WebServlet("/UpdateGame")
@MultipartConfig
public class UpdateGameServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIR = "uploads";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Verifica se o usuário está logado
		HttpSession session = request.getSession(false);
		if (session == null) {
			response.sendRedirect(request.getContextPath() + "/erro.html");

			return;
		}

		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");

		// Verifica se o usuário é admin
		if (usuario == null || !"admin".equalsIgnoreCase(usuario.getTipo())) {
			response.sendRedirect(request.getContextPath() + "/erro.html");

			return;
		}

		String idParam = request.getParameter("id");
		if (idParam == null) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID do jogo não informado.");
			return;
		}

		try {
			int id = Integer.parseInt(idParam);
			DaoJogo dao = DaoJogo.getInstance();
			Jogo jogo = dao.buscarPorId(id);

			if (jogo == null) {
				response.sendError(HttpServletResponse.SC_NOT_FOUND, "Jogo não encontrado.");
				return;
			}

			// Retorna os dados em JSON
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");

			Gson gson = new Gson();
			response.getWriter().write(gson.toJson(jogo));

		} catch (NumberFormatException e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inválido.");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Verifica se o usuário está logado
		HttpSession session = request.getSession(false);
		if (session == null) {
			response.sendRedirect(request.getContextPath() + "/erro.html");

			return;
		}

		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");

		// Verifica se o usuário é admin
		if (usuario == null || !"admin".equalsIgnoreCase(usuario.getTipo())) {
			response.sendRedirect(request.getContextPath() + "/erro.html");

			return;
		}

		request.setCharacterEncoding("UTF-8");

		try {
			int id = Integer.parseInt(request.getParameter("id"));
			DaoJogo dao = DaoJogo.getInstance();
			Jogo jogo = dao.buscarPorId(id);

			if (jogo == null) {
				response.sendError(HttpServletResponse.SC_NOT_FOUND, "Jogo não encontrado.");
				return;
			}

			// Atualiza os campos
			jogo.setTitulo(request.getParameter("titulo"));
			jogo.setDesenvolvedor(request.getParameter("desenvolvedor"));
			jogo.setAnoLancamento(Integer.parseInt(request.getParameter("anoLancamento")));
			jogo.setGenero(request.getParameter("genero"));
			jogo.setSinopse(request.getParameter("sinopse"));
			jogo.setIdioma(request.getParameter("idioma"));
			jogo.setPlataforma(request.getParameter("plataforma"));
			jogo.setClassificacao(request.getParameter("classificacao"));
			jogo.setAvaliacao(Double.parseDouble(request.getParameter("avaliacao")));

			String precoParam = request.getParameter("preco");
			if (precoParam != null && !precoParam.isEmpty()) {
				jogo.setPreco(Double.parseDouble(precoParam));
			}

			boolean destaque = request.getParameter("destaque") != null;
			boolean lancamento = request.getParameter("lancamento") != null;

			jogo.setDestaque(destaque);
			jogo.setLancamento(lancamento);

			// Upload da nova imagem
			Part filePart = request.getPart("imagem");
			if (filePart != null && filePart.getSize() > 0) {
				String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
				String applicationPath = request.getServletContext().getRealPath("");
				String uploadPath = applicationPath + UPLOAD_DIR + File.separator;
				Path uploadDirPath = Paths.get(uploadPath);

				if (!Files.exists(uploadDirPath)) {
					Files.createDirectories(uploadDirPath);
				}

				Path filePath = uploadDirPath.resolve(fileName);
				try (InputStream input = filePart.getInputStream()) {
					Files.copy(input, filePath, StandardCopyOption.REPLACE_EXISTING);
				}

				jogo.setNomeImagem(fileName);
			}

			// Atualiza o jogo
			dao.atualizar(jogo);

			response.sendRedirect("CRUD.html");

		} catch (Exception e) {
			e.printStackTrace();
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Erro ao atualizar o jogo.");
		}
	}
}
