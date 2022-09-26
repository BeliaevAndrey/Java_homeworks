import cls.Product;
import cls.VendingAutomat;
import svc.ViewSvc;

import java.util.Scanner;

public class Main {
    Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        Main local = new Main();
        VendingAutomat va = new VendingAutomat();
        ViewSvc vs = new ViewSvc();

        vs.printWholeList(va.getPayload());

        String menuLine = "Введите категорию продукта:\n";
        String category = vs.choice(menuLine, local.scn);
        menuLine = va.assemblyMenu(category);
        if (menuLine != null) {
            menuLine = "Введите наименование продукта (без кавычек):" + menuLine;
            String prodName = vs.choice(menuLine, local.scn);
            Product result = va.getProduct(va.getPayload().get(category), prodName);
            if (result != null) {
                System.out.println("HELLO FROM MAIN");
                System.out.println(result);
            }
            else{
                System.out.println("Неверный ввод");
            }
        } else {
            System.out.println("Неверный ввод");
        }
        local.scn.close();
    }


}
