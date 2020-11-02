import java.util.*;
public class Vehiculo
{
    private  String color;
    private String placas ;
    private Vector<Producto> produxvent;
    public Vehiculo(String c, String placas,Vector<Producto> array){
         color=c;
         this.placas=placas;
         produxvent=array;
     }
    public String getColor(){ return color;}
    public String getPlaca(){return placas;}
    
    public Vector<Producto> invaux(){return produxvent;}
}
