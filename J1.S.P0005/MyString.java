
import java.util.Hashtable;

/**
 * @author Khang Ta
 */
public class MyString {
    private String s;
    private Hashtable<String, Integer> count = new Hashtable<>();

    /**
     * Constructor
     * 
     * @param s
     */
    public MyString(String s) {
        this.s = s;
    }

    /**
     * Show and count all words in String s
     * 
     * @return all the words
     */
    public String getWords() {
        count.clear();
        String[] words = s.split("[\\W+_]");

        for (int i = 0; i < words.length; i++) {
            String word = words[i].toLowerCase().trim();
          //  if (!word.equals("")) {
                if (!count.containsKey(word)) // If count doesn't have the word, put it in
                    count.put(word, 1);
                else
                    count.replace(word, count.get(word) + 1); // else add the value to 1
           // }
        }
        return show();
    }

    /**
     * Show and count all letters in String s
     * 
     * @return all the letters
     */
    public String getLetters() {
        // Use countLetter to count
        count.clear();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') { // check if s.charAt(i) is a letter
                String letter = "";
                letter += s.charAt(i);
                letter = letter.toLowerCase(); // Convert letter to lower case
                if (!count.containsKey(letter)) {
                    count.put(letter, 1);// If count doesn't have this letter, put it in
                } else
                    count.replace(letter, count.get(letter) + 1); // else add the value to 1
            }
        }
        return show();
    }

    /**
     * show answer
     * 
     * @return
     */
    private String show() {
        // Show the result
        return count.toString();
    }
}
