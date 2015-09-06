package nyc.c4q;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.util.List;

import nyc.c4q.models.Book;
import nyc.c4q.models.Member;

/**
 * Created by Hoshiko on 8/30/15.
 */
public class MySQLiteOpenHelper extends OrmLiteSqliteOpenHelper {
    public static final String DATABASE_NAME = "mydb.db";
    public static final int DATABASE_VERSION = 2;

    private static MySQLiteOpenHelper mHelper;

    private Dao<Member, Integer> memberDao = null;
    private Dao<Book, Integer> bookDao = null;

    private RuntimeExceptionDao<Member, Integer> simpleRuntimeDao = null;
    private RuntimeExceptionDao<Book, Integer> simpleRuntimeDao2 = null;

    public MySQLiteOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static synchronized MySQLiteOpenHelper getInstance(Context context) {
        if (mHelper == null) {
            mHelper = new MySQLiteOpenHelper(context.getApplicationContext());
        }

        return mHelper;
    }

    /**
     * This is called when the database is first created. Usually you should call createTable statements here to create
     * the tables that will store your data.
     */
    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Book.class);
            TableUtils.createTable(connectionSource, Member.class);
        } catch (SQLException e) {
            Log.e(MySQLiteOpenHelper.class.getName(), "Can't create database", e);
            throw new RuntimeException(e);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void onUpgrade(SQLiteDatabase db,ConnectionSource connectionSource, int oldVersion, int newVersion) {
//        try {
//            List<String> allSql = new ArrayList<String>();
//            switch(oldVersion)
//            {
//                case 1:
//                    //allSql.add("alter table AdData add column `new_col` VARCHAR");
//                    //allSql.add("alter table AdData add column `new_col2` VARCHAR");
//            }
//            for (String sql : allSql) {
//                db.execSQL(sql);
//            }
//        } catch (SQLException e) {
//            Log.e(DatabaseHelper.class.getName(), "exception during onUpgrade", e);
//            throw new RuntimeException(e);
//        }

    }

    public Dao<Member, Integer> getMembeDao() {
        if (null == memberDao) {
            try {
                memberDao = getDao(Member.class);
            }catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        return memberDao;
    }


    public void insertMemberData(int id, String name, int dobMonth, int dobDay, int dobYear, String city, String state) throws SQLException {

        Member member = new Member(id, name, dobMonth, dobDay, dobYear, city, state);
        Dao<Member, Integer> dao = null;
        try {
            dao = getDao(Member.class);
            dao.create(member);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }

    }


    public Member loadMemberData(String name) throws SQLException, java.sql.SQLException {
        return getDao(Member.class).queryBuilder().where().eq("name", name).queryForFirst();
    }

    public List <Member> loadAllMember () throws java.sql.SQLException {
        return getDao(Member.class).queryForAll();
    }

    public Dao<Book, Integer> getBookDao() {
        if (null == bookDao) {
            try {
                bookDao = getDao(Book.class);
            }catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        return bookDao;
    }

    public void insertBookData(int id, String title, String author, String isbn,
                               String isbn13, String publisher, int publishyear) throws SQLException {

        Book book = new Book(id, title, author, isbn, isbn13, publisher, publishyear);
        Dao<Book, Integer> dao = null;
        try {
            dao = getDao(Book.class);
            dao.create(book);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }

    }

    public void insertBookCheckedOutData(int id, String title, String author, String isbn,
                               String isbn13, String publisher, int publishyear,
                               Boolean checkedout, int checkedoutby, int checkoutdateyear,
                               int checkoutdatemonth, int checkoutdateday, int duedateyear,
                               int duedatemonth, int duedateday) throws SQLException {

        Book book = new Book(id, title, author, isbn, isbn13, publisher, publishyear, checkedout,
                checkedoutby, checkoutdateyear, checkoutdatemonth, checkoutdateday, duedateyear, duedatemonth, duedateday);
        Dao<Book, Integer> dao = null;
        try {
            dao = getDao(Book.class);
            dao.create(book);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }

    }



    public Book loadBookData(String isbn) throws SQLException, java.sql.SQLException {
        return getDao(Book.class).queryBuilder().where().eq("isbn", isbn).queryForFirst();
    }

    public List <Book> loadAllBook () throws java.sql.SQLException {
        return getDao(Book.class).queryForAll();
    }

}

