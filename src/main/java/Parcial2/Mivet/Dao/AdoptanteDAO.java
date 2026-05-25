package Parcial2.Mivet.Dao;

import Parcial1.Humano.Adoptante;
import Parcial2.Mivet.Util.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdoptanteDAO {

    public void insertar(Adoptante adoptante) throws SQLException {
        String sql = "INSERT INTO ADOPTANTES (nombre, edad) VALUES (?, ?)";
        try (Connection conn = Conexion.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, adoptante.getNombre());
            ps.setInt(2, adoptante.getEdad());
            ps.executeUpdate();
        }
    }
}
