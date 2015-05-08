package com.example.okadayosuke.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class setting extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);


        try{
            Context ctx = createPackageContext("com.example.okadayosuke.myapplication", 0);

            int adt, kid, bay, lmt, set;
            //  プリファレンスの作成
            SharedPreferences pri_adult = ctx.getSharedPreferences("Preferences", MODE_PRIVATE);
            SharedPreferences pri_kids = ctx.getSharedPreferences("Preferences", MODE_PRIVATE);
            SharedPreferences pri_baby = ctx.getSharedPreferences("Preferences", MODE_PRIVATE);
            SharedPreferences pri_limit = ctx.getSharedPreferences("Preferences", MODE_PRIVATE);
            SharedPreferences pri_setting = ctx.getSharedPreferences("Preferences", MODE_PRIVATE);

            ctx.getSharedPreferences("Preferences", MODE_PRIVATE);
            ctx.getSharedPreferences("Preferences", MODE_PRIVATE);
            ctx.getSharedPreferences("Preferences", MODE_PRIVATE);
            ctx.getSharedPreferences("Preferences", MODE_PRIVATE);
            ctx.getSharedPreferences("Preferences", MODE_PRIVATE);

            adt = pri_adult.getInt("key_adult", 0);
            kid = pri_kids.getInt("key_kids", 0);
            bay = pri_baby.getInt("key_baby", 0);
            lmt = pri_limit.getInt("key_limit", 0);
            set = pri_setting.getInt("key_setting", 0);

            String str_adult = String.valueOf(adt);
            String str_kids = String.valueOf(kid);
            String str_baby = String.valueOf(bay);
            String str_limit = String.valueOf(lmt);
            String str_setting = String.valueOf(set);

            EditText et_adult = (EditText)findViewById(R.id.input_Adult);
            EditText et_kids = (EditText)findViewById(R.id.input_Kids);
            EditText et_baby = (EditText)findViewById(R.id.input_Baby);
            EditText et_limit = (EditText)findViewById(R.id.input_limit);
            EditText et_setting = (EditText)findViewById(R.id.input_setting);

            et_adult.setText(str_adult);
            et_kids.setText(str_kids);
            et_baby.setText(str_baby);
            et_limit.setText(str_limit);
            et_setting.setText(str_setting);

        } catch (NameNotFoundException e){
            e.printStackTrace();
        }

        Button btnHome = (Button)findViewById(R.id.setting_home);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  インデント作成
                Intent intentHome = new Intent();
                intentHome.setClassName("com.example.okadayosuke.myapplication","com.example.okadayosuke.myapplication.MainActivity");

                //  プリファレンス
                SharedPreferences pri_adult = getSharedPreferences("Preferences", MODE_PRIVATE);
                SharedPreferences pri_kids = getSharedPreferences("Preferences", MODE_PRIVATE);
                SharedPreferences pri_baby = getSharedPreferences("Preferences", MODE_PRIVATE);
                SharedPreferences pri_limit = getSharedPreferences("Preferences", MODE_PRIVATE);
                SharedPreferences pri_setting = getSharedPreferences("Preferences", MODE_PRIVATE);

                Editor e_adult = pri_adult.edit();
                Editor e_kids = pri_kids.edit();
                Editor e_baby = pri_baby.edit();
                Editor e_limit = pri_limit.edit();
                Editor e_setting = pri_setting.edit();

                EditText et_adult = (EditText)findViewById(R.id.input_Adult);
                EditText et_kids = (EditText)findViewById(R.id.input_Kids);
                EditText et_baby = (EditText)findViewById(R.id.input_Baby);
                EditText et_limit = (EditText)findViewById(R.id.input_limit);
                EditText et_setting = (EditText)findViewById(R.id.input_setting);

                String str_adult = et_adult.getText().toString();
                String str_kids = et_kids.getText().toString();
                String str_baby = et_baby.getText().toString();
                String str_limit = et_limit.getText().toString();
                String str_setting = et_setting.getText().toString();

                if(str_adult.length() <= 0){
                    str_adult = "0";
                }
                if(str_kids.length() <= 0){
                    str_kids = "0";
                }
                if(str_baby.length() <= 0){
                    str_baby = "0";
                }
                if(str_limit.length() <= 0){
                    str_limit = "0";
                }
                if(str_setting.length() <= 0){
                    str_setting = "0";
                }

                int adt = Integer.parseInt(str_adult);
                int kid = Integer.parseInt(str_kids);
                int bay = Integer.parseInt(str_baby);
                int lmt = Integer.parseInt(str_limit);
                int set = Integer.parseInt(str_setting);

                e_adult.putInt("key_adult", adt);
                e_kids.putInt("key_kids", kid);
                e_baby.putInt("key_baby", bay);
                e_limit.putInt("key_limit", lmt);
                e_setting.putInt("key_setting", set);

                e_adult.commit();
                e_kids.commit();
                e_baby.commit();
                e_limit.commit();
                e_setting.commit();

                startActivity(intentHome);
            }
        });

        Button btnStock = (Button)findViewById(R.id.setting_stock);
        btnStock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  インデント作成
                Intent intentStock = new Intent();
                intentStock.setClassName("com.example.okadayosuke.myapplication","com.example.okadayosuke.myapplication.stock");

                //  プリファレンス
                SharedPreferences pri_adult = getSharedPreferences("Preferences", MODE_PRIVATE);
                SharedPreferences pri_kids = getSharedPreferences("Preferences", MODE_PRIVATE);
                SharedPreferences pri_baby = getSharedPreferences("Preferences", MODE_PRIVATE);
                SharedPreferences pri_limit = getSharedPreferences("Preferences", MODE_PRIVATE);
                SharedPreferences pri_setting = getSharedPreferences("Preferences", MODE_PRIVATE);

                Editor e_adult = pri_adult.edit();
                Editor e_kids = pri_kids.edit();
                Editor e_baby = pri_baby.edit();
                Editor e_limit = pri_limit.edit();
                Editor e_setting = pri_setting.edit();

                EditText et_adult = (EditText)findViewById(R.id.input_Adult);
                EditText et_kids = (EditText)findViewById(R.id.input_Kids);
                EditText et_baby = (EditText)findViewById(R.id.input_Baby);
                EditText et_limit = (EditText)findViewById(R.id.input_limit);
                EditText et_setting = (EditText)findViewById(R.id.input_setting);

                String str_adult = et_adult.getText().toString();
                String str_kids = et_kids.getText().toString();
                String str_baby = et_baby.getText().toString();
                String str_limit = et_limit.getText().toString();
                String str_setting = et_setting.getText().toString();

                if(str_adult.length() <= 0){
                    str_adult = "0";
                }
                if(str_kids.length() <= 0){
                    str_kids = "0";
                }
                if(str_baby.length() <= 0){
                    str_baby = "0";
                }
                if(str_limit.length() <= 0){
                    str_limit = "0";
                }
                if(str_setting.length() <= 0){
                    str_setting = "0";
                }

                int adt = Integer.parseInt(str_adult);
                int kid = Integer.parseInt(str_kids);
                int bay = Integer.parseInt(str_baby);
                int lmt = Integer.parseInt(str_limit);
                int set = Integer.parseInt(str_setting);

                e_adult.putInt("key_adult", adt);
                e_kids.putInt("key_kids", kid);
                e_baby.putInt("key_baby", bay);
                e_limit.putInt("key_limit", lmt);
                e_setting.putInt("key_setting", set);

                e_adult.commit();
                e_kids.commit();
                e_baby.commit();
                e_limit.commit();
                e_setting.commit();

                startActivity(intentStock);
            }
        });


        Button btnFood = (Button)findViewById(R.id.setting_food);
        btnFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  インデント作成
                Intent intentFood = new Intent();
                intentFood.setClassName("com.example.okadayosuke.myapplication","com.example.okadayosuke.myapplication.food");

                //  プリファレンス
                SharedPreferences pri_adult = getSharedPreferences("Preferences", MODE_PRIVATE);
                SharedPreferences pri_kids = getSharedPreferences("Preferences", MODE_PRIVATE);
                SharedPreferences pri_baby = getSharedPreferences("Preferences", MODE_PRIVATE);
                SharedPreferences pri_limit = getSharedPreferences("Preferences", MODE_PRIVATE);
                SharedPreferences pri_setting = getSharedPreferences("Preferences", MODE_PRIVATE);

                Editor e_adult = pri_adult.edit();
                Editor e_kids = pri_kids.edit();
                Editor e_baby = pri_baby.edit();
                Editor e_limit = pri_limit.edit();
                Editor e_setting = pri_setting.edit();

                EditText et_adult = (EditText)findViewById(R.id.input_Adult);
                EditText et_kids = (EditText)findViewById(R.id.input_Kids);
                EditText et_baby = (EditText)findViewById(R.id.input_Baby);
                EditText et_limit = (EditText)findViewById(R.id.input_limit);
                EditText et_setting = (EditText)findViewById(R.id.input_setting);

                String str_adult = et_adult.getText().toString();
                String str_kids = et_kids.getText().toString();
                String str_baby = et_baby.getText().toString();
                String str_limit = et_limit.getText().toString();
                String str_setting = et_setting.getText().toString();

                if(str_adult.length() <= 0){
                    str_adult = "0";
                }
                if(str_kids.length() <= 0){
                    str_kids = "0";
                }
                if(str_baby.length() <= 0){
                    str_baby = "0";
                }
                if(str_limit.length() <= 0){
                    str_limit = "0";
                }
                if(str_setting.length() <= 0){
                    str_setting = "0";
                }

                int adt = Integer.parseInt(str_adult);
                int kid = Integer.parseInt(str_kids);
                int bay = Integer.parseInt(str_baby);
                int lmt = Integer.parseInt(str_limit);
                int set = Integer.parseInt(str_setting);

                e_adult.putInt("key_adult", adt);
                e_kids.putInt("key_kids", kid);
                e_baby.putInt("key_baby", bay);
                e_limit.putInt("key_limit", lmt);
                e_setting.putInt("key_setting", set);

                e_adult.commit();
                e_kids.commit();
                e_baby.commit();
                e_limit.commit();
                e_setting.commit();

                startActivity(intentFood);
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_setting, menu);
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
