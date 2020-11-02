import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Trabajadores
{
    ArrayList<Trabajador> trabajadores = new ArrayList();
    Persistence <Trabajador> traba = new <Trabajador> Persistence (); 

    public void GuardaTraba(){
        traba.GuardaObjetos("Persistence/trabajadores.obj",trabajadores);
    }

    public Vendedor busca(){
        try{
            for(Trabajador t : trabajadores){
                if(t instanceof Vendedor){
                    Vendedor c= (Vendedor)t; 
                    return c;
                }
            }
        }catch(NullPointerException e){
            System.err.println(e.getMessage());
        }
        System.err.println("No se encuentra ningun Vendedor deberia contratar uno ");
        return null;
    }


    public void RecuperaTrabajador(){
        trabajadores = traba.RecuperaObjetos("Persistence/trabajadores.obj");
    }

    public void Muestratrabajadores(){
        try{
            for(Trabajador t : trabajadores){
                System.out.println("Nombre: "+t.nombre+"\nHorario: "+t.horario+"\nSalario: "+t.salario);
                System.out.println("-------------------------------");
            }
        }catch(ArrayIndexOutOfBoundsException  a){
            System.err.println("Se produjo una excepcion: "+a);  
        }
    }

    public void AgregatipoTrabajador(String tipo,String nombre,Operador ja){
        try{
            if(tipo.equalsIgnoreCase("Estudiante")){
                trabajadores.add(new Alfarero (nombre));
            }
            else if(tipo.equalsIgnoreCase("Alfarero")){
                trabajadores.add(new Alfarero (nombre,800));
            }
            else if(tipo.equalsIgnoreCase("Esmaltador")){
                trabajadores.add(new Esmaltador (nombre));
            }
            else if(tipo.equalsIgnoreCase("Horneador")){
                trabajadores.add(new Horneador (nombre));
            }
            else if(tipo.equalsIgnoreCase("Repartidor")){
                trabajadores.add(new Repartidor (nombre,"cv54"));
            }
            else if(tipo.equalsIgnoreCase("Vendedor")){
                String c= ja.leerString("Introduce la clave de vendedor");
                trabajadores.add(new Vendedor (nombre,c));
            }
        }catch(NullPointerException e){
            System.err.println(e.getMessage());

        }
    }

    public void BucarTrabajador(String nombre){
        try{
            for(int i=0;i<trabajadores.size();i++){
                if(nombre.equalsIgnoreCase(trabajadores.get(i).nombre)){
                    System.out.println(nombre+" se encuentra en la posicion: "+i);
                    return;
                }
            }
        }catch(NullPointerException a){
            System.err.println("Se produjo una excepcion: "+a);
        }
    }

    public void EliminaTrabajador(int indice){
        try{
            trabajadores.remove(indice);
        }catch(ArrayIndexOutOfBoundsException | NullPointerException z){}
    }

    public void MustraMenuTrabajo(Scanner xd,Operador ja){
        int op;
        boolean salir = false;
        String aux;
        String name;
        while(!salir){
            System.out.println("1 :Agregar nuvo trabajador");
            System.out.println("2 :Ver trabajadores");
            System.out.println("3 :Eliminar trabajador");
            System.out.println("4 :Busca a trabajador");
            System.out.println("5 :Regresar");
            try{
                op=xd.nextInt();

                switch(op){
                    case 1:

                    System.out.println("Agrega tipo: Estudiante,Alfarero,Esmaltador,Horneador, vendedor y repartidor);");
                    aux=ja.leerString("Introduce tipo");
                    name=ja.leerString("Itroduce su nombre");
                    AgregatipoTrabajador(aux,name,ja);
                    break;
                    case 2:
                    Muestratrabajadores();
                    break;
                    case 3:
                    System.out.println("Itroduce el indice");
                    EliminaTrabajador(xd.nextInt());
                    break;
                    case 4:
                    name=ja.leerString("Itroduce el nombre que busca");
                    BucarTrabajador(name);
                    break;
                    case 5:
                    salir = true;
                    break;
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
