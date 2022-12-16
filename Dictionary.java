import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Dictionary {
    public static HashMap<String, String[]> returnHash(String filename) throws FileNotFoundException{
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
            // Finds all instances of spaces or periods and considers the preceding text a word.
            if (sentence.contains(" ")) {
                int space = sentence.indexOf(" ");
                word = sentence.substring(0, space).toLowerCase();
                sentence = sentence.substring(space + 1, sentence.length());
            } else {
                int period = sentence.indexOf(".");
                word = sentence.substring(0, period).toLowerCase();
                sentence = "";
            }
            // If the word is problematic, offer a suggestion on how it can be modified.
            if (dictionary.containsKey(word)) {
                String[] replacements = dictionary.get(word);
                suggestions.append("Consider using ").append(replacements[0]).append(" instead of ");
                suggestions.append(word).append("\n").append("Reason: ").append(replacements[1]).append("\n");

            }
        }
        if (suggestions.toString().equals("")) return "Everything is safe! \n";
        else return suggestions.toString();
    }

    public static void main(String[] args) throws FileNotFoundException{
        // TEST - prints HashMap values using returnHash method.
        // TEST 1- tests returnHash. Command line argument should be list.txt.
        // Expected output- same words and sequence as the list.txt file
        String file = args[0];
        HashMap<String, String[]> theDictionary = returnHash(file);
        theDictionary.forEach((flaggedWord, definitions) -> {
            String[] array = theDictionary.get(flaggedWord);
            System.out.println(flaggedWord);
            System.out.println(array[0]);
            System.out.println(array[1]);
        });

        // TEST - checks that compareTo returns a corrected sentence.
        // TEST 2.1 - tests sentence with flagged word in the middle of the sentence (not capitalized)
        // Expected output - "Consider using troublemaker instead of thug
        // Reason: The term is used to label gang members as violent and a threat to society. Often, the term is solely
        // based on one's appearance rather than actions that have racial undertones."
        String testSentence1 = "I saw a thug today.";
        String replacements1 = checkProblematic(testSentence1, theDictionary);
        System.out.println(replacements1);

        // TEST 2.2 - tests sentence with flagged word in the middle of the sentence (not capitalized) and beginning of
        // the sentence (capitalized).
        // Expected output - "Consider using expert instead of guru
        // Reason: In certain religions, the term represents respect. The casual use and integration of the term into
        // English negates that effect."
        String testSentence2 = "Guru.";
        String replacements2 = checkProblematic(testSentence2, theDictionary);
        System.out.println(replacements2);

        // TEST 2.3 - no problematic words (only a true expression of gratitude)
        // Expected output - "Everything is Safe!"
        String testSentence3 = "Thank you Pedro for all your hardwork and quick replies we love you a ton have a " +
                "great break.";
        String replacements3 = checkProblematic(testSentence3, theDictionary);
        System.out.println(replacements3);

        // TEST 2.4 - problematic words in both beginning and end.
        // Expected output - "Consider using enslaved people instead of slaves
        //Reason: First-person language is becoming increasingly popular in disability studies because it offers the
        // disabled person agency. While "slave" is a dehumanizing term, "enslaved person" avoids that issue and gives
        // the person agency.
        //Consider using gathering instead of picnic
        //Reason: The origin of the term comes from the phrase "Pick a N*****", where individuals pick a Black person to
        // lynch to jumpstart a family gathering. Although the term "picnic" is embedded into American culture, it is
        // super easy to replace it with the word "gathering" to have the same meaning."
        String testSentence4 = "Slaves were a root component of the American Civil War and they had a picnic.";
        String replacements4 = checkProblematic(testSentence4, theDictionary);
        System.out.println(replacements4);

        // TEST 2.5 - no problematic words (only a true expression of gratitude)
        // Expected output - "Everything is Safe!"
        String testSentence5 = ".";
        String replacements5 = checkProblematic(testSentence5, theDictionary);
        System.out.println(replacements5);
    }
}
