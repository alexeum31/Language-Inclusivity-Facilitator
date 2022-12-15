import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class stringModifier {
    public static HashMap<String, String[]> returnHash(String filename) throws FileNotFoundException {
        // Initializes Scanner and HashMap objects.
        File file = new File(filename);
        Scanner scanned = new Scanner(file);
        HashMap<String, String[]> dictionary = new HashMap<>();
        while (scanned.hasNextLine()) {
            // Adds each term in the list to a new HashMap dictionary entry.
            String term = scanned.nextLine();
            String replacement = scanned.nextLine();
            String reasoning = scanned.nextLine();

            // Creates and initializes an array of length 2 for each term.
            int ARRAY_LENGTH = 2;
            String[] corrected = new String[ARRAY_LENGTH];
            corrected[0] = replacement;
            corrected[1] = reasoning;

            // Adds items.
            dictionary.put(term, corrected);
        }
        scanned.close();
        return dictionary;
    }

    public static String checkProblematic(String sentence, HashMap<String, String[]> dictionary) {
        StringBuilder suggestions = new StringBuilder();
        String original = sentence;
        while (!(sentence.equals(""))) {
            String word;
            // Finds all instances of spaces and considers them words.
            if (sentence.contains(" ")) {
                int space = sentence.indexOf(" ");
                word = sentence.substring(0, space);
                sentence = sentence.substring(space + 1, sentence.length());
            }
            else {
                int period = sentence.indexOf(".");
                word = sentence.substring(0,period);
                sentence = "";
            }
            // If the word is problematic, offer a suggestion on how it can be modified.
            if (dictionary.containsKey(word.toLowerCase())) {
                String[] replacements = dictionary.get(word);
                suggestions.append("Consider using ").append(replacements[0]).append(" instead of ");
                suggestions.append(word).append("\n").append("Reason: ").append(replacements[1]).append("\n");
            }
        }
        if (suggestions.toString().equals(original)) return "Everything is safe!";
        else return suggestions.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        // TEST - prints HashMap values using returnHash method.
        HashMap<String, String[]> dictionary1 = returnHash("list.txt");
//        dictionary1.forEach((flaggedWord, definitions) -> {
//            String[] array = dictionary1.get(flaggedWord);
//            System.out.println(flaggedWord);
//            System.out.println(array[0]);
//            System.out.println(array[1]);
//        });

        // TEST - checks that compareTo returns a corrected sentence.
        String testSentence = "I saw a thug today.";
        String replacements = checkProblematic(testSentence, dictionary1);
        System.out.println(replacements);
    }
}
