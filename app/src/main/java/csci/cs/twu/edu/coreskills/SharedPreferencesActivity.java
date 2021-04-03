package csci.cs.twu.edu.coreskills;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**

 Assignment Notes: For this activity, the user should be able to
 save and load the username and computing ID from SharedPreferences,
 the key/value store built into Android.

 Reference:
 https://gitlab.com/csci3313sp20/storageexample-master

 */

public class SharedPreferencesActivity extends AppCompatActivity {

    public static final String PREFS_NAME = "CoreSkillsPrefsFile";

    EditText spnameEditText;
    EditText spcompIDEditText;

    TextView spnameTextView;
    TextView spcompIDTextView;
    SharedPreferences sharedPreferences;
    String spnameStr, spcompStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        spnameEditText = (EditText) findViewById(R.id.spnameEditText);
        spcompIDEditText = (EditText) findViewById(R.id.spcompIDEditText);

        spnameTextView = (TextView) findViewById(R.id.spnameTextView);
        spcompIDTextView = (TextView) findViewById(R.id.spcompIDTextView);

        sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public void saveToSharedPreferences(View view) {

        // Add your code here to save
        spnameStr = spnameEditText.getText().toString();
        spcompStr = spcompIDEditText.getText().toString();

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name", spnameStr);
        editor.putString("id", spcompStr);
        editor.commit();


        Toast.makeText(this,"Saved to Share Preferences, Please press load button to load the name and id", Toast.LENGTH_SHORT).show();




    }

    public void loadFromSharedPreferences(View view) {

        // Add your code here to load


        SharedPreferences sp = getApplicationContext().getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE);
        String name = sp.getString("name","");
        String id = sp.getString("id", "");
        spnameTextView.setText(name);
        spcompIDTextView.setText(id);




    }
}
