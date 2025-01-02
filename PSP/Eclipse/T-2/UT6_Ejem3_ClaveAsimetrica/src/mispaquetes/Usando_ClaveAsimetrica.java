package mispaquetes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.System.Logger.Level;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class Usando_ClaveAsimetrica {
	private static final int tamanoClaveAsimetrica = 1024;
    private static final String algoritmoClaveAsimetrica = "RSA";
    private static final String ficheroClavePublica = "clavepublica.der";
    private static final String ficheroClavePrivada = "claveprivada.pkcs8";
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            //////////////////////////////////////////////////
            // CIFRADO
            //////////////////////////////////////////////////
            
            // Leemos la clave pública de un archivo
            PublicKey clavePublica = leerClavePublica(ficheroClavePublica);

            // Preparamos la información que queremos cifrar
            // INTRODUCIR DATOS POR TECLADO
    		System.out.print("Introduce la cadena a convertir: ");
    		String textoEnClaro = sc.nextLine();
            byte[] mensajeEnClaro = textoEnClaro.getBytes("UTF-8");
            
            // Realizamos el proceso de cifrado con clave pública
            // Los pasos son exactamente los mismos que con el cifrado simétrico
            Cipher cifrado = Cipher.getInstance(algoritmoClaveAsimetrica);
            cifrado.init(Cipher.ENCRYPT_MODE, clavePublica);
            byte[] mensajeCifrado = cifrado.doFinal(mensajeEnClaro);
            // Visualizamos el mensaje cifrado en modo texto
            MostrarMensajeBase64(mensajeCifrado);
            
            //////////////////////////////////////////////////
            // DESCIFRADO
            //////////////////////////////////////////////////
            
            // Leemos la clave privada de un archivo
            PrivateKey clavePrivada = leerClavePrivada(ficheroClavePrivada);

            // Realizamos el proceso de descifrado con clave privada
            // Los pasos son exactamente los mismos que con el cifrado simétrico
            // Cipher cifrado = Cipher.getInstance(algoritmoClaveAsimetrica);
            cifrado.init(Cipher.DECRYPT_MODE, clavePrivada);
            byte[] mensajeDescifrado = cifrado.doFinal(mensajeCifrado);
            // Visualizamos el mensaje descifrado
            System.out.println("Texto descifrado:\n" + new String(mensajeDescifrado, "UTF-8"));
                        
        } catch (UnsupportedEncodingException ex) {
            System.out.println("Codificación de caracteres UTF-8 no soportada");
        } catch (NoSuchAlgorithmException ex) {
            System.err.println("No se ha encontrado la implementación del algoritmo " + algoritmoClaveAsimetrica + " en ningún Provider");
        } catch (NoSuchPaddingException ex) {
            System.err.println("El relleno especificado para el algoritmo no está permitido");
        } catch (InvalidKeyException ex) {
            System.err.println("Especificación de clave no válida");
        } catch (IllegalBlockSizeException ex) {
            System.err.println("Tamaño de bloque no válido");
        } catch (BadPaddingException ex) {
            System.err.println("Excepción con el relleno usado por el algoritmo");
        }
    }

    private static PublicKey leerClavePublica(String ficheroClave) {
        byte[] clavePublicaEncoded;

        // Leemos la información del archivo
        try (FileInputStream publicKeyFile = new FileInputStream(ficheroClave)) {
            clavePublicaEncoded = publicKeyFile.readAllBytes();
        } catch (FileNotFoundException ex) {
            System.out.println("No se ha encontrado el archivo " + ficheroClave + " con la clave pública.");
            return null;
        } catch (IOException ex) {
            System.out.println("Se ha producido un error de E/S accediendo al archivo " + ficheroClave + " de la clave pública.");
            return null;
        }

        // Generamos la clave a partir del array de bytes leídos
        KeyFactory keyFactory;
        try {
            keyFactory = KeyFactory.getInstance(algoritmoClaveAsimetrica);
            X509EncodedKeySpec codificacionClavePublica = new X509EncodedKeySpec(clavePublicaEncoded);
            PublicKey clavePublica = keyFactory.generatePublic(codificacionClavePublica);

            // Devolvemos la clave pública generada
            return clavePublica;
        } catch (NoSuchAlgorithmException ex) {
            System.err.println("No se ha encontrado la implementación del algoritmo " + algoritmoClaveAsimetrica + " en ningún Provider");
            return null;
        } catch (InvalidKeySpecException ex) {          
            return null;
        }
    }

    private static PrivateKey leerClavePrivada(String ficheroClave) {
        byte[] clavePrivadaEncoded;

        // Leemos la información del archivo
        try (FileInputStream privateKeyFile = new FileInputStream(ficheroClave)) {
            clavePrivadaEncoded = privateKeyFile.readAllBytes();
        } catch (FileNotFoundException ex) {
            System.out.println("No se ha encontrado el archivo " + ficheroClave + " con la clave privada.");
            return null;
        } catch (IOException ex) {
            System.out.println("Se ha producido un error de E/S accediendo al archivo " + ficheroClave + " de la clave privada.");
            return null;
        }

        // Generamos la clave a partir del array de bytes leídos
        KeyFactory keyFactory;
        try {
            keyFactory = KeyFactory.getInstance(algoritmoClaveAsimetrica);
            PKCS8EncodedKeySpec codificacionClavePrivada = new PKCS8EncodedKeySpec(clavePrivadaEncoded);
            PrivateKey clavePrivada = keyFactory.generatePrivate(codificacionClavePrivada);

            // Devolvemos la clave pública generada
            return clavePrivada;
        } catch (NoSuchAlgorithmException ex) {
            System.err.println("No se ha encontrado la implementación del algoritmo " + algoritmoClaveAsimetrica + " en ningún Provider");
            return null;
        } catch (InvalidKeySpecException ex) {
            return null;
        }
    }
    
    private static void MostrarMensajeBase64(byte[] mensajeCifrado) {
        System.out.println("Mensaje cifrado visualizado como texto en Base64:");                
        System.out.println(Base64.getEncoder().encodeToString(mensajeCifrado).replaceAll("(.{76})", "$1\n"));
    }    
}
