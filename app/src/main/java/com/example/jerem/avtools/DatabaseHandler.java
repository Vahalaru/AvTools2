package com.example.jerem.avtools;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jerem on 10/10/2016.
 */

public class DatabaseHandler extends SQLiteOpenHelper {
    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


/*
    private static DatabaseHandler mInstance = null;


    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "planeManager";

    // Contacts table name
    public static final String TABLE_PLANES = "planes";

    // Contacts Table Columns names
    public static final String KEY_ID = "_id";
    public static final String KEY_PNAME = "pname";
    public static final String KEY_PTYPE = "ptype";
    public static final String KEY_PCLASS = "pclass";
    public static final String KEY_PSTYLE = "pstyle";
    public static final String KEY_PNOTES = "pnotes";

    public static DatabaseHandler getInstance(Context ctx) {

        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (mInstance == null) {
            mInstance = new DatabaseHandler(ctx.getApplicationContext());
        }
        return mInstance;
    }

    public DatabaseHandler(Context ctx) {
        super(ctx, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PLANES_TABLE = "CREATE TABLE "+TABLE_PLANES+" ("
                +KEY_ID+" INTEGER PRIMARY KEY, "+KEY_PNAME+" TEXT, "
                +KEY_PTYPE+" TEXT," +KEY_PCLASS+" TEXT,"+KEY_PSTYLE+" TEXT,"+KEY_PNOTES+" TEXT"+ ")";
        db.execSQL(CREATE_PLANES_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PLANES);

        // Create tables again
        onCreate(db);
    }

    //Adding new plane
    public void addPlane(Plane plane){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_PNAME, plane.getPname());
        values.put(KEY_PTYPE, plane.getPtype());
        values.put(KEY_PCLASS, plane.getPclass());
        values.put(KEY_PSTYLE, plane.getPstyle());
        values.put(KEY_PNOTES, plane.getPnotes());

        // Inserting Row
        db.insert(TABLE_PLANES, null, values);
        db.close(); // Closing database connection
    }

*/
/*
    //Getting single plane
    public Plane getPlane(int _id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_PLANES, new String[] { KEY_ID,
                        KEY_PNAME, KEY_PTYPE }, KEY_ID + "=?",
                new String[] { String.valueOf(_id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Plane plane = new Plane(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));
        // return contact
        return plane;
    }
*//*




    //Getting all Planes
    public List<Plane> getAllPlanes(){

        List<Plane> planeList = new ArrayList<Plane>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_PLANES + " ORDER BY " + KEY_PNAME + " COLLATE NOCASE;";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Plane plane = new Plane();
                plane.setID(Integer.parseInt(cursor.getString(0)));
                plane.setPname(cursor.getString(1));
                plane.setPtype(cursor.getString(2));
                plane.setPclass(cursor.getString(3));
                plane.setPstyle(cursor.getString(4));
                plane.setPnotes(cursor.getString(5));
                // Adding contact to list
                planeList.add(plane);
            } while (cursor.moveToNext()) ;

        }
        cursor.close();

        db.close();
        // return contact list
        return planeList;
    }

    public Cursor GetAllData()
    {

        String selectQuery = "SELECT * FROM " + TABLE_PLANES;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        cursor.moveToFirst();
        return cursor;
        }


    //Getting planes count
    public int getPlanesCount(){

        String selectQuery = "SELECT * FROM " + TABLE_PLANES;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();

    }



    //Updating a single plane
    public int updatePlane(Plane plane){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_PNAME, plane.getPname());
        values.put(KEY_PTYPE, plane.getPtype());

        // updating row
        return db.update(TABLE_PLANES, values, KEY_ID + " = ?",
                new String[] { String.valueOf(plane.get_id()) });
    }

    //Deleting a plane
    public void deletePlane(Plane plane){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_PLANES, KEY_ID + " = ?",
                new String[] { String.valueOf(plane.get_id()) });
        db.close();
    }
*/

}
