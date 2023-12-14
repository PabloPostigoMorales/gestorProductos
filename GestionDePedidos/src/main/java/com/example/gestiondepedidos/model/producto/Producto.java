package com.example.gestiondepedidos.model.producto;

import lombok.Getter;
import lombok.Setter;

public class Producto {

    @Getter
    private String id;

    @Getter
    @Setter
    private String prod_Name;

    @Getter
    @Setter
    private Integer price;

    @Getter
    @Setter
    private Integer avail_Quantity;
}
