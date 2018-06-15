
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
    private UsuarioDAO dao;
    
    public UsuarioController()
    {
        dao = new UsuarioDAO();
    }
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {     
               
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
         String forward = "";
        String action = request.getParameter("action");
        System.out.println("action=================" + action);
        
        if (action.equalsIgnoreCase("delete")) 
        {
            int idUsuario = Integer.parseInt(request.getParameter("id"));
            dao.deleteUsuario(idUsuario);
            forward = LIST_USUARIOS;
            request.setAttribute("usuarios", dao.slectAllUsers());
        }
        else if(action.equalsIgnoreCase("edit"))
        {
            int idUsuario = Integer.parseInt(request.getParameter("id"));            
            forward = INSERT_OR_EDIT;
            Usuario user = dao.getUsuarioById(idUsuario);
            request.setAttribute("user",user);
        }
        else if(action.equalsIgnoreCase("listUsuarios"))
        {
            forward = LIST_USUARIOS;
            request.setAttribute("usuarios", dao.slectAllUsers());
        
        }
        else
        {
            forward= INSERT_OR_EDIT;
        }
        
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        Usuario user = new Usuario();
        
        user.setNombre_usuario(request.getParameter("nombre_usuario"));
        user.setEmail(request.getParameter("email"));
        String idUsuario = request.getParameter("id");
        
        if (idUsuario != null || idUsuario.isEmpty()) 
        {
            dao.addUsuario(user);
        }else
        {
            user.setId(Integer.parseInt(idUsuario));
            dao.updateUsuario(user);
        }
        
        RequestDispatcher view = request.getRequestDispatcher(LIST_USUARIOS);
        request.setAttribute("usuarios", dao.slectAllUsers());
        view.forward(request, response);
        
    }    

}
