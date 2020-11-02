public class Alfarero extends Trabajador
{
    public Alfarero(String nombre,int sal){
        super(nombre,sal,"08:00-06:00",0);
    }

    public Alfarero(String nombre_Estudent){
        super(nombre_Estudent,0,"Estudiante",0);
    } 

    public void aumen(){
        piezas++;
        if(horario.equalsIgnoreCase("Estudiante")){
          double sal= piezas*3;
            setSalario(sal);} 
    }

    public Producto ProduceProductoTaza(Inventario_insumos n,Inventario_Productos p ){
        try{
            for(int i=0;i<n.tamañovec();i++){
                if(n.retornapos(i) instanceof Arcilla && n.retornapos(i).getcantidad()>0.350){
                    Producto s = new Taza("Natural",1);
                    n.resta(0.350,i);
                    p.agrega(s); 
                    aumen();
                    return s;
                }
            }
        }catch(RuntimeException e){
            return null;
        }
        return null; 
    }

    public Producto ProduceProductoPlato(Inventario_insumos n,Inventario_Productos p ){
        try{
            for(int i=0;i<n.tamañovec();i++){
                if(n.retornapos(i) instanceof Arcilla && n.retornapos(i).getcantidad()>0.400){
                    Producto k = new Plato("Natural",1);
                    n.resta(0.400,i);
                    p.agrega(k); 
                    aumen();
                    return k;
                }
            }
        }catch(RuntimeException e){
            return null;
        }
        return null; 
    }
     public String toString(){return "nombre: "+nombre+" Horario: "+horario;}

}
