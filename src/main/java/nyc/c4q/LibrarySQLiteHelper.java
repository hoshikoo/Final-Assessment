package nyc.c4q;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Hoshiko on 9/2/15.
 */
public class LibrarySQLiteHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "library.db";
    private static final int DB_VERSION = 2;


    public static final String MEMBERS_TABLE = "MEMBERS";
    public static final String COLUMN_MEMBER_NAME = "MEMBER_NAME";
    public static final String COLUMN_MEMBER_ID = "MEMBER_ID";
    public static final String COLUMN_DOB_MONTH = "DOB_MONTH";
    public static final String COLUMN_DOB_DAY = "DOB_DAY";
    public static final String COLUMN_DOB_YEAR = "DOB_YEAR";
    public static final String COLUMN_CITY = "CITY";
    public static final String COLUMN_STATE = "STATE";


    private static String CREATE_MEMBERS =
            "CREATE TABLE " + MEMBERS_TABLE + "( " +
                    COLUMN_MEMBER_ID + " INTEGER PRIMARY KEY  , " +
                    COLUMN_MEMBER_NAME + " TEXT," +
                    COLUMN_DOB_MONTH + " INTEGER," +
                    COLUMN_DOB_DAY + " INTEGER," +
                    COLUMN_DOB_YEAR + " INTEGER," +
                    COLUMN_CITY + " TEXT," +
                    COLUMN_STATE + " TEXT)";

    public static final String BOOKS_TABLE = "BOOKS";
    public static final String COLUMN_BOOK_ID = "BOOK_ID";
    public static final String COLUMN_TITLE = "TITLE";
    public static final String COLUMN_AUTHOR = "AUTHOR";
    public static final String COLUMN_ISBN = "ISBN";
    public static final String COLUMN_ISBN13 = "ISBN13";
    public static final String COLUMN_PUBLISHER = "PUBLISHER";
    public static final String COLUMN_PUBLISH_YEAR = "PUBLISH_YEAR";
    public static final String COLUMN_CHECKEDOUT = "CHECKEDOUT";
    public static final String COLUMN_FOREIGN_KEY_CHECKEDOUT_BY = "MEMBER_ID";
    public static final String COLUMN_CHECKOUT_DATE = "CHECKOUT_DATE";
    public static final String COLUMN_CHECKOUT_MONTH = "CHECKOUT_MONTH";
    public static final String COLUMN_CHECKOUT_YEAR = "CHECKOUT_YEAR";
    public static final String COLUMN_DUE_YEAR = "DUE_YEAR";
    public static final String COLUMN_DUE_MONTH = "DUE_MONTH";
    public static final String COLUMN_DUE_DAY = "DUE_DAY";

    private static String CREATE_BOOKS =
            "CREATE TABLE " + BOOKS_TABLE + "( " + COLUMN_BOOK_ID + " INTEGER PRIMARY KEY," +
                    COLUMN_TITLE + " TEXT," +
                    COLUMN_AUTHOR + " TEXT," +
                    COLUMN_ISBN + " TEXT," +
                    COLUMN_ISBN13 + " TEXT," +
                    COLUMN_PUBLISHER + " TEXT," +
                    COLUMN_PUBLISH_YEAR + " TEXT," +
                    COLUMN_CHECKEDOUT + " INTEGER," +
                    COLUMN_CHECKOUT_DATE + " INTEGER," +
                    COLUMN_CHECKOUT_MONTH + " INTEGER," +
                    COLUMN_CHECKOUT_YEAR + " INTEGER," +
                    COLUMN_DUE_YEAR + " INTEGER," +
                    COLUMN_DUE_MONTH + " INTEGER," +
                    COLUMN_DUE_DAY + " INTEGER," +
                    COLUMN_FOREIGN_KEY_CHECKEDOUT_BY + " INTEGER," +
                    " FOREIGN KEY(" + COLUMN_FOREIGN_KEY_CHECKEDOUT_BY + ") REFERENCES MEMBERS(COLUMN_MEMBER_ID))";



    public LibrarySQLiteHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_MEMBERS);
        db.execSQL(CREATE_BOOKS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
