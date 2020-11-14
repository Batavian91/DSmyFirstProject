import java.util.Scanner;

public class DNAPalindrome
{
    public String getUserInput(Scanner input)
    {
        System.out.print("Enter DNA string of characters:  ");
        return input.nextLine();
    }

    /**
     * This method is used by method isValidDNA
     * It checks if a given char belongs to the DNA charset
     * @param c character of a String
     * */
    private boolean isDNALetter(char c) { return (c=='A') || (c=='T')  || (c=='C') || (c=='G'); }

    /**
     * @return false if a given String does not contain strictly
     * A, C, G, T characters, which comprise the valid DNA charset.
     * Special occasion of an empty String is also acceptable.
     * */
    public boolean isValidDNA(String s)
    {
        try
        {
            if (!s.equals("")) // special case of empty string is valid
            {
                // return false if you get characters out of the valid DNA charset (A, T, C, G)
                for (int i=0; i<s.length(); i++)
                    if (!(isDNALetter(s.charAt(i))))
                        return false;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return true;
    }

    private char getComplement(char c)
    {
        if (c=='A')
            return 'T';
        else if (c=='T')
            return 'A';
        else if (c=='C')
            return 'G';
        else
            return 'C';
    }

    public boolean isWatsonCrick(String DNA)
    {
        if (DNA.equals("")) // the empty string is Watson-Crick complemented palindrome
            return true;

        if (DNA.length()%2==0) // odd length strings cannot be Watson-Crick complemented palindrome
        {
            StringDoubleEndedQueueImpl<Character> DNAQueue = new StringDoubleEndedQueueImpl<>();
            for (int i=0; i<DNA.length(); i++)
            {
                DNAQueue.addLast(DNA.charAt(i)); // create a queue that contains the DNA characters
            }

            while (!(DNAQueue.isEmpty()))
            {
                if (!(DNAQueue.getFirst() == getComplement(DNAQueue.getLast())))
                    return false;
                DNAQueue.removeFirst();
                DNAQueue.removeLast();
            }

            return true;
        }

        return false;
    }

    public static void main(String[] args)
    {
        DNAPalindrome p = new DNAPalindrome();
        Scanner input = new Scanner(System.in);
        String userInput = p.getUserInput(input);
        while (!(p.isValidDNA(userInput)))
        {
            System.out.println("\nInvalid input! DNA charset contains only (A, C, G, T) or the empty string!" +
                               "\nLowercase letters are also excluded! Please, try again!\n");
            userInput = p.getUserInput(input);
        }

        if (p.isWatsonCrick(userInput))
            System.out.println("Yes, " + userInput + " is Watson-Crick complemented palindrome!");
        else
            System.out.println("No, " + userInput + " is not Watson-Crick complemented palindrome!");
    }
}