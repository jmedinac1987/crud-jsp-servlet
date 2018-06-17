package Controllers;

import Model.Usuario;
import Services.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jmedinac
 */
@WebServlet(name = "UsuarioController", urlPatterns = {"/UsuarioController"})
public class UsuarioController extends HttpServlet {

    private static String INSERT_OR_EDIT = "/usuario.jsp";
    private static String LIST_USUARIOS = "/listUsuarios.jsp";
    private static String INDEX = "index.jsp";
    private static String DELETEUSER = "/usuarioDelete.jsp";
    private UsuarioDAO dao;

    public UsuarioController() {
        dao = new UsuarioDAO();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");//importante para el manejo de caracteres latinos
        request.setCharacterEncoding("UTF-8");//importante para el manejo de caracteres latinos
        processRequest(request, response);
        String forward = "";
        String action = request.getParameter("action");
        System.out.println("action=================" + action);

        if (action.equalsIgnoreCase("delete")) {
            int idUsuario = Integer.parseInt(request.getParameter("id"));
            forward = DELETEUSER;
            Usuario user = dao.getUsuarioById(idUsuario);
            request.setAttribute("user", user);
        } else if (action.equalsIgnoreCase("edit")) {
            int idUsuario = Integer.parseInt(request.getParameter("id"));
            forward = INSERT_OR_EDIT;
            Usuario user = dao.getUsuarioById(idUsuario);
            request.setAttribute("user", user);
        } else if (action.equalsIgnoreCase("listUsuarios")) {
            forward = LIST_USUARIOS;
            request.setAttribute("usuarios", dao.slectAllUsers());

        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");//importante para el manejo de caracteres latinos
        request.setCharacterEncoding("UTF-8");//importante para el manejo de caracteres latinos
        processRequest(request, response);

        Usuario user = new Usuario();

        user.setNombre_usuario(request.getParameter("nombre_usuario"));
        user.setEmail(request.getParameter("email"));
        String idUsuario = request.getParameter("id");

        if (idUsuario == null || idUsuario.isEmpty()) {

            dao.addUsuario(user);

        } else if (request.getParameter("eliminar") != null) {

            user.setId(Integer.parseInt(idUsuario));
            dao.deleteUsuario(user.getId());

        } else {
            user.setId(Integer.parseInt(idUsuario));
            dao.updateUsuario(user);
        }

        response.sendRedirect(INDEX);

    }

}
