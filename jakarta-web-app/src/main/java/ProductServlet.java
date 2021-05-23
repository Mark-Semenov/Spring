import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "goods", urlPatterns = "/goods")
public class ProductServlet extends HttpServlet {
    private List<Product> products;


    @Override
    public void init() throws ServletException {
        this.products = new ArrayList<>();

        products.add(new Product(1000, "Bamboo Watch", 24));
        products.add(new Product(1001, "Black Watch", 72));
        products.add(new Product(1002, "Blue Band", 79));
        products.add(new Product(1003, "Blue T-Shirt", 29));
        products.add(new Product(1004, "Bracelet", 73));
        products.add(new Product(1005, "Brown Purse", 120));
        products.add(new Product(1006, "Chakra Bracelet", 32));
        products.add(new Product(1007, "Galaxy Earrings", 34));
        products.add(new Product(1008, "Game Controller", 99));
        products.add(new Product(1009, "Gaming Set", 63));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getPathInfo() == null || req.getPathInfo().equals("/goods")) {
            req.setAttribute("goods", products);
            getServletContext().getRequestDispatcher("/WEB-INF/product.jsp").forward(req, resp);
        }
    }

}
