package ui;

import service.MensajesServices;

import java.util.Scanner;

public class UIMenu {
    public static void showMenu(){
        System.out.println("****** Bienvenido/a ******");
        System.out.println("Aplicación de mensajes");
        System.out.println("1. Crear mensaje");
        System.out.println("2. Listar mensaje");
        System.out.println("3. Editar mensaje");
        System.out.println("4. Eliminar");
        System.out.println("0. Salir");

        Scanner sc = new Scanner(System.in);
        String opcion = "";

        do{
            System.out.println("Por favor seleccionar una opción del menú");
            System.out.print(">> ");
            opcion= sc.nextLine();
            switch (opcion){
                case "1":
                    MensajesServices.insertMessage();
                    break;
                case "2":
                    MensajesServices.readMessage();
                    break;
                case "3":
                    MensajesServices.updateMessage();
                    break;
                case "4":
                    MensajesServices.deleteMessege();
                    break;
                case "0":
                    System.out.println("Has salido del sistema...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Debes seleccionar una opción correcta");
                    break;
            }
        } while(true);


    }
}
