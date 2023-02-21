
public class App {

    public static void main(String[] args) {
        String s = Validation.readString("Enter your content: ");

        MyString string = new MyString(s);
        System.out.println(string.getWords()); // Show and count all words in s
        System.out.println(string.getLetters()); // Show and count all letters in s
    }

}
