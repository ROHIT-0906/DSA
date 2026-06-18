
import java.util.Stack;



public class SimplerPath {
    
    public static String simplifyPath(String str){
        Stack<String> s = new Stack<>();

        String[] components = str.split("/");

        for(String directory : components){
            if(directory.isEmpty() || directory.equals(".")){
                continue;
            }

            if(directory.equals("..")){
                if(!s.isEmpty()){
                     s.pop();
                }
            }else{
                s.push(directory);
            }
        }

        StringBuilder simplifiedPath = new StringBuilder();

        for(String dir : s){
            simplifiedPath.append("/").append(dir);
        }
        return simplifiedPath.length() > 0 ? simplifiedPath.toString() : "/";
    }

    public static void main(String[] args) {
        String str = "/rohit//";

        System.out.println(simplifyPath(str));
    }
}
