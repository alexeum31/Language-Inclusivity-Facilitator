import java.util.HashMap;
import java.util.Scanner;
import java.io.File;


public class stringModifier { 
    public static void main(String[] args) {
    // Initializes Scanner and HashMap objects.
    Scanner scanned = new Scanner("list.txt");
    HashMap<String, String[]> dictionary = new HashMap<String, String[]>();

    while (scanned.hasNextLine()) {
        // Adds each term in the list to a new HashMap dictionary entry.
        String term  = scanned.nextLine();
        String replacement = scanned.nextLine();
        String reasoning = scanned.nextLine();

        // Creates and initializes an array of length 2 for each term.
        int ARRAY_LENGTH = 2;
        String[] corrected = new String[ARRAY_LENGTH]; 
        corrected[0] = replacement;
        corrected[1] = reasoning;

        // Adds items.
        dictionary.put(term, corrected);

        // Reads in blank line between each term.
        scanned.nextLine();
    }
    scanned.close();
    
    // TEST - PRINTS HashMap values.
    // error
    dictionary.forEach((key, value) -> {
        String[] array = dictionary.get(key);
        System.out.println(key);
        System.out.println(array[0]);
        System.out.println(array[1]);
    });
    

}
}