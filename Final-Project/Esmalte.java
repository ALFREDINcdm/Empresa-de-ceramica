public class Esmalte extends Insumo
{
 public Esmalte(double cantidadml, String color){
  super(cantidadml,"Esmalte",color,"456E");
  
 }
 public String toString(){
    return "Es un material que sirve para decorar "+ ", hay en existencia " + cantidad+ "ml";}
}
