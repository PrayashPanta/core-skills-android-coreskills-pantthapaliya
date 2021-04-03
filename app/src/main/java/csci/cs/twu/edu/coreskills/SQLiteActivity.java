package csci.cs.twu.edu.coreskills;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

    DatabaseHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        nameEditText = (EditText) findViewById(R.id.nameEditText);
        compIDEditText = (EditText) findViewById(R.id.compIDEditText);

        nameTextView = (TextView) findViewById(R.id.nameTextView);
        compIDTextView = (TextView) findViewById(R.id.compIDTextView);
        DB = new DatabaseHelper(this);

    }

    public void saveToDatabase(View view) {
        // Add code here to save to the database

        String nameText = nameEditText.getText().toString();
        String compId = compIDEditText.getText().toString();

        Boolean checkInsertData = DB.insertuserdata(compId,nameText);
        if (checkInsertData == true){
            Toast.makeText(this, "New Data Added",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "Not Inserted", Toast.LENGTH_SHORT).show();
        }


    }

    public void loadFromDatabase(View view) {

        // Add code here to load from the database

        Cursor res = DB.getdata();
        if (res.getCount()==0){
            Toast.makeText(this, "No Data Exists", Toast.LENGTH_SHORT).show();
            return;
        }

        nameTextView.setText(res.getString(1));
        compIDTextView.setText(res.getString(0));



    }
}
