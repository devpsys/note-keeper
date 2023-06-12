package assignment.notekeeper;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
//
import java.lang.reflect.Type;
import java.util.ArrayList;

public class NoteKeeper extends Application {
    public static SharedPreferences prefs;
    public static ArrayList<Note> notes = new ArrayList<>();

    private static final Gson gson = new Gson();

    @Override
    public void onCreate() {
        super.onCreate();

        prefs = getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE);

        decode();
    }

    public static void encode() {
        String notesStr = gson.toJson(notes);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("Notes", notesStr);
        editor.apply();
    }

    public static void decode() {
        String noteStr = prefs.getString("Notes", "[]");
        Type listType = new TypeToken<ArrayList<Note>>() {
        }.getType();
        notes = gson.fromJson(noteStr, listType);
    }
}
