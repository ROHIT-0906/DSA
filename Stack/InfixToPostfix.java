import java.util.Stack;
public class InfixToPostfix{

    private static int getPrecedence(char operator){
        switch (operator) {
            case '+':
            case '-':
            return 1;
            case '*':
            case '/':
            return 2;
            case '^':
            return 3; 
            default: 
            return -1;
        }
    }

    public static String convert(String str){
        StringBuilder result = new StringBuilder();
        Stack<Character> s = new Stack<>();

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                result.append(ch);
            }else if(ch =='('){
                s.push(ch);
            }else if(ch == ')'){
                while(!s.isEmpty() && ch != '('){
                    result.append(s.pop());
                }
                if(!s.isEmpty() && ch == '('){
                    s.pop();
                }
            }else{
                while (!s.isEmpty() && s.peek() != '(') {
                char topChar = s.peek();
                int topCharPrecedence = getPrecedence(topChar);
                int currentCharPrec = getPrecedence(ch);
                if( topCharPrecedence > currentCharPrec || topCharPrecedence == currentCharPrec && ch != '^' ){
                    result.append(s.pop());
                }else{
                    break;
                }
            }
                s.push(ch);
            }
        }

        while(!s.isEmpty()){
            result.append(s.pop());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String str = "a+b*c^^bd";
        System.out.println(convert(str));
    }
}