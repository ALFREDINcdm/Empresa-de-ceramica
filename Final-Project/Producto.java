import java.io.*;

public abstract class Producto implements Serializable
{
    protected String ClaveP;
    protected String caracteristica;
    protected String estado;
    protected int cantidad;
    public Producto (String P, String caracteristica,String estado,int cantidad){
  ClaveP=P;
     this.caracteristica=caracteristica;
     this.estado=estado;
     this.cantidad=cantidad;
    }
    public abstract String toString();
    public void setCantidad(int c){cantidad=c;}
    public void setEstado(String e){
    estado=e;
    }
}
