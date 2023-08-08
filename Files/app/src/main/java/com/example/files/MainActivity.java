package com.example.files;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    EditText textmsg;
    static final int Read_BLOCK_SIZE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textmsg = findViewById(R.id.edittext1);
        Button WriteBtn = findViewById(R.id.writebtn);
        Button ReadBtn = findViewById(R.id.readbtn);

        WriteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    FileOutputStream fileout = openFileOutput("mytextfile.txt",MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(textmsg.getText().toString());
                    outputWriter.close();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        ReadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    FileInputStream fileln = openFileInput("mytextfile.txt");
                    InputStreamReader inputRead = new InputStreamReader(fileln);

                    char [] inputBuffer = new char[Read_BLOCK_SIZE];

                    String s = "";
                    int charRead;

                    while ((charRead = inputRead.read(inputBuffer)) > 0){
                        String readString = String.copyValueOf(inputBuffer,0,charRead);
                        s += readString;
                    }
                    inputRead.close();
                    textmsg.setText(s);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}