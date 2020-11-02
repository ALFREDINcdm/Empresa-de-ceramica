import java.util.ArrayList;

public class Inventario_insumos 
{
    ArrayList <Insumo> inventar = new ArrayList <Insumo>();
    Persistence <Insumo> insumos = new <Insumo> Persistence (); 

    public void agrega(Insumo c){ inventar.add(c);  
    }

    public void GuardaInsumos(){
        insumos.GuardaObjetos("Persistence/insumos.obj",inventar);
    }

    public void RecuperaInsumos(){
        inventar = insumos.RecuperaObjetos("Persistence/insumos.obj");
    }

    public int tamañovec(){return  inventar.size();}

    public Insumo retornapos(int d){
        return inventar.get(d);
    }

    public void muestrasInsumos(){
        for(Insumo x:inventar){
            System.out.println("clave: "+x.claveInuso+"\ncantidad: "+x.cantidad);
        }
    }

    
    public void resta(double z, int pos){
        inventar.get(pos).setcantidad(inventar.get(pos).getcantidad()-z);
    }
}

