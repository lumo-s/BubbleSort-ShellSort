/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.bubblesort;
import java.util.Arrays;

/**
 *
 * @author 86139
 */
public class BubbleSort {
    
    private BubbleSort(){}
    
    public static<E extends Comparable<E>>void sort(E[] data){
        
        for(int i=0;i+1<data.length;i++){
            //arr[n-i,n)已排好序
            //通过冒泡排序arr[n-i-1]位置上放上合适的元素
            for(int j=0;j<data.length-i-1;j++)
                if(data[j].compareTo(data[j+1])>0)
                    swap(data,j,j+1);
        }
    }
    
    public static<E extends Comparable<E>>void sort2(E[] data){
        
        for(int i=0;i+1<data.length;i++){
            //arr[n-i,n)已排好序
            //通过冒泡排序arr[n-i-1]位置上放上合适的元素
            boolean isSwapped=false;
            for(int j=0;j<data.length-i-1;j++)
                if(data[j].compareTo(data[j+1])>0){
                    swap(data,j,j+1);
                    isSwapped=true;
                }
            if(!isSwapped) break;
        }
    }
    
    public static<E extends Comparable<E>>void sort3(E[] data){
        
        for(int i=0;i+1<data.length;){
            //arr[n-i,n)已排好序
            //通过冒泡排序arr[n-i-1]位置上放上合适的元素
            int lastSwappedIndex=0;
            for(int j=0;j<data.length-i-1;j++)
                if(data[j].compareTo(data[j+1])>0){
                    swap(data,j,j+1);
                    lastSwappedIndex=j+1;
                }
            //if(lastSwappedIndex==0) break;
            i=data.length-lastSwappedIndex;
        }
    }
    
    private static <E>void swap(E[] arr,int i,int j){
        E t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }

    public static void main(String[] args) {
       int n=100000;
       
       Integer[]arr=ArrayGenerator.generateRandomArray(n,n);
       Integer[]arr2=Arrays.copyOf(arr,arr.length);
       Integer[]arr3=Arrays.copyOf(arr,arr.length);
       
       System.out.println("Random Array");
       SortingHelper.sortTest("BubbleSort",arr);
       SortingHelper.sortTest("BubbleSort2",arr2);
       SortingHelper.sortTest("BubbleSort3",arr3);
       
       System.out.println();
       
       arr=ArrayGenerator.generateOrderArray(n);
       arr2=Arrays.copyOf(arr,arr.length);
       arr3=Arrays.copyOf(arr,arr.length);
       
       System.out.println("Ordered Array");
       SortingHelper.sortTest("BubbleSort",arr);
       SortingHelper.sortTest("BubbleSort2",arr2);
       SortingHelper.sortTest("BubbleSort3",arr3);
    }
}
