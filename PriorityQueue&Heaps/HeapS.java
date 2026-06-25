
public class HeapS {

    public static void heapify(int i,int n, int[] arr){
        int left = 2*i + 1;
        int right = 2*i + 2;
        int maxIdx = i;

        if(left < n && arr[maxIdx] > arr[left] ){
            maxIdx = left;
        }
        if(right < n && arr[maxIdx] > arr[right] ){
            maxIdx = right;
        }

        if(maxIdx != i){
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;

            heapify(maxIdx, n, arr);
        }

    }

    public static  void heapSort(int[] arr){
        int n = arr.length;
        //step1 - build MaxHeap
    for(int i=n/2; i>=0; i--){
        heapify(i,n,arr);
    }
    
    //step2 - push largest at the end
    for(int i=n-1; i>0; i--){
        int temp = arr[0];
        arr[0] = arr[i];
        arr[i] = temp;

        heapify(0, i, arr);
    }
    }


    public static void main(String[] args) {
        int arr[] = {1,2,4,5,3};
        heapSort(arr);

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    
}
