package data;

import model.Mensajes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MensajesDAO {

    public static Conexion db_connect = new Conexion();

    public static void insertMessageDB(Mensajes mensaje){


        try(Connection conexion = db_connect.get_connection()){

            PreparedStatement ps = null;

            try {
                String query = "INSERT INTO mensajes(mensaje, autor_mensaje) VALUES (?,?)";
                ps= conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutor_mensaje());
                ps.executeUpdate();
                System.out.println("Mensaje creado");
            } catch (SQLException e){
                System.out.println(e);
            }

        } catch (SQLException e){
            System.out.println(e);
        }
    }
    public static void readMessageDB(){
        PreparedStatement ps = null;
        ResultSet resultSet;

        try(Connection conexion = db_connect.get_connection()){

            try {
                String query = "SELECT * FROM mensajes";
                ps = conexion.prepareStatement(query);
                resultSet = ps.executeQuery();

                System.out.println("\n***** Lista de mensajes *****\n");

                // mientras haya datos
                while(resultSet.next()){
                    System.out.println("ID: " + resultSet.getInt("id_mensaje"));
                    System.out.println("Mensaje: " + resultSet.getString("mensaje"));
                    System.out.println("Autor: " + resultSet.getString("autor_mensaje"));
                    System.out.println("Fecha creación: " + resultSet.getString("fecha_mensaje") + "\n");
                }

            } catch (SQLException e){
                System.out.println(e);
            }

        } catch (SQLException e){
            System.out.println(e);
        }
    }
    public static void deleteMessegeDB(int id){

        try(Connection conexion = db_connect.get_connection()){

            PreparedStatement ps = null;

            try {

                String query = "DELETE FROM mensajes WHERE mensajes.ID_MENSAJE = ?";
                ps = conexion.prepareStatement(query);
                ps.setInt(1, id);
                int countRowsUpdated = ps.executeUpdate();


                if (countRowsUpdated != 0) {
                    System.out.println("El mensaje con el id " + id + " ha sido eliminado exitosamente");
                } else {
                    System.out.println("Este id no existe");
                }

            } catch (SQLException e){
                System.out.println("No se pudo borrar el examen");
                System.out.println(e);
            }

        } catch (SQLException e){
            System.out.println(e);
        }

    }
    public static void updateMessageDB(Mensajes mensaje){
        try(Connection conexion = db_connect.get_connection()){
            PreparedStatement ps;

            try {
                String query = "UPDATE mensajes SET mensaje = ? WHERE id_mensaje = ? ";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setInt(2, mensaje.getId_mensaje());

                int countRow = ps.executeUpdate();

                if(countRow != 0){
                    System.out.println("Mensaje actualizado");
                } else{
                    System.out.println("No existe ese id en la base de datos");
                }

            } catch (SQLException e){
                System.out.println(e);
            }

        } catch (SQLException e){
            System.out.println(e);
        }
    }
}
