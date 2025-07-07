package maquinadeturing;

import java.util.Scanner;

public class pruebas {    

    public static String Direccion(char[] aCadena){
        
        StringBuilder resultado = new StringBuilder();
        char aux = ' ';
        char inicio = 'i';
        char fin = 'f';
        
        boolean primerCambio = true;

        if(aCadena[0] == ' '){
            for (int i = 1; i < aCadena.length - 1; i++) {
                String direccion = "Derecha";
                if (primerCambio) {
                    resultado.append("\n|1|").append(aCadena[i]).append("|").append(aCadena[i] == '1' ? '0' : '1').append("|").append(direccion).append("|2|");
                    aCadena[i] = aCadena[i] == '1' ? '0' : '1';
                    primerCambio = false;
                    continue;
                }
                if(aCadena[i] == '1'){
                    aux = aCadena[i];
                    aCadena[i] = '0';
                    resultado.append("\n|2|").append(aux).append("|").append(aCadena[i]).append("|").append(direccion).append("|2|");
                } else if(aCadena[i] == '0'){
                    aux = aCadena[i];
                    aCadena[i] = '1';
                    resultado.append("\n|2|").append(aux).append("|").append(aCadena[i]).append("|").append(direccion).append("|2|");
                } else {
                    aux = aCadena[i];    
                    aCadena[i] = 'B';
                    resultado.append("\n|1|").append(aux).append("|").append(aCadena[i]).append("|").append(direccion).append("|2|");
                }
            }    
        } else {
            aCadena[0] = inicio;
            aCadena[aCadena.length-1] = fin;
            
            for (int i = aCadena.length - 2; i > 0; i--) {
                String direccion = "Izquierda";
                
                if (primerCambio) {
                    resultado.append("\n|1|").append(aCadena[i]).append("|").append(aCadena[i] == '1' ? '1' : '0').append("|").append(direccion).append("|2|");
                    aCadena[i] = aCadena[i];
                    primerCambio = false;
                    continue;
                }
                if(aCadena[i] == '1'){
                    aux = aCadena[i];
                    aCadena[i] = '1';
                    resultado.append("\n|3|").append(aux).append("|").append(aCadena[i]).append("|").append(direccion).append("|3|");
                } else if(aCadena[i] == '0'){
                    aux = aCadena[i];
                    aCadena[i] = '0';
                    resultado.append("\n|3|").append(aux).append("|").append(aCadena[i]).append("|").append(direccion).append("|3|");
                } else {
                    if(aCadena[i] == 'f'){
                        aux = aCadena[i];
                        aCadena[i] = ' ';
                        resultado.append("\n|2|").append(aux).append("|").append(aCadena[i]).append("|").append(direccion).append("|3|");
                    } else {
                        direccion = "Derecha";
                        aux = aCadena[i];
                        aCadena[i] = ' ';
                        resultado.append("\n|3|").append(aux).append("|").append(aCadena[i]).append("|").append(direccion).append("|4|");
                    }
                }
            }    
        }
        
        return resultado.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la cadena a revisar (0,1): ");
        String cadena = sc.next();
        
        if (!cadena.matches("[01]+")) {
            System.out.println("Entrada no válida. Por favor, ingrese solo 0s y 1s.");
            return;
        }
         
        char blanco = ' ';
        
        cadena = blanco + cadena + blanco;
        char[] aCadena = cadena.toCharArray();
        
        System.out.println("|I|E|S|Direccion|F|");
        String resultado = Direccion(aCadena);
        System.out.println(resultado);
        
        String resultadof = Direccion(aCadena);
        System.out.println(resultadof);
        
        cadena = new String(aCadena);
        System.out.println("Cadena resultante: " + cadena);
    }
}
