package Parcial2.Mivet.Dao;

import Parcial1.Animal.Mascota;
import Parcial2.Mivet.Util.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MascotaDAO {

    public void insertar(Mascota mascota) throws SQLException {
        String sql = "INSERT INTO MASCOTAS (nombre, especie) VALUES (?, ?)";
        try (Connection conn = Conexion.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, mascota.getNombreMascota());
            ps.setString(2, mascota.getClass().getSimpleName());
            ps.executeUpdate();
        }
    }
}
