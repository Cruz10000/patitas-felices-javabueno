package Parcial2.Mivet;

import Parcial2.Mivet.Login.Loginvet;

public class MainApp {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            new Loginvet();
        });
    }
}
