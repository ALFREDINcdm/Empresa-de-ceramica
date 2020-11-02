
public class Cliente extends Persona 

{
    private String ncliente;
    public Cliente (String nombre,String ncliente){
        super(nombre);
        this.ncliente=ncliente;
    }
    public String getncliente(){return ncliente;}
    public String toString(){
        return "Hola soy el Cliennte " + nombre ;} 
}
