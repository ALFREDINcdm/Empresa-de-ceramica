
public class Arcilla extends Insumo
{
    public Arcilla(double cantidadgramos){
        super(cantidadgramos,"Arcilla","Gris","456A");
    }
   public String toString(){
    return "Es un material  "+ " que sirve para crear platos,hay en existencia " + cantidad+ "gramos";}
}
