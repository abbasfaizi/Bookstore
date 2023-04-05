public class Main {

    public static void main(String [] args){

        Bookstore bookstore = new Bookstore();
        Menu menu = new Menu(bookstore);
        menu.run();

    }
}
