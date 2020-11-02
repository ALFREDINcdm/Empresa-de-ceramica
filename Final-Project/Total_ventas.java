import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Total_ventas 
{
    ArrayList<Venta> vent = new ArrayList<Venta>();
    Persistence <Venta> disk = new Persistence ();

    public void Agregaven(Venta f){
        try{
            vent.add(f);
        }catch(NullPointerException e){
            System.err.println(e.getMessage());
        }    
    }

    public void GuardaVentas(){
        disk.GuardaObjetos("Persistence/Ventas.obj",vent);
    }

    public void RecuperaVentas(){
        vent = disk.RecuperaObjetos("Persistence/Ventas.obj");
    } 

    public void BuscaFechaPordia(String fecha){
        try{
            for(Venta recibo:vent){
                if(recibo.fecha.equalsIgnoreCase(fecha)){
                    System.out.println(recibo);
                }
            }
        }catch(NullPointerException z){
            System.err.println(z.getMessage());}

    }

    public void VentasXcliente(String idCliente){
        try{
            for(Venta recibo:vent){
                if(recibo.getCliente().equalsIgnoreCase("idCliente")){
                    System.out.println(recibo);
                }
            }
        }catch(NullPointerException x){
            System.err.println(x.getMessage());}

    }

    public void BuscaProductos(String tipo){
        try{
            int i=0;
            do{
                if(tipo.equalsIgnoreCase("plato")&&vent.get(i).getClaProdu().equals("102p")){
                    System.out.println(vent.get(i));
                }
                else if(tipo.equalsIgnoreCase("Taza")&&vent.get(i).getClaProdu().equals("103t")){
                    System.out.println(vent.get(i));
                }
                i++;
            }while(i<vent.size());
        }catch(NullPointerException m){
            System.err.println(m.getMessage());
        }
    }

    public void VentasXVendedor(String idVendedor){
        try{

            for(Venta recibo:vent){
                if(recibo.GetclaveVend().equalsIgnoreCase(idVendedor)){
                    System.out.println(recibo);
                }
            }
        }catch(NullPointerException m){
            System.err.println(m.getMessage());
        }
    }

    public void MuetraVentas(Scanner xd,Operador ja){
        int op;
        boolean salir=false;
        String aux;
        try{
            while(!salir){
                System.out.println("1 :Ventas por dia");
                System.out.println("2 :Ventas por cliente");
                System.out.println("3 :Ventas por vendedor");
                System.out.println("4 :Ventas por producto");
                System.out.println("5 :Salir");
                op=xd.nextInt();
                switch(op){
                    case 1:
                    ja.muetra("Ejemplo 2020-06-13");
                    aux=ja.leerString("Introduzca la fecha a buscar");
                    BuscaFechaPordia(aux);
                    break;
                    case 2:
                    aux= ja.leerString("Introduzca Numero de cliente");
                    VentasXcliente(aux);
                    case 3:
                    aux= ja.leerString("Introduza numero de vendedor");
                    VentasXVendedor(aux);
                    break;
                    case 4:
                    aux=ja.leerString("Busca venta Plato o Taza");
                    BuscaProductos(aux);
                    break;
                    case 5:
                    salir=true;
                    break;
                    default:
                    System.out.println("Observe el menu");
                }
            }
        }catch(InputMismatchException | NumberFormatException e){
            System.out.println("Debes insertar un número");
            xd.next();
        }
    }
}

