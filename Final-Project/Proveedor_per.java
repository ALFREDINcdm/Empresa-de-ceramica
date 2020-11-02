
public class Proveedor_per extends Provedor
{
  private  String curp;
  public Proveedor_per(String nombre, String curp,String clave){
      super(nombre,clave);
      this.curp=curp;
    
    }
  public String getCurp(){return curp;}
  public String toString(){return "Provedor: "+nombre+"\n curp: "+curp+"\nClave de vendedor: "+clavepro;}
}
