package com.example.gestiondepedidos.model.pedido;

import bbdd.properties.AmazenConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PedidoDAO {

    protected static final Connection con = AmazenConnection.getConnection();
    public static String SQL_GET_ALL="SELECT * FROM pedido where user_id = ?";


    public ArrayList<Pedido> getAllByUserID(Integer id){
        ArrayList<Pedido> pedidos = new ArrayList<>();
        try(PreparedStatement ps = con.prepareStatement(SQL_GET_ALL)){
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Pedido pedido = new Pedido();
                pedido.setId(rs.getInt("id"));
                pedido.setUser_id(rs.getInt("user_id"));
                pedido.setCod_pedido(rs.getString("cod_pedido"));
                pedido.setOrder_date(rs.getDate("order_date"));
                pedido.setTotal(rs.getInt("total"));
                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pedidos;
    }
}
