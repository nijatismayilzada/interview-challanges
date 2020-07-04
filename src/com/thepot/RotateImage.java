package com.thepot;

public class RotateImage {


    public void rotate(int[][] matrix) {


        for (int y = 0; y < matrix.length; y++) {
            for (int x = y; x < matrix[y].length; x++) {
                int val = matrix[y][x];

                matrix[y][x] = matrix[x][y];

                matrix[x][y] = val;

            }
        }

        for (int[] row : matrix) {

            int middle = row.length / 2;

            for (int x = 0; x < middle; x++) {
                int val = row[x];

                row[x] = row[row.length - 1 - x];

                row[row.length - 1 - x] = val;

            }


        }


    }

}
