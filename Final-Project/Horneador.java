
public class Horneador extends Trabajador
{

    public Horneador(String nombre){
        super(nombre,700,"08:00-06:00",0);
    }

    public String cueceProducto(Producto x){
        try{    
            if(x.estado.equalsIgnoreCase("Natural")){
            x.estado="Cocido";
            piezas++;
            return "Ahora tu Producto esta cocido";}
            else 
            return "Debes pasar por las otros paso";
        }catch(NullPointerException s){
            return "error " + s;
        }
    }

    public String CoccionFinal(Producto x){
        try{
            if(x.estado.equalsIgnoreCase("Esmaltado")){
                x.estado="Terminado";
            piezas++;
            return "Tu producto ha pasado todos los procesos intenta pintarlos con el esmaltador :)";}
            else
            return "Comprueba si tu producto ya paso por los pasos requeridos";
        }catch(NullPointerException s){
            return "error "+s;
        }
    }
    
    @Override
    public String toString(){
        return nombre;
    }
}
