package Parcial2.Mivet.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    private static Conexion instancia;
    private Connection conexion;

    private static final String URL = "jdbc:h2:~/veterinaria";
    private static final String USUARIO = "sa";
    private static final String PASSWORD = "";

    private Conexion() throws SQLException {
        this.conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
    }

    public static Conexion getInstance() throws SQLException {
        if (instancia == null || instancia.getConnection().isClosed()) {
            instancia = new Conexion();
        }
        return instancia;
    }

    public Connection getConnection() {
        return conexion;
    }
}
