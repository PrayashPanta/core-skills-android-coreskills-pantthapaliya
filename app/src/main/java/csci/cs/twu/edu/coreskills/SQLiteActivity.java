package csci.cs.twu.edu.coreskills;

import androidx.appcompat.app.AppCompatActivity;import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**

 Assignment Notes: For this activity, the user should be able to
 save and load the username and computing ID from SQLite.  Several
 helper classes (DatabaseHelper and Section) are included to make
 this a bit easier.

 NOTE: YOU MUST ONLY SHOW THE LAST RECORD FROM THE DATABASE.  i.e.
 the record that was most recently added!

 Reference:
 https://developer.android.com/training/basics/data-storage/databases.html

 */

public class SQLiteActivity extends AppCompatActivity {

    EditText nameEditText;
    EditText compIDEditText;

    TextView nameTextView;
    TextView compIDTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        nameEditText = (EditText) findViewById(R.id.nameEditText);
        compIDEditText = (EditText) findViewById(R.id.compIDEditText);

        nameTextView = (TextView) findViewById(R.id.nameTextView);
        compIDTextView = (TextView) findViewById(R.id.compIDTextView);

    }

    public void saveToDatabase(View view) {
        // Add code here to save to the database

    }

    public void loadFromDatabase(View view) {

        // Add code here to load from the database

    }
}
