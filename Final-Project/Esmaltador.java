
public class Esmaltador extends Trabajador
{
    public Esmaltador(String nombre){
        super(nombre,800,"08:00-06:00",0);
    }

    public String EsmaltarPlato(Plato x,String color,Inventario_insumos c){
        try{
            if(x.estado.equalsIgnoreCase("Cocido")){
                for(int i =0;i<c.tamañovec();i++){
                    String col = c.retornapos(i).color;
                    if(col.equalsIgnoreCase(color) && c.retornapos(i) instanceof Esmalte && c.retornapos(i).cantidad>0.100){
                        x.setEstado("Esmaltado");
                        c.resta(0.60,i);
                        piezas++;
                        return "Ahora tu producto esta esmaltado";
                    }
                }
            }
        }catch(RuntimeException z){return "error "+z;
        }return null;
    }

    public String EsmaltarTaza(Taza x,String color,Inventario_insumos c){
        try{
            if(x.estado.equalsIgnoreCase("Cocido")){
                for(int i =0;i<c.tamañovec();i++){
                    String col = c.retornapos(i).color;
                    if(col.equalsIgnoreCase(color) && c.retornapos(i) instanceof Esmalte && c.retornapos(i).cantidad>0.85){
                        x.setEstado("Esmaltado");
                        c.resta(0.90,i);
                        piezas++;
                        return "Ahora tu producto esta esmaltado";
                    }
                }
            }
        }catch(RuntimeException z){return "error "+z;
        }return null;
    }

    public String PintarProductos(Producto x, String color,Inventario_insumos c ){
        try{
            if(x.estado.equalsIgnoreCase("Terminada")){
                for(int i =0;i<c.tamañovec();i++){
                    String col = c.retornapos(i).color;
                    if(col.equalsIgnoreCase(color) && c.retornapos(i) instanceof Pintura && c.retornapos(i).cantidad>0.90){
                        x.caracteristica="Pintado de color "+ color;
                        c.resta(0.90,i);
                        piezas++;
                        return "Ahora tu producto esta Pintado ";
                    }
                }
            }
        }catch(RuntimeException z){return "error "+z;
        }return null;

      }
           public String toString(){return "nombre: "+nombre+" Horario: "+horario;}


}