package cls;

import data.Storage;
import svc.LoggingSvc;

import java.util.HashMap;

public class VendingAutomat {

    private HashMap<String, HashMap<String, Product>> payload = new HashMap<>();
    LoggingSvc lg = new LoggingSvc();

    public VendingAutomat() {
        Storage.generate();
        load();

    }

    void load() {
        for (Product item : Storage.getAssort()) {
            if (payload.containsKey(item.getType())) {
                payload.get(item.getType()).put(item.getName(), item);
            } else {
                HashMap<String, Product> position = new HashMap<>();
                position.put(item.getName(), item);
                payload.put(item.getType(), position);
            }
        }

    }

    public String assemblyMenu(String category) {
        String menuLine = "";
        if (getPayload().containsKey(category))
            for (String key : getPayload().get(category).keySet()) {
                menuLine += "\n" + key;
            }
        else
            return null;

        return menuLine;
    }

    public Product getProduct(HashMap<String, Product> category, String name) {
        if (!category.containsKey(name)) {
            return null;
        }

        if (category.get(name).getAmount() > 0) {
            category.get(name).decreaseAmt();
            System.out.println(category.get(name).getAmount());
            String logMsg = String.format("Выдано: %s\nОстаток: %d шт.\n",
                    category.get(name).toString(),
                    category.get(name).getAmount());
            lg.writeLog(logMsg);
            return category.get(name);
        } else {
            String logMsg = String.format("Товар закончился: %s\nОстаток: %d шт.\n",
                    category.get(name).toString(),
                    category.get(name).getAmount());
            lg.writeLog(logMsg);
        }
        return null;
    }


    public HashMap<String, HashMap<String, Product>> getPayload() {
        return this.payload;
    }
}
