public class App {
    public static void main(String[] args) throws Exception {
        try {
            int n = 45;
            Fibonacci fibo = new Fibonacci(n);
            System.out.println("The " + n + " sequence Fibonacci:");
            System.out.println(fibo);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
