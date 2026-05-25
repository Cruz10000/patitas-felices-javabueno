package Parcial1.Mail;

public class Mail implements EnviarMail {
    public void Enviar(String Origen, String Destino, String Asunto, String Cuerpo) {
        System.out.println("Email de: " + Origen + ", A: " + Destino);
        System.out.println("Asunto: " + Asunto);
        System.out.println("Contenido: " + Cuerpo);
    }
}
