/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica_Negocio;

import Helpers.HelperCifrado;

/**
 * La clase Administrador representa un tipo específico de usuario en la aplicación,
 * que hereda de la clase {@link Usuario}. Esta clase implementa el patrón Template Method
 * para definir el comportamiento específico de inicio de sesión (LogOn) para un administrador.
 *
 * @author Santiago Lopez
 * @version 1.0
 */
public class Administrador extends Usuario {

    public Administrador(String usuario, String contraseña) {
        super(usuario, contraseña);
    }
    /**
     * Método sobreescrito que verifica las credenciales del administrador
     * para iniciar sesión. Compara el nombre de usuario y la contraseña
     * proporcionados con los valores cifrados utilizando el algoritmo SHA-256.
     *
     * @param usuario el nombre de usuario ingresado.
     * @param contraseña la contraseña ingresada.
     * @return {@code true} si las credenciales son correctas, {@code false} en caso contrario.
     */
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
