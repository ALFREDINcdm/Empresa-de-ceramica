import java.util.ArrayList;
import java.util.Scanner;

import java.util.InputMismatchException;

public class Compras
{
    ArrayList <Compra> comprs = new ArrayList ();
    Persistence <Compra> dico = new <Compra> Persistence (); 
    public boolean addcomp(Compra c){  
        try{
            comprs.add(c); 
            return true;
        }catch(NullPointerException z){
            System.err.println(z.getMessage());
        }
        return false; 
    }

    public void ComprarPordia(String fecha){
        try{
            for(Compra ceo:comprs){
                if(ceo.getFecha().equalsIgnoreCase(fecha)){
                    System.out.println(ceo);
                }
            }
        }catch(NullPointerException s){
            System.err.print(s.getMessage());

        }
    }

    public void ComprasporProvedor(String IDPROVEDOR){
        try{
            for(Compra ceo:comprs){
                if(ceo.getClaveprove().equalsIgnoreCase(IDPROVEDOR)){
                    System.out.println(ceo);
                }
            }
        }catch(NullPointerException s){
            System.err.print(s.getMessage());
        }
    }

    public void BuscaCompraxInsumo(String claveInsumo){
        try{
            for(Compra ceo:comprs){
                if(ceo.getInsucv().equalsIgnoreCase(claveInsumo)){
                    System.out.println(ceo);
                }
            }
        }
        catch(NullPointerException s){
            System.err.print(s.getMessage());
        }

    }

    public void GuardaCompras(){
        dico.GuardaObjetos("Persistence/compras.obj",comprs);
    }

    public void Recupecompras(){
        comprs = dico.RecuperaObjetos("Persistence/compras.obj");
    }

    public void muestramenucompras(Scanner xd,Operador ja){
        int op;
        boolean salir=false;
        String aux;
        try{
            while(!salir){
                System.out.println("1 :Compras por dia");
                System.out.println("2 :Compras por Provedor");
                System.out.println("3 :Compras por Producto");
                System.out.println("4 :Salir");
                op=xd.nextInt();
                switch(op){
                    case 1:
                    ja.muetra("Ejemplo 2020-06-13");
                    aux= ja.leerString("Introduzca la fecha a buscar");
                    ComprarPordia(aux);
                    break;
                    case 2:
                    aux= ja.leerString("Introduza numero de Provedor");
                    ComprasporProvedor(aux);
                    break;
                    case 3:
                    ja.muetra("Esmalte:456e\nPintura:456p\nArcilla:456a");
                    aux= ja.leerString("Introduza numero de Insumo");
                    BuscaCompraxInsumo(aux);
                    break;
                    case 4:
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
