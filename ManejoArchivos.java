package ArchivosJa;

import java.io.*; 

public class ManejoArchivos {
    public static void crearArchivo(String nombreArchivo){
        File archivo = new File(nombreArchivo);
        
        try{
            PrintWriter salida = new PrintWriter(archivo);
            salida.close();
            System.out.println("Se ha creado el archivo: " + nombreArchivo);
        }catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void escribirArchivo(String nombreArchivo, String contenido){
        File archivo = new File(nombreArchivo);
        
        try{
            PrintWriter salida = new PrintWriter(archivo);
            salida.println(contenido);
            salida.close();
            System.out.println("Se ha escrito en el archivo");
        }catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void anexarArchivo(String nombreArchivo, String contenido){
        File archivo = new File(nombreArchivo);
        
        try{
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, true));
            salida.println(contenido);
            salida.close();
            System.out.println("Se ha anexado informacion al archivo");
        }catch (FileNotFoundException ex) { 
            ex.printStackTrace(System.out);
        } catch (IOException ex) { //Catch de FileWriter
            ex.printStackTrace(System.out);
        }
    }
    
    public static void leerArchivo(String nombreArchivo){
        File archivo = new File(nombreArchivo);
        
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String lectura = entrada.readLine();
            
            //Leer todas las lineas
            while(lectura != null){
                System.out.println(lectura);
                lectura = entrada.readLine(); //Leer lineas completas
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void borrandoArchivo(String nombreArchivo){
        try{
            PrintWriter archivo = new PrintWriter(nombreArchivo);
            archivo.println("");
            archivo.close();
            System.out.println("Se ha limpiado el archivo");
        }catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void main(String[] args) {
        String nombreArchivo = "prueba.txt";
        
        //Se crea un archivo con el nombre que está en "nombreArchivo"
        crearArchivo(nombreArchivo);

        /* IMPORTANTE: Si el nombre del archivo se manda o no como una variable, debebe de tener la extension (.txt)*/

        //Si existe informacion en el archivo, no le hace nada y agrega nueva informacion
        anexarArchivo(nombreArchivo, "I got you moonlight"); 
        
        //Si existe información en el archivo la borra y agrega nueva 
        escribirArchivo(nombreArchivo, "You're my starlight"); 
        
        anexarArchivo(nombreArchivo, "I'm levitating");

        //Leer lo que hay en un archivo
        leerArchivo(nombreArchivo);
        
        //Elimina toda la informacion que existe, es similar a "escribirArchivo"
        borrandoArchivo(nombreArchivo);

        escribirArchivo(nombreArchivo, "You can fly away with me tonight"); 
        leerArchivo(nombreArchivo);
    }    
}
