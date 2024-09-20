/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Logica_Conexion;

import Logica_Negocio.Persona;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 * Interfaz DAOInterfacePersona que define las operaciones básicas
 * para manejar la entidad Persona en la base de datos. Esta interfaz
 * establece un contrato para implementar clases de acceso a datos
 * (DAO) relacionadas con personas.
 *
 * @author Santiago Lopez
 */
public interface DAOInterfacePersona {
    /**
     * Agrega una nueva persona a la base de datos.
     *
     * @param per el objeto Persona que se va a agregar.
     * @return el número de filas afectadas por la operación.
     * @throws SQLException si ocurre un error al acceder a la base de datos.
     */
    public int add(Persona per) throws SQLException;
    /**
     * Elimina una persona de la base de datos usando su ID.
     *
     * @param id el ID de la persona a eliminar.
     * @return el número de filas afectadas por la operación.
     * @throws SQLException si ocurre un error al acceder a la base de datos.
     */
    public int delete(String id) throws SQLException;
    /**
     * Obtiene una persona de la base de datos utilizando su ID.
     *
     * @param id el ID de la persona a obtener.
     * @return un objeto Persona si se encuentra, o null si no.
     * @throws SQLException si ocurre un error al acceder a la base de datos.
     */
    public Persona getPersona(String id) throws SQLException;
    /**
     * Obtiene una lista de todas las personas en la base de datos.
     *
     * @return una lista de objetos Persona.
     * @throws SQLException si ocurre un error al acceder a la base de datos.
     */
    public ArrayList<Persona> getPersona() throws SQLException;
    /**
     * Actualiza la información de una persona en la base de datos.
     *
     * @param per el objeto Persona con la información actualizada.
     * @throws SQLException si ocurre un error al acceder a la base de datos.
     */
    public void update(Persona per) throws SQLException;
    /**
     * Cierra la conexión a la base de datos.
     *
     * @throws SQLException si ocurre un error al cerrar la conexión.
     */
    public void close() throws SQLException;
    
}
