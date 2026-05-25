package Parcial2.Mivet.Login;

import Parcial2.Mivet.Dao.EmpleadoDAO;
import Parcial2.Mivet.Dao.EmpleadoDAOImpl;
import Parcial2.Mivet.Util.Conexion;
import Parcial2.Mivet.Modelo.Empleado;


import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class Loginvet extends JFrame {

    private JTextField campoUsuario;
    private JPasswordField campoPassword;

    public Loginvet() {
        setTitle("Login de Empleado");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inicializarComponentes();
        setVisible(true);
    }

    private void inicializarComponentes() {
        JPanel panel=new JPanel(new GridLayout(3, 2));

        panel.add(new JLabel("Usuario:"));
        campoUsuario=new JTextField();
        panel.add(campoUsuario);

        panel.add(new JLabel("Contrasena:"));
        campoPassword=new JPasswordField();
        panel.add(campoPassword);

        JButton botonLogin=new JButton("Login");
        botonLogin.addActionListener(e -> login());
        panel.add(botonLogin);

        JButton botonRegistrar=new JButton("Registrarse");
        botonRegistrar.addActionListener(e -> abrirRegistro());
        panel.add(botonRegistrar);

        add(panel);
    }

    private void login() {
        try {
            String usuario=campoUsuario.getText();
            String password=new String(campoPassword.getPassword());

            EmpleadoDAO dao=new EmpleadoDAOImpl(Conexion.getInstance().getConnection());
            Empleado empleado=dao.buscarPorUsuarioYContrasena(usuario,password);

            if (empleado!=null) {
                EmpleadoLogueadoSingleton.getInstance().setEmpleado(empleado);
                JOptionPane.showMessageDialog(this,"Login correcto. Bienvenido "+empleado.getNombre());
                dispose();
            } else {
                JOptionPane.showMessageDialog(this,"Usuario o contrasena incorrectos");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,"Error al conectar con la base de datos");
            e.printStackTrace();
        }
    }

    private void abrirRegistro() {
        new RegistroEmpleadoVet();
    }

}