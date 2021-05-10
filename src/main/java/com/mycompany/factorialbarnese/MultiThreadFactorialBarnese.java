/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.factorialbarnese;

import java.util.concurrent.RecursiveTask;

/**
 *
 * @author k_bar
 */
public class MultiThreadFactorialBarnese extends RecursiveTask<Long> {
    
    final long n1;
    final long n2;
            
    public MultiThreadFactorialBarnese(long n1, long n2){
    this.n1 = n1;
    this.n2 = n2;
    }
    
    
    @Override
    protected Long compute(){
    long num = n1 - n2;
    
    if (n1 == 1L)
        return 1L;
    else if (num <= 250L)
        return helper(n1,n2);

    else{
            MultiThreadFactorialBarnese mtfb1 = new MultiThreadFactorialBarnese(n1, n1-((n1-n2)/2L));
            mtfb1.fork();
            MultiThreadFactorialBarnese mtfb2 = new MultiThreadFactorialBarnese(n1-((n1-n2)/2L), n2);

            return  mtfb2.compute() * mtfb1.join();
        }
    }
    
    private long helper(long finish, long start){
    long num = 1;
        for( long i = start + 1; i <= finish; i++)
        num = num * i; 
        
    return num;
    
}
}
    

