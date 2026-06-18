
import java.util.Stack;

public class DecodingString {

    public static String decodeString(String str){
        Stack<Integer> stackNumber = new Stack<>();
        Stack<StringBuilder> stackString = new Stack<>();

        StringBuilder currentString = new StringBuilder();
        int currentNumber = 0;
        

        for(char c : str.toCharArray()){
            // if this char is a digit
            if(Character.isDigit(c)){
                currentNumber = currentNumber * 10 + (c -'0');
            }else if(c == '['){
                stackNumber.push(currentNumber);
                stackString.push(currentString);

                currentNumber = 0;
                currentString = new StringBuilder();

            }else if(c == ']'){
                int repeatTimes = stackNumber.pop();
                StringBuilder prevString = stackString.pop();
                
                for(int i=0; i<repeatTimes; i++){
                    prevString.append(currentString);
                }

                currentString = prevString;

            }else{
                currentString.append(c);
            }
        }

        return currentString.toString();

    }

    public static void main(String[] args) {
        String str = "3[b2[v]]";

        System.out.println(decodeString(str));
    }
}
