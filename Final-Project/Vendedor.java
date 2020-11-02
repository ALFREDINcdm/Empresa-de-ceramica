
public class Vendedor extends Trabajador
{
        private  String clave;
    public Vendedor(String n,String clavende){
       super(n,800,"08:00-06:00",0); 
       clave=clavende;
    }

    public boolean VendeProducto(Inventario_Productos p, Venta v){
        try{
            int total;
            for(int i=0;i<p.tamañarr();i++){
                if(p.pos(i).ClaveP.equalsIgnoreCase(v.getClaProdu())&&p.pos(i).estado.equalsIgnoreCase("Terminado") ){
                    total=p.pos(i).cantidad-v.cantidadPro;
                    p.pos(i).setCantidad(total); 
                    return true;}
                else return false;
            }
        }catch(NullPointerException e){ }
        return false;
    }
    public String Getclave(){return clave;}

    public String toString(){
        return "Hola soy el Vendedor " + nombre;}
}