/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.parqueadero.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Portatil
 */
public class AccesoBD {
    // Librería de MySQL
    public String driver = "com.mysql.cj.jdbc.Driver";

    // Nombre de la base de datos
    public String database = "parqueadero";

    // Host
    public String hostname = "localhost";

    // Puerto
    public String port = "3306";

    // Ruta de nuestra base de datos (desactivamos el uso de SSL con
    // "?useSSL=false")
    public String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database
            + "?allowPublicKeyRetrieval=true&useSSL=false";

    // Nombre de usuario
    public String username = "root";

    // Clave de usuario
    public String password = "";

    public Connection conectarMySQL() {
        Connection conn = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }
}
