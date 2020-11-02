import java.io.*;
public abstract class Insumo implements Serializable
{
    protected double cantidad;
    protected String nombre;
    protected String color;
    String claveInuso;
    public Insumo(double c, String p,String e,String x){
        cantidad=c;
        nombre=p;
        color=e;
        claveInuso=x;
    }
    public abstract String toString();
    public void setcantidad(double cantidad){
    this.cantidad=cantidad;
    }
    public double getcantidad(){
    return cantidad;
    }
   public String getColor(){return color;}

}
