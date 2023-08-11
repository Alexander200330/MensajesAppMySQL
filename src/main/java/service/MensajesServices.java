package service;

import data.MensajesDAO;
import model.Mensajes;

import java.util.Scanner;

public class MensajesServices {

    public static Scanner sc = new Scanner(System.in);
    public static void insertMessage(){

        System.out.print("Escribe un mensaje: ");
        String mensaje = sc.nextLine();

        System.out.print("\nEscribe tu nombre: ");
        String nombre = sc.nextLine();

        Mensajes newMensaje = new Mensajes();
        newMensaje.setMensaje(mensaje);
        newMensaje.setAutor_mensaje(nombre);

        MensajesDAO.insertMessageDB(newMensaje);
    }
    public static void readMessage(){
        MensajesDAO.readMessageDB();
    }
    public static void deleteMessege(){
        int id = 0;

        System.out.print("Digite un id para eliminar mensaje: ");
        id = Integer.parseInt(sc.nextLine());

        MensajesDAO.deleteMessegeDB(id);
    }
    public static void updateMessage(){
        // Pedir id y mensaje
        System.out.print("Escribir el nuevo mensaje: ");
        String newMessage = sc.nextLine();

        System.out.print("\nEscribir el id del mensaje: ");
        int id = Integer.parseInt(sc.nextLine());

        Mensajes newMessageObject = new Mensajes();

        newMessageObject.setId_mensaje(id);
        newMessageObject.setMensaje(newMessage);

        MensajesDAO.updateMessageDB(newMessageObject);
    }
}
