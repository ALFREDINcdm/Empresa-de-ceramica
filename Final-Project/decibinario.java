import java.util.Scanner;
import java.util.InputMismatchException;

class decibinario {
    public static void main(String[] args){
        Scanner tastiera = new Scanner(System.in);
        System.out.println("Inserte un numero entero: ");
        int numeroIntero = tastiera.nextInt();
        
        String binarioCodiceInvertito = ""; 
        String binarioParziale =" ";
        
        if (numeroIntero == 0) {
            System.out.print("Il tuo numero in codice binario sara': ");
            System.out.println(numeroIntero);
        }
        
        else {
            while (numeroIntero>0) {
            int resto = numeroIntero%2;
            if (resto == 0) {
                if (numeroIntero > 1) {
                    binarioParziale = "0";
                    binarioCodiceInvertito += binarioParziale;
                }
                else {
                    binarioParziale = "1";
                    binarioCodiceInvertito += binarioParziale;
                }
            }
            else if (resto == 1) {
                binarioParziale = "1";
                binarioCodiceInvertito += binarioParziale;
            }
            numeroIntero = numeroIntero/2;
        }
        
        String CodiceBinario = ""; 
        
        for (int lunghezzaStringaInvertita = binarioCodiceInvertito.length()-1; 
            lunghezzaStringaInvertita > -1; lunghezzaStringaInvertita--) {
               CodiceBinario += (binarioCodiceInvertito.charAt(lunghezzaStringaInvertita));
        }
        
        System.out.print("Il tuo numero in codice binario sara': ");
        System.out.println(CodiceBinario);
        }
    }
}