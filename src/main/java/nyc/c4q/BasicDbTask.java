package nyc.c4q;

import android.os.AsyncTask;

import java.util.List;


/**
 * Created by Hoshiko on 8/30/15.
 */
public class BasicDbTask extends AsyncTask<Void, Void, Void>
{
    public List<Book> books;
    int position;

    @Override
    protected Void doInBackground(Void... params) {
        books.get(position);
        return null;
    }
}
