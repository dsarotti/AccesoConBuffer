import java.io.File;

/**
 * Demostración del ejercicio de acceso a ficheros con buffer
 */
public class App {
    private static String ruta ="src\\f1.txt";
    private static String textoAEscribir="España, espantapájaros";
    
    public static void main(String[] args) throws Exception {
        System.out.println("El texto a escribir será \"" + textoAEscribir + "\"");

        //Escritura de un fichero sin buffer
        System.out.println("PRUEBA: ESCRITURA SIN BUFFER");
        try{
            File f = new File(ruta);
            AccesoFicheros.escribirSinBuffer(f,textoAEscribir);
        }catch (NullPointerException e){
            System.out.println("Ha ocurrido un error al inicializar el fichero");
        }
        System.out.println("--------------------------------------");

        //Lectura de un fichero sin buffer
        System.out.println("PRUEBA: LECTURA SIN BUFFER");
        leerSinBuffer();
        System.out.println("--------------------------------------");

        //Lectura de un fichero con buffer
        System.out.println("PRUEBA: LECTURA CON BUFFER");
        leerConBuffer();
        System.out.println("--------------------------------------");

        //Espera pulsación de teclado para continuar.
        System.out.println("pulsa una tecla para continuar");
        System.in.read();

        //Escritura de un fichero con buffer
        System.out.println("PRUEBA: ESCRITURA CON BUFFER");
        try{
            File f = new File(ruta);
            AccesoFicheros.escribirConBuffer(f,textoAEscribir);
        }catch (NullPointerException e){
            System.out.println("Ha ocurrido un error al inicializar el fichero");
        }
        System.out.println("--------------------------------------");

        //Lectura de un fichero sin buffer
        System.out.println("PRUEBA: LECTURA SIN BUFFER");
        leerSinBuffer();
        System.out.println("--------------------------------------");

        //Lectura de un fichero con buffer
        System.out.println("PRUEBA: LECTURA CON BUFFER");
        leerConBuffer();
        System.out.println("--------------------------------------");
    }

    /**
     * Inicia el proceso de lectura del fichero con Buffer
     */
    public static void leerConBuffer(){
        try{
            File f = new File(ruta);
            AccesoFicheros.leerConBuffer(f);
        }catch (NullPointerException e){
            System.out.println("Ha ocurrido un error al inicializar el fichero");
        }finally{
            System.out.println();
        }
    }

    /**
     * Inicia el proceso de lectura del fichero sin Buffer
     */
    public static void leerSinBuffer(){
        try{
            File f = new File(ruta);
            AccesoFicheros.leerSinBuffer(f);
        }catch (NullPointerException e){
            System.out.println("Ha ocurrido un error al inicializar el fichero");
        }finally{
            System.out.println();
        }
    }
}