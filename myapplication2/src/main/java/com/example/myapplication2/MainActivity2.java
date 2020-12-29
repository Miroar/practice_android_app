package com.example.myapplication2;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle arguments = getIntent().getExtras();
        ImageView flag = (ImageView) findViewById(R.id.imageView_flag);
        flag.setImageResource(arguments.getInt("IdDrawble"));
        TextView countryName = (TextView) findViewById(R.id.textView_countryName);
        countryName.setText(arguments.getString("country"));
        TextView descriprion = (TextView) findViewById(R.id.textView_description);
        try {
            descriprion.setText(this.getDescriptionByResId(arguments.getInt("IdRaw")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
            default:
                return true;
        }
    }

    public String getDescriptionByResId(int resId) throws IOException {
        InputStream stream = getApplicationContext().getResources().openRawResource(resId);
        InputStreamReader inputStreamReader = new InputStreamReader(stream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuilder text = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            text.append(line);
            text.append('\n');
        }
        bufferedReader.close();
        return text.toString();
    }

}