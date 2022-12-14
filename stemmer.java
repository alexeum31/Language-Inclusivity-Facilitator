import java.util.Scanner;
import edu.stanford.nlp.process.Stemmer;

public class stemmer {
  public static void main(String[] args) {
    // create a new Stemmer object
    Stemmer stemmer = new Stemmer();

    // create a new Scanner object to read from standard input
    Scanner scanner = new Scanner(System.in);

    // prompt the user to enter a word
    System.out.print("Enter a word: ");

    // read the word from standard input
    String word = scanner.nextLine();

    // stem the word using the stemmer
    String stemmedWord = stemmer.stem(word);

    // print the stemmed word
    System.out.println("Stemmed word: " + stemmedWord);
  }
}
