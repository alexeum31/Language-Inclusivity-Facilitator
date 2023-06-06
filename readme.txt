## **Racist Terminology Remover**
This was my final project for "Introduction to Computer Science" (COS 126) at Princeton University.
## **Purpose**
This project is intended to aid in the removal of potentially problematic subtleties that are common throughout everyday conversation. The user is prompted by a Guided User Interface (GUI) upon running the code to input text, sentence by sentence, in order to determine its validity. A valid sentence is considered to end with a period, and there must be spaces in between each word. The program then creates a HashMap object, "dictionary", that serves to act as a list of problematic terms, potential replacements, and the reason for the term being flagged. Then, the program checks the user's input sentence String, word by word, against each of the words in the dictionary HashMap, and provides suggestions on how the user could make adjustments their writing.

