
public class Venta extends Operacion
{
    private String nCliente ;
    int cantidadPro;
    private String Clave;
    private String claveven;
    public Venta(String fecha ,int cantidad, String d,String clave){
        super(fecha);
        nCliente=d;  
        cantidadPro=cantidad;
        Clave=clave;
        claveven ="";
    }
    public void SetClaveven(String clave){claveven=clave;}
    public String GetclaveVend(){return claveven;}
    public String getClaProdu(){return Clave;}

    public int getCantidadPro(){return cantidadPro;}

    public String getCliente(){return nCliente;}

    public String toString(){return "se vendio la cantidad de "+cantidadPro +" del producto "+Clave + "\nen la fecha "+fecha+"\nVededor: "+claveven; }

}