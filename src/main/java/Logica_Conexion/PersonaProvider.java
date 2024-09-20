/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica_Conexion;

import Logica_Negocio.Persona;
import Logica_Negocio.Producto;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.Precondition;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 * Clase PersonaProvider que proporciona métodos para interactuar con
 * la colección de personas en Firestore. Esta clase incluye operaciones
 * para guardar, cargar y eliminar personas en la base de datos.
 *
 * @author Santiago Lopez
 */
public class PersonaProvider {

    CollectionReference reference;
    public static Firestore db;
    /**
     * Guarda una persona en la colección especificada de Firestore.
     *
     * @param coleccion el nombre de la colección donde se almacenará la persona.
     * @param documento el identificador del documento donde se guardará la persona.
     * @param data un mapa que contiene los datos de la persona.
     * @return true si la operación fue exitosa, false en caso contrario.
     */

    public static boolean GuardarPersona(String coleccion, String documento, Map<String, Object> data) {
        db = FirestoreClient.getFirestore();
        try {
            DocumentReference docRef = db.collection(coleccion).document(documento);
            ApiFuture<WriteResult> result = docRef.set(data);
            System.out.println("Guardado Correctamente");
            return true;
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return false;
    }
    /**
     * Carga la información de todas las personas de la colección "Persona".
     *
     * @return una lista de objetos Persona.
     */
    public static ArrayList CargarInfoPersona() {

        Persona objper;
        Producto produ;

        ArrayList<Persona> lspersona = new ArrayList<>();
        ArrayList<Producto> lsprodu = new ArrayList<>();

        try {
            CollectionReference persona = Conexion.db.collection("Persona");
            ApiFuture<QuerySnapshot> querySnap = persona.get();

            for (DocumentSnapshot document : querySnap.get().getDocuments()) {

                objper = new Persona(document.getString("uid"),
                        document.getString("Nombre"),
                        document.getString("Apellido"),
                        document.getString("Cedula"),
                        document.getString("Direccion"),
                        document.getString("Productos"),
                        document.getString("Nom_img")
                );
                lspersona.add(objper);

            }

        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return lspersona;
    }
    /**
     * Verifica si un UID ya existe en la colección "Persona".
     *
     * @param uid el UID a verificar.
     * @return true si el UID existe, false en caso contrario.
     */
    public static boolean RetornarUid(String uid) {

        ArrayList<String> uids = new ArrayList<>();
        boolean rta = true;

        try {
            CollectionReference persona = Conexion.db.collection("Persona");
            ApiFuture<QuerySnapshot> querySnap = persona.get();

            for (DocumentSnapshot document : querySnap.get().getDocuments()) {

                uids.add(document.getString("uid"));

            }

            for (int i = 0; i < uids.size(); i++) {

                if (uids.get(i).equals(uid)) {
                    System.out.println("entra");
                    return rta;
                }
            }

        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return !rta;
    }
    /**
     * Carga la información de una persona específica usando su UID.
     *
     * @param codigo el UID de la persona a cargar.
     * @return un objeto Persona si se encuentra, o null si no.
     */
    public static Persona CargarInfoPersonaCodigo(String codigo) {

        Persona objper;
        Persona objper1 = null;

        ArrayList<Persona> lspersona = new ArrayList<>();
        ArrayList<Producto> lsprodu = new ArrayList<>();

        try {
            CollectionReference persona = Conexion.db.collection("Persona");
            ApiFuture<QuerySnapshot> querySnap = persona.get();

            for (DocumentSnapshot document : querySnap.get().getDocuments()) {

                objper = new Persona(document.getString("uid"),
                        document.getString("Nombre"),
                        document.getString("Apellido"),
                        document.getString("Cedula"),
                        document.getString("Direccion"),
                        document.getString("Productos"),
                        document.getString("Nom_img")
                );
                lspersona.add(objper);

            }

        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        for (int i = 0; i < lspersona.size(); i++) {
            if (codigo.equals(lspersona.get(i).getUid())) {
                objper1 = lspersona.get(i);
            }
        }
        return objper1;
    }
    /**
     * Elimina una persona de la colección especificada en Firestore.
     *
     * @param coleccion el nombre de la colección de la que se eliminará la persona.
     * @param documento el UID del documento a eliminar.
     * @return true si la operación fue exitosa, false en caso contrario.
     */
    public static boolean EliminarPersona(String coleccion, String documento) {
        db = FirestoreClient.getFirestore();
        boolean res = RetornarUid(documento);
        System.out.println("Respuesta" + res);

        try {
            if (res != false) {
                DocumentReference docref = db.collection(coleccion).document(documento);
                ApiFuture<WriteResult> result = docref.delete(Precondition.NONE);
                System.out.println("Eliminado exitosamente");
                return true;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cliente no encontrado");
        }

        return false;
    }

}
