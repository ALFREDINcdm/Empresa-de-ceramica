import java.util.Scanner;
import java.util.InputMismatchException;

public class menu
{
    public static void main (String args []) {
        Scanner in=new Scanner(System.in);
        Operador ja = new Operador(); 

        Trabajadores nene = new Trabajadores();
        Personas people = new Personas();
        Proveedores pro = new Proveedores();
        Inventario_Productos ducto = new Inventario_Productos();
        Total_ventas ventas = new Total_ventas();
        Compras com = new Compras();
        Inventario_insumos insi = new Inventario_insumos();
        Compras compa = new Compras();
        Total_ventas venta = new Total_ventas();

        com.Recupecompras();
        ventas.RecuperaVentas();
        nene.RecuperaTrabajador();
        people.Recuperaclientes(); 
        pro.Recuperaprovedor();
        ducto.RecuperaInventario();
        insi.RecuperaInsumos();
        compa.Recupecompras();
        venta.RecuperaVentas();

        int op;
        boolean sal= false;
        String axu1 ,aux2,aux3; int aux;
        while(!sal){
            System.out.println("1 :Muestra menu trabajadores");
            System.out.println("2 :Muestra menu de clientes");
            System.out.println("3 :Muetra menu de Proveedores");
            System.out.println("4 :Muetra menu de Productos");
            System.out.println("5 :Realiza Venta");
            System.out.println("6 :Realiza Compra de insumo");
            System.out.println("7 :Muestras menu de ventas");
            System.out.println("8 :Muestras menu de Compras");
            System.out.println("9 :Muestra inventario de insumos");
            System.out.println("10 :Cerrar el programa");

            try{
                op=in.nextInt();
                switch(op){
                    case 1:
                    nene.MustraMenuTrabajo(in,ja);
                    break;
                    case 2:
                    people.MenuClientes(in,ja);
                    break;
                    case 3:
                    pro.muetramenuprovedores(in, ja);
                    break;
                    case 4:
                    ducto.muestramenu(in, ja);
                    break;
                    case 5:
                    try{
                        Vendedor x= nene.busca(); 
                        aux = Integer.parseInt(Operador.leerString("Introtuzca la cantidad a vender"));
                        axu1=Operador.leerString("Introduzca el numero de cliente");
                        aux2= Operador.leerString("Taza: 103t o Plato: 102p");
                        aux3 = ja.ObtenFecha();
                        Venta d = new Venta(aux3,aux,axu1,aux2);
                        d.SetClaveven(x.Getclave());
                        if(x.VendeProducto(ducto, d)){
                            ventas.Agregaven(d);
                            ja.muetra("Venta hecha");
                        }
                        else{ja.muetra("Error verifique los datos");}
                    }catch(Exception e){}
                    break;
                    case 6:
                    people.ComprarInsumos(insi, ja, com);
                    break;
                    case 7:
                    venta.MuetraVentas(in,ja);
                    break;
                    case 8:
                    compa.muestramenucompras(in, ja);
                    break;
                    case 9:
                    insi.muestrasInsumos();
                    break;
                    case 10:
                    sal = true;
                    ja.muetra("Programa cerrado");
                    ja.muetra("Acciones respaldadas");
                    default:
                }
            }catch(InputMismatchException e){
                System.out.println("Debes insertar un número");
                in.next();
            }

        }
        nene.GuardaTraba();
        people.GuardaPersonas();
        pro.GuardaProvedor();
        insi.GuardaInsumos();
        ducto.Guaraproductos();
        ventas.GuardaVentas();
        compa.GuardaCompras();
        ventas.GuardaVentas();
    }
}
