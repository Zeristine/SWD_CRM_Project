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
        sqlQuery = "CREATE TABLE \"noti_table\" (\n" +
                "\t\"notiID\"\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                "\t\"notiTitle\"\tINTEGER NOT NULL,\n" +
                "\t\"notiBody\"\tINTEGER NOT NULL\n" +
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

    public boolean inputNoti(String notiTitle, String notiBody) {
        ContentValues values = new ContentValues();
        values.put("notiTitle", notiTitle);
        values.put("notiBody", notiBody);
        SQLiteDatabase db = this.getWritableDatabase();
        boolean result = db.insert("noti_table", null, values) > 0;
        db.close();
        return result;
    }

    public List<NotiDTO> getListNoti() {
        List<NotiDTO> list = new ArrayList<>();
        String query = "SELECT notiTitle, notiBody FROM noti_table";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                NotiDTO dto = new NotiDTO();
                dto.setNotiTitle(cursor.getString(0));
                dto.setNotiBody(cursor.getString(1));
                list.add(dto);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return list;
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

    //get Brand
    public boolean checkUserRegisterBrand(int userId, int brandId){
        boolean result = false;
        String query = "SELECT brandId " +
                "FROM user_table JOIN registedBrand_table on user_table.id = registedBrand_table.userId " +
                "WHERE user_table.id = " + String.valueOf(userId) + " AND registedBrand_table.brandId = " + String.valueOf(brandId);
        SQLiteDatabase db =  this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()){
            result = true;
        }
        cursor.close();
        db.close();
        return result;
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
