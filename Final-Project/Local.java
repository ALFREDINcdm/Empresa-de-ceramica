
public class Local 
{
    protected int Cant;
    private String nombre;
    protected  String producto;
    protected String numerocli;
    public Local(String n,String ncliente,int cc,String Plato_vazo){
        this.numerocli=ncliente;
        nombre=n;
        Cant=cc;
        producto=Plato_vazo;
    }

    public int getcat(){return Cant;}

}
