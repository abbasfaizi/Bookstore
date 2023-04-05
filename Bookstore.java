import java.util.ArrayList;
import java.util.List;

public class Bookstore {

    private List<Book> inventory;
    private double revenue;

    public Bookstore(){
        this.inventory = new ArrayList<>();
        this.revenue = 0;
    }

    public void addBook(Book book) {
        inventory.add(book);
    }

    public List<Book> getInventory(){
        return inventory;
    }

    public void sellBook(Book book){
        if(inventory.contains(book)){
            book.setQuantity(book.getQuantity() - 1);
            revenue += book.getPrice();
        }
    }

    public double getRevenue(){
        return revenue;
    }
}
