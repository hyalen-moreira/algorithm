package us.hyalen.algorithm.others;

import org.springframework.stereotype.Component;

import java.util.*;

class Product {
    String name;
    int quantity;

    public Product(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    String getName() {
        return name;
    }

    int getQuantity() {
        return quantity;
    }
}

@Component
public class FirstHighestElement {
    public List<Product> highest(List<Product> products, int n) {
        // Edge cases
        // ...
        List<Product> result = new LinkedList<>();

        Map<Integer, List<Product>> map = new HashMap<>();

        for (Product product : products) {
            map.putIfAbsent(product.quantity, new LinkedList());
            map.get(product.quantity).add(product);
        }

        List<Integer> list = new ArrayList<>();
        list.addAll(map.keySet());
        Collections.sort(list);

        for (int i = list.size() - 1; i >= 0 && n > 0; i--, n--) {
            List<Product> temp = map.get(list.get(i));

            for (Product product : temp)
                result.add(product);
        }

        return result;
    }
}
