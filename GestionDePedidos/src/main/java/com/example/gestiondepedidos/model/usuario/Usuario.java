package com.example.gestiondepedidos.model.usuario;

import lombok.Getter;
import lombok.Setter;

public class Usuario {

    @Getter @Setter
    private Integer id;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private String password;

    @Getter @Setter
    private String email;

    @Override
    public String toString () {
        return "Usuario{" +
                "id:" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '\n';
    }
}

