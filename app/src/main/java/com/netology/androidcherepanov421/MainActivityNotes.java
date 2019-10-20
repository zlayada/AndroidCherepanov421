package com.netology.androidcherepanov421;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivityNotes extends AppCompatActivity {

    private EditText mInputNote;
    private Button mBtnSaveNote;

    private SharedPreferences myNoteSharedPref;
    private static String NOTE_TEXT = "note_text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_notes);
        initViews();
        getDateFromSharedPref();
    }

    //Инициализируем элементы экрана
    private void initViews() {
        mInputNote = findViewById(R.id.inputNote);
        mBtnSaveNote = findViewById(R.id.btnSaveNote);

        myNoteSharedPref = getSharedPreferences("MyNote", MODE_PRIVATE);

        // Обрабатываем кнопку "ОК" Выводим тост о сохранении данных
        mBtnSaveNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor myEditor = myNoteSharedPref.edit();
                String noteTxt = mInputNote.getText().toString();
                myEditor.putString(NOTE_TEXT, noteTxt);
                myEditor.apply();
                Toast.makeText(MainActivityNotes.this, "Данные сохранены", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void getDateFromSharedPref(){
        String noteTxt = myNoteSharedPref.getString(NOTE_TEXT, "");
        mInputNote.setText(noteTxt);
    }


}