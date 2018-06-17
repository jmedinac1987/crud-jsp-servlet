/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Model.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jmedinac
 */
public class UsuarioDAO extends DBConnection.Connection {

    public UsuarioDAO() {
        super();//para heredar el constructor
    }

    public List<Usuario> slectAllUsers() {
        Usuario user = null;
        List<Usuario> list = new ArrayList<Usuario>();

        try {
            prepareStatement = connect.prepareStatement("SELECT * FROM usuarios");
            resulset = prepareStatement.executeQuery();

            while (resulset.next()) {
                user = new Usuario();
                user.setId(Integer.parseInt(resulset.getString("id")));
                user.setNombre_usuario(resulset.getString("nombre_usuario"));
                user.setEmail(resulset.getString("email"));

                list.add(user);
            }
        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        return list;
    }

    public void deleteUsuario(int usuarioId) {
        try {
            prepareStatement = connect.prepareStatement("DELETE FROM usuarios WHERE id = ?");
            prepareStatement.setInt(1, usuarioId);
            int consultationQuantity = prepareStatement.executeUpdate();

            if (consultationQuantity == 1) {
                System.out.println("User deleted");
            } else {
                System.out.println("User not found");
            }
        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    public void addUsuario(Usuario user) {
        try {
            prepareStatement = connect.prepareStatement("INSERT INTO usuarios (nombre_usuario, email) VALUES (?, ?)");
            prepareStatement.setString(1, user.getNombre_usuario());
            prepareStatement.setString(2, user.getEmail());
            prepareStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }

    }

    public void updateUsuario(Usuario user) {
        try {
            prepareStatement = connect.prepareStatement("UPDATE usuarios SET nombre_usuario=? , email=? WHERE id =?");
            prepareStatement.setString(1, user.getNombre_usuario());
            prepareStatement.setString(2, user.getEmail());
            prepareStatement.setInt(3, user.getId());
            prepareStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    public Usuario getUsuarioById(int idUsuario) {
        Usuario user = new Usuario();

        try {
            prepareStatement = connect.prepareStatement("SELECT * FROM usuarios WHERE id = ?");
            prepareStatement.setInt(1, idUsuario);
            resulset = prepareStatement.executeQuery();

            if (resulset.next()) {
                user.setId(Integer.parseInt(resulset.getString("id")));
                user.setNombre_usuario(resulset.getString("nombre_usuario"));
                user.setEmail(resulset.getString("email"));
            }

        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        return user;
    }
}
