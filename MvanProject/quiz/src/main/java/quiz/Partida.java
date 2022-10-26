package quiz;

import java.util.Scanner;

import java.sql.*;


public class Partida {

    private Scanner sc = new Scanner(System.in);
    private String usuario;
    private PreguntasDAO preguntasDAO = new PreguntasDAO();
    private Pregunta pregunta_aciertos = new Pregunta();
    private Integer respuestasIncorrectas = pregunta_aciertos.respuestasCorrectas;
    private Integer respuestasCorrectas = pregunta_aciertos.respuestasCorrectas;
    private ResultSet preguntas = preguntasDAO.getPreguntas();

    public Partida(String usuario) {
        this.usuario = usuario;
    }

    public boolean verificarRespuesta(String respuesta, ResultSet preguntas) throws SQLException {
        if (respuesta.equalsIgnoreCase(preguntas.getString("respuesta_letra"))) {  return true; } 
        else { return false; }

    }
    public void mostrarPuntuacion(){
        System.out.println("\nAciertos: " + respuestasCorrectas + "\nFallos: " + respuestasIncorrectas);
    }
    public void hacerPreguntas() {   
        try {
            
            while (preguntas.next()) {
                System.out.println("\n" + preguntas.getString("pregunta"));
                System.out.println("\n" + preguntas.getString("todas_respuestas"));
                System.out.println("\n" + "Escribe la respuesta correcta: ");
                String respuesta = sc.nextLine();

                if (verificarRespuesta(respuesta, preguntas)) { respuestasCorrectas++; } 
                else { respuestasIncorrectas++; }
            }

            PreguntasDAO.addResultado(usuario, String.valueOf(respuestasCorrectas), String.valueOf(respuestasIncorrectas));

        } catch (Exception e) { System.out.println("\n" + e);}
    }

    public void jugar(){
        hacerPreguntas();
        mostrarPuntuacion();
    }
}
