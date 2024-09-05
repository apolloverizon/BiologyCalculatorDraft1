import java.util.Scanner;
/**
 * The user is prompted to enter the characters of a DNA strand.
 * A scanner takes in the input and in a while loop we validate the input.
 * The String's length must be divisible by 3, otherwise the user is prompted to try again.
 * The programme then displays:
 * - m-RNA to the Strand
 * - Protein
 * - duplicated DNA (DNAHelix)
 * Helpful Information:
 * A = 65; T = 84; G = 71; C = 67; U = 85
 */
public class Main {
    /**
     * Default constructor for the Main class.
     */
    public Main(){}


    /**
     * The method is used to run the program.
     * @param args is the user input. In this case it is supposed to model a DNA strand.
     */
    public static void main(String[] args) {
        boolean validInput = false;
        String welcomeMessage =
                "Welcome to the Genetics Calculator\n" +
                "This application allows you to decode a DNA strand to its protein form.\n" +
                "Please enter the bases in your DNA strand:\n";
        System.out.println(welcomeMessage);

        // Repeats until a valid input has been entered
        while (!validInput){
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();

            validInput = validate(input);

        }
        System.out.println("You entered a valid input. Good job!");
    }

    /**
     * The method accepts lower case characters too but turns them into upper case ones during the validation.
     * Criteria:
     * - divisible by 3
     * - all bases are found in  {65, 67, 71, 84}
     * @param dnaStrand each char of the dnaStrand stands for a base
     * @return true if all the criteria are meth
     */
    private static boolean validate(String dnaStrand){
        dnaStrand = dnaStrand.toUpperCase();
        if(dnaStrand.length() % 3 != 0) {
            String errorMessage =
                    "The length of the entered chain of bases is invalid!\n" +
                    "Please keep in mind that a valid DNA strand is divisible by 3!\n" +
                    "Furthermore, the only valid base characters are {65, 67, 71, 84}.\n" +
                    "Explanation:\n" +
                    "During the transcription process a m-RNA strand is created based on the DNA strand\n" +
                    "This m-RNA is composed of codons. Each codon is composed of nucleotides with a bases from this list {A, U, G, C}\n" +
                    "In short, a codon can be simplified as a combination of three such base characters.\n" +
                    "These combinations encode the amino acid that they are meant to synthesize.\n" +
                    "So, you see, if your input is not divisible by 3, a valid protein can not be generated.\n" +
                    "Try and reenter your DNA strand:\n";
            System.out.println(errorMessage);
            return false;
        } else if (!validateBases(dnaStrand)) {
            String errorMessage =
                    "One or more bases in the DNA strand are invalid!\n" +
                    "Please keep in mind that only the following base characters are allowed {65, 67, 71, 84}" +
                    "Try and reenter your DNA strand:\n";
            System.out.println(errorMessage);
            return false;
        } else {
            return true; //TODO is there any other case where the user might break the program, do I really not need exceptions
        }
    }


    /**
     * @param dnaStrand each char of the dnaStrand stands for a base
     * @return true if each char is in {65, 67, 71, 84}
     */
    private static boolean validateBases(String dnaStrand){
        for(int i = 0; i < dnaStrand.length(); i++){
            char base = dnaStrand.charAt(i);    //TODO if it's broke, cast it to int
            if(base != 65 && base != 67 && base != 71 && base != 84) return false;
        }
        return true;
    }

}