package com.at0mic.xcuzme;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<String> excusas = new ArrayList<String>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(getAssets().open("excusas.txt")));
            String line = br.readLine();
            while (line != null) {
                excusas.add(line.toString());
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int rnd = 1 + (int)(Math.random() * ((103 - 1) + 1));

        TextView excuseText = (TextView)findViewById(R.id.excuseText);
        excuseText.setText(excusas.get(rnd));

        final Button button = (Button) findViewById(R.id.excuseButton);
        button.setTransformationMethod(null);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int rnd = 1 + (int)(Math.random() * ((103 - 1) + 1));
                TextView excuseText = (TextView)findViewById(R.id.excuseText);
                excuseText.setText(excusas.get(rnd));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
