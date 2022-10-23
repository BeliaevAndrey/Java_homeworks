package model.Common;

import java.util.Scanner;

public class KeyboardReader {

    String getData(String prompt){
        String response = null;
        System.out.printf("%s _> ", prompt);
        try (Scanner input = new Scanner(System.in)){
            response = input.nextLine();
            input.reset();
        }
        return response;
    }
}
