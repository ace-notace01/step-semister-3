public class ClassMarksGridAnalysis {

    public static void main(String[] args) {
        String[] names = {"Asha", "Ravi", "Neha"};

        int[][] marks = {
            {78, 85, 90},
            {88, 92, 79},
            {65, 70, 95}
        };

        int[] subjectTotal = new int[3];

        int topperIndex = 0;
        int highestTotal = 0;

        for (int i = 0; i < marks.length; i++) {
            int total = 0;

            for (int j = 0; j < marks[i].length; j++) {
                total += marks[i][j];
                subjectTotal[j] += marks[i][j];
            }

            System.out.println("Total " + names[i] + " " + total);

            if (total > highestTotal) {
                highestTotal = total;
                topperIndex = i;
            }
        }

        System.out.printf("averages %.2f, %.2f, %.2f%n",
            subjectTotal[0] / 3.0,
            subjectTotal[1] / 3.0,
            subjectTotal[2] / 3.0
        );

        System.out.println("topper " + names[topperIndex] +
            " (" + highestTotal + ")");
    }
}