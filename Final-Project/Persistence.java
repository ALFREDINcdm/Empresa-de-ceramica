import java.util.ArrayList;
import java.io.*;
public class Persistence<T>
{

    public boolean GuardaObjetos(String ruta,ArrayList<T> dato){
        try{
            FileOutputStream archivoAguardar = new FileOutputStream(ruta);
            ObjectOutputStream escritorDelArchivo = new ObjectOutputStream(archivoAguardar);
            for(T info : dato){
                escritorDelArchivo.writeObject(info);
            }
            archivoAguardar.close();
        }catch(IOException e){
            System.err.print(e.getMessage());
            return false;
        }
        return true;
    }
    
    public ArrayList<T>  RecuperaObjetos(String ruta){ 
        ObjectInputStream lector = null;
        T objeto = null;
        ArrayList<T> salida = new ArrayList();
        try{
            FileInputStream archivoAleer = new FileInputStream(ruta);
            lector= new ObjectInputStream(archivoAleer);
            objeto =(T)lector.readObject();
            while(objeto!=null){
                salida.add(objeto);
               objeto =(T)lector.readObject();
         } 
        }catch(IOException | ClassNotFoundException e){
          System.err.print(e.getMessage());

        }
        return salida;
       }
    
   }
