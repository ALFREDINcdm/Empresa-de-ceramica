import java.io.*;
public abstract class  Operacion implements Serializable
{
    protected String fecha;
    public Operacion ( String fecha){
    this.fecha=fecha;
    }
    public String getFecha(){ return fecha;}
    public abstract String toString();

}
