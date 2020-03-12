package com.flege.gumukrejo.session;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {
    private static final String KEY_NAME = "vOJo2UwWcPTSsJu5crby";
    private static final String IS_LOGGEDIN = "Pq2jl888JlWUvMOsQqwm";
    private static final String ID_PELANGGAN = "gJXw0aAreyfUMJFbCfFW";
    private static final String NIK = "YxJW6t3KBIPgGYJYLINx";
    private static final String NAMA = "kicfKeG26u1jadrhGNWm";
    private static final String KONTAK = "aOgam60gF4ZBKNIX93sz";
    private static final String GENDER = "GM1nZMcytGzkGORQ2lAI";

    private SharedPreferences sp;
    private SharedPreferences.Editor spEditor;

    public SessionManager(Context context){
        sp = context.getSharedPreferences(KEY_NAME, Context.MODE_PRIVATE);
        spEditor = sp.edit();
    }

    public void set_is_loggedin(){
        spEditor.putBoolean(IS_LOGGEDIN, true);
        spEditor.commit();
    }

    public void set_is_loggedout(){
        spEditor.putBoolean(IS_LOGGEDIN, false);
        spEditor.commit();
        spEditor.clear();
        spEditor.apply();
    }

    public void set_id_pelanggan(String value){
        spEditor.putString(ID_PELANGGAN, value);
        spEditor.commit();
    }

    public void set_nik(String value){
        spEditor.putString(NIK, value);
        spEditor.commit();
    }

    public void set_nama(String value){
        spEditor.putString(NAMA, value);
        spEditor.commit();
    }

    public void set_kontak(String value){
        spEditor.putString(KONTAK, value);
        spEditor.commit();
    }

    public void set_gender(String value){
        spEditor.putString(GENDER, value);
        spEditor.commit();
    }

    public boolean is_loggedin(){
        return sp.getBoolean(IS_LOGGEDIN,false);
    }

    public String get_id_pelanggan(){
        return sp.getString(ID_PELANGGAN,"");
    }

    public String get_nik(){
        return sp.getString(NIK,"");
    }

    public String get_nama(){
        return sp.getString(NAMA,"");
    }

    public String get_kontak(){
        return sp.getString(KONTAK,"");
    }

    public String get_gender(){
        return sp.getString(GENDER,"");
    }
}