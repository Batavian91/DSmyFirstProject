import java.util.Scanner;

public class PostfixToInfix
{

    public String getUserInput(Scanner input)
    {
        System.out.print("Enter expression in postfix notation:  ");
        return input.nextLine();
    }

    private boolean isOperator(char c)
    {
        return c=='+' || c=='-' || c=='*'|| c=='/';
    }

    public boolean isValidExpression(String s)
    {
        try
        {
            //minimum number of characters must be 3
            if (s.length()<3)
                return false;

            // string's first two characters must be digits and last character must be valid operator
            if (!(Character.isDigit(s.charAt(0))
                    && Character.isDigit(s.charAt(1))
                    && isOperator(s.charAt(s.length()-1))))
                return false;

            int operands = 2, operators = 0;

            // check the rest of the string and count operands and operators
            for (int i = 2; i < s.length(); i++) // i=2 since we know the first 2 characters are digits
            {
                if (Character.isDigit(s.charAt(i)))
                    operands++;
                else if (isOperator(s.charAt(i)))
                    operators++;
                else
                    return false;
            }

            // if operands == n, then operators == n-1
            if (operands != operators + 1)
                return false;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return true;
    }

    public String getInfix(String postfix)
    {
        StringDoubleEndedQueueImpl<String> queue = new StringDoubleEndedQueueImpl<>();

        // use the queue to build the required string
        for (int i=0; i<postfix.length(); i++)
        {
            if (Character.isDigit(postfix.charAt(i)))
                queue.addLast(postfix.charAt(i) + "");
            else
            {
                String s1 = queue.removeLast();
                String s2 = queue.removeLast();
                queue.addLast("(" + s2 + postfix.charAt(i) + s1 + ")");
            }
        }

        return queue.getFirst();
    };

    public static void main(String[] args)
    {
        PostfixToInfix postToInf = new PostfixToInfix();
        Scanner fromTerminal = new Scanner(System.in);
        String postfix = postToInf.getUserInput(fromTerminal);

        while (!postToInf.isValidExpression(postfix))
        {
            System.out.println("\nInvalid input! Postfix notation contains at least three characters,\n" +
                               "starts with two digits and ends with an operator ( +,-,*,/ ). Also,\n" +
                               "keep in mind that digits equal operators plus 1! Please, try again!\n");
            postfix = postToInf.getUserInput(fromTerminal);
        }

        String infix = postToInf.getInfix(postfix);
        System.out.println(infix);
    }

}