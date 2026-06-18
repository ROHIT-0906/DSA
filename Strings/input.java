public class input {

    // public static void isPalindrom( String str){
    //     int n = str.length();
    //     for(int i=0; i<n/2; i++){
    //         if(str.charAt(i) == str.charAt(n-i-1)){
    //             System.out.println("This name "+ str +" is palindrom");
    //         }else{
    //             System.out.println("This name "+ str +" isn't a palindrom");

    //         }
    //     }
    // }

    // public static float getShortestPath(String str){
    //     int x=0,y=0;
    //     for(int i=0;i<str.length();i++){
    //         char dir = str.charAt(i);
    //         if(dir == 'S'){
    //             y--;
    //         }else if(dir == 'N'){
    //             y++;
    //         }else if(dir == 'W'){
    //             x--;
    //         }else{
    //             x++;
    //         }
    //     }
    //     int X2 = x*x;
    //     int Y2= y*y;
    //     return (float)Math.sqrt(X2 + Y2);
    // }

    // public static String toUpperCase(String str){
    //     StringBuilder sb = new StringBuilder("");
    //     char ch = Character.toUpperCase(str.charAt(0));
    //     sb.append(ch);
    //     for(int i=1; i<str.length(); i++){
    //         if(str.charAt(i) == ' ' && i<str.length()-1){
    //             sb.append(str.charAt(i));
    //             i++;
    //             sb.append(Character.toUpperCase(str.charAt(i)));
    //         }else{
    //             sb.append(str.charAt(i));
    //         }
    //     }

    //     return sb.toString();

    // }

    public static String compress(String str){
        StringBuilder sb = new StringBuilder("");
        for(int i=0; i<str.length();i++){
            Integer count = 1;
            while(i<str.length()-1 && str.charAt(i)==str.charAt(i+1)){
                
                count++;
                i++;
            }
            sb.append(str.charAt(i));
            if(count>1){
                sb.append(count.toString());
            }
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // String name;
        // name = sc.next();
        // System.out.println(name);
        // String str = "rohit";
        // isPalindrom(str);
        // String str = "WNEENESENNN";
        // String str = "hi, i am rohit";
        String str = "aabcd";
        System.out.println(compress(str));
        
        // System.out.println(toUpperCase(str));
        // System.out.println(getShortestPath(str));
    }
}
