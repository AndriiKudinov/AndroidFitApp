package com.example.demon.diplom;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SquatsActivity extends AppCompatActivity implements View.OnClickListener {

    TextView weekText;
    TextView quantText;
    TextView ex1, ex2, ex3, ex4, ex5, exMain;
    ProgressBar progress;
    int total = 100;
    CountDownTimer cdt;
    private int exCounter = 2;
    Button ready_button, finish_button;
    Button minus, plus;
    SharedPreferences pref1;
    SharedPreferences pref2;
    SharedPreferences pref3;
    SharedPreferences pref4, pref5, pref6;
    int weekNum = 1, dayNum = 1;
    int ex1Int;
    int ex2Int;
    int ex3Int;
    int ex4Int;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_squats);
        weekText = findViewById(R.id.squats_text1);
        weekText.setGravity(Gravity.CENTER);
        quantText = findViewById(R.id.squats_text2);
        quantText.setGravity(Gravity.CENTER);

        ex1 = findViewById(R.id.squats_ex_text1);
        ex2 = findViewById(R.id.squats_ex_text2);
        ex3 = findViewById(R.id.squats_ex_text3);
        ex4 = findViewById(R.id.squats_ex_text4);
        ex5 = findViewById(R.id.squats_ex_text5);
        minus = findViewById(R.id.squats_button);
        minus.setOnClickListener(this);
        plus = findViewById(R.id.squats_button2);
        plus.setOnClickListener(this);
        load_ex();

        weekText.setText(String.format("Неделя %d - День %d", weekNum, dayNum));
        exMain = findViewById(R.id.squats_text3);
        exMain.setText(String.format("%d", Integer.parseInt(ex1.getText().toString())));
        ready_button = findViewById(R.id.squats_text4);
        ready_button.setOnClickListener(this);
        finish_button = findViewById(R.id.squats_button3);
        finish_button.setOnClickListener(this);

        progress = (ProgressBar) findViewById(R.id.squats_Progress);
        progress.setProgress(total);

        ex1.setTextColor(0xff00ddff);
        ex1.setBackgroundColor(0xffffffff);

        int oneMin= 1 * 60 * 1000; // 1 minute in milli seconds

        /* CountDownTimer starts with 1 minutes and every onTick is 1 second */
        cdt = new CountDownTimer(oneMin, 1000) {

            public void onTick(long millisUntilFinished) {

                total = (int) (millisUntilFinished/ 600);
                progress.setProgress(total);
            }

            public void onFinish() {
                progress.setProgress(100);
            }
        };
    }

    @Override
    protected void onStart() {
        super.onStart();
        load_ex();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.squats_text4:
                switch (exCounter) {
                    case 1:
                        ex1.setTextColor(0xff00ddff);
                        ex1.setBackgroundColor(0xffffffff);
                        ex2.setTextColor(0xffffffff);
                        ex2.setBackgroundColor(0xff00ddff);
                        ex3.setTextColor(0xffffffff);
                        ex3.setBackgroundColor(0xff00ddff);
                        ex4.setTextColor(0xffffffff);
                        ex4.setBackgroundColor(0xff00ddff);
                        ex5.setTextColor(0xffffffff);
                        ex5.setBackgroundColor(0xff00ddff);
                        exMain.setText(String.format("%d", (Integer.parseInt(ex1.getText().toString()))));
                        break;
                    case 2:
                        ex2.setTextColor(0xff00ddff);
                        ex2.setBackgroundColor(0xffffffff);
                        ex1.setTextColor(0xffffffff);
                        ex1.setBackgroundColor(0xff00ddff);
                        ex3.setTextColor(0xffffffff);
                        ex3.setBackgroundColor(0xff00ddff);
                        ex4.setTextColor(0xffffffff);
                        ex4.setBackgroundColor(0xff00ddff);
                        ex5.setTextColor(0xffffffff);
                        ex5.setBackgroundColor(0xff00ddff);
                        exMain.setText(String.format("%d", (Integer.parseInt(ex2.getText().toString()))));
                        break;
                    case 3:
                        ex3.setTextColor(0xff00ddff);
                        ex3.setBackgroundColor(0xffffffff);
                        ex2.setTextColor(0xffffffff);
                        ex2.setBackgroundColor(0xff00ddff);
                        ex1.setTextColor(0xffffffff);
                        ex1.setBackgroundColor(0xff00ddff);
                        ex4.setTextColor(0xffffffff);
                        ex4.setBackgroundColor(0xff00ddff);
                        ex5.setTextColor(0xffffffff);
                        ex5.setBackgroundColor(0xff00ddff);
                        exMain.setText(String.format("%d", (Integer.parseInt(ex3.getText().toString()))));
                        break;
                    case 4:
                        ex4.setTextColor(0xff00ddff);
                        ex4.setBackgroundColor(0xffffffff);
                        ex2.setTextColor(0xffffffff);
                        ex2.setBackgroundColor(0xff00ddff);
                        ex3.setTextColor(0xffffffff);
                        ex3.setBackgroundColor(0xff00ddff);
                        ex1.setTextColor(0xffffffff);
                        ex1.setBackgroundColor(0xff00ddff);
                        ex5.setTextColor(0xffffffff);
                        ex5.setBackgroundColor(0xff00ddff);
                        exMain.setText(String.format("%d", (Integer.parseInt(ex4.getText().toString()))));
                        break;
                    case 5:
                        ex5.setTextColor(0xff00ddff);
                        ex5.setBackgroundColor(0xffffffff);
                        ex2.setTextColor(0xffffffff);
                        ex2.setBackgroundColor(0xff00ddff);
                        ex3.setTextColor(0xffffffff);
                        ex3.setBackgroundColor(0xff00ddff);
                        ex4.setTextColor(0xffffffff);
                        ex4.setBackgroundColor(0xff00ddff);
                        ex1.setTextColor(0xffffffff);
                        ex1.setBackgroundColor(0xff00ddff);
                        exMain.setText("8+");
                        break;
                    default:
                        ex1.setTextColor(0xff00ddff);
                        ex1.setBackgroundColor(0xffffffff);
                        ex2.setTextColor(0xffffffff);
                        ex2.setBackgroundColor(0xff00ddff);
                        ex3.setTextColor(0xffffffff);
                        ex3.setBackgroundColor(0xff00ddff);
                        ex4.setTextColor(0xffffffff);
                        ex4.setBackgroundColor(0xff00ddff);
                        ex5.setTextColor(0xffffffff);
                        ex5.setBackgroundColor(0xff00ddff);

                        dayNum++;
                        if(dayNum>3){
                            change_ex();
                            weekNum++;
                            dayNum = 1;
                        }

                        weekText.setText(String.format("Неделя %d - День %d", weekNum, dayNum));

                        save_ex();

                        exCounter = 1;
                        exMain.setText(String.format("%d", (Integer.parseInt(ex1.getText().toString()))));
                        AlertDialog.Builder builder = new AlertDialog.Builder(SquatsActivity.this);
                        builder.setTitle("Тренировка закончена!")
                                .setIcon(R.drawable.heart)
                                .setCancelable(false)
                                .setNegativeButton("ОК",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                dialog.cancel();
                                                SquatsActivity.this.finish();
                                            }
                                        });
                        AlertDialog alert = builder.create();
                        alert.show();
                        break;
                }
                cdt.start();
                exCounter++;
                break;
            case R.id.squats_button:

                if(Integer.parseInt(ex1.getText().toString()) > 13){
                    ex1Int = Integer.parseInt(ex1.getText().toString()) - 1;
                    ex1.setText(String.format("%d", ex1Int));
                    ex2Int = Integer.parseInt(ex2.getText().toString()) - 1;
                    ex2.setText(String.format("%d", ex2Int));
                    ex3Int = Integer.parseInt(ex3.getText().toString()) - 1;
                    ex3.setText(String.format("%d", ex3Int));
                    ex4Int = Integer.parseInt(ex4.getText().toString()) - 1;
                    ex4.setText(String.format("%d", ex4Int));
                    exMain.setText(String.format("%d", (Integer.parseInt(exMain.getText().toString()) - 1)));
                    save_ex();
                }
                break;
            case  R.id.squats_button2:

                ex1Int = Integer.parseInt(ex1.getText().toString()) + 1;
                ex1.setText(String.format("%d", ex1Int));
                ex2Int = Integer.parseInt(ex2.getText().toString()) + 1;
                ex2.setText(String.format("%d", ex2Int));
                ex3Int = Integer.parseInt(ex3.getText().toString()) + 1;
                ex3.setText(String.format("%d", ex3Int));
                ex4Int = Integer.parseInt(ex4.getText().toString()) + 1;
                ex4.setText(String.format("%d", ex4Int));
                exMain.setText(String.format("%d", (Integer.parseInt(exMain.getText().toString()) + 1)));
                save_ex();
                break;
            case R.id.squats_button3:
                finish();
                break;
            default:
                break;
        }

    }

    public void change_ex(){
        ex1Int = Integer.parseInt(ex1.getText().toString()) + 2;
        ex1.setText(String.format("%d", ex1Int));
        ex2Int = Integer.parseInt(ex2.getText().toString()) + 2;
        ex2.setText(String.format("%d", ex2Int));
        ex3Int = Integer.parseInt(ex3.getText().toString()) + 2;
        ex3.setText(String.format("%d", ex3Int));
        ex4Int = Integer.parseInt(ex4.getText().toString()) + 2;
        ex4.setText(String.format("%d", ex4Int));
    }

    void save_ex(){
        pref1 = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor1 = pref1.edit();
        editor1.putString("ex1_Text_squats", ex1.getText().toString());
        editor1.commit();
        pref2 = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor2 = pref2.edit();
        editor2.putString("ex2_Text_squats", ex2.getText().toString());
        editor2.commit();
        pref3 = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor3 = pref3.edit();
        editor3.putString("ex3_Text_squats", ex3.getText().toString());
        editor3.commit();
        pref4 = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor4 = pref4.edit();
        editor4.putString("ex4_Text_squats", ex4.getText().toString());
        editor4.commit();
        pref5 = getSharedPreferences("days", MODE_PRIVATE);
        SharedPreferences.Editor editor5 = pref5.edit();
        editor5.putInt("week_num_squats", weekNum);
        editor5.commit();
        pref6 = getSharedPreferences("days", MODE_PRIVATE);
        SharedPreferences.Editor editor6 = pref6.edit();
        editor6.putInt("day_num_squats", dayNum);
        editor6.commit();
    }

    void load_ex(){
        pref1 = getPreferences(MODE_PRIVATE);
        String savedEx1Text = pref1.getString("ex1_Text_squats", "14");
        ex1.setText(savedEx1Text);
        pref2 = getPreferences(MODE_PRIVATE);
        String savedEx2Text = pref2.getString("ex2_Text_squats", "16");
        ex2.setText(savedEx2Text);
        pref3 = getPreferences(MODE_PRIVATE);
        String savedEx3Text = pref3.getString("ex3_Text_squats", "17");
        ex3.setText(savedEx3Text);
        pref4 = getPreferences(MODE_PRIVATE);
        String savedEx4Text = pref4.getString("ex4_Text_squats", "14");
        ex4.setText(savedEx4Text);
        pref5 = getSharedPreferences("days", MODE_PRIVATE);
        int savedWeek = pref5.getInt("week_num_squats", 1);
        weekNum = savedWeek;
        pref4 = getSharedPreferences("days", MODE_PRIVATE);
        int savedDay = pref5.getInt("day_num_squats", 1);
        dayNum = savedDay;
    }
}
