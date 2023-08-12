package com.luckk.lizzie;

import java.util.HashMap;
import java.util.Scanner;

class Solution2 {

    /* Write Code Here */
    public int calculateMaxTotalYie(int[][] cropField) {
        if (cropField == null || cropField.length == 0) {
            return 0;
        }
        int row = cropField.length;
        int col = cropField[0].length;

        int[] rowArr = new int[row];
        int[] colArr = new int[col];

        int origin = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                rowArr[i] += cropField[i][j];
                colArr[j] += cropField[i][j];
                origin += cropField[i][j];
            }
        }
        int max = 0;

        System.out.println(origin);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int tmp = rowArr[i] + colArr[j] - cropField[i][j];
                if (tmp > max){
                    System.out.println(i+":"+j);
                    System.out.println(tmp);
                }
                max = Math.max(max, rowArr[i] + colArr[j] -  cropField[i][j]);

            }
        }
        return max + origin;

    }
}

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        int cropField_rows = 0;
        int cropField_cols = 0;
        cropField_rows = in.nextInt();
        cropField_cols = in.nextInt();

        int[][] cropField = new int[cropField_rows][cropField_cols];
        for (int cropField_i = 0; cropField_i < cropField_rows; cropField_i++) {
            for (int cropField_j = 0; cropField_j < cropField_cols; cropField_j++) {
                cropField[cropField_i][cropField_j] = in.nextInt();
            }
        }

        if (in.hasNextLine()) {
            in.nextLine();
        }


        res = new Solution2().calculateMaxTotalYie(cropField);
        System.out.println(String.valueOf(res));

    }
}

