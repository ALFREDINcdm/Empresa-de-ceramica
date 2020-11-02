import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
public class Personas 
{
    ArrayList<Persona> clientes = new ArrayList();
    Persistence <Persona> people = new Persistence ();

    public void AgregaCliente(String nombre,String numerocliente){
        try{
            clientes.add(new Cliente(nombre,numerocliente));
        }catch(NullPointerException e){
            System.out.println(e.getMessage());
        }
    }
 

    public void agregarGerente(String nombre,String identificacion){
        try{
            clientes.add(new Gerente(nombre,identificacion));
        }catch(NullPointerException e){
            System.out.println(e.getMessage());
        }
    }

    public Persona Gerente(){
        for(Persona pe:clientes){
            if(pe instanceof Gerente){
                return pe;
            }
        }
        return null;
    }

    public void ComprarInsumos(Inventario_insumos d,Operador ja,Compras f){
        try{
            Gerente se=(Gerente)Gerente();
            String aux,aux1,aux2; double can;
            aux = ja.ObtenFecha();
            can=Double.parseDouble(ja.leerString("Introduza la cantidad a comprar"));
            aux1=ja.leerString("Introduzaca la clave de provedor");
            ja.muetra("Debera elegir solo la clave delante del producto");
            aux2=ja.leerString("Esmalte:456e, Arcilla:456a, Pintura:456p");
            Compra cdd=new Compra(aux,can,aux1,aux2);
           if( f.addcomp(cdd)){
            ja.muetra("Compra gurdada");
            }

            if(se.Compra(d,cdd)== true){
                ja.muetra("Operacion hecha y registrada");
            }
            else{
                ja.muetra("Verifica tus datos");
            }
        }catch(NullPointerException rd){
            System.out.println(rd);
        }

    }

    public void GuardaPersonas(){
        people.GuardaObjetos("Persistence/personas.obj",clientes);
    }

    public void Recuperaclientes(){
        clientes = people.RecuperaObjetos("Persistence/personas.obj");
    } 

    public void muetraclientes(){ 
        try{
            for(Persona pe:clientes){
                if(pe instanceof Cliente){
                    Cliente d=(Cliente)pe;
                    System.out.println("Nombre: "+d.nombre+" numero de cliente: "+d.getncliente());
                    System.out.println("-------------------------------");
                }
                else{ System.out.println("Sin clientes");
                }
            }
        }catch(ArrayIndexOutOfBoundsException s){
            System.err.println(s.getMessage());
        }
    }

    public boolean EliniaCliente(String nombre){
        try{
            for(Persona pe:clientes){
                if(nombre.equalsIgnoreCase(pe.nombre)){
                    clientes.remove(pe);
                    System.out.println("Eliminado");
                    return true;
                }
            }
        }catch(NullPointerException s){
            System.err.println(s.getMessage());
        }
        return false;
    }

    public void BuscaCliente(String nombre){
        try{
            for(Persona pe:clientes){
                if(nombre.equalsIgnoreCase(pe.nombre)){
                    System.out.print(pe);
                    return;
                }
            }
        }catch(NullPointerException s){
            System.err.println(s.getMessage());
        }
    }

    public void MenuClientes(Scanner xd,Operador ja){
        int op;
        boolean salir = false;
        String aux;
        String name;
        while(!salir){
            System.out.println("1 :Agregar nuvo Cliente");
            System.out.println("2 :Ver Clientes");
            System.out.println("3 :Busca a Cliente");
            System.out.println("4 :Elimina cliente");
            System.out.println("5 :Regresar");
            try{
                op=xd.nextInt();
                switch(op){
                    case 1:
                    name=ja.leerString("Introduce su nombre porfavor");
                    aux=ja.leerString("Introduzca su numero de cliente");
                    AgregaCliente(name, aux);
                    ja.muetra("Nuevo cliente");
                    break;
                    case 2:
                    muetraclientes();
                    break;
                    case 3:
                    name =ja.leerString("Ingre el nombre del cliente");
                    BuscaCliente(name);
                    break;
                    case 4:
                    name=ja.leerString("Ingrese el nombre del cliente a eliminar");
                    if(EliniaCliente(name)){
                        ja.muetra("Eliminado");
                    }
                    else{ja.muetra("Sin concidencias");
                    }
                    break;
                    case 5:
                    salir=true;
                    default:
                    System.out.println("Observe el menu");
                }
            }catch(InputMismatchException  e){
                System.out.println("Debes insertar un número");
                xd.next();
            }

        }
    }
}
