package com.example.gestiondepedidos.model.usuario;

import bbdd.properties.AmazenConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public class UsuarioDAO{

    final static String QUERY_GET_CREDENTIALS="SELECT * from usuario where name =? and password = ? ";
    protected static final Connection con = AmazenConnection.getConnection();

    static public  ArrayList<Usuario> getAll () {
        ArrayList<Usuario> usuarios = new ArrayList<>();

        String sql_query = "SELECT * FROM usuario";

        try(PreparedStatement ps = con.prepareStatement(sql_query)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setName(rs.getString("name"));
                usuario.setPassword(rs.getString("password"));
                usuario.setEmail(rs.getString("email"));
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (!usuarios.isEmpty()){
            return usuarios;
        }else return null;


    }


    static public ArrayList<Usuario> getT (Integer identificador) {
        ArrayList<Usuario> usuarios = new ArrayList<>();

        String sql_query = "SELECT * FROM usuario WHERE id=?";

        try(PreparedStatement ps = con.prepareStatement(sql_query)){
            ps.setInt(1,identificador);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setName(rs.getString("name"));
                usuario.setPassword(rs.getString("password"));
                usuario.setEmail(rs.getString("email"));
                usuarios.add(usuario);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (usuarios.size()>0){
            return usuarios;
        }
        return null;
    }


    public Optional<Usuario> loginUsuario(String name, String password){
        try(PreparedStatement ps = con.prepareStatement(QUERY_GET_CREDENTIALS)){

            ps.setString(1, name);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            Optional<Usuario> optional = Optional.empty();
            while (rs.next()){
                Usuario user = new Usuario();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                System.out.println(user);
                optional =  Optional.of(user);
            }
            return optional;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
