import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Proveedores 
{
    ArrayList<Provedor> prov = new ArrayList();
    Persistence <Provedor> traba = new <Trabajador> Persistence (); 
    public void GuardaProvedor(){
        traba.GuardaObjetos("Persistence/provedores.obj",prov);
    }

    public void Recuperaprovedor(){
        prov = traba.RecuperaObjetos("Persistence/provedores.obj");
    } 

    public boolean AgregaProvedor(String tipo,String nombre,String dato,String clave){
        try{
            if(tipo.equalsIgnoreCase("persona")){
                prov.add(new Proveedor_per (nombre,dato,clave));
                return true;
            }
            else if(tipo.equalsIgnoreCase("Empresa")){
                prov.add(new Proveedor_empre (nombre,dato,clave));
                return true;

            }
            else{
                System.out.println("Solo es posible si introduce persona o empresa");
                return true;
            }
        }catch(NullPointerException v){
            System.out.println(v.getMessage());
        }
        return false;
    }

    public void Muetraprove(){
        try{
            for(Provedor xd: prov){
                System.out.println(xd);
                System.out.println("-------------------------------");

            }
        }catch(ArrayIndexOutOfBoundsException a){
            System.err.println("Se produjo una excepcion: "+a);
        }
    }

    public Provedor RegresaProve(String PersonaoEmpresa){
        try{
            int i=0; ;
            do{
                if(PersonaoEmpresa.equalsIgnoreCase("Persona")&& prov.get(i) instanceof Proveedor_per){
                    return prov.get(i);
                }
                else 
                    return prov.get(i);
            }while(i<prov.size());
        }catch(NullPointerException z){
            System.err.print(z.getMessage());
        }
        return null;
    }

    public boolean Elimina(String nombre){
        try{
            for(Provedor xd: prov){
                if(xd.nombre.equalsIgnoreCase(nombre)){
                    prov.remove(xd);
                    System.out.println("Sigue asi champion");
                    return true;
                }
            }
        }catch(NullPointerException v){
            System.out.println(v.getMessage());
        }
        return false;
    }

    public void Busca(String nombre){
        try{
            for(int i=0;i<prov.size();i++){
                if(prov.get(i).nombre.equalsIgnoreCase(nombre)){
                    System.out.println(prov.get(i)+ " se encuentra en la posicion: "+i);

                }
            }}catch(NullPointerException v){
            System.out.println(v.getMessage());
        }
    }

    public void muetramenuprovedores(Scanner xd,Operador ja){
        int op;
        boolean salir= false;
        String aux, aux2;
        String name;
        while(!salir){
            System.out.println("1 :Agregar nuvo Proveedor");
            System.out.println("2 :Ver Proveedores");
            System.out.println("3 :Eliminar proveedor");
            System.out.println("4 :Busca a proveedor");
            System.out.println("5 :Regresar");
            try{
                op=xd.nextInt();
                switch(op){
                    case 1:
                    System.out.println("Agrega tipo:Persona o empresa);");
                    aux = ja.leerString("Persona o empresa");
                    name= ja.leerString("Ingrese el nombre de la empresa");
                    String dato = ja.leerString("Introduzca curp si es persona o id del abogado");
                    aux2=ja.leerString("Introduce la clave del Provedor");
                    if( AgregaProvedor(aux, name, dato,aux2)){
                        ja.muetra("Nuevo Proveedor");}
                    else ja.muetra("Error");
                    break;
                    case 2:
                    Muetraprove();
                    break;
                    case 3:
                    name= ja.leerString("Introduce el nombre del proveedor a eliminar");
                    if(Elimina(name)){
                        ja.muetra("Proveedor eliminado");}
                    else ja.muetra("No existe");
                    break;
                    case 4: 
                    name=ja.leerString("Ingrese su nombre");
                    Busca(name);
                    break;
                    case 5:
                    salir = true;
                    default:
                    System.out.println("Observe el menu");
                }
            }
            catch(InputMismatchException e){
                System.out.println("Debes insertar un número");
                xd.next();
            }
        }
    }
}

