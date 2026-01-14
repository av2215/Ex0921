package com.example.ex0921;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

/**
 * @author Itay Vaknin <itayvaknin2424@gmail.com>
 * @version 1.0
 * @since 2026-01-14
 * The main activity of the application.
 */
public class MainActivity extends AppCompatActivity {
    Intent si;
    LinearLayout layout;
    AlertDialog.Builder adb;
    final Random rnd=new Random();


    /**
     * Initializes the activity..
     * <p>
     * This method is called when the activity is first created. It sets up the user interface,
     * initializes the layout and the intent for the credits screen.
     *
     * @param savedInstanceState If the activity is being re-initialized after
     *                           previously being shut down then this Bundle contains the data it most
     *                           recently supplied in onSaveInstanceState(Bundle).
     *                           <b>Note: Otherwise it is null.</b>
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        si=new Intent(this,CreditsActivity.class);
        layout = findViewById(R.id.main);
    }

    /**
     * Creates the options menu.
     * <p>
     * This method inflates the menu resource file to create the options menu.
     *
     * @param menu The options menu in which you place your items.
     * @return You must return true for the menu to be displayed; if you return false it will not be shown.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * Handles options menu item selections.
     * <p>
     * This method is called when a menu item is selected. It checks which item was
     * selected and performs the appropriate action.
     *
     * @param item The menu item that was selected.
     * @return boolean Return false to allow normal menu processing to
     *         proceed, true to consume it here.
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.credit)
        {
            startActivity(si);
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Displays a simple alert dialog with a message.
     * <p>
     * This method is called when the "message" button is clicked.
     *
     * @param view The button view that was clicked.
     */
    public void message(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("message only");
        adb.setMessage("this is a simple message");
        AlertDialog ad = adb.create();
        ad.show();
    }

    /**
     * Displays an alert dialog with an icon and a message.
     * <p>
     * This method is called when the "icon" button is clicked.
     *
     * @param view The button view that was clicked.
     */
    public void icon(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("icon");
        adb.setMessage("this is a simple message with icon");
        adb.setIcon(R.drawable.icon);
        AlertDialog ad = adb.create();
        ad.show();
    }

    /**
     * Displays an alert dialog with an icon, a message, and a close button.
     * <p>
     * This method is called when the "cancel" button is clicked. The dialog cannot be dismissed by tapping outside of it.
     *
     * @param view The button view that was clicked.
     */
    public void cancel(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("cancel");
        adb.setMessage("this is a simple message with icon and cancel button");
        adb.setIcon(R.drawable.icon);
        adb.setNegativeButton("close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        adb.setCancelable(false);
        AlertDialog ad = adb.create();
        ad.show();
    }

    /**
     * Displays an alert dialog with an icon, a message, and a close button.
     * <p>
     * This method is called when the "cancel" button is clicked. The dialog cannot be dismissed by tapping outside of it.
     *
     * @param view The button view that was clicked.
     */
    public void changeColor(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("change color");
        adb.setMessage("change background color");
        adb.setPositiveButton("change", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                layout.setBackgroundColor(Color.rgb(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
            }
        });
        adb.setNegativeButton("close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        adb.setCancelable(false);
        AlertDialog ad = adb.create();
        ad.show();
    }

    /**
     * Displays an alert dialog to change or reset the background color.
     * <p>
     * This method is called when the "changeReset" button is clicked. The dialog has a button to set a random
     * background color, a button to reset the color to white, and a close button. The dialog
     * cannot be dismissed by tapping outside of it.
     *
     * @param view The button view that was clicked.
     */
    public void changeReset(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("change and reset");
        adb.setMessage("change background color or reset to white");
        adb.setPositiveButton("change", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                layout.setBackgroundColor(Color.rgb(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
            }
        });
        adb.setNeutralButton("reset", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                layout.setBackgroundColor(Color.WHITE);
            }
        });
        adb.setNegativeButton("close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        adb.setCancelable(false);
        AlertDialog ad = adb.create();
        ad.show();
    }
}