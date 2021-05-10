/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.factorialbarnese;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author k_bar
 */
public class FactorialTest {
    
    public FactorialTest() {
    }

   

    /**
     * Test of factorialFor method, of class Factorial.
     */
    //@org.junit.Test
    public void testFactorialFor() {
        
       
        assertEquals(120L, Factorial.factorialFor(5));
        

    }
    
        /**
     * Test of factorialRec2 method, of class Factorial.
     */
   //@org.junit.Test
    public void testFactorialRec2() {
       
        
        
        
        assertEquals(120L, Factorial.factorialRec2(5,1));
        
    }
    
            /**
     * Test of factorialRec1 method, of class Factorial.
     */
    //@org.junit.Test
    public void testFactorialRec1() {
       
       
        assertEquals(120L, Factorial.factorialRec1(5));
        
    }
    
    //@org.junit.Test
    public void testFactorialMultiThread(){
        
        MultiThreadFactorialBarnese mtfb = new MultiThreadFactorialBarnese(10, 1);
        
        
        
        assertEquals(3628800L, (long)mtfb.compute());
        
    }
    
    
    public void TimeTest(int i){
        System.out.println("N = " + i);
        long start_time = 0L, end_time = 0L, f=0L, r1=0L, r2=0L, mt = 0L;
        double difference=0L;
        
        
        
        start_time = System.nanoTime();
        r2 = Factorial.factorialRec2(i,1);
        end_time = System.nanoTime();
        difference = (end_time - start_time) / 1e6;
        System.out.println("Recursion 2 Loop time: " + difference);
        
        start_time = System.nanoTime();
        f = Factorial.factorialFor(i);
        end_time = System.nanoTime();
        difference = (end_time - start_time) / 1e6;
        System.out.println("For Loop time: " + difference);
        
        
        start_time = System.nanoTime();
         MultiThreadFactorialBarnese mtfb = new MultiThreadFactorialBarnese(i, 1);
        mt = mtfb.compute();
        end_time = System.nanoTime();
        difference = (end_time - start_time) / 1e6;
        System.out.println("Multi Thread Loop time: " + difference);
        
        /*start_time = System.nanoTime();
        r1 = Factorial.factorialRec1(i);
        end_time = System.nanoTime();
        difference = (end_time - start_time) / 1e6;
        System.out.println("Recursion 1 Loop time: " + difference);
        */
        
        
        
        

            boolean pass = (f == r1) && (mt == r1);
            System.out.println(pass);
        }
   
    
    @org.junit.Test
    public void MultiTimeTest(){
        
        for(int i = 10; i <= 335544325; i=i*2){
        TimeTest(i);
        System.out.println("--------------------------------");
        
        
    }
    }
                
    
    
}
