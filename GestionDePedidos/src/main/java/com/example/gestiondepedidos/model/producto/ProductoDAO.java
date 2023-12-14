package com.example.gestiondepedidos.model.producto;

import bbdd.properties.AmazenConnection;
import com.example.gestiondepedidos.model.detallepedido.DetallePedido;
import com.example.gestiondepedidos.model.pedido.Pedido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductoDAO<Producto> {

    Connection con = AmazenConnection.getConnection();
    private static String SQL_GET_NAME="SELECT prod_name FROM producto where id = ?";
    private static String SQL_GET_PRICE="SELECT price FROM producto where id = ?";

    public String getNameById (Integer id) {
        try(PreparedStatement ps = con.prepareStatement(SQL_GET_NAME)){
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                return rs.getString("prod_name");
            }else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Integer getPriceById (Integer id) {
        try(PreparedStatement ps = con.prepareStatement(SQL_GET_PRICE)){
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                return rs.getInt("price");
            }else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
