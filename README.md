# BubbleSort-ShellSort
排序总结

一、冒泡排序

时间复杂度：O(n^2)
思路在生活中并不常用
对比：选择排序；插入排序

1.基本思想，每次比较相邻元素
第i轮开始，arr[n-i,n)已排好序
第i轮：通过冒泡在arr[n-i-1]位置放上合适的元素
第i轮结束：arr[n-i-1,n)已排好序

2.冒泡排序的实现

 public static<E extends Comparable<E>>void sort(E[] data){
        
        for(int i=0;i+1<data.length;i++){
            //arr[n-i,n)已排好序
            //通过冒泡排序arr[n-i-1]位置上放上合适的元素
            for(int j=0;j<data.length-i-1;j++)
                if(data[j].compareTo(data[j+1])>0)
                    swap(data,j,j+1);
        }
    }

3.优化

完全有序的数组是时间复杂度是O(n)

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

4.进一步优化

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

5.换一种方式实现冒泡排序

每次找出最小元素

二、希尔排序

1.基本思想：让数组越来越有序
   基本原理：对元素间距为n/2的所有数组做插入排序
                    对元素间距为n/4的所有数组做插入排序
                    ......
                    对元素间距为1的所有数组做插入排序

2.实现希尔排序

 public static <E extends Comparable<E>>void sort(E [] data){
        
        int h=data.length/2;
        while(h>=1){
            
            for(int start=0;start<h;start++){
                //对data[start,start+h,start+2h,start+3h...],进行插入排序
                for(int i=start+h;i<data.length;i+=h){
                    E t=data[i];
                    int j;
                    for(j=i;j-h>=0&&t.compareTo(data[j-h])<0;j-=h)
                        data[j]=data[j-h];
                    data[j]=t;
                }
            } 
            h/=2; 
        }
        
    }

3.希尔排序的性能
时间复杂度O(n^2)

4.换个方式实现希尔排序

public static <E extends Comparable<E>>void sort2(E [] data){
        
        int h=data.length/2;
        while(h>=1){
                //对data[h,n),进行插入排序
                for(int i=h;i<data.length;i++){
                    E t=data[i];
                    int j;
                    for(j=i;j-h>=0&&t.compareTo(data[j-h])<0;j-=h)
                        data[j]=data[j-h];
                    data[j]=t;
                }
            
            h/=2; 
        }   
    }

5.步长序列

 public static <E extends Comparable<E>>void sort3(E [] data){
        
        int h=1;
        while(h<data.length) h=h*3+1;
        //1,4,13,40....
        while(h>=1){
                //对data[h,n),进行插入排序
                for(int i=h;i<data.length;i++){
                    E t=data[i];
                    int j;
                    for(j=i;j-h>=0&&t.compareTo(data[j-h])<0;j-=h)
                        data[j]=data[j-h];
                    data[j]=t;
                }
            
            h/=3; 
        }   
    }

三、基于比较的排序算法总结
                时间       空间     特殊数据
选择排序  O(n^2)  O(1)    
插入排序  O(n^2)  O(1)    完全有序数组，时间O(n)
冒泡排序  O(n^2)  O(1)    完全有序数组，时间O(n)
归并排序  O(nlogn)   O(n) 完全有序数组，时间O(n) 自顶向下的归并排序算法 自底向上的归并排序算法
快速排序  O(nlogn)* O(1)  含有相同元素数组，三路快排时间 O(n)  单路 双路 三路排序
堆排序      O(nlogn)  O(1)
希尔排序  O(nlogn)-O(n^2)  O(1)不同的步长序列 

排序的稳定性：排序前相等的两个元素，排序后相对位置不变
选择排序是不稳定的
插入排序法是稳定的
希尔排序是不稳定的
冒泡排序是稳定的
堆排序是不稳定的
归并是有序的
快速排序不稳定
