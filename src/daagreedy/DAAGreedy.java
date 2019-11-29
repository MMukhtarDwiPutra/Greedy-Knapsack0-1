/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daagreedy;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class DAAGreedy {
    
    public static void sort(double[] arr1, int[] arr2, int[] arr3){
        int temp;
        double temp2;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 1; j < arr1.length-1; j++) {
                if(arr1[j-1] > arr1[j]){
                        temp2 = arr1[j-1];  
                        arr1[j-1] = arr1[j];  
                        arr1[j] = temp2;
                        
                        temp = arr2[j-1];  
                        arr2[j-1] = arr2[j];  
                        arr2[j] = temp;
                        
                        temp = arr3[j-1];  
                        arr3[j-1] = arr3[j];  
                        arr3[j] = temp;
                }  
            }
        }
    }
    
    public static void sort(int[] arr1, int[] arr2, double[] arr3){
        int temp;
        double temp2;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 1; j < arr1.length-1; j++) {
                if(arr1[j-1] > arr1[j]){
                        temp = arr1[j-1];  
                        arr1[j-1] = arr1[j];  
                        arr1[j] = temp;
                        
                        temp = arr2[j-1];  
                        arr2[j-1] = arr2[j];  
                        arr2[j] = temp;
                        
                        temp2 = arr3[j-1];  
                        arr3[j-1] = arr3[j];  
                        arr3[j] = temp2;
                }  
            }
        }
    }
    
    public static int greedyByProfit(int[] p, int[] w, int n, int k){
        int isi = 0, temp = 0, i = n-1;
        while(isi < k && i >= 0){
            if(w[i] <= (k-isi)){
                temp = temp + p[i];
                isi = isi + w[i];
            }
            i--;
        }
        System.out.println("Total bobot : "+isi);
        return temp;
    }
    
    public static int greedyByWeight(int[] w, int[] p, int n, int k){
        int isi = 0, temp = 0, i = 0;
        while(isi < k && i < n){
            if(w[i] <= (k-isi)){
                temp = temp + p[i];
                isi = isi + w[i];
            }
            i++;
        }
        System.out.println("Total bobot : "+isi);
        return temp;
    }
    
    public static double greedyByDensity(double[] d, int[] w, int p[], int n, int k){
        int isi = 0, temp = 0, i = n-1;
        while(isi < k && i >= 0){
            if(w[i] <= (k-isi)){
                temp = temp + p[i];
                isi = isi + w[i];
            }
            i--;
        }
        System.out.println("Total bobot : "+isi);
        return temp;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukan kapasitas knapsack : ");
        int k = sc.nextInt();
        System.out.print("Masukan jumlah objek : ");
        int n = sc.nextInt();
        int temp;
        int[] w = new int[n+1];
        int[] p = new int[n+1];
        
        System.out.println("Masukan berat : ");
        for (int i = 0; i < n; i++) {
            System.out.print((i+1)+" : ");
            temp = sc.nextInt();
            w[i] = temp;
        }
        System.out.println("=================");
        System.out.println("Masukan profit : ");
        for (int i = 0; i < n; i++) {
            System.out.print((i+1)+" : ");
            temp = sc.nextInt();
            p[i] = temp;
        }
        double[] d = new double[n+1];
        for (int i = 0; i < n; i++) {
            d[i] = p[i]/w[i];
        }
        
        System.out.println("No || Profit || Berat || Density");
        for(int i = 0; i < n; i++) {
            System.out.println((i+1)+"  ||  "+p[i]+"     ||  "+w[i]+"    ||    "+d[i]);
        }
        
        sort(p,w,d);
        int profit = greedyByProfit(p,w,n,k);
        System.out.println("Greedy by profit : "+profit);
        sort(w,p,d);
        int weight= greedyByWeight(w,p,n,k);
        System.out.println("Greedy by weight : "+weight);
        sort(d,w,p);
        double density = greedyByDensity(d,w,p,n,k);
        System.out.println("Greedy by density : "+density);
    }
}
