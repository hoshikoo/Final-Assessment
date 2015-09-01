package nyc.c4q;

import android.content.Context;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Created by Hoshiko on 8/30/15.
 */
public class MockData {

    public static nyc.c4q.models.Book getMockData(Context context) {

        InputStream raw = context.getResources().openRawResource(R.raw.books);
        Reader rd = new BufferedReader(new InputStreamReader(raw));
        Gson gson = new Gson();
        nyc.c4q.models.Book response = gson.fromJson(rd, nyc.c4q.models.Book.class);
        return response;
    }
}
