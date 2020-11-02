import java.io.*;
public abstract class Persona implements Serializable
{
  protected String nombre;
    public Persona(String n){
       nombre = n;
  }
    public abstract String toString();
}
