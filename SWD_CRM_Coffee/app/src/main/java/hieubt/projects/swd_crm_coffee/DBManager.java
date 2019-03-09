package hieubt.projects.swd_crm_coffee;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBManager extends SQLiteOpenHelper {

    private Context mContext;

    public DBManager(Context context){
        super(context, "SWS_database", null, 1);
        this.mContext= context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlQuery = "CREATE TABLE \"registedBrand_table\" (\n" +
                "\t\"userId\"\tINTEGER,\n" +
                "\t\"brandId\"\tINTEGER\n" +
                ")";
        db.execSQL(sqlQuery);
        sqlQuery = "CREATE TABLE \"user_table\" (\n" +
                "\t\"id\"\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                "\t\"username\"\tINTEGER NOT NULL,\n" +
                "\t\"password\"\tINTEGER NOT NULL\n" +
                ")";
        db.execSQL(sqlQuery);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //login
    public boolean checkLogin(String username, String password) {
//        String query = "select * from user_table where username = bbb and password = bbb";
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = new String[]{"username", "password"};
        String whereClause = "username = ? and password = ?";
        String[] whereArgs = new String[]{username, password};
        Cursor cursor = db.query("user_table", columns, whereClause, whereArgs, null, null, null);

        boolean result = cursor.moveToFirst();
        cursor.close();
        db.close();
        return result;
    }

    public boolean registed(String username, String password) {
        ContentValues values = new ContentValues();
        values.put("username", username);
        values.put("password", password);
        SQLiteDatabase db = this.getWritableDatabase();
        boolean result = db.insert("user_table", null, values) > 0;
        db.close();
        return result;
    }

    //registedBrand table
    //return list of registed brand id
    public List<Integer> getAllRegistedBrandId(int userId) {
        List<Integer> list = new ArrayList<>();
        String query = "SELECT brandId FROM user_table JOIN registedBrand_table on user_table.id = registedBrand_table.userId WHERE user_table.id = " + String.valueOf(userId);
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                list.add(cursor.getInt(0));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return list;
    }

    //regist a brand
    public boolean addRegistedBrandId(int userId, int brandId) {
        boolean result = false;
        ContentValues values = new ContentValues();
        values.put("userId", userId);
        values.put("brandId", brandId);
        SQLiteDatabase db = this.getReadableDatabase();
        result = db.insert("registedBrand_table", null, values) > 0;
        db.close();

        return result;
    }

}
