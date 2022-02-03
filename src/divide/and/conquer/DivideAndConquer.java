
package divide.and.conquer;
import java.util.Arrays;
public class DivideAndConquer {

    
    public static void main(String[] args) {
        int [] arr = {3,2,8,7,5};
        int [] aux = Arrays.copyOf(arr,arr.length);
        System.out.println("the inversion here count is " + mergesort(arr,aux,
                0,arr.length -1));
        
    }
    

public static int merge(int[] arr,int[] aux,int low,int mid,int high){
    int k = low,i=low,j=mid+1;
    int inversioncount=0;
    while(i<=mid&&j<=high)
    {
        if (arr[i] <= arr[j]) {
            aux[k++] = arr[i++];
        }
        else{
            aux[k++] = arr[j++];
            inversioncount += (mid - i + 1);
        }
    }
    while (i<=mid){
        aux[k++]=arr[i++];
    }
    for (int l = low; l < high; l++) {
        arr[l]=aux[l];
    }
    return inversioncount;
}
public static int mergesort(int [] arr, int[] aux , int low , int high){
    if (high == low) {
        return 0;
    }
    int mid = (low + ((high - low)>> 1)) ;
    int inversioncount =0;
    inversioncount += mergesort(arr,aux,low, mid);
    
    inversioncount += mergesort(arr, aux ,mid+1,high);
    
    inversioncount += merge(arr,aux,low,mid,high);
    
    return inversioncount;
    }
}