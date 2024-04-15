public class Main {
    public static void main(String[] args) {
        Item itemOne = new Item("Reebok", 2000, ProductType.SHOE);
        Item itemTwo = new Item("NYC", 500, ProductType.CAP);
        Item itemThree = new Item("J&J", 800, ProductType.CAP);
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addToCart(itemOne);
        shoppingCart.addToCart(itemTwo);
        shoppingCart.addToCart(itemThree);
        System.out.println("Total Price after Discount " + shoppingCart.getTotalPrice());
    }
}
