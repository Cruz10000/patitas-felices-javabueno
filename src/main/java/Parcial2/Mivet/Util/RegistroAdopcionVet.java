package Parcial2.Mivet.Util;

import Parcial1.Animal.MascotaExtra;
import Parcial1.Humano.Adoptante;
import Parcial1.Animal.Mascota;
import Parcial2.Mivet.Dao.AdoptanteDAO;
import Parcial2.Mivet.Dao.AdoptanteDAOImpl;
import Parcial2.Mivet.Dao.MascotaDAO;
import Parcial2.Mivet.Dao.MascotaDAOImpl;
import Parcial2.Mivet.Dao.AdopcionDAO;
import Parcial2.Mivet.Dao.AdopcionDAOImpl;
import Parcial2.Mivet.Login.EmpleadoLogueadoSingleton;

import javax.swing.*;
import java.awt.*;

public class RegistroAdopcionVet extends JFrame {

    private JTextField campoNombreAdoptante;
    private JTextField campoEdadAdoptante;
    private JTextField campoDireccionAdoptante;

    private JTextField campoNombreMascota;
    private JTextField campoEspecieMascota;
    private JTextField campoFechaNacimiento;
    private JTextField campoPesoMascota;

    public RegistroAdopcionVet() {
        setTitle("Registro de Adopcion");
        setSize(400,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        inicializarComponentes();

        setVisible(true);
    }

    private void inicializarComponentes() {
        JPanel panel=new JPanel(new GridLayout(9, 2));

        panel.add(new JLabel("Nombre del adoptante:"));
        campoNombreAdoptante=new JTextField();
        panel.add(campoNombreAdoptante);

        panel.add(new JLabel("Edad del adoptante:"));
        campoEdadAdoptante=new JTextField();
        panel.add(campoEdadAdoptante);

        panel.add(new JLabel("Direccion del adoptante:"));
        campoDireccionAdoptante=new JTextField();
        panel.add(campoDireccionAdoptante);
                                                                        //pr mascota
        panel.add(new JLabel("Nombre de la mascota:"));
        campoNombreMascota=new JTextField();
        panel.add(campoNombreMascota);

        panel.add(new JLabel("Especie de la mascota:"));
        campoEspecieMascota=new JTextField();
        panel.add(campoEspecieMascota);

        panel.add(new JLabel("Fecha de nacimiento (YYYY-MM-DD):"));
        campoFechaNacimiento=new JTextField();
        panel.add(campoFechaNacimiento);

        panel.add(new JLabel("Peso de la mascota en kg:"));
        campoPesoMascota=new JTextField();
        panel.add(campoPesoMascota);

        JButton botonRegistrar=new JButton("Registrar Adopcion");
        botonRegistrar.addActionListener(e -> registrarAdopcion());
        panel.add(botonRegistrar);

        add(panel);
    }

    private void registrarAdopcion() {
        try {
            Adoptante adoptante=new Adoptante();
            adoptante.setNombre(campoNombreAdoptante.getText());
            adoptante.setEdad(Integer.parseInt(campoEdadAdoptante.getText()));
            adoptante.setDireccion(campoDireccionAdoptante.getText());

            AdoptanteDAO adoptanteDAO=new AdoptanteDAOImpl();
            adoptanteDAO.insertar(adoptante);

            Mascota mascota=new MascotaExtra();
            mascota.setNombreMascota(campoNombreMascota.getText());
            mascota.setEspecie(campoEspecieMascota.getText());
            mascota.setFechaNacimiento(campoFechaNacimiento.getText());
            mascota.setPeso(Double.parseDouble(campoPesoMascota.getText()));
            mascota.getIdAdoptante(adoptante.getId());

            MascotaDAO mascotaDAO=new MascotaDAOImpl();
            mascotaDAO.insertar(mascota);

            AdopcionDAO adopcionDAO = new AdopcionDAOImpl();
            adopcionDAO.insertar(adoptante.getId(), mascota.getId(),
                    EmpleadoLogueadoSingleton.getInstance().getEmpleado().getId());

            mostrarRecomendaciones(mascota.getEspecie());

            String ticket="Adopcion registrada:\n\n"
                    +"Adoptante: "+adoptante.getNombre()+"\n"
                    +"Mascota: "+mascota.getNombreMascota()+" ("+mascota.getEspecie()+")\n";

            JOptionPane.showMessageDialog(this, ticket, "Ticket de Adopcion", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al registrar adopcion", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void mostrarRecomendaciones(String especie) {
        String recomendaciones;
        switch (especie.toLowerCase()){
            case "perro":
                recomendaciones="Pasear todos los días y vacunas al dia.";
                break;
            case "gato":
                recomendaciones="Proveer rascadores y control veterinario.";
                break;
            default:
                recomendaciones="Cuidados generales y chequeo anual.";
                break;
        }
        JOptionPane.showMessageDialog(this, recomendaciones, "Recomendaciones de Cuidado", JOptionPane.INFORMATION_MESSAGE);
    }
}

