import javax.swing.JOptionPane;
import java.util.Scanner;
import java.text.*;
import java.util.Date;

public class Operador
{
    public static String leerString(String cad) {
        return JOptionPane.showInputDialog(cad);
    }

    public void muetra(String cadena){
        JOptionPane.showMessageDialog(null, cadena);

    }

    public static String ObtenFecha(){
        String fechas = "yyyy-MM-dd";
        SimpleDateFormat formato = new SimpleDateFormat(fechas);
        Date date = new Date();
        String fecha = formato.format(date); 
        return fecha;  
    }

    public static SimpleDateFormat Prueba(){
        String fecha = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(fecha);
         return simpleDateFormat;
    }

    public void muestienda(){
    }

    public static Scanner re(){
        Scanner in=new Scanner(System.in);
        return in;
    }
}
