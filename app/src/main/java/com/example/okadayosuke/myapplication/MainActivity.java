package com.example.okadayosuke.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tw = (TextView)findViewById(R.id.Date);
        Calendar cal = Calendar.getInstance();

        tw.setText("今日は"
                   +  cal.get(Calendar.YEAR) + "年"
                   + (cal.get(Calendar.MONTH)+1) + "月"
                   +  cal.get(Calendar.DATE) + "日です");

        Button btnHome = (Button)findViewById(R.id.home_setting);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentHome = new Intent();
                intentHome.setClassName("com.example.okadayosuke.myapplication", "com.example.okadayosuke.myapplication.setting");

                startActivity(intentHome);
            }
        });

        Button btnStock = (Button)findViewById(R.id.home_stock);
        btnStock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentStock = new Intent();
                intentStock.setClassName("com.example.okadayosuke.myapplication", "com.example.okadayosuke.myapplication.stock");

                startActivity(intentStock);
            }
        });

        Button btnFood = (Button)findViewById(R.id.home_food);
        btnFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentFood = new Intent();
                intentFood.setClassName("com.example.okadayosuke.myapplication", "com.example.okadayosuke.myapplication.food");

                startActivity(intentFood);
            }
        });

        //
        //  非常食の合計値S

        SharedPreferences pref = getSharedPreferences("Preferences", MODE_PRIVATE);

        int ReRice = 0;
        ReRice = pref.getInt("key_ReRice", ReRice);

        int kandume = 0;
        kandume = pref.getInt("key_kandume", kandume);

        int kanmen = 0;
        kanmen = pref.getInt("key_kanmen", kanmen);

        int kanpan = 0;
        kanpan = pref.getInt("key_kanpan", kanpan);

        int kandume2 = 0;
        kandume2 = pref.getInt("key_kandume2", kandume2);

        int retoruto = 0;
        retoruto = pref.getInt("key_retoruto", retoruto);

        int furizzu = 0;
        furizzu = pref.getInt("key_furizzu", furizzu);

        int dSonota = 0;
        dSonota = pref.getInt("key_dsonota", dSonota);

        int mizu = 0;
        mizu = pref.getInt("key_mizu", mizu);

        int pokari = 0;
        pokari = pref.getInt("key_pokari", pokari);

        int karori = 0;
        karori = pref.getInt("key_karori", karori);

        int okasi = 0;
        okasi = pref.getInt("key_okasi", okasi);


        int tFood = ReRice + kandume + kanmen + kanpan
                  + kandume2 + retoruto + furizzu + dSonota
                  + mizu + pokari + karori + okasi;

        //
        String strFood = String.valueOf(tFood);

        TextView food = (TextView)findViewById(R.id.total_food);
        food.setText(strFood);

        //  非常食の合計値E
        //

        //
        //  備蓄品の合計値S

        int gas = 0;
        gas = pref.getInt("key_gas", gas);

        int almi = 0;
        almi = pref.getInt("key_almi", almi);

        int bombe = 0;
        bombe = pref.getInt("key_bombe", bombe);

        int gunte = 0;
        gunte = pref.getInt("key_gunte", gunte);

        int hue = 0;
        hue = pref.getInt("key_hue", hue);

        int matti = 0;
        matti = pref.getInt("key_matti", matti);

        int sitagi = 0;
        sitagi = pref.getInt("key_sitagi", sitagi);

        int thisshu = 0;
        thisshu = pref.getInt("key_thissyu", thisshu);

        int tStock = gas + almi + bombe + gunte
                   + hue + matti + sitagi + thisshu;

        String strStock = String.valueOf(tStock);

        TextView stock = (TextView)findViewById(R.id.total_stock);
        stock.setText(strStock);


        //  備蓄品の合計値E
        //


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
