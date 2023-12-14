module com.example.gestiondepedidos {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires lombok;


    opens com.example.gestiondepedidos to javafx.fxml;
    exports com.example.gestiondepedidos;
    exports com.example.gestiondepedidos.controllers;
    opens com.example.gestiondepedidos.controllers to javafx.fxml;
    exports com.example.gestiondepedidos.model.producto;
    opens com.example.gestiondepedidos.model.producto to javafx.fxml;
    exports com.example.gestiondepedidos.model.pedido;
    opens com.example.gestiondepedidos.model.pedido to javafx.fxml;
    exports com.example.gestiondepedidos.model.usuario;
    opens com.example.gestiondepedidos.model.usuario to javafx.fxml;
    exports com.example.gestiondepedidos.model.detallepedido;
    opens com.example.gestiondepedidos.model.detallepedido to javafx.fxml;
}