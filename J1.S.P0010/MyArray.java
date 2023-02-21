public class MyArray {
    private int[] a;
    private int index;

    /**
     * Constructor
     */
    public MyArray() {
        // a = new int[0];
    }

    /**
     * check and set the length of the array
     * 
     * @param n the length of the array
     * @throws Exception if n <= 0
     */
    public void setN(int n) throws Exception {
        if (n <= 0) {
            throw new Exception("Accept positive integer only!");
        }
        a = new int[n];
        index = 0;
    }

    /**
     * Sort the array ascending by using Bubble Sort
     * 
     * @param a the array need to sort
     * @return the sorted array (ascending)
     */
    private void sortAscending() {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    int t = a[i];
                    a[i] = a[j];
                    a[j] = t;
                }
            }
        }
    }

    /**
     * Sort the array descending by using Bubble Sort
     * 
     * @param a the array need to sort
     * @return the sorted array (descending)
     */
    private void sortDescending() {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] < a[j]) {
                    int t = a[i];
                    a[i] = a[j];
                    a[j] = t;
                }
            }
        }
    }

    /**
     * Add a value in the array
     * 
     * @param n the value need to add in the array
     */
    public void add(int n) {
        a[index] = n;
        index++;
    }

    /**
     * Convert the sorted array to string (Ascending)
     * 
     * @return The ascending array (String)
     */
    public String showAscendingArray() {
        String res;
        if (a != null) {
            sortAscending();
            res = "[" + a[0] + "]";
            for (int i = 1; i < a.length; i++) {
                res += "->[" + a[i] + "]";
            }
        } else {
            res = "No element in the array!";
        }
        return res;
    }

    /**
     * Convert the sorted array to string (Descending)
     * 
     * @return The descending array (String)
     */
    public String showDescendingArray() {
        String res;
        if (a != null) {
            sortDescending();
            res = "[" + a[0] + "]";
            for (int i = 1; i < a.length; i++) {
                res += "<-[" + a[i] + "]";
            }
        } else {
            res = "No element in the array!";
        }
        return res;
    }
}
