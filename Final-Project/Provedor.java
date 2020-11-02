import java.io.*;

public abstract class Provedor implements Serializable
{
     protected String nombre;
     protected String clavepro;
     public Provedor(String n,String x){
        nombre=n;
        clavepro=x;
    }
       
     public abstract String toString();
  
}
