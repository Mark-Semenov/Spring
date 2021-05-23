import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.geekbrains.AppConfig;
import ru.geekbrains.Cart;
import java.util.Scanner;

public class Shop {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ApplicationContext appctx = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println("Welcome to the Shop");
        Cart cart = appctx.getBean(Cart.class);
        help();
        while (true) {
            String productName;
            String userCommand = scanner.nextLine();
            switch (checkCommand(userCommand)) {
                case "add" -> {
                    System.out.println("Input product");
                    productName = scanner.nextLine();
                    cart.addProduct(productName);
                }
                case "rm" -> {
                    System.out.println("Input product");
                    productName = scanner.nextLine();
                    cart.deleteProduct(productName);
                }
                case "show" -> {
                    cart.getRepository().showProducts();
                }
                case "cart" -> {
                    cart.showProducts();
                }
                case "close" -> {
                    cart.closeCart();
                }
                case "open" -> {
                    cart = appctx.getBean(Cart.class);
                }
                case "q" -> {
                    System.out.println("Buy");
                    scanner.close();
                    return;
                }
            }


        }

    }

    public static void help() {
        System.out.println("Use next commands to manage shop:");
        System.out.println("add - add product to the cart");
        System.out.println("rm - remove product from the cart");
        System.out.println("show - show all products at the catalog");
        System.out.println("cart - show all products at the cart");
        System.out.println("close - close cart");
        System.out.println("open - open cart");
        System.out.println("q - exit from shop");
    }

    public static String checkCommand (String userCommand){
        String command;
        command = userCommand.toLowerCase();
        return command.trim();
    }


}
