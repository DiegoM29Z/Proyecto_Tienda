/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helpers;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *Clase HelperCifrado
 *Proporciona métodos para cifrar mensajes utilizando el algoritmo SHA-256.
 * @author Santiago Lopez
 */
public class HelperCifrado {
     /**
     * Cifra un mensaje utilizando el algoritmo SHA-256.
     * 
     * @param mensaje El mensaje que se desea cifrar.
     * @return Una cadena de texto en formato hexadecimal que representa el cifrado del mensaje.
     * @throws RuntimeException Si ocurre una excepción relacionada con el algoritmo de cifrado.
     */
    
      public static String CifrarSHA256(String mensaje)
    {
         try{
            MessageDigest sha= MessageDigest.getInstance("SHA-256");
            byte[] digest = sha.digest(mensaje.getBytes());
            StringBuilder hexString = new StringBuilder();
            for(byte b: digest)
            {
                hexString.append(String.format("%02x", b));
            }
            
            return hexString.toString();
            
            
        }catch( NoSuchAlgorithmException e)
        {
            throw new RuntimeException(e);
        }
    }
}
