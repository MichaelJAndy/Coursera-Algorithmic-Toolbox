package net.andreacchio.algorithmicToolbox.week1;

/**
 * Created with IntelliJ IDEA.
 * Date: 21/03/16
 * Time: 8:55 AM
 * Purpose: Coursera Week1
 */

import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {

    // Slower Method N^2
    static long getMaxPairwiseProduct(int[] numbers) {
        long result = 0;
        int n = numbers.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if ((long)numbers[i] * numbers[j] > result) {
                    result = (long)numbers[i] * numbers[j];
                }
            }
        }
        return result;
    }

    // Faster Method
    static long getMaxPairwiseProductFast(int[] numbers) {
        int nSize = numbers.length;

        int max_index1 = -1;
        for (int i = 0; i < nSize; i++) {
            if ((max_index1 == -1) || (numbers[i] > numbers[max_index1]))
                max_index1 = i;
        }

        int max_index2 = -1;
        for (int j = 0; j < nSize; j++) {
            if ((j != max_index1) && ((max_index2 == -1) || (numbers[j] > numbers[max_index2])))
                max_index2 = j;
        }

        return (long)numbers[max_index1] * numbers[max_index2];

    }


    // Main Method
    public static void main(String[] args) {

        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        System.out.println(getMaxPairwiseProductFast(numbers));


        // Stress testing for debugging
        /**
        while (true) {

            Random ran = new Random();
            int max = 5;
            int min = 2;
            int randomNum = ran.nextInt((max - min) + 1) + min;

            System.out.println("Random number: " + randomNum);

            int[] list = new int[randomNum];

            for (int i = 0; i < randomNum; i++) {
                list[i] = ran.nextInt((10) + 1);
                System.out.println(list[i]);
            }
            System.out.println("");

            double result1 = getMaxPairwiseProduct(list);
            double result2 = getMaxPairwiseProductFast(list);

            if (result1 != result2) {
                System.out.println("Something wrong yo, PW: " + result1 + "fast: " + result2);
                break;
            } else {
                System.out.println("OK yo\n");
            }
        }
        **/
    }

    // Scanning Code
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}
