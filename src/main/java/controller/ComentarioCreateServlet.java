package controller;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ComentarioDAOJSON;
import model.Comentario;
import model.Usuario;

@WebServlet("/criar-comentario")
public class ComentarioCreateServlet extends HttpServlet {

}
