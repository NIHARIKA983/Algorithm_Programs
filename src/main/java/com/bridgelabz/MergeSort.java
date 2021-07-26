package com.bridgelabz;

public class MergeSort {
    public void  merge(int arr[],int lo, int mid , int hi)
    {
        //Find sizes of two subarrays to be merged
        int n1 = mid - lo + 1;
        int n2 = hi - mid;
        //Create temp arrays
        int LO[] = new int[n1];
        int HI[] = new int[n2];

        //Copy data to temp arrays
        for(int i=0;i<n1;i++)
            LO[i]=arr[lo+i];
        for(int j=0;j<n2;j++)
            HI[j] = arr[mid+1+j];//Merge the temp arrays
        //Initial indexes of first and second subarrays
        int i=0,j=0;

        //Initial index of merged subarray
        int k=lo;
        while(i < n1 && j < n2){
            if(LO[i] <= HI[j]){
                arr[k] =LO[i];
                i++;
            }
            else{
                arr[k] = HI[j];
                j++;
            }
            k++;
        }
        //copy remaining elements of L[] if any
        while (i<n1){
            arr[k]=LO[i];
            i++;
            k++;
        }
        //Copy remaining elements of R[] if any
        while(j<n2){
            arr[k] = HI[j];
            j++;
            k++;
        }
    }
    //merge()
    public void sort(int arr[],int lo,int hi)
    {
        if(lo<hi){
            //Find the middle poin
            int mid=lo+(hi-lo)/2;
            //sort first and second halves
            sort(arr,lo,mid);
            sort(arr,mid+1,hi);

            //Merge the sorted halves
            merge(arr,lo,mid,hi);
        }
    }
    //Print array of size n
    public static void printArray(int arr[])
    {
        int n= arr.length;
        for (int i=0;i<n;++i)
            System.out.println(arr[i] + " ");
        System.out.println();
    }
    public static void main(String args[])
    {
        int arr[]={12,11,13,5,6,7};
        System.out.println("Given Array");
        printArray(arr);

        MergeSort ob = new MergeSort();
        ob.sort(arr,0,arr.length - 1);

        System.out.println("\nSorted array");
        printArray(arr);
    }
}
