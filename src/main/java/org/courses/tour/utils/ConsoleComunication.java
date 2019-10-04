package org.courses.tour.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleComunication {


    public static void showMessage(String message) {
        System.out.println(message);
    }

    public static int enterMessageForTour(int size) {
        int i = 0;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {

            String scan = "";
            while (!(scan = bufferedReader.readLine()).isEmpty()) {
                try {
                    if ((i = Integer.parseInt(scan)) > size || i <= 0) {
                        System.out.println("Please, enter number 1-" + size);
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please, enter number 1-" + size);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
        return i;
    }


}
