package com.example.ch7_alertdialogtest2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private String selectedDrink = "커피";
    private int tempWhich = 0;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        Button showDialogButton = findViewById(R.id.button);
        showDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDrinkSelectionDialog();
            }
        });
    }

    private void showDrinkSelectionDialog() {
        final String[] drinks = {"커피", "티", "밀크"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("음료 선택").setSingleChoiceItems(drinks, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tempWhich = which;
                    }
                }).setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        selectedDrink = drinks[tempWhich];
                        if (tempWhich == 0) {
                            imageView.setImageResource(R.drawable.coffee);
                        } else if (tempWhich == 1) {
                            imageView.setImageResource(R.drawable.tea);
                        } else if (tempWhich == 2) {
                            imageView.setImageResource(R.drawable.milk);
                        }
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        builder.create().show();
    }
}