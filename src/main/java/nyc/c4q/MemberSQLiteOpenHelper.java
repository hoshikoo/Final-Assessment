package nyc.c4q;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.util.List;

/**
 * Created by Hoshiko on 8/30/15.
 */
public class MemberSQLiteOpenHelper extends OrmLiteSqliteOpenHelper {
    public static final String MEMBERDB = "memberdb";
    public static final int VERSION = 1;

    private static MemberSQLiteOpenHelper INSTANCE;

    public static synchronized MemberSQLiteOpenHelper getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new MemberSQLiteOpenHelper(context.getApplicationContext());
        }

        return INSTANCE;
    }

    private MemberSQLiteOpenHelper(Context context) {
        super(context, MEMBERDB, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, nyc.c4q.Member.class);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, nyc.c4q.Member.class, false);
            onCreate(database, connectionSource);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertData() throws SQLException {
        Dao<nyc.c4q.Member, ?> dao = null;
        try {
            dao = getDao(nyc.c4q.Member.class);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }

        try {
            dao.delete(dao.deleteBuilder().prepare());
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
//        insertRow();

    }

    private void insertRow(int id, String name, String city, String state, int dob_month, int dob_date, int dob_year) throws SQLException {
        nyc.c4q.Member member = new nyc.c4q.Member();
        member.setName(name);
        member.setCity(city);
        member.setState(state);
        member.setDob_date(dob_date);
        member.setDob_month(dob_month);
        member.setDob_year(dob_year);
        try {
            getDao(nyc.c4q.Member.class).create(member);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }

    public List<nyc.c4q.Member> loadData() throws SQLException, java.sql.SQLException {
        return getDao(nyc.c4q.Member.class).queryForAll();
    }
}

