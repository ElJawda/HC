package com.shc.SHC_SS.database;

/**
 * Created by jawdah on 4/2/2017.
 */

import java.util.ArrayList;
import java.util.HashMap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

import com.shc.SHC_SS.entities.FamilyByNumericalRegionId;
import com.shc.SHC_SS.utilies.HCApplication;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "HCDataBase.db";

    String query;

    private HashMap hp;

    public DBHelper() {
        super(HCApplication.context, DATABASE_NAME, null, 1);
        this.query = query;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL("create table   IF NOT EXISTS  evolution (id integer primary key autoincrement, name text,check_uploaded integer)");
        db.execSQL("create table   IF NOT EXISTS numerical_region (id integer primary key autoincrement,region_code text)");
        db.execSQL("create table   IF NOT EXISTS family (ID integer,NumericalAreaCode text,FamilyNo integer,Name text," +
                "Center integer,CenterName text,SubCity integer,SubCityNo integer,CityName text,HaraName text,HaraNo integer," +
                "Section integer,BlockNo integer,BuildNo integer,UnitNo integer,GPSX text,GPSY text,CreateDate text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        //db.execSQL("DROP TABLE IF EXISTS family");
        onCreate(db);
    }

    public boolean insertContact(String table_name, String COLUMN_NAME, String name, String COLUMN_CHeck, int check) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME, name);
        contentValues.put(COLUMN_CHeck, check);
        db.insert(table_name, null, contentValues);
        return true;
    }

    public boolean insertContact(String table_name, String COLUMN_NAME, String name, String COLUMN_CHeck, String region_value) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME, name);
        contentValues.put(COLUMN_CHeck, region_value);
        db.insert(table_name, null, contentValues);
        return true;
    }

    public boolean insertContact(String table_name, String COLUMN_NAME, String value) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME, value);
        db.insert(table_name, null, contentValues);
        return true;
    }

    public boolean insertFamily(String table_name, int ID, String NumericalAreaCode, int FamilyNo, String Name, int Center, String CenterName,
                                int SubCity, int SubCityNo, String CityName, String HaraName, int HaraNo, int Section,
                                int BlockNo, int BuildNo, int UnitNo, String GPSX, String GPSY,
                                String CreateDate) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ID", ID);
        contentValues.put("NumericalAreaCode", NumericalAreaCode);
        contentValues.put("FamilyNo", FamilyNo);
        contentValues.put("Name", Name);
        contentValues.put("Center", Center);
        contentValues.put("CenterName", CenterName);
        contentValues.put("SubCity", SubCity);
        contentValues.put("SubCityNo", SubCityNo);
        contentValues.put("CityName", CityName);
        contentValues.put("HaraName", HaraName);
        contentValues.put("HaraNo", HaraNo);
        contentValues.put("Section", Section);
        contentValues.put("BlockNo", BlockNo);
        contentValues.put("BuildNo", BuildNo);
        contentValues.put("UnitNo", UnitNo);
        contentValues.put("GPSX", GPSX);
        contentValues.put("GPSY", GPSY);
        contentValues.put("CreateDate", CreateDate);
//        contentValues.put("UpdateDate", UpdateDate);
//        contentValues.put("ModifiedByID", ModifiedByID);
        db.insert(table_name, null, contentValues);
        return true;
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }

    public boolean deleteAllRow(String table_name) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(table_name, null, null);
        return true;
    }

    public ArrayList<FamilyByNumericalRegionId> getData(String table_name, String column_name, String id) {
        ArrayList<FamilyByNumericalRegionId> familyByNumericalRegionIds = new ArrayList<FamilyByNumericalRegionId>();
        SQLiteDatabase mSQLiteDb = this.getReadableDatabase();
        String[] projection = {"ID", "NumericalAreaCode", "FamilyNo", "Name", "Center", "CenterName", "SubCity"
                , "SubCityNo", "CityName","HaraName","HaraNo","Section","BlockNo","BuildNo","UnitNo","GPSX","GPSY","CreateDate"};
        Cursor res = mSQLiteDb.query(table_name, projection, "NumericalAreaCode=\'" + id + "\'", null, null, null, null);

        if (res != null && res.getCount() != 0) {
            res.moveToFirst();
            while (!res.isAfterLast()) {
                FamilyByNumericalRegionId familyByNumericalRegionId = new FamilyByNumericalRegionId();
                familyByNumericalRegionId.setID(Integer.parseInt(res.getString(res.getColumnIndex("ID"))));
                familyByNumericalRegionId.setNumericalAreaCode(res.getString(res.getColumnIndex("NumericalAreaCode")));
                familyByNumericalRegionId.setFamilyNo(Integer.parseInt(res.getString(res.getColumnIndex("FamilyNo"))));
                familyByNumericalRegionId.setName(res.getString(res.getColumnIndex("Name")));
                familyByNumericalRegionId.setCenter(Integer.parseInt(res.getString(res.getColumnIndex("Center"))));
                familyByNumericalRegionId.setCenterName(res.getString(res.getColumnIndex("CenterName")));
                familyByNumericalRegionId.setSubCity(Integer.parseInt(res.getString(res.getColumnIndex("SubCity"))));
                familyByNumericalRegionId.setSubCityNo(Integer.parseInt(res.getString(res.getColumnIndex("SubCityNo"))));
                familyByNumericalRegionId.setCityName(res.getString(res.getColumnIndex("CityName")));
                familyByNumericalRegionId.setHaraName(res.getString(res.getColumnIndex("HaraName")));
                familyByNumericalRegionId.setHaraNo(Integer.parseInt(res.getString(res.getColumnIndex("HaraNo"))));
                familyByNumericalRegionId.setSection(Integer.parseInt(res.getString(res.getColumnIndex("Section"))));
                familyByNumericalRegionId.setBlockNo(Integer.parseInt(res.getString(res.getColumnIndex("BlockNo"))));
                familyByNumericalRegionId.setBuildNo(Integer.parseInt(res.getString(res.getColumnIndex("BuildNo"))));
                familyByNumericalRegionId.setUnitNo(Integer.parseInt(res.getString(res.getColumnIndex("UnitNo"))));
                familyByNumericalRegionId.setGPSX(res.getString(res.getColumnIndex("GPSX")));
                familyByNumericalRegionId.setGPSY(res.getString(res.getColumnIndex("GPSY")));
                familyByNumericalRegionId.setCreateDate(res.getString(res.getColumnIndex("CreateDate")));
                familyByNumericalRegionIds.add(familyByNumericalRegionId);
                res.moveToNext();

            }
        }
        return familyByNumericalRegionIds;
    }

    public int numberOfRows(String table_name) {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, table_name);
        return numRows;
    }

    public synchronized boolean updateContact(String table_name, Integer id, String column_name, String name, String column_ch_name, int checked) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(column_name, name);
        contentValues.put(column_ch_name, checked);
        db.update(table_name, contentValues, "id=" + id, null);
        return true;
    }

    public Integer deleteContact(String table_name,String column_name ,Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(table_name, column_name +"= ? ",
                new String[]{Integer.toString(id)});
    }

    //---deletes a particular title---
    public boolean deleteRow(String table_name,String column_name ,Integer id)
    {       SQLiteDatabase db = this.getWritableDatabase();
      db.execSQL("DELETE FROM " + table_name + " WHERE " + column_name + "='" + id + "'");
        return true ;
    }

    public JSONArray getColumnNameandValue(String table_name, int checK_value) throws JSONException {
        JSONArray jsonObject = new JSONArray();
        SQLiteDatabase mSQLiteDb = this.getReadableDatabase();
        String[] projection = {"id", "name", "check_uploaded"};
        Cursor cursor = mSQLiteDb.query(table_name, projection, "check_uploaded=\'" + checK_value + "\'", null, null, null, null);

        if (cursor != null && cursor.getCount() != 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                JSONObject values = new JSONObject();
                values.put("id", cursor.getInt(cursor.getColumnIndex("id")));
                values.put("name", cursor.getString(cursor.getColumnIndex("name")));
                values.put("check_uploaded", cursor.getInt(cursor.getColumnIndex("check_uploaded")));
                jsonObject.put(values);

                cursor.moveToNext();
            }
        }
        return jsonObject;
    }

    public ArrayList<String> getAllCotacts(String table_name, String column_name) {
        ArrayList<String> array_list = new ArrayList<String>();
        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from " + table_name, null);
        res.moveToFirst();
        while (res.isAfterLast() == false) {
            array_list.add(res.getString(res.getColumnIndex(column_name)));
            res.moveToNext();
        }
        return array_list;
    }
}