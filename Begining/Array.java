

public class Array {

    // public static void update(int marks[]){
    //     for(int i=0; i<marks.length; i++){
    //         marks[i] = marks[i] + 1;

    //     }
    // }

    // public static int linearSearch(int numbers[], int key){
    //     for(int i =0; i<numbers.length; i++){
    //         if(numbers[i] == key){
    //            return i;
    //         }
    //     }
    //     return -1;
    // }

    // public static int menuSearch(String[] Menu, String key){
    //     for(int i = 0; i<Menu.length; i++){
    //         if(Menu[i].equals(key)){
    //              return i;
    //         }
           
    //     }
    //     return -1;
    // }

    // public static int largestValue(int value[]){
    //     int largest=Integer.MIN_VALUE;
    //     int smallest = Integer.MAX_VALUE;
    //     for(int i =0; i<value.length; i++){
    //         if(value[i] > largest){
    //             largest = value[i];
    //         }
    //         if(value[i]<smallest){
    //             smallest = value[i];
    //         }
    //     }
    //     System.out.println("Smallest value is "+smallest);
    //     return largest;
    // }

    // public static int binarySearch(int numbers[], int key){
    //     int start =0;
    //     int end = numbers.length-1;

    //     while (start <= end) { 
    //         int mid = (start + end )/2;
    //         if(numbers[mid] == key){
    //             return mid;
    //         }
    //         if(numbers[mid] < key){
    //             start = mid+1;
    //         }else{
    //             end = mid-1;
    //         }
    //     }
    //     return -1;
    // }

    // public static void reverse(int[] numbers) {
    //     int first = 0;
    //     int last = numbers.length-1;
    //     while (first < last) { 
    //        int temp = numbers[last];
    //        numbers[last] = numbers[first];
    //        numbers[first] = temp;

    //        first++;
    //        last--;
    //     }

    // }


    // public static void pairs(int numbers[]){
    //     for(int i = 0; i<numbers.length; i++){
    //         int curr = numbers[i];
    //         for(int j=i+1; j<numbers.length; j++){
    //             System.out.print("("+curr+","+numbers[j]+")");
    //         }
    //         System.out.println();
    //     }
    // }


    // public static void printSubArrays(int numbers[]){
    //   int curr = 0;
    //   int maxSum = Integer.MIN_VALUE;
    //   int prefix[] = new int[numbers.length];
    //   prefix[0] = numbers[0];

    //   for(int i = 1; i<prefix.length;i++){
    //     prefix[i] = prefix[i-1] + numbers[i];
    //   }

    //     for(int i = 0; i<numbers.length; i++){
    //         int start = i;
    //         for(int j = i; j<numbers.length; j++){
    //             int end = j;
    //               curr = start == 0 ? prefix[end] : prefix[end] - prefix[start-1]; 
    //             if(maxSum < curr){
    //               maxSum = curr;
    //             }
    //         }
          
    //     }
    //     System.out.println(maxSum);
    // }


    public static void kadanes(int numbers[]){
      int cs = 0;
      int ms = Integer.MIN_VALUE;
      for(int i=0; i<numbers.length;i++){
        cs += numbers[i];
        if(cs < 0){
          cs =0;
        }
        ms = Math.max(cs , ms);
      }
      System.out.println("Max sum is "+ms);
    }

    public static void main(String[] args) {
        // int marks[] = new int[100];
        // Scanner sc = new Scanner(System.in);

        // marks[0] = sc.nextInt();
        // marks[1] = sc.nextInt();
        // marks[2] = sc.nextInt();
         
        // System.out.println("phy : "+marks[0]);
        // System.out.println("chem : "+marks[1]);
        // System.out.println("maths : "+marks[2]);

    //      int marks[] = {97,95,96};
    //      update(marks);
    //      System.out.println(marks.length);

    //      for(int i=0; i<marks.length; i++){
    //         System.out.print(marks[i]+" ");
    //      }
    //      System.out.println();


    int numbers[] = {2,34,56,78,90,123,234};
    kadanes(numbers);
    
    // String[] Menu = {"Samosa", "Masala Dosa", "Poha", "Dhokla"};

    // String key = "Samosa";
    // // int index = linearSearch(numbers, key);
    // int index = menuSearch(Menu, key);
    // if(index == -1){
    //     System.out.println("NOT FOUND");
    // }else{
    //     System.out.println("Key is at index "+index);
    // }

    // int value[] = {12,3,4,6,7};
    // int largestValue =largestValue(value);
    // System.out.println("Largest value is: "+largestValue);

    // int key = 78;

    // int index = binarySearch(numbers, key);
    // System.out.println("Index number is "+index);
    // reverse(numbers);
    // for(int i= 0; i<numbers.length; i++){
    //     System.out.print(" "+numbers[i]);
    // }
    // pairs(numbers);
    }
    
}
