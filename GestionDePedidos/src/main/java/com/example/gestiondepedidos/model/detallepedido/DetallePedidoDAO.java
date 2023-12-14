package com.example.gestiondepedidos.model.detallepedido;

import bbdd.properties.AmazenConnection;
import com.example.gestiondepedidos.controllers.DetallePedidoController;
import com.example.gestiondepedidos.model.pedido.Pedido;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DetallePedidoDAO {

    protected static final Connection con = AmazenConnection.getConnection();
    public static String SQL_GET_ALL="SELECT * FROM detallepedido where id_pedido = ?";

    public ArrayList<DetallePedido> getAllById (Integer id) {
        ArrayList<DetallePedido> detallePedidos = new ArrayList<>();
        try(PreparedStatement ps = con.prepareStatement(SQL_GET_ALL)){
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                DetallePedido detallePedido = new DetallePedido();
                detallePedido.setId(rs.getInt("id"));
                detallePedido.setId_pedido(rs.getInt("id_pedido"));
                detallePedido.setId_producto(rs.getInt("id_producto"));
                detallePedido.setCantidad(rs.getInt("cantidad"));
                detallePedidos.add(detallePedido);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return detallePedidos;
    }
}
