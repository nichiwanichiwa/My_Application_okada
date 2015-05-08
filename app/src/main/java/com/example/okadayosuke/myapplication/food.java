package com.example.okadayosuke.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Calendar;


public class food extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        //  画面遷移
        Button btnHome = (Button)findViewById(R.id.food_home);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentHome = new Intent();
                intentHome.setClassName("com.example.okadayosuke.myapplication", "com.example.okadayosuke.myapplication.MainActivity");

                startActivity(intentHome);
            }
        });

        Button btnSetting = (Button)findViewById(R.id.food_setting);
        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSetting = new Intent();
                intentSetting.setClassName("com.example.okadayosuke.myapplication", "com.example.okadayosuke.myapplication.setting");

                startActivity(intentSetting);
            }
        });

        Button btnStock = (Button)findViewById(R.id.food_stock);
        btnStock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentStock = new Intent();
                intentStock.setClassName("com.example.okadayosuke.myapplication", "com.example.okadayosuke.myapplication.stock");

                startActivity(intentStock);
            }
        });


        //  ポップアップ（ダイアログ）の作成
        ImageButton btnReRice = (ImageButton)findViewById(R.id.popup_food_retorutogohan);
        btnReRice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertReRice = new AlertDialog.Builder(food.this);
                alertReRice.setTitle("レトルトご飯");

                LayoutInflater inflater = LayoutInflater.from(food.this);
                final View vReRice = inflater.inflate(R.layout.activity_food_pop_rerice, null);

                //  プリファレンスの作成S
                SharedPreferences prefReRice = getSharedPreferences("Preferences", MODE_PRIVATE);

                int i = 0;
                i = prefReRice.getInt("key_ReRice", 0);

                int adult = 0;
                adult = prefReRice.getInt("key_adult", adult);

                int kids = 0;
                kids = prefReRice.getInt("key_kids", kids);

                int baby = 0;
                baby = prefReRice.getInt("key_baby", baby);

                String str = String.valueOf(i);
                String strAdult = String.valueOf(adult);
                String strKids = String.valueOf(kids);
                String strBaby = String.valueOf(baby);

                //  必ずView変換で作成したデータを使うこと
                EditText et = (EditText)vReRice.findViewById(R.id.input_ReRice);
                TextView tAdult = (TextView)vReRice.findViewById(R.id.rerice_adult);
                TextView tKids = (TextView)vReRice.findViewById(R.id.rerice_kids);
                TextView tBaby = (TextView)vReRice.findViewById(R.id.rerice_baby);

                //  はいっちゃう（変数内に保存される）
                et.setText(str);
                tAdult.setText(strAdult);
                tKids.setText(strKids);
                tBaby.setText(strBaby);

                //  ポップアップ内の日付表示
                TextView tw = (TextView)vReRice.findViewById(R.id.date_rerice);
                Calendar cal = Calendar.getInstance();

                tw.setText(cal.get(Calendar.YEAR) + "年"
                        + (cal.get(Calendar.MONTH)+1) + "月"
                        +  cal.get(Calendar.DATE) + "日");

                //  プリファレンスの作成E

                //  ダイアログ内での保存S
                alertReRice.setPositiveButton("保存", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences prefReRice;
                        prefReRice = getSharedPreferences("Preferences", MODE_PRIVATE);

                        SharedPreferences.Editor e = prefReRice.edit();

                        EditText etReRice = (EditText)vReRice.findViewById(R.id.input_ReRice);
                        String strReRice = etReRice.getText().toString();

                        if(strReRice.length() <= 0){
                            strReRice = "0";
                        }

                        int i = Integer.parseInt(strReRice);

                        e.putInt("key_ReRice", i);
                        e.commit();

                        dialog.dismiss();
                    }
                });

                //  ダイアログ内での保存E

                alertReRice.setView(vReRice);
                alertReRice.show();

            }
        });

        //  ポップアップ（ダイアログ）の作成
        ImageButton btnKandume = (ImageButton)findViewById(R.id.popup_food_kandume);
        btnKandume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertKandume = new AlertDialog.Builder(food.this);
                alertKandume.setTitle("缶詰（ご飯）");

                LayoutInflater inflater = LayoutInflater.from(food.this);
                final View vKandume = inflater.inflate(R.layout.activity_food_pop_kandume, null);

                //  プリファレンスの作成S
                SharedPreferences prefKandume = getSharedPreferences("Preferences", MODE_PRIVATE);

                int i = 0;
                i = prefKandume.getInt("key_kandume", 0);
                String str = String.valueOf(i);

                //  必ずView変換で作成したデータを使うこと
                EditText et = (EditText)vKandume.findViewById(R.id.input_kandume);

                //  はいっちゃう（変数内に保存される）
                et.setText(str);

                //  のちに整理すること
                int adult = 0;
                adult = prefKandume.getInt("key_adult", adult);

                int kids = 0;
                kids = prefKandume.getInt("key_kids", kids);

                int baby = 0;
                baby = prefKandume.getInt("key_baby", baby);

                String strAdult = String.valueOf(adult);
                String strKids = String.valueOf(kids);
                String strBaby = String.valueOf(baby);

                TextView tAdult = (TextView)vKandume.findViewById(R.id.kandume_adult);
                TextView tKids = (TextView)vKandume.findViewById(R.id.kandume_kids);
                TextView tBaby = (TextView)vKandume.findViewById(R.id.kandume_baby);

                tAdult.setText(strAdult);
                tKids.setText(strKids);
                tBaby.setText(strBaby);

                //  ポップアップ内の日付表示
                TextView tw = (TextView)vKandume.findViewById(R.id.date_kandume);
                Calendar cal = Calendar.getInstance();

                tw.setText(cal.get(Calendar.YEAR) + "年"
                        + (cal.get(Calendar.MONTH)+1) + "月"
                        +  cal.get(Calendar.DATE) + "日");


                //  プリファレンスの作成E

                //  ダイアログ内での保存S
                alertKandume.setPositiveButton("保存", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences prefKandume;
                        prefKandume = getSharedPreferences("Preferences", MODE_PRIVATE);

                        SharedPreferences.Editor e = prefKandume.edit();

                        EditText etKandume = (EditText)vKandume.findViewById(R.id.input_kandume);
                        String strKandume = etKandume.getText().toString();

                        if(strKandume.length() <= 0){
                            strKandume = "0";
                        }

                        int i = Integer.parseInt(strKandume);

                        e.putInt("key_kandume", i);
                        e.commit();

                        dialog.dismiss();
                    }
                });

                //  ダイアログ内での保存E

                alertKandume.setView(vKandume);
                alertKandume.show();

            }
        });


        //  ポップアップ（ダイアログ）の作成
        ImageButton btnKanpan = (ImageButton)findViewById(R.id.popup_food_kanpan);
        btnKanpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertKanpan = new AlertDialog.Builder(food.this);
                alertKanpan.setTitle("乾パン");

                LayoutInflater inflater = LayoutInflater.from(food.this);
                final View vKanpan = inflater.inflate(R.layout.activity_food_pop_kanpen, null);

                //  プリファレンスの作成S
                SharedPreferences prefKanpan = getSharedPreferences("Preferences", MODE_PRIVATE);

                int i = 0;
                i = prefKanpan.getInt("key_kanpan", 0);
                String str = String.valueOf(i);

                //  必ずView変換で作成したデータを使うこと
                EditText et = (EditText)vKanpan.findViewById(R.id.input_kanpan);

                //  はいっちゃう（変数内に保存される）
                et.setText(str);

                //  のちに整理すること
                int adult = 0;
                adult = prefKanpan.getInt("key_adult", adult);

                int kids = 0;
                kids = prefKanpan.getInt("key_kids", kids);

                int baby = 0;
                baby = prefKanpan.getInt("key_baby", baby);

                String strAdult = String.valueOf(adult);
                String strKids = String.valueOf(kids);
                String strBaby = String.valueOf(baby);

                TextView tAdult = (TextView)vKanpan.findViewById(R.id.kanpan_adult);
                TextView tKids = (TextView)vKanpan.findViewById(R.id.kanpan_kids);
                TextView tBaby = (TextView)vKanpan.findViewById(R.id.kanpan_baby);

                tAdult.setText(strAdult);
                tKids.setText(strKids);
                tBaby.setText(strBaby);

                //  ポップアップ内の日付表示
                TextView tw = (TextView)vKanpan.findViewById(R.id.date_kanpan);
                Calendar cal = Calendar.getInstance();

                tw.setText(cal.get(Calendar.YEAR) + "年"
                        + (cal.get(Calendar.MONTH)+1) + "月"
                        +  cal.get(Calendar.DATE) + "日");


                //  プリファレンスの作成E

                //  ダイアログ内での保存S
                alertKanpan.setPositiveButton("保存", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences prefKanpan;
                        prefKanpan = getSharedPreferences("Preferences", MODE_PRIVATE);

                        SharedPreferences.Editor e = prefKanpan.edit();

                        EditText etKanpan = (EditText)vKanpan.findViewById(R.id.input_kanpan);
                        String strKanpan = etKanpan.getText().toString();

                        if(strKanpan.length() <= 0){
                            strKanpan = "0";
                        }

                        int i = Integer.parseInt(strKanpan);

                        e.putInt("key_kanpan", i);
                        e.commit();

                        dialog.dismiss();
                    }
                });

                //  ダイアログ内での保存E

                alertKanpan.setView(vKanpan);
                alertKanpan.show();

            }
        });


        //  ポップアップ（ダイアログ）の作成
        ImageButton btnKanmen = (ImageButton)findViewById(R.id.popup_food_kanmen);
        btnKanmen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertKanmen = new AlertDialog.Builder(food.this);
                alertKanmen.setTitle("乾麺");

                LayoutInflater inflater = LayoutInflater.from(food.this);
                final View vKanmen = inflater.inflate(R.layout.activity_food_pop_kanmen, null);

                //  プリファレンスの作成S
                SharedPreferences prefKanmen = getSharedPreferences("Preferences", MODE_PRIVATE);

                int i = 0;
                i = prefKanmen.getInt("key_kanmen", 0);
                String str = String.valueOf(i);

                //  必ずView変換で作成したデータを使うこと
                EditText et = (EditText)vKanmen.findViewById(R.id.input_kanmen);

                //  はいっちゃう（変数内に保存される）
                et.setText(str);

                //  のちに整理すること
                int adult = 0;
                adult = prefKanmen.getInt("key_adult", adult);

                int kids = 0;
                kids = prefKanmen.getInt("key_kids", kids);

                int baby = 0;
                baby = prefKanmen.getInt("key_baby", baby);

                String strAdult = String.valueOf(adult);
                String strKids = String.valueOf(kids);
                String strBaby = String.valueOf(baby);

                TextView tAdult = (TextView)vKanmen.findViewById(R.id.kanmen_adult);
                TextView tKids = (TextView)vKanmen.findViewById(R.id.kanmen_kids);
                TextView tBaby = (TextView)vKanmen.findViewById(R.id.kanmen_baby);

                tAdult.setText(strAdult);
                tKids.setText(strKids);
                tBaby.setText(strBaby);

                //  ポップアップ内の日付表示
                TextView tw = (TextView)vKanmen.findViewById(R.id.date_kanmen);
                Calendar cal = Calendar.getInstance();

                tw.setText(cal.get(Calendar.YEAR) + "年"
                        + (cal.get(Calendar.MONTH)+1) + "月"
                        +  cal.get(Calendar.DATE) + "日");


                //  プリファレンスの作成E

                //  ダイアログ内での保存S
                alertKanmen.setPositiveButton("保存", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences prefKanmen;
                        prefKanmen = getSharedPreferences("Preferences", MODE_PRIVATE);

                        SharedPreferences.Editor e = prefKanmen.edit();

                        EditText etKanmen = (EditText)vKanmen.findViewById(R.id.input_kanmen);
                        String strKanmen = etKanmen.getText().toString();

                        if(strKanmen.length() <= 0){
                            strKanmen = "0";
                        }

                        int i = Integer.parseInt(strKanmen);

                        e.putInt("key_kanmen", i);
                        e.commit();

                        dialog.dismiss();
                    }
                });

                //  ダイアログ内での保存E

                alertKanmen.setView(vKanmen);
                alertKanmen.show();

            }
        });



        //  ポップアップ（ダイアログ）の作成
        ImageButton btnKandume2 = (ImageButton)findViewById(R.id.popup_food_kandume2);
        btnKandume2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertKandume2 = new AlertDialog.Builder(food.this);
                alertKandume2.setTitle("缶詰（肉・魚・野菜など）");

                LayoutInflater inflater = LayoutInflater.from(food.this);
                final View vKandume2 = inflater.inflate(R.layout.activity_food_pop_kandume2, null);

                //  プリファレンスの作成S
                SharedPreferences prefKandume2 = getSharedPreferences("Preferences", MODE_PRIVATE);

                int i = 0;
                i = prefKandume2.getInt("key_kandume2", 0);
                String str = String.valueOf(i);

                //  必ずView変換で作成したデータを使うこと
                EditText et = (EditText)vKandume2.findViewById(R.id.input_kandume2);

                //  はいっちゃう（変数内に保存される）
                et.setText(str);

                //  のちに整理すること
                int adult = 0;
                adult = prefKandume2.getInt("key_adult", adult);

                int kids = 0;
                kids = prefKandume2.getInt("key_kids", kids);

                int baby = 0;
                baby = prefKandume2.getInt("key_baby", baby);

                String strAdult = String.valueOf(adult);
                String strKids = String.valueOf(kids);
                String strBaby = String.valueOf(baby);

                TextView tAdult = (TextView)vKandume2.findViewById(R.id.kandume2_adult);
                TextView tKids = (TextView)vKandume2.findViewById(R.id.kandume2_kids);
                TextView tBaby = (TextView)vKandume2.findViewById(R.id.kandume2_baby);

                tAdult.setText(strAdult);
                tKids.setText(strKids);
                tBaby.setText(strBaby);

                //  ポップアップ内の日付表示
                TextView tw = (TextView)vKandume2.findViewById(R.id.date_kandume2);
                Calendar cal = Calendar.getInstance();

                tw.setText(cal.get(Calendar.YEAR) + "年"
                        + (cal.get(Calendar.MONTH)+1) + "月"
                        +  cal.get(Calendar.DATE) + "日");

                //  プリファレンスの作成E

                //  ダイアログ内での保存S
                alertKandume2.setPositiveButton("保存", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences prefKandume2;
                        prefKandume2 = getSharedPreferences("Preferences", MODE_PRIVATE);

                        SharedPreferences.Editor e = prefKandume2.edit();

                        EditText etKandume2 = (EditText)vKandume2.findViewById(R.id.input_kandume2);
                        String strKandume2 = etKandume2.getText().toString();

                        if(strKandume2.length() <= 0){
                            strKandume2 = "0";
                        }

                        int i = Integer.parseInt(strKandume2);

                        e.putInt("key_kandume2", i);
                        e.commit();

                        dialog.dismiss();
                    }
                });

                //  ダイアログ内での保存E

                alertKandume2.setView(vKandume2);
                alertKandume2.show();

            }
        });



        //  ポップアップ（ダイアログ）の作成
        ImageButton btnFurizzu = (ImageButton)findViewById(R.id.popup_food_furizzu);
        btnFurizzu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertFurizzu = new AlertDialog.Builder(food.this);
                alertFurizzu.setTitle("フリーズドライ");

                LayoutInflater inflater = LayoutInflater.from(food.this);
                final View vFurizzu = inflater.inflate(R.layout.activity_food_pop_furizzu, null);

                //  プリファレンスの作成S
                SharedPreferences prefFurizzu = getSharedPreferences("Preferences", MODE_PRIVATE);

                int i = 0;
                i = prefFurizzu.getInt("key_furizzu", 0);
                String str = String.valueOf(i);

                //  必ずView変換で作成したデータを使うこと
                EditText et = (EditText)vFurizzu.findViewById(R.id.input_furizzu);

                //  はいっちゃう（変数内に保存される）
                et.setText(str);

                //  のちに整理すること
                int adult = 0;
                adult = prefFurizzu.getInt("key_adult", adult);

                int kids = 0;
                kids = prefFurizzu.getInt("key_kids", kids);

                int baby = 0;
                baby = prefFurizzu.getInt("key_baby", baby);

                String strAdult = String.valueOf(adult);
                String strKids = String.valueOf(kids);
                String strBaby = String.valueOf(baby);

                TextView tAdult = (TextView)vFurizzu.findViewById(R.id.furizzu_adult);
                TextView tKids = (TextView)vFurizzu.findViewById(R.id.furizzu_kids);
                TextView tBaby = (TextView)vFurizzu.findViewById(R.id.furizzu_baby);

                tAdult.setText(strAdult);
                tKids.setText(strKids);
                tBaby.setText(strBaby);

                //  ポップアップ内の日付表示
                TextView tw = (TextView)vFurizzu.findViewById(R.id.date_furizzu);
                Calendar cal = Calendar.getInstance();

                tw.setText(cal.get(Calendar.YEAR) + "年"
                        + (cal.get(Calendar.MONTH)+1) + "月"
                        +  cal.get(Calendar.DATE) + "日");


                //  プリファレンスの作成E

                //  ダイアログ内での保存S
                alertFurizzu.setPositiveButton("保存", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences prefFurizzu;
                        prefFurizzu = getSharedPreferences("Preferences", MODE_PRIVATE);

                        SharedPreferences.Editor e = prefFurizzu.edit();

                        EditText etFurizzu = (EditText)vFurizzu.findViewById(R.id.input_furizzu);
                        String strFurizzu = etFurizzu.getText().toString();

                        if(strFurizzu.length() <= 0){
                            strFurizzu = "0";
                        }

                        int i = Integer.parseInt(strFurizzu);

                        e.putInt("key_furizzu", i);
                        e.commit();

                        dialog.dismiss();
                    }
                });

                //  ダイアログ内での保存E

                alertFurizzu.setView(vFurizzu);
                alertFurizzu.show();

            }
        });



        //  ポップアップ（ダイアログ）の作成
        ImageButton btnRetoruto = (ImageButton)findViewById(R.id.popup_food_retoruto);
        btnRetoruto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertRetoruto = new AlertDialog.Builder(food.this);
                alertRetoruto.setTitle("レトルト食品");

                LayoutInflater inflater = LayoutInflater.from(food.this);
                final View vRetoruto = inflater.inflate(R.layout.activity_food_pop_retoruto, null);

                //  プリファレンスの作成S
                SharedPreferences prefRetoruto = getSharedPreferences("Preferences", MODE_PRIVATE);

                int i = 0;
                i = prefRetoruto.getInt("key_retoruto", 0);
                String str = String.valueOf(i);

                //  必ずView変換で作成したデータを使うこと
                EditText et = (EditText)vRetoruto.findViewById(R.id.input_retoruto);

                //  はいっちゃう（変数内に保存される）
                et.setText(str);

                //  のちに整理すること
                int adult = 0;
                adult = prefRetoruto.getInt("key_adult", adult);

                int kids = 0;
                kids = prefRetoruto.getInt("key_kids", kids);

                int baby = 0;
                baby = prefRetoruto.getInt("key_baby", baby);

                String strAdult = String.valueOf(adult);
                String strKids = String.valueOf(kids);
                String strBaby = String.valueOf(baby);

                TextView tAdult = (TextView)vRetoruto.findViewById(R.id.retoruto_adult);
                TextView tKids = (TextView)vRetoruto.findViewById(R.id.retoruto_kids);
                TextView tBaby = (TextView)vRetoruto.findViewById(R.id.retoruto_baby);

                tAdult.setText(strAdult);
                tKids.setText(strKids);
                tBaby.setText(strBaby);

                //  ポップアップ内の日付表示
                TextView tw = (TextView)vRetoruto.findViewById(R.id.date_retoruto);
                Calendar cal = Calendar.getInstance();

                tw.setText(cal.get(Calendar.YEAR) + "年"
                        + (cal.get(Calendar.MONTH)+1) + "月"
                        +  cal.get(Calendar.DATE) + "日");

                //  プリファレンスの作成E

                //  ダイアログ内での保存S
                alertRetoruto.setPositiveButton("保存", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences prefRetoruto;
                        prefRetoruto = getSharedPreferences("Preferences", MODE_PRIVATE);

                        SharedPreferences.Editor e = prefRetoruto.edit();

                        EditText etRetoruto = (EditText)vRetoruto.findViewById(R.id.input_retoruto);
                        String strRetoruto = etRetoruto.getText().toString();

                        if(strRetoruto.length() <= 0){
                            strRetoruto = "0";
                        }

                        int i = Integer.parseInt(strRetoruto);

                        e.putInt("key_retoruto", i);
                        e.commit();

                        dialog.dismiss();
                    }
                });

                //  ダイアログ内での保存E

                alertRetoruto.setView(vRetoruto);
                alertRetoruto.show();

            }
        });


        //  ポップアップ（ダイアログ）の作成
        ImageButton btnMisu = (ImageButton)findViewById(R.id.popup_mizu);
        btnMisu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertMisu = new AlertDialog.Builder(food.this);
                alertMisu.setTitle("水");

                LayoutInflater inflater = LayoutInflater.from(food.this);
                final View vMisu = inflater.inflate(R.layout.activity_food_pop_mizu, null);

                //  プリファレンスの作成S
                SharedPreferences prefMisu = getSharedPreferences("Preferences", MODE_PRIVATE);

                int i = 0;
                i = prefMisu.getInt("key_mizu", 0);
                String str = String.valueOf(i);

                //  必ずView変換で作成したデータを使うこと
                EditText et = (EditText)vMisu.findViewById(R.id.input_mizu);

                //  はいっちゃう（変数内に保存される）
                et.setText(str);

                //  のちに整理すること
                int adult = 0;
                adult = prefMisu.getInt("key_adult", adult);

                int kids = 0;
                kids = prefMisu.getInt("key_kids", kids);

                int baby = 0;
                baby = prefMisu.getInt("key_baby", baby);

                String strAdult = String.valueOf(adult);
                String strKids = String.valueOf(kids);
                String strBaby = String.valueOf(baby);

                TextView tAdult = (TextView)vMisu.findViewById(R.id.mizu_adult);
                TextView tKids = (TextView)vMisu.findViewById(R.id.mizu_kids);
                TextView tBaby = (TextView)vMisu.findViewById(R.id.mizu_baby);

                tAdult.setText(strAdult);
                tKids.setText(strKids);
                tBaby.setText(strBaby);

                //  ポップアップ内の日付表示
                TextView tw = (TextView)vMisu.findViewById(R.id.date_mizu);
                Calendar cal = Calendar.getInstance();

                tw.setText(cal.get(Calendar.YEAR) + "年"
                        + (cal.get(Calendar.MONTH)+1) + "月"
                        +  cal.get(Calendar.DATE) + "日");

                //  プリファレンスの作成E

                //  ダイアログ内での保存S
                alertMisu.setPositiveButton("保存", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences prefMisu;
                        prefMisu = getSharedPreferences("Preferences", MODE_PRIVATE);

                        SharedPreferences.Editor e = prefMisu.edit();

                        EditText etMisu = (EditText)vMisu.findViewById(R.id.input_mizu);
                        String strMisu = etMisu.getText().toString();

                        if(strMisu.length() <= 0){
                            strMisu = "0";
                        }

                        int i = Integer.parseInt(strMisu);

                        e.putInt("key_mizu", i);
                        e.commit();

                        dialog.dismiss();
                    }
                });

                //  ダイアログ内での保存E

                alertMisu.setView(vMisu);
                alertMisu.show();

            }
        });



        //  ポップアップ（ダイアログ）の作成
        ImageButton btnDSonota = (ImageButton)findViewById(R.id.pop_desh_other);
        btnDSonota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDSonota = new AlertDialog.Builder(food.this);
                alertDSonota.setTitle("その他の主菜");

                LayoutInflater inflater = LayoutInflater.from(food.this);
                final View vDSonota = inflater.inflate(R.layout.activity_food_pop_dish_sonota, null);


                //  プリファレンスの作成S
                SharedPreferences prefDSonota = getSharedPreferences("Preferences", MODE_PRIVATE);

                int i = 0;
                i = prefDSonota.getInt("key_dsonota", 0);
                String str = String.valueOf(i);

                //  必ずView変換で作成したデータを使うこと
                EditText et = (EditText)vDSonota.findViewById(R.id.input_dish_sonota);

                //  はいっちゃう（変数内に保存される）
                et.setText(str);

                //  のちに整理すること
                int adult = 0;
                adult = prefDSonota.getInt("key_adult", adult);

                int kids = 0;
                kids = prefDSonota.getInt("key_kids", kids);

                int baby = 0;
                baby = prefDSonota.getInt("key_baby", baby);

                String strAdult = String.valueOf(adult);
                String strKids = String.valueOf(kids);
                String strBaby = String.valueOf(baby);

                TextView tAdult = (TextView)vDSonota.findViewById(R.id.sonota_adult);
                TextView tKids = (TextView)vDSonota.findViewById(R.id.sonota_kids);
                TextView tBaby = (TextView)vDSonota.findViewById(R.id.sonota_baby);

                tAdult.setText(strAdult);
                tKids.setText(strKids);
                tBaby.setText(strBaby);

                //  ポップアップ内の日付表示
                TextView tw = (TextView)vDSonota.findViewById(R.id.date_DSonota);
                Calendar cal = Calendar.getInstance();

                tw.setText(cal.get(Calendar.YEAR) + "年"
                        + (cal.get(Calendar.MONTH)+1) + "月"
                        +  cal.get(Calendar.DATE) + "日");

                //  プリファレンスの作成E

                //  ダイアログ内での保存S
                alertDSonota.setPositiveButton("保存", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences prefDSonota;
                        prefDSonota = getSharedPreferences("Preferences", MODE_PRIVATE);

                        SharedPreferences.Editor e = prefDSonota.edit();

                        EditText etDSonota = (EditText)vDSonota.findViewById(R.id.input_dish_sonota);
                        String strDSonota = etDSonota.getText().toString();

                        if(strDSonota.length() <= 0){
                            strDSonota = "0";
                        }

                        int i = Integer.parseInt(strDSonota);

                        e.putInt("key_dsonota", i);
                        e.commit();

                        dialog.dismiss();
                    }
                });

                //  ダイアログ内での保存E

                alertDSonota.setView(vDSonota);
                alertDSonota.show();

            }
        });



        //  ポップアップ（ダイアログ）の作成
        ImageButton btnPokari = (ImageButton)findViewById(R.id.popup_pokari);
        btnPokari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertPokari = new AlertDialog.Builder(food.this);
                alertPokari.setTitle("ポカリスエット粉末");

                LayoutInflater inflater = LayoutInflater.from(food.this);
                final View vPokari = inflater.inflate(R.layout.activity_food_pop_pokari, null);

                //  プリファレンスの作成S
                SharedPreferences prefPokari = getSharedPreferences("Preferences", MODE_PRIVATE);

                int i = 0;
                i = prefPokari.getInt("key_pokari", 0);
                String str = String.valueOf(i);

                //  必ずView変換で作成したデータを使うこと
                EditText et = (EditText)vPokari.findViewById(R.id.input_pokari);

                //  はいっちゃう（変数内に保存される）
                et.setText(str);

                //  のちに整理すること
                int adult = 0;
                adult = prefPokari.getInt("key_adult", adult);

                int kids = 0;
                kids = prefPokari.getInt("key_kids", kids);

                int baby = 0;
                baby = prefPokari.getInt("key_baby", baby);

                String strAdult = String.valueOf(adult);
                String strKids = String.valueOf(kids);
                String strBaby = String.valueOf(baby);

                TextView tAdult = (TextView)vPokari.findViewById(R.id.pokari_adult);
                TextView tKids = (TextView)vPokari.findViewById(R.id.pokari_kids);
                TextView tBaby = (TextView)vPokari.findViewById(R.id.pokari_baby);

                tAdult.setText(strAdult);
                tKids.setText(strKids);
                tBaby.setText(strBaby);

                //  ポップアップ内の日付表示
                TextView tw = (TextView)vPokari.findViewById(R.id.date_pokari);
                Calendar cal = Calendar.getInstance();

                tw.setText(cal.get(Calendar.YEAR) + "年"
                        + (cal.get(Calendar.MONTH)+1) + "月"
                        +  cal.get(Calendar.DATE) + "日");

                //  プリファレンスの作成E

                //  ダイアログ内での保存S
                alertPokari.setPositiveButton("保存", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences prefPokari;
                        prefPokari = getSharedPreferences("Preferences", MODE_PRIVATE);

                        SharedPreferences.Editor e = prefPokari.edit();

                        EditText etPokari = (EditText)vPokari.findViewById(R.id.input_pokari);
                        String strPokari = etPokari.getText().toString();

                        if(strPokari.length() <= 0){
                            strPokari = "0";
                        }

                        int i = Integer.parseInt(strPokari);

                        e.putInt("key_pokari", i);
                        e.commit();

                        dialog.dismiss();
                    }
                });

                //  ダイアログ内での保存E

                alertPokari.setView(vPokari);
                alertPokari.show();

            }
        });



        //  ポップアップ（ダイアログ）の作成
        ImageButton btnOkasi = (ImageButton)findViewById(R.id.popup_okasi);
        btnOkasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertOkasi = new AlertDialog.Builder(food.this);
                alertOkasi.setTitle("菓子類");

                LayoutInflater inflater = LayoutInflater.from(food.this);
                final View vOkasi = inflater.inflate(R.layout.activity_food_pop_okasi, null);

                //  プリファレンスの作成S
                SharedPreferences prefOkasi = getSharedPreferences("Preferences", MODE_PRIVATE);

                int i = 0;
                i = prefOkasi.getInt("key_okasi", 0);
                String str = String.valueOf(i);

                //  必ずView変換で作成したデータを使うこと
                EditText et = (EditText)vOkasi.findViewById(R.id.input_okasi);

                //  はいっちゃう（変数内に保存される）
                et.setText(str);

                //  のちに整理すること
                int adult = 0;
                adult = prefOkasi.getInt("key_adult", adult);

                int kids = 0;
                kids = prefOkasi.getInt("key_kids", kids);

                int baby = 0;
                baby = prefOkasi.getInt("key_baby", baby);

                String strAdult = String.valueOf(adult);
                String strKids = String.valueOf(kids);
                String strBaby = String.valueOf(baby);

                TextView tAdult = (TextView)vOkasi.findViewById(R.id.okasi_adult);
                TextView tKids = (TextView)vOkasi.findViewById(R.id.okasi_kids);
                TextView tBaby = (TextView)vOkasi.findViewById(R.id.okasi_baby);

                tAdult.setText(strAdult);
                tKids.setText(strKids);
                tBaby.setText(strBaby);

                //  ポップアップ内の日付表示
                TextView tw = (TextView)vOkasi.findViewById(R.id.date_okasi);
                Calendar cal = Calendar.getInstance();

                tw.setText(cal.get(Calendar.YEAR) + "年"
                        + (cal.get(Calendar.MONTH)+1) + "月"
                        +  cal.get(Calendar.DATE) + "日");

                //  プリファレンスの作成E

                //  ダイアログ内での保存S
                alertOkasi.setPositiveButton("保存", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences prefOkasi;
                        prefOkasi = getSharedPreferences("Preferences", MODE_PRIVATE);

                        SharedPreferences.Editor e = prefOkasi.edit();

                        EditText etOkasi = (EditText)vOkasi.findViewById(R.id.input_okasi);
                        String strOkasi = etOkasi.getText().toString();

                        if(strOkasi.length() <= 0){
                            strOkasi = "0";
                        }

                        int i = Integer.parseInt(strOkasi);

                        e.putInt("key_okasi", i);
                        e.commit();

                        dialog.dismiss();
                    }
                });

                //  ダイアログ内での保存E

                alertOkasi.setView(vOkasi);
                alertOkasi.show();

            }
        });



        //  ポップアップ（ダイアログ）の作成
        ImageButton btnKarori = (ImageButton)findViewById(R.id.popup_karori);
        btnKarori.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertKarori = new AlertDialog.Builder(food.this);
                alertKarori.setTitle("カロリーメイト");

                LayoutInflater inflater = LayoutInflater.from(food.this);
                final View vKarori = inflater.inflate(R.layout.activity_food_pop_karori, null);

                //  プリファレンスの作成S
                SharedPreferences prefKarori = getSharedPreferences("Preferences", MODE_PRIVATE);

                int i = 0;
                i = prefKarori.getInt("key_karori", 0);
                String str = String.valueOf(i);

                //  必ずView変換で作成したデータを使うこと
                EditText et = (EditText)vKarori.findViewById(R.id.input_karori);

                //  はいっちゃう（変数内に保存される）
                et.setText(str);

                //  のちに整理すること
                int adult = 0;
                adult = prefKarori.getInt("key_adult", adult);

                int kids = 0;
                kids = prefKarori.getInt("key_kids", kids);

                int baby = 0;
                baby = prefKarori.getInt("key_baby", baby);

                String strAdult = String.valueOf(adult);
                String strKids = String.valueOf(kids);
                String strBaby = String.valueOf(baby);

                TextView tAdult = (TextView)vKarori.findViewById(R.id.karori_adult);
                TextView tKids = (TextView)vKarori.findViewById(R.id.karori_kids);
                TextView tBaby = (TextView)vKarori.findViewById(R.id.karori_baby);

                tAdult.setText(strAdult);
                tKids.setText(strKids);
                tBaby.setText(strBaby);

                //  ポップアップ内の日付表示
                TextView tw = (TextView)vKarori.findViewById(R.id.date_karori);
                Calendar cal = Calendar.getInstance();

                tw.setText(cal.get(Calendar.YEAR) + "年"
                        + (cal.get(Calendar.MONTH)+1) + "月"
                        +  cal.get(Calendar.DATE) + "日");

                //  プリファレンスの作成E

                //  ダイアログ内での保存S
                alertKarori.setPositiveButton("保存", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences prefKarori;
                        prefKarori = getSharedPreferences("Preferences", MODE_PRIVATE);

                        SharedPreferences.Editor e = prefKarori.edit();

                        EditText etKarori = (EditText)vKarori.findViewById(R.id.input_karori);
                        String strKarori = etKarori.getText().toString();

                        if(strKarori.length() <= 0){
                            strKarori = "0";
                        }

                        int i = Integer.parseInt(strKarori);

                        e.putInt("key_karori", i);
                        e.commit();

                        dialog.dismiss();
                    }
                });

                //  ダイアログ内での保存E

                alertKarori.setView(vKarori);
                alertKarori.show();

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_food, menu);
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
