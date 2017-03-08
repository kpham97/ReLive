package edu.uw.ischool.maga.relive;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.prefs.Preferences;

public class MainActivity extends AppCompatActivity implements FacebookLoginFragment.OnFragmentInteractionListener {

    private Fragment fragment; //Facebook Log In Fragment

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainApp main = new MainApp();
        /*Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        */

        fragment = FacebookLoginFragment.newInstance();

        android.support.v4.app.FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
        tx.replace(R.id.login, fragment);
        tx.commit();

        android.support.v4.app.FragmentManager fragManager = getSupportFragmentManager();
        fragManager.beginTransaction()
                .replace(R.id.quizButtons,new QuizSelectFragment())
                .commit();

    }

    @Override
    public void onFragmentInteraction(Uri uri){

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_preferences:
                Intent i = new Intent(MainActivity.this, AppPreferences.class);
                startActivity(i);
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}
