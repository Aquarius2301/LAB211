public class GradeStudent {
    int midWeight, finalWeight, homeworkWeight;
    double totalWeight = 0;

    /**
     * Introduce
     */
    public void begin() {
        System.out.println("This program reads exam/homework scores and reports your overall course grade");
    }

    /**
     * Input mid term score
     */
    public void midTerm() {
        System.out.println("\nMidterm:");
        midWeight = Validation.getInteger("Weight (0-100)?", "Error! Please enter an integer from 0 to 100:", 0, 100);
        double score = Validation.getDouble("Score earned?", "Error! Please enter a number from 0 to 100:", 0, 100);
        // shifted amount
        int choose = Validation.getInteger("Were scores shifted (1=yes, 2=no)?", "Error! Please enter 1 or 2:", 1, 2);
        if (choose == 1) {
            double shift = Validation.getDouble("Shift amount?", "Error! Please enter a number greater than 0:", 1,
                    Double.MAX_VALUE);
            score += shift;
            if (score > 100)
                score = 100;
        }
        double weight = score * midWeight / 100;

        totalWeight += weight;
        System.out.println("Total points = " + score + " / 100");
        System.out.println("Weight score = " + round(weight) + " / " + midWeight);
    }

    /**
     * Input final term score
     */
    public void finalTerm() {
        System.out.println("\nFinal:");
        finalWeight = Validation.getInteger("Weight (0-" + (100 - midWeight) + ")?",
                "Error! Please enter an integer from 0 to " + (100 - midWeight) + ": ", 0,
                100 - midWeight);
        double score = Validation.getDouble("Score earned?", "Error! Please enter a number from 0 to 100:", 0, 100);
        // shifted amount
        int choose = Validation.getInteger("Were scores shifted (1=yes, 2=no)?", "Error! Please enter 1 or 2", 1, 2);
        if (choose == 1) {
            double shift = Validation.getDouble("Shift amount?", "Error! Please enter a number greater than 0:", 1,
                    Double.MAX_VALUE);
            score += shift;
            if (score > 100)
                score = 100;
        }
        double weight = score * finalWeight / 100;
        totalWeight += weight;
        System.out.println("Total points = " + score + " / 100");
        System.out.println("Weight score = " + round(weight) + " / " + finalWeight);
    }

    /**
     * Input homework score
     */
    public void homeWork() {
        System.out.println("\nHomework:");
        homeworkWeight = findHomeworkWeight(); // homeworkWeight = midWeight - finalWeight
        System.out.println("Weight: " + homeworkWeight);

        int numOfAssignments = Validation.getInteger("Number of assignments?",
                "Error! Please enter an integer greater than 0:", 1, Integer.MAX_VALUE);
        double totalScore = 0;
        double totalMax = 0;
        // Assignment
        for (int i = 0; i < numOfAssignments; i++) {
            double score, max;
            System.out.print("Assignment " + (i + 1) + " score and max? ");
            do {
                try {
                    score = Validation.sc.nextDouble();
                    max = Validation.sc.nextDouble();
                    if (score <= 0 || max <= 0 || score > 150 || max > 150) {
                        System.out.print(
                                "Error! Please enter the score and the max greater than 0 and smaller than 150: ");

                    } else if (score > max) {
                        System.out.print("Error! Please enter the score must be smaller than or equal to the max: ");
                    } else
                        break;
                } catch (Exception e) {
                    System.out.print("Error! Please enter the score and the max greater than 0 and smaller than 150: ");
                    Validation.sc.nextLine();
                }
            } while (true);
            totalScore += score;
            totalMax += max;
        }
        Validation.sc.nextLine();
        int attend = Validation.getInteger("How many section did you attend?",
                "Error! Please enter an integer greater than 0:", 1, Integer.MAX_VALUE);

        // Compute section points
        int sectionPoints = attend * 5;
        if (sectionPoints > 30)
            sectionPoints = 30;
        System.out.println("Section points: " + sectionPoints + " / 30");
        totalScore += sectionPoints;
        totalMax += 30;
        if (totalScore > totalMax)
            totalScore = totalMax;
        double weight = totalScore * homeworkWeight / totalMax;
        totalWeight += weight;
        System.out.println("Total points = " + round(totalScore) + " / " + round(totalMax));
        System.out.println("Weight score = " + round(weight) + " / " + homeworkWeight);
    }

    /**
     * find homework weight
     * 
     * @return homework weight
     */
    private int findHomeworkWeight() {
        return 100 - midWeight - finalWeight;
    }

    /**
     * Report the result
     */
    public void report() {
        totalWeight = round(totalWeight);
        System.out.println("\nOverall percentage = " + totalWeight);
        System.out.print("Your grade will be at least: ");
        if (totalWeight < 60)
            System.out.println("0.0");
        else if (totalWeight <= 74.99)
            System.out.println("0.7");
        else if (totalWeight <= 84.99)
            System.out.println("2.0");
        else
            System.out.println("3.0");
    }

    /**
     * Round a double
     * 
     * @param n a number need to round
     * @return a rounded number by n
     */
    private double round(double n) {
        return Math.round(n * 10) / 10.0;
    }
}
