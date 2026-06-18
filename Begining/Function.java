import java.util.Scanner;

public class Function {
    public static void printHelloWorld(){
        System.out.println("Hello World");
    };
    // public static int product(int a, int b){
    //     int product = a*b;
    //     return product;
    // }
    public static int factorial(int n){
        int f = 1;
        for(int i=1; i<=n; i++){
             f = f*i;
        }
        return f;
    }


   
    public static void main(String[] args) {
    //    int a = 3;
    //    int b = 5;
    //    int product = product(a, b);
    //    System.out.println("Sum = "+ product);
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int fact = factorial(n);
    System.out.println("fact = "+fact);
    }
}
