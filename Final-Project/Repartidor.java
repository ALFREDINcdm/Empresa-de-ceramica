import java.util.*;
import java.text.SimpleDateFormat;

public class Repartidor extends Trabajador
{
    private String licencia;
    
    public Repartidor(String nombre,String lic){
        super(nombre,0,"Por reparto",0);
        licencia=lic;
    }

    public ArrayList<Producto> ObtenProduct(Inventario_Productos s){
        try{
            ArrayList <Producto> inventa = new ArrayList <Producto>();
            int x= (int)s.tamañarr()/2;
            for(int i=0;i<x;i++){
                inventa.add(s.pos(i));
                s.eliminap(i);
            }
            return inventa;
        }catch(RuntimeException c){
            return null;
        }
    }

    public String Regrsapro(Vector<Producto> x,Inventario_Productos s){
        try{
            for(int i=0;i<x.size();i++){
                s.agrega(x.get(i));
                x.remove(i);
                return "Productos regresados ";
            }
        }catch (RuntimeException c){
            return "se produjo un error " +c;
        } 
        return null;
    }

    public Venta Dia_Venta(DiaVent dia){
        try{
            SimpleDateFormat act = new SimpleDateFormat("dd/MM/yyyy");
            String fecha= act.format(new Date());
            int cant = dia.getruta().gettlocal().getcat(); 
            String nclin=dia.getruta().gettlocal().numerocli; 
            if( dia.getruta().gettlocal().producto.equalsIgnoreCase("Taza")){
                Venta v= new Venta(fecha,cant,nclin,"103t");  
                vende(dia.getvehiculo().invaux(),v);
                setSalario(cant*4);
                return v;
            }
            else{
                Venta v= new Venta(fecha,cant,nclin,"102p"); 
                vende(dia.getvehiculo().invaux(),v);
                setSalario(cant*4);

                return v;
            }
        }catch(Exception e){
        } 
        return null;  
    }

    public void vende(Vector<Producto> x,Venta v){
        try{
            int total;
            for(int i=0;i<x.size();i++){
                if(x.get(i).ClaveP.equalsIgnoreCase(v.getClaProdu())&&x.get(i).estado.equalsIgnoreCase("Terminado") ){
                    total=x.get(i).cantidad-v.cantidadPro;
                    x.get(i).setCantidad(total); 
                }

            }
        }catch(Exception e){ }}

    public String getlicencia(){return licencia;}
     public String toString(){return "nombre: "+nombre+" Horario: "+horario;}



}
