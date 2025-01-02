package mispaquetes;

import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class ClaveAsimetrica {
	private static final int tamanoClaveAsimetrica = 1024;
    private static final String algoritmoClaveAsimetrica = "RSA";
    private static final String ficheroClavePublica = "clavepublica.der";
    private static final String ficheroClavePrivada = "claveprivada.pkcs8";

    public static void main(String[] args) {
        try {
            // Elijo un algoritmo de generación de números aleatorios de los denominados
            // altamente seguros para generar el par de claves
            SecureRandom algoritmoSeguro = SecureRandom.getInstanceStrong();
            // Preparo el generador de claves para usar el algortimo RSA
            KeyPairGenerator genParClaves = KeyPairGenerator.getInstance(algoritmoClaveAsimetrica);
            genParClaves.initialize(tamanoClaveAsimetrica, algoritmoSeguro);

            // Creo el par de claves y lo guardo en objetos
            KeyPair parClaves = genParClaves.generateKeyPair();
            PublicKey clavePublica = parClaves.getPublic();
            PrivateKey clavePrivada = parClaves.getPrivate();

            // Guardamos la clave pública en un archivo y la visualizamos
            // La clave se guarda con codificación DER y en formato X.509
            guardaClavePublicaX509(clavePublica);
            
            // Guardamos la clave privada en un archivo y la visualizamos
            // La clave se guarda con codificación DER y en formato PKCS#8
            guardaClavePrivadaPKCS8(clavePrivada);
            

        } catch (NoSuchAlgorithmException ex) {
            System.err.println("No se ha encontrado la implementación del algortimo en ningún Provider");
        }

    }

    private static void guardaClavePublicaX509(PublicKey clavePublica) {
        try (FileOutputStream publicKeyFile = new FileOutputStream(ficheroClavePublica)) {
            X509EncodedKeySpec codificacionClavePublica = new X509EncodedKeySpec(clavePublica.getEncoded(), algoritmoClaveAsimetrica);
            publicKeyFile.write(clavePublica.getEncoded());
            
            // Visualizamos la clave por consola
            MostrarClaveBase64(codificacionClavePublica.getEncoded(),
                    codificacionClavePublica.getFormat(), ficheroClavePublica);
        } catch (IOException ex) {
            System.out.println("Error almacenando la clave pública en " + ficheroClavePublica);
        }                
    }

    private static void guardaClavePrivadaPKCS8(PrivateKey clavePrivada) {
        try (FileOutputStream privateKeyFile = new FileOutputStream(ficheroClavePrivada)) {
            PKCS8EncodedKeySpec codificacionClavePrivada = new PKCS8EncodedKeySpec(clavePrivada.getEncoded(), algoritmoClaveAsimetrica);
            privateKeyFile.write(clavePrivada.getEncoded());
            
            // Visualizamos la clave por consola
            MostrarClaveBase64(codificacionClavePrivada.getEncoded(),
                    codificacionClavePrivada.getFormat(), ficheroClavePrivada);
        } catch (IOException ex) {
            System.out.println("Error almacenando la clave privada en " + ficheroClavePrivada);
        }        
    }

    private static void MostrarClaveBase64(byte[] clave, String formatoClave, String ficheroClave) {
        System.out.println("Clave guardada en formato " + formatoClave 
                + " en fichero " + ficheroClave);
        System.out.println(Base64.getEncoder().encodeToString(clave).replaceAll("(.{76})", "$1\n"));
    }
}
