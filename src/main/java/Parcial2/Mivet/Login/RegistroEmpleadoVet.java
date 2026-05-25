package Parcial2.Mivet.Login;

import Parcial2.Mivet.Dao.EmpleadoDAO;
import Parcial2.Mivet.Dao.EmpleadoDAOImpl;
import Parcial2.Mivet.Modelo.Empleado;
import Parcial2.Mivet.Util.Conexion;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class RegistroEmpleadoVet extends JFrame {

    private JTextField campoUsuario;
    private JPasswordField campoPassword;
    private JTextField campoNombre;

    public RegistroEmpleadoVet() {
        setTitle("Registrar Empleado");
        setSize(300,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        inicializarComponentes();
        setVisible(true);
    }

    private void inicializarComponentes() {
        JPanel panel=new JPanel(new GridLayout(4, 2));

        panel.add(new JLabel("Usuario:"));
        campoUsuario=new JTextField();
        panel.add(campoUsuario);

        panel.add(new JLabel("Contraseña:"));
        campoPassword=new JPasswordField();
        panel.add(campoPassword);

        panel.add(new JLabel("Nombre:"));
        campoNombre=new JTextField();
        panel.add(campoNombre);

        JButton botonRegistrar=new JButton("Registrar");
        botonRegistrar.addActionListener(e -> registrar());
        panel.add(botonRegistrar);

        add(panel);
    }

    private void registrar() {
        try {
            String usuario=campoUsuario.getText();
            String password=new String(campoPassword.getPassword());
            String nombre=campoNombre.getText();

            EmpleadoDAO dao=new EmpleadoDAOImpl(Conexion.getInstance().getConnection());
            Empleado empleado=new Empleado(usuario,password,nombre);
            dao.guardar(empleado);

            JOptionPane.showMessageDialog(this, "Empleado registrado correctamente.");
            dispose();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al registrar el empleado.");
            e.printStackTrace();
        }
    }
}
