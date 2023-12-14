package com.example.gestiondepedidos.model.detallepedido;

import com.example.gestiondepedidos.model.producto.ProductoDAO;
import lombok.Getter;
import lombok.Setter;

public class DetallePedido {


    @Getter
    @Setter
    private Integer id;

    @Getter
    @Setter
    private Integer id_pedido;

    @Getter
    @Setter
    private String nombre_producto;

    @Getter
    @Setter
    private Integer total_dinero;

    @Getter
    @Setter
    private Integer id_producto;

    @Getter
    @Setter
    private Integer cantidad;


    public void configurar() {
        ProductoDAO productoDAO = new ProductoDAO();
        nombre_producto = productoDAO.getNameById(id_producto);
        total_dinero = productoDAO.getPriceById(id_producto) * cantidad;
    }

}
