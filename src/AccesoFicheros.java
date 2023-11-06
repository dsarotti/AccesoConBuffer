import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

/**
 * Gestiona el acceso a ficheros con o sin buffer
 * 
 * @author Dante Sarotti
 */
public class AccesoFicheros {
    //Clase no instanciable.
    private AccesoFicheros(){}
    
    /** 
     * Lee un fichero con un FileInputStream y muestra su contenido sin utilizar buffer.
     * @param f representación del fichero a leer
     */
    public static void leerSinBuffer(File f){
        Reader streamReader=null;
        try {
            streamReader = new InputStreamReader(new FileInputStream(f),"UTF-8");
            int caracter;
            boolean salida=false;
            while (!salida){
                caracter=streamReader.read();
                if(caracter!=-1){
                    System.out.print((char)caracter);
                }else{
                   salida=true;
                }
            }
        }catch (FileNotFoundException e){
            System.out.println("No se encuentra el fichero.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error.");
            e.printStackTrace();
        }finally{
            try{
                if(streamReader!=null){
                    streamReader.close();
                }
            }catch(IOException e ){
                System.out.println("Error al cerrar el recurso.");
                e.printStackTrace();
            }
        }
    }


    /** 
     * Escribe en un fichero sin utilizar buffer.
     * @param f representación del fichero a escribir.
     * @param textoAEscribir Texto a escribir en el fichero.
     */
    public static void escribirSinBuffer(File f, String textoAEscribir){
        Writer streamWriter = null;
        try{
            streamWriter=new OutputStreamWriter(new FileOutputStream(f),"UTF-8");
            streamWriter.write(textoAEscribir);
            System.out.println("Se ha escrito el fichero sin BufferedWriter");
        }catch(FileNotFoundException e){
            System.out.println("no se encuentra el fichero.");
        }catch(IOException e ){
            System.out.println("Ha ocurrido un error.");
            e.printStackTrace();
        }finally{
            try{
                if (streamWriter!=null){
                    streamWriter.close();
                }
            }catch(IOException e){
                System.out.println("Error al cerrar el recurso.");
                e.printStackTrace();
            }
        }
    }

    /** 
     * Lee un fichero con un BufferedReader y muestra su contenido.
     * @param f representación del fichero a leer
     */
    public static void leerConBuffer(File f){
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(f),"UTF-8"));
            String linea="";
            while ((linea = bufferedReader.readLine())!=null){
                System.out.print(linea);
            }
        }catch (FileNotFoundException e){
            System.out.println("No se encuentra el fichero.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error.");
            e.printStackTrace();
        }finally{
            try{
                if(bufferedReader!=null){
                    bufferedReader.close();
                }
            }catch(IOException e ){
                System.out.println("Error al cerrar el recurso.");
                e.printStackTrace();
            }
        }
    }

    /** 
     * Escribe en un fichero con un BufferedReader
     * @param f representación del fichero a escribir.
     * @param textoAEscribir Texto a escribir en el fichero.
     */
    public static void escribirConBuffer(File f, String textoAEscribir){
        BufferedWriter bufferedWriter = null;
        try{
            bufferedWriter=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f),"UTF-8"));
            bufferedWriter.write(textoAEscribir);
            bufferedWriter.flush();
            System.out.println("Se ha escrito el fichero con un BufferedWriter");
        }catch(FileNotFoundException e){
            System.out.println("no se encuentra el fichero.");
        }catch(IOException e ){
            System.out.println("Ha ocurrido un error.");
            e.printStackTrace();
        }finally{
            try{
                if (bufferedWriter!=null){
                    bufferedWriter.close();
                }
            }catch(IOException e){
                System.out.println("Error al cerrar el recurso.");
                e.printStackTrace();
            }
        }
    }
}