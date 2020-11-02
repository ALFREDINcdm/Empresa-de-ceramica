
public class Compra extends Operacion {
    private String claveprovedor;
    private double cantidad;
    private String clavematerial;
    public Compra(String fecha,double cantidad,String p, String m){
        super(fecha);
        this.cantidad=cantidad;
        claveprovedor=p;
        clavematerial=m;
    }

    public String getInsucv(){
        return clavematerial;
    }
  public String getClaveprove(){
        return claveprovedor;
    }

    public double getcantidadinsu(){
        return cantidad;}

    public String toString(){return "se compro la cantidad de: "+cantidad +" del insumo "+clavematerial+ "\nen la fecha "+fecha+"\nVendedor :"+claveprovedor; }

}
