
public class Gerente extends Persona
{

    private String id;

    public Gerente(String nombre,String id){
        super(nombre);
        this.id=id;
    }

    public String getid(){ return id;}

    public boolean  Compra(Inventario_insumos i, Compra c){
        Insumo material; 
        try{
            if(c.getInsucv().equalsIgnoreCase("456A")){
                material= new Arcilla(c.getcantidadinsu());
                i.agrega(material); return true;
            }
            else if(c.getInsucv().equalsIgnoreCase("456E")){
                 material= new Esmalte(c.getcantidadinsu(),"rojo");
                i.agrega(material); return true;
            }
            else if(c.getInsucv().equalsIgnoreCase("456P")){
                material = new Pintura(c.getcantidadinsu(),"Verde");
                i.agrega(material); return true;
            }
        }catch(NullPointerException d){
            System.err.println(d.getMessage());
        }
        return false;
    } 

    public String toString(){
        return "Hola soy el gerente " + nombre+ " tengo una identificacion " + id;}
}
