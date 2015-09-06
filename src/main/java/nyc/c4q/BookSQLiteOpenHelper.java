//package nyc.c4q;
//
//import android.content.Context;
//import android.database.SQLException;
//import android.database.sqlite.SQLiteDatabase;
//
//import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
//import com.j256.ormlite.dao.Dao;
//import com.j256.ormlite.support.ConnectionSource;
//import com.j256.ormlite.table.TableUtils;
//
//import java.util.List;
//
//import nyc.c4q.models.Book;
//
///**
// * Created by Hoshiko on 8/30/15.
// */
//public class BookSQLiteOpenHelper extends OrmLiteSqliteOpenHelper
//{
//    public static final String BOOKDB = "book.db";
//    public static final int VERSION = 1;
//
//    private static BookSQLiteOpenHelper INSTANCE;
//
//
//    public static synchronized BookSQLiteOpenHelper getInstance(Context context)
//    {
//        if(INSTANCE == null)
//        {
//            INSTANCE = new BookSQLiteOpenHelper(context.getApplicationContext());
//        }
//
//        return INSTANCE;
//    }
//
//    private BookSQLiteOpenHelper(Context context)
//    {
//        super(context, BOOKDB, null, VERSION);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource)
//    {
//        try
//        {
//            TableUtils.createTable(connectionSource, Book.class);
//        }
//        catch(SQLException e)
//        {
//            throw new RuntimeException(e);
//        } catch (java.sql.SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion)
//    {
//        try
//        {
//            TableUtils.dropTable(connectionSource, Book.class, false);
//            onCreate(database, connectionSource);
//        }
//        catch(SQLException e)
//        {
//            throw new RuntimeException(e);
//        } catch (java.sql.SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void insertData(Context context) throws SQLException
//    {
//        Dao<Book, ?> dao = null;
//        try {
//            dao = getDao(Book.class);
//        } catch (java.sql.SQLException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            dao.delete(dao.deleteBuilder().prepare());
//        } catch (java.sql.SQLException e) {
//            e.printStackTrace();
//        }
//
//        Book book  = getBookJsonData(context.getApplicationContext());
//        int id = book.getId();
//        String title = book.getTitle();
//        String author = book.getAuthor();
//        String isbn = book.getIsbn();
//        String isbn13 = book.getIsbn13();
//        String publisher = book.getPublisher();
//        int publishyear = book.getPublishyear();
//
//        insertRow(id, title, author, isbn, isbn13, publisher, publishyear);
//
//    }
//
//    private void insertRow(int id, String title, String author, String isbn, String isbn13, String publisher, int publishyear) throws SQLException
//    {
//        Book book = new Book();
//        book.setTitle(title);
//        book.setAuthor(author);
//        book.setIsbn(isbn);
//        book.setIsbn13(isbn13);
//        book.setPublisher(publisher);
//        book.setPublishyear(publishyear);
//        try {
//            getDao(Book.class).create(book);
//        } catch (java.sql.SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public List<Book> loadData() throws SQLException, java.sql.SQLException {
//        return getDao(Book.class).queryForAll();
//    }
//
//    public Book getBookJsonData(Context context){
//
//        Book bookResponse= JsonHelper.loadBookJsonRawUsingGson(context.getApplicationContext(), R.raw.books);
//        return bookResponse;
//
//    }
//
//
//}
