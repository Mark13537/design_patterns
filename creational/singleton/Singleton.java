package creational.singleton;

public class Singleton {
    public static void main(String[] args) {
        Database foo = Database.getInstance();
        System.out.println(foo);
        Database bar = Database.getInstance();
        System.out.println(bar);
    }
}

class Database {
    private static Database instance;

    private Database() {
        // some init code like connection to db server
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }
}
