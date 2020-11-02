
public class Proveedor_empre extends Provedor
{
   private String idabogado;
   public Proveedor_empre(String nombre,String idabogado,String clave){
       super(nombre,clave);
       this.idabogado=idabogado;
    }
   public String toString(){return "Provedor: "+nombre+"\nID del abogado: "+idabogado+"\nClave de vendedor: "+clavepro;}

}
