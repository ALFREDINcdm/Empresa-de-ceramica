import java.io.*;
public abstract class Trabajador implements Serializable
{
    
    protected String nombre;
    protected double salario;
    protected String horario;
    protected int piezas;
   public Trabajador (String n,double s,String h,int p){
    nombre=n;
    salario=s;
    horario=h;
    piezas=p;
    }
    
   public void setSalario(double sal){
       salario=sal;
    }
    public void salario(int z,int pz){
    salario=z*pz;
    }
    public abstract String toString();

}
