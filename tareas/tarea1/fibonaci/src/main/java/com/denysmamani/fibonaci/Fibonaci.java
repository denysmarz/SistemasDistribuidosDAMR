/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.denysmamani.fibonaci;

import java.util.Scanner;

/**
 *
 * @author DENYS XD
 */
public class Fibonaci {

public static void main(String[] args) {
 
          Scanner sc = new Scanner(System.in);
          System.out.print("Introduce N: ");
          int n = sc.nextInt();
          System.out.print(funcionFibonacci(n));                     
     } 

     private static int funcionFibonacci(int num){
          if(num == 0 || num==1)
               return num;
          else
               return funcionFibonacci(num-1) + funcionFibonacci(num-2);
     }
}
