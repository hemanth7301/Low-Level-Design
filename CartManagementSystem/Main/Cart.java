package Main;

import java.util.*;

public class Cart {
    Map<Integer, Integer> productVsCount;

    public Cart() {
        productVsCount = new HashMap<>();
    }

    public void addItemInCart(int productId, int count) {
        if (productVsCount.containsKey(productId)) {
            int oldCount = productVsCount.get(productId);
            productVsCount.put(productId, oldCount + count);
        } else {
            productVsCount.put(productId, count);
        }
    }

    public void removeItemFromCart(int productId, int count) {
        if (productVsCount.containsKey(productId)) {
            int oldCount = productVsCount.get(productId);
            if (oldCount == count) {
                productVsCount.remove(productId);
            } else {
                productVsCount.put(productId, oldCount - count);
            }
        }
    }

    public void emptyCart() {
        productVsCount = new HashMap<>();
    }

    public Map<Integer, Integer> getCart() {
        return productVsCount;
    }
}
