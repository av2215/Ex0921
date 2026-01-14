package com.example.ex0921;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
/**
 * @author Itay Vaknin <itayvaknin2424@gmail.com>
 * @version 1.0
 * @since 2026-01-14
 * The credits activity of the application.
 */
public class CreditsActivity extends AppCompatActivity {

    /**
     * Initializes the activity.
     * <p>
     * This method is called when the activity is first created. It sets up the user interface
     * for the credits screen.
     *
     * @param savedInstanceState If the activity is being re-initialized after
     *                           previously being shut down then this Bundle contains the data it most
     *                           recently supplied in onSaveInstanceState(Bundle).
     *                           <b>Note: Otherwise it is null.</b>
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
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
     * This method is called when a menu item is selected. It checks if the 'back' button was
     * selected and if so, finishes the activity.
     *
     * @param item The menu item that was selected.
     * @return boolean Return false to allow normal menu processing to
     *         proceed, true to consume it here.
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.back)
        {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}