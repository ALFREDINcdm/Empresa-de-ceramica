import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
public class Inventario_Productos 
{
    ArrayList <Producto> inventario = new ArrayList();
    Persistence <Producto> produc = new Persistence ();

    public void Guaraproductos(){
        produc.GuardaObjetos("Persistence/productos.obj",inventario);
    }

    public void RecuperaInventario(){
        inventario = produc.RecuperaObjetos("Persistence/productos.obj");
    } 

    public void AgregaTipoProduc(String tipo,String estado, int cantidad){
        try{
            if(cantidad >0)
                if(tipo.equalsIgnoreCase("Taza")){
                    inventario.add(new Taza (estado,cantidad));
                }
                else if(tipo.equalsIgnoreCase("Plato")){
                    inventario.add(new Plato (estado,cantidad));
                }
                else{
                    System.out.println("Solo plato o taza");}
        }catch(NullPointerException e){
            System.out.print(e.getMessage());}
    }

    public void muetraProductos(){
        for(int i =0;i<inventario.size();i++){
           if(inventario.get(i) instanceof Plato){
            System.out.println("Plato con una cantidad de :"+inventario.get(i).cantidad+"\n estado: "+inventario.get(i).estado+"\nposicion: "+i);
            }
            else{
                System.out.println("Taza con una cantidad de :"+inventario.get(i).cantidad+"\n estado: "+inventario.get(i).estado+"\nposicion: "+i);
            }
         }
    }

    public String agrega(Producto c){
        try{
            inventario.add(c);
            return "Nuevo producto";

        }catch(NullPointerException e){
            return "Error "+e;
        }
    }

    public void eliminap(int x){
        try{
            inventario.remove(x);
            System.out.print("Hecho");

        }catch(NullPointerException e){
        }
    }

    public void muestramenu(Scanner xd,Operador ja){
        int op;
        boolean salir = false;
        String aux , name, cantidad; 
        int num;
        try{
            while(!salir){
                System.out.println("1 :Agregar nuvo Producto");
                System.out.println("2 :Ver Productos");
                System.out.println("3 :Eliminar Producto");
                System.out.println("4 :Salir");
                op=xd.nextInt();
                switch(op){
                    case 1: 
                    aux=ja.leerString("Itroduzca Plato o taza");
                    name=ja.leerString("Introduzca su estado: Cocido,natural,esmaltado,Terminado");
                    cantidad =ja.leerString("Introduzca la cantidad"); 
                    num= Integer.parseInt(cantidad);
                    AgregaTipoProduc(aux, name, num);
                    break;
                    case 2:
                    muetraProductos();
                    break;
                    case 3:
                    cantidad=ja.leerString("Introduza el indice recurde ver los productos para este dato");
                    num= Integer.parseInt(cantidad);
                    eliminap(num);
                    break;
                    case 4:
                    salir=true;
                    default:
                    System.out.println("Observe el menu");
                }
            }}catch(InputMismatchException | NumberFormatException e){
            System.out.println("Debes insertar un número");
            xd.next();
        }
    }

    public Producto pos(int l){return inventario.get(l);}
    public int tamañarr(){return  inventario.size();}
}
