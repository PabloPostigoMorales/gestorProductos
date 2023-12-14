package com.example.gestiondepedidos.model.pedido;

import lombok.Getter;
import lombok.Setter;

public class Pedido {

    @Setter
    @Getter
    private Integer id;

    @Getter
    @Setter
    private String cod_pedido;

    @Getter
    @Setter
    private java.sql.Date order_date;

    @Getter
    @Setter
    private Integer user_id;

    @Getter
    @Setter
    private Integer total;

}
