package exam2011;

public class ThreeDArray {
    public static void main(String[] args) {
        int[][][] threeDArray = new int[10][10][10];
        for (int i = 0; i < threeDArray.length; i++) {
            for (int j = 0; j < threeDArray[i].length; j++) {
                for (int k = 0; k < threeDArray[j].length; k++) {
                    threeDArray[i][j][k] = 5;
                }
            }
        }

        // print
        for (int[][] rowsOfRows : threeDArray) {
            for (int[] row : rowsOfRows) {
                for (int value : row) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
