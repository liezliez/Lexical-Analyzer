/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubestba;
import java.util.*;
/**
 *
 * @author acer
 */
public class TubesTBA {

    public static List token = new ArrayList();
    public static String inp;
    public static String inpS;
    private int panjang;
    public static Scanner read = new Scanner(System.in);
    
    public static void menu(String inp){
        System.out.println("Masukan input : ");
        inp = read.nextLine();
        if (inp.isEmpty()){
            System.out.println("Kosong");
            menu(inp);
        }
        Lexing(inp);
    }

    
    public static void Lexing(String inp){
        int i=0;
        int j=0;
        while (i < inp.length()){
            ////SPASI
            if (inp.charAt(i)==' '){
                i++;
            }
            ////TOKEN PQRS
            else if( (inp.charAt(i)=='p') ){
                token.add(1);
                i++;}
            else if( (inp.charAt(i)=='q') ){
                token.add(1);
                i++;}
            else if( (inp.charAt(i)=='r') ){
                token.add(1);
                i++;}
            else if( (inp.charAt(i)=='s') ){
                token.add(1);
                i++;
            ///TOKEN NOT ///   
            } else if(inp.charAt(i)=='n') {
                j=i;
                j++;
                i++;
                try{
                    inp.charAt(j);
                } catch(StringIndexOutOfBoundsException s){
                    token.add("Error");
                    break;
                };
                j++;
                try{
                        inp.charAt(j);
                    } catch(StringIndexOutOfBoundsException s){
                    token.add("Error");
                    break;
                    };
                if(inp.charAt(i)=='o'){
                    i++;
                    if(inp.charAt(i)=='t'){
                        token.add(2);
                        i++;
                    } else {
                        token.add("Error");
                        i=inp.length();
                    }
                } 
            /////AND///             
            } else if(inp.charAt(i)=='a') {
                j=i;
                j++;
                i++;
                try{
                    inp.charAt(j);
                } catch(StringIndexOutOfBoundsException s){
                    token.add("Error");
                    break;
                };
                j++;
                try{
                        inp.charAt(j);
                    } catch(StringIndexOutOfBoundsException s){
                    token.add("Error");
                    break;
                    };
                
                if(inp.charAt(i)=='n'){
                    i++;
                    if(inp.charAt(i)=='d'){
                        token.add(3);
                        i++;
                    } else {
                        token.add("Error");
                        i=inp.length();
                    }
                } else {
                    token.add("Error");
                    i = inp.length();
                }
             
            ///TOKEN OR
            } else if(inp.charAt(i)=='o') {
                j=i;
                j++;
                i++;
                try{
                    inp.charAt(j);
                } catch(StringIndexOutOfBoundsException s){
                    token.add("Error");
                    break;
                };
                j++;
                if(inp.charAt(i)=='r'){
                    token.add(4);
                    i++;
                } else {
                    token.add("error");
                    i = inp.length();
                }
            
            ////TOKEN XOR
            } else if (inp.charAt(i)=='x'){
                j=i;
                j++;
                i++;
                try{
                    inp.charAt(j);
                } catch(StringIndexOutOfBoundsException s){
                    token.add("Error");
                    break;
                };
                j++;
                try{
                        inp.charAt(j);
                    } catch(StringIndexOutOfBoundsException s){
                    token.add("Error");
                    break;
                    };
                
                if (inp.charAt(i)=='o'){
                    i++;
                    if(inp.charAt(i)=='r'){
                        token.add(5);
                        i++;
                    } else {
                        token.add("Error");
                        i = inp.length();
                    }
                }
                else {
                    token.add("error");
                    i = inp.length();
                }
            
            //// TOKEN IFF            
            } else if (inp.charAt(i)=='i'){
                j=i;
                j++;
                i++;
                try {
                    inp.charAt(j);
                }catch(StringIndexOutOfBoundsException s){
                    token.add("Error");
                    break;
                };
                
                if (inp.charAt(i)=='f'){
                    token.add(6);
                    i++;
                    try {
                     inp.charAt(j);
                     }catch (StringIndexOutOfBoundsException s){
                        token.add("Error");
                        break;
                    };
                    if(i<inp.length()&&inp.charAt(i)=='f'){
                        token.remove(token.size()-1);
                        token.add(8);
                        i++;
                    }
                        else {
                        token.add("Error");
                        break;
                    }
                         
                } else {
                    token.add("Error");
                    i = inp.length();
                } 
             
            //TOKEN THEN
            } else if (inp.charAt(i)=='t'){  
            j=i;
            j++;
            i++;
            try {
                inp.charAt(j);
            }   catch(StringIndexOutOfBoundsException s) {
                token.add("Error");
                break;
            }
            j++;
            try{
                inp.charAt(j);
            } catch(StringIndexOutOfBoundsException s){
                token.add("Error");
                break;
            };
            j++;
            try{
                inp.charAt(j);
            } catch(StringIndexOutOfBoundsException s){
                token.add("Error");
                break;
            };
             
                if(inp.charAt(i)=='h'){
                    i++;
                    if(inp.charAt(i)=='e'){
                        i++;
                        if(inp.charAt(i)=='n'){
                            token.add(7);
                            i++;
                        }
                        else {
                            token.add("error");
                            i=inp.length();
                        }
                    }
                    else {
                        token.add("error");
                        i=inp.length();
                    }
                }
                else {
                    token.add("error");
                    i=inp.length();
                }
            }
            //TOKEN '('
            else if(inp.charAt(i)=='('){
                token.add(9);
                i++;
            }
            //TOKEN ')'
            else if(inp.charAt(i)==')'){
                token.add(10);
                i++;
            }
            else {
                token.add("error");
                i=inp.length();
            };
        };
        System.out.println(token);
    }
    public static void main(String[] args) {
        menu(inp);
    }
}
