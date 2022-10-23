package model.Common;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScanKeybSvc {

    public int scanNum() {
        boolean flag;
        int num = 0;
        do {
            flag = false;
            try {
                num = new Scanner(System.in).nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Only integer numbers allowed.");
                flag = true;
            }
        } while (flag);

        return num;
    }

//    public static void main(String[] args) {
//        System.out.println(new ScanKeybSvc().scanNum());
//        System.out.println(new ScanKeybSvc().scanNum());
//    }
}
