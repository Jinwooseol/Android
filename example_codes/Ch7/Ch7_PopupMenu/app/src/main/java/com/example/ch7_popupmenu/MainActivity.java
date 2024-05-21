package com.example.ch7_popupmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private boolean isSubMenu = false;
    private View anchorButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anchorButton = findViewById(R.id.button);
    }

    public void onClick(View view) {
        showPopupMenu();
    }

    private void showPopupMenu() {
        PopupMenu popup = new PopupMenu(this, anchorButton);
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                             @Override
                                             public boolean onMenuItemClick(MenuItem item) {
                                                 return handleMenuItemClick(item);
                                             }
                                         }
        );
        if (isSubMenu) {
            popup.getMenuInflater().inflate(R.menu.popup_submenu, popup.getMenu());
        } else {
            popup.getMenuInflater().inflate(R.menu.popup, popup.getMenu());
        }
        popup.show();
    }

    private boolean handleMenuItemClick(MenuItem item) {
        if (item.getItemId() == R.id.edit) {
            isSubMenu = true;
            showPopupMenu();
            return true;
        } else if (item.getItemId() == R.id.back) {
            isSubMenu = false;
            showPopupMenu();
            return true;
        } else if (item.getItemId() == R.id.add ||
                item.getItemId() == R.id.search ||
                item.getItemId() == R.id.share) {
            return true;
        } else {
            return false;
        }
    }
}