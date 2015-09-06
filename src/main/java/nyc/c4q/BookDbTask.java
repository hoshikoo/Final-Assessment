//package nyc.c4q;
//
//import android.content.Context;
//import android.os.AsyncTask;
//
//import java.sql.SQLException;
//import java.util.List;
//
//import nyc.c4q.models.Book;
//
//
///**
// * Created by Hoshiko on 8/30/15.
// */
//public class BookDbTask extends AsyncTask <Void, Void, List<Book>>
//{
//    public List<Book> books;
//    int position;
//    private final Context mContext;
//
//    public BookDbTask(Context context) {
//        super();
//        this.mContext = context;
//    }
//    @Override
//    protected List<Book> doInBackground(Void... params) {
//
//        BookSQLiteOpenHelper bookSQLiteOpenHelper = BookSQLiteOpenHelper.getInstance(mContext);
//
//        bookSQLiteOpenHelper.insertData();
//
//        try {
//            books = bookSQLiteOpenHelper.loadData();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return books;
//    }
//
//    @Override
//    protected void onPostExecute(List<Book> books) {
//        super.onPostExecute(books);
//    }
//
//
//}
