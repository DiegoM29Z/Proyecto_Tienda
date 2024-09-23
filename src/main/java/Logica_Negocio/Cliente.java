/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica_Negocio;

import Helpers.HelperCifrado;

/**
 * La clase Cliente representa un tipo específico de usuario en la aplicación,
 * que hereda de la clase {@link Usuario}. Implementa el patrón Template Method
 * para definir el comportamiento de inicio de sesión (LogOn) específico para un cliente.
 *
 * @author Santiago Lopez
 * @version 1.0
 */
public class Cliente extends Usuario {
    /**
     * Constructor de la clase Cliente. Inicializa un nuevo cliente con un nombre de usuario
     * y contraseña.
     *
     * @param usu el nombre de usuario del cliente.
     * @param contra la contraseña del cliente.
     */

    public Cliente(String usu, String contra) {
        super(usu, contra);
    }

    @Override
    public boolean LogOn(String usuario, String contraseña) {
        boolean res = true;
        String comprobarusuario = HelperCifrado.CifrarSHA256(getUsu());
        String comprobarcontra = HelperCifrado.CifrarSHA256(getContra());
        System.out.println("usu ci abs" + "\t" + comprobarusuario);
        System.out.println("usu con abs" + "\t" + comprobarcontra);

        if (comprobarusuario.compareTo(usuario) == 0 && 
                comprobarcontra.compareTo(contraseña) == 0) {
            return res;
        } else {

            return !res;
        }
    }
}
