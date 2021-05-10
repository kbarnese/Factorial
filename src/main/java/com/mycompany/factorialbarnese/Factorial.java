/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.factorialbarnese;

import java.math.BigInteger;

/**
 *
 * @author k_bar
 */
public class Factorial {

    
    public Factorial(){}

    /*
    It was the second fastest algorithm and it also grew O(n). 
    */
    public static long  factorialFor(long  n){
        long product = 1;
        for(long  i = 1; i <= n; i++){
            product *= i;
        }
        return product;
    }
    
    
    /*
    It was the fastest algorithm. It grew O(n). Although it ran into a 
    Stack Overflow error in finding factorial of 20480 or larger. 
    */
    public static long factorialRec1(long n){
        try
        {if (n == 1L)
            return 1L;
        else
        return n * factorialRec1(n-1L);
        }
        
        catch(Exception e){e.getMessage();}
        return 0;
    }
    
    /*
    The algorithm was the slowest, but it did grow at O(n). 
    The algorithm was about 4 times slower than the for loop. 
    */
    public static long factorialRec2(long n1, long n2){
        if (n1 == 1L)
            return 1L;
        else if ((n1 - n2) == 1L)
            return n1;
        else
        return factorialRec2(n1, n1-((n1-n2)/2L)) * factorialRec2(n1-((n1-n2)/2L), n2); 
    }
    
}
