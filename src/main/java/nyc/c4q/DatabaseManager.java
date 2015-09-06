package nyc.c4q;

import android.content.Context;

import java.sql.SQLException;
import java.util.List;

import nyc.c4q.models.Book;
import nyc.c4q.models.Member;

/**
 * Created by Hoshiko on 9/4/15.
 */
public class DatabaseManager {

    static private DatabaseManager instance;

    static public void init(Context ctx) {
        if (null==instance) {
            instance = new DatabaseManager(ctx);
        }
    }

    static public DatabaseManager getInstance() {
        return instance;
    }

    private MySQLiteOpenHelper helper;
    private DatabaseManager(Context ctx) {
        helper = new MySQLiteOpenHelper(ctx);
    }

    private MySQLiteOpenHelper getHelper() {
        return helper;
    }

    public List<Book> getAllBooks() {
        List<Book> books = null;
        try {
            books = getHelper().getBookDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public List<Member> getAllMembers() {
        List<Member> members = null;
        try {
            members = getHelper().getMembeDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return members;
    }
}