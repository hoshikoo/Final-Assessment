//package nyc.c4q;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//
//import java.util.ArrayList;
//
//import nyc.c4q.models.Book;
//import nyc.c4q.models.Member;
//
///**
// * Created by Hoshiko on 9/2/15.
// */
//public class LibraryDataSource {
//    private Context mContext;
//    private LibrarySQLiteHelper mLibrarySQLiteHelper;
//
//    public LibraryDataSource (Context context){
//
//        mContext = context;
//        mLibrarySQLiteHelper = new LibrarySQLiteHelper(context);
//
//    }
//
//
//
//    private SQLiteDatabase open(){
//        return mLibrarySQLiteHelper.getReadableDatabase();
//    }
//
//    private void close (SQLiteDatabase database){
//        database.close();
//    }
//
//    public ArrayList<Member> read(){
//        return null;
//    }
//
//    public ArrayList<Member> readMembers(){
//        SQLiteDatabase database = open();
//        Cursor cursor = database.query(LibrarySQLiteHelper.MEMBERS_TABLE, new String[]{
//                        LibrarySQLiteHelper.COLUMN_MEMBER_NAME,
//                        LibrarySQLiteHelper.COLUMN_MEMBER_ID,
//                        LibrarySQLiteHelper.COLUMN_DOB_DAY,
//                        LibrarySQLiteHelper.COLUMN_DOB_MONTH,
//                        LibrarySQLiteHelper.COLUMN_DOB_YEAR,
//                        LibrarySQLiteHelper.COLUMN_CITY,
//                        LibrarySQLiteHelper.COLUMN_STATE,
//                },
//                null,
//                null,
//                null,
//                null,
//                null);
//
//        ArrayList <Member> members = new ArrayList<Member>();
//        if (cursor.moveToFirst()){
//            do{
//                Member member = new Member(getIntFromColumnName(cursor, LibrarySQLiteHelper.COLUMN_MEMBER_ID),
//                        getStringFromColumnName(cursor, LibrarySQLiteHelper.COLUMN_MEMBER_NAME),
//                        getIntFromColumnName(cursor, LibrarySQLiteHelper.COLUMN_DOB_MONTH),
//                        getIntFromColumnName(cursor, LibrarySQLiteHelper.COLUMN_DOB_DAY),
//                        getIntFromColumnName(cursor, LibrarySQLiteHelper.COLUMN_DOB_YEAR),
//                        getStringFromColumnName(cursor, LibrarySQLiteHelper.COLUMN_CITY),
//                        getStringFromColumnName(cursor, LibrarySQLiteHelper.COLUMN_STATE));
//                members.add(member);
//            }while (cursor.moveToNext());
//        }
//        cursor.close();
//        close(database);
//        return members;
//    }
//
//
//
//    private int getIntFromColumnName (Cursor cursor, String columnName){
//        int columnIndex = cursor.getColumnIndex(columnName);
//        return cursor.getInt(columnIndex);
//    }
//
//    private String getStringFromColumnName (Cursor cursor, String columnName){
//        int columnIndex = cursor.getColumnIndex(columnName);
//        return cursor.getString(columnIndex);
//    }
//
//    public void createMembers (Member member){
//        SQLiteDatabase database = open();
//        database.beginTransaction();
//
//        ContentValues memberValues= new ContentValues();
//        memberValues.put(LibrarySQLiteHelper.COLUMN_MEMBER_ID, member.getId());
//        memberValues.put(LibrarySQLiteHelper.COLUMN_MEMBER_NAME, member.getName());
//        memberValues.put(LibrarySQLiteHelper.COLUMN_DOB_MONTH, member.getDobMonth());
//        memberValues.put(LibrarySQLiteHelper.COLUMN_DOB_DAY, member.getDobDay());
//        memberValues.put(LibrarySQLiteHelper.COLUMN_DOB_YEAR, member.getDobYear());
//        memberValues.put(LibrarySQLiteHelper.COLUMN_CITY, member.getCity());
//        memberValues.put(LibrarySQLiteHelper.COLUMN_STATE, member.getState());
//
//        database.insert(LibrarySQLiteHelper.MEMBERS_TABLE, null, memberValues);
//
//        database.setTransactionSuccessful();
//        database.endTransaction();
//        close(database);
//    }
//
//    public void createBooks (Book book){
//        SQLiteDatabase database = open();
//        database.beginTransaction();
//
//        ContentValues bookValues= new ContentValues();
//        bookValues.put(LibrarySQLiteHelper.COLUMN_BOOK_ID, book.getId());
//        bookValues.put(LibrarySQLiteHelper.COLUMN_TITLE, book.getAuthor());
//        bookValues.put(LibrarySQLiteHelper.COLUMN_ISBN, book.getIsbn());
//        bookValues.put(LibrarySQLiteHelper.COLUMN_ISBN13, book.getIsbn13());
//        bookValues.put(LibrarySQLiteHelper.COLUMN_PUBLISHER, book.getPublisher());
//        bookValues.put(LibrarySQLiteHelper.COLUMN_PUBLISH_YEAR, book.getPublishyear());
//        bookValues.put(LibrarySQLiteHelper.COLUMN_CHECKEDOUT, book.getCheckedout());
//        bookValues.put(LibrarySQLiteHelper.COLUMN_CHECKOUT_DATE, book.getCheckoutdateday());
//        bookValues.put(LibrarySQLiteHelper.COLUMN_CHECKOUT_MONTH, book.getCheckoutdatemonth());
//        bookValues.put(LibrarySQLiteHelper.COLUMN_CHECKOUT_YEAR, book.getCheckoutdateyear());
//        bookValues.put(LibrarySQLiteHelper.COLUMN_DUE_YEAR, book.getDuedateyear());
//        bookValues.put(LibrarySQLiteHelper.COLUMN_DUE_MONTH, book.getDuedatemonth());
//        bookValues.put(LibrarySQLiteHelper.COLUMN_DUE_DAY, book.getDuedateday());
//        bookValues.put(LibrarySQLiteHelper.COLUMN_FOREIGN_KEY_CHECKEDOUT_BY, book.getCheckedoutby());
//
//        database.insert(LibrarySQLiteHelper.BOOKS_TABLE, null, bookValues);
//
//        database.setTransactionSuccessful();
//        database.endTransaction();
//        close(database);
//    }
//
//
//}
