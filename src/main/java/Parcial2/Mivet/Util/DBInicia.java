package Parcial2.Mivet.Util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBInicia {
    public static void main(String[] args) {
        try (Connection conn = Conexion.getInstance().getConnection();
             Statement st = conn.createStatement()) {

            String sqlEmpleado = "CREATE TABLE IF NOT EXISTS empleado (" +
                "id IDENTITY PRIMARY KEY, " +
                "nombre VARCHAR(255), " +
                "usuario VARCHAR(50), " +
                "password VARCHAR(50))";
        st.execute(sqlEmpleado);
        System.out.println("Tabla empleado creada correctamente.");

        String sqlAdoptante = """
            CREATE TABLE IF NOT EXISTS ADOPTANTES (
                id INT AUTO_INCREMENT PRIMARY KEY,
                nombre VARCHAR(100),
                edad INT
            );
            """;
        st.execute(sqlAdoptante);
        System.out.println("Tabla adoptantes creada correctamente.");

        String sqlMascota = """
            CREATE TABLE IF NOT EXISTS MASCOTAS (
                id INT AUTO_INCREMENT PRIMARY KEY,
                nombre VARCHAR(100),
                tipo VARCHAR(100),
                edad INT,
                peso FLOAT,
                id_adoptante INT
            )
        """;
        st.execute(sqlMascota);
        System.out.println("Tabla mascotas creada correctamente.");

    } catch (SQLException e) {
        System.err.println("Error al crear las tablas: "+e.getMessage());

        throw new RuntimeException("Error en la inicializacion de la base de datos", e);
    }
    }
}
