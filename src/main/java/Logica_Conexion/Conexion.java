/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica_Conexion;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Clase Conexion que implementa el patrón Singleton para gestionar
 * conexiones a Firestore y a una base de datos MySQL.
 *
 * @author Santiago Lopez Patron Singleton
 */
public class Conexion {

    public static Firestore db;
    public static Connection con = null;

    /**
     * Establece una conexión con Firestore utilizando credenciales desde un archivo JSON.
     * Si la conexión se establece con éxito, se imprime un mensaje de confirmación.
     *
     * @throws IOException si ocurre un error al leer el archivo de credenciales.
     */
    public static void Conectar() {
        try {
            FileInputStream as = new FileInputStream("tienda-electronica.json");
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(as))
                    .build();

            FirebaseApp.initializeApp(options);
            db= FirestoreClient.getFirestore();
            System.out.println("Conexion Exitosa");
            
        } catch (IOException e) {
            System.out.println("Error:" + e.getMessage());
        }
    }
    /**
     * Obtiene una conexión a la base de datos MySQL.
     *
     * @return una instancia de Connection que representa la conexión a la base de datos,
     *         o null si no se pudo establecer la conexión.
     */
    public static Connection getConnection() {
        String url = "jdbc:mysql:// localhost:3307/prueba";
        String user = "root";
        String pass = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return con;
    }

}
