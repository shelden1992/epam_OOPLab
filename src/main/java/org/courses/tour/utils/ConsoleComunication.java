package org.courses.tour.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleComunication {
    private static final int MAX_DAYS = 30;

    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void showMessage(String message) {
        System.out.println(message);
    }

    public static int chooseSomeEntity(int maxChoose) {

        int i = 0;
        try {

            String scan = "";
            while (!(scan = bufferedReader.readLine()).isEmpty()) {
                try {
                    if ((i = Integer.parseInt(scan)) > maxChoose || i <= 0) {
                        System.out.println("Please, enter number 1-" + maxChoose);
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please, enter number 1-" + maxChoose);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
        return i;
    }

    public static int chooseDay() {
        int i = 0;
        do {
            i = chooseSomeEntity(MAX_DAYS);
        }
        while (i < 0);
        return i;
    }


    static public void close() {
        try {
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
