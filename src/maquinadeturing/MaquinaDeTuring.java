/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maquinadeturing;

import java.util.Scanner;

/**
 *
 * @author jddca
 */

public class MaquinaDeTuring {    
    
    public static String Direccion(char[] aCadena, String cadena){
        
        String direccion = "";
        cadena = "";
        char aux = ' ';
        String a = "";
        //char inicio = '\u25AF';
        //char fin = '\u25A2';
        
        if(aCadena[0] == ' '){
            
            boolean primerapasada = true;
            
            
        for (int i = 0; i < aCadena.length; i++) {
                direccion = "Derecha";
                switch(aCadena[i]){
                    case '1':
                        
                        if(primerapasada == false){
                            
                        aux = aCadena[i];
                        aCadena[i] = '0';
                        a = a+ "\n|              1 |    "+aux+"    |   "+aCadena[i]+"    |  "+direccion+"  |            2 |";
                        
                        primerapasada = true;
                        
                        }else{
                            
                        aux = aCadena[i];
                        aCadena[i] = '0';
                        a = a+ "\n|              2 |    "+aux+"    |   "+aCadena[i]+"    |  "+direccion+"  |            2 |";
                        
                        }
                        
                       
                        break;
                        
                    case '0':
                        
                        if(primerapasada == false){
                            
                        aux = aCadena[i];
                        aCadena[i] = '1';
                        a = a+ "\n|              1 |    "+aux+"    |   "+aCadena[i]+"    |  "+direccion+"  |            2 |";   
                            
                        primerapasada = true;
                        }else{
                            
                        aux = aCadena[i];
                        aCadena[i] = '1';
                        a = a+ "\n|              2 |    "+aux+"    |   "+aCadena[i]+"    |  "+direccion+"  |            2 |";
                            
                        }
                        
                        
                        
                        break;
                        
                    case ' ':
                        
                        if(primerapasada == true){
                            primerapasada = false;
                            aCadena[i] = 'B';
                            break;
                            
                        }else{
                            aux = aCadena[i];    
                            aCadena[i] = 'B';
                            a = a + "\n|             2 |    "+aux+"    |   "+aCadena[i]+"    |  "+direccion+"  |            3 |";
                        }
                        
                        break;
                        
                        
                    default:
                        
                        System.out.println("ERROR");
                        System.exit(0);
                        break;
                }
            }    
        }else{
            
            boolean segundapasada = true;
            
            aCadena[0] = '\u25A1';
            aCadena[aCadena.length-1] = '\u25A1';
            direccion = "Izquierda";
      
            for (int i = aCadena.length-1; i>=0 ; i--) {
                
                switch(aCadena[i]){
                    
                    case '0':
                        
                        if(segundapasada == false){
                            
                        aux = aCadena[i];
                        aCadena[i] = '0';
                        a = a+ "\n|              3 |    "+aux+"    |   "+aCadena[i]+"    | "+direccion+" |            3 |";   
                            
                        //segundapasada = true;
                        }else{
                            
                        aux = aCadena[i];
                        aCadena[i] = '0';
                        a = a+ "\n|              3 |    "+aux+"    |   "+aCadena[i]+"    | "+direccion+" |            3 |";
                            
                        }
                        
                        break;
                    case '1':
                        
                        if(segundapasada == false){
                            
                        aux = aCadena[i];
                        aCadena[i] = '1';
                        a = a+ "\n|              3 |    "+aux+"    |   "+aCadena[i]+"    | "+direccion+" |            3 |";
                        
                        //segundapasada = true;
                        
                        }else{
                            
                        aux = aCadena[i];
                        aCadena[i] = '1';
                        a = a+ "\n|             3 |    "+aux+"    |   "+aCadena[i]+"    | "+direccion+" |            3 |";
                        
                        }
                        
                        break;
                    case '\u25A1':
                        
                        if(segundapasada == true){
                            
                            segundapasada = false;
                            aux = aCadena[i];
                            aCadena[i] = '\u25A1';
                            a = a+"\n|              2 |    "+aux+"    |   "+aCadena[i]+"   | "+direccion+" |            3 |";
                            
                        }else{
                            
                            direccion = "Derecha";
                            aux = aCadena[i];
                            aCadena[i] = '\u25A1';
                            a = a+"\n|              3 |    "+aux+"    |   "+aCadena[i]+"   |  "+direccion+"  |            4 |";
                            
                        }
                        
                        break;
                    default:
                        
                        System.out.println("ERROR");
                        System.exit(0);
                        
                        break;
                    
                }
                
            }
            
            
        }
        
        
        return a;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la cadena a revisar (0,1): ");
        String cadena = sc.next();
        
         if (!cadena.matches("[01]+")) {
            System.out.println("Entrada no válida. Por favor, ingrese solo 0s y 1s.");
            return;
        }
         
        char blanco = ' ';
        
        cadena = blanco +cadena+ blanco;
        char [] aCadena;
        aCadena = cadena.toCharArray();
        //System.out.println(cadena);
        System.out.println("| Estado Inicial | Entrada | Salida | Direccion | Estado Final |");
        String ri = Direccion(aCadena, cadena).substring(1);
        System.out.println(ri);
        String rf = Direccion(aCadena, cadena);
        System.out.println(rf);
        
        cadena = new String(aCadena);
        System.out.println("Cadena resultante: "+cadena.substring(1, aCadena.length-1));
        
        
        }

    }    