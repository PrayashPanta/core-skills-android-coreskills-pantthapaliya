package csci.cs.twu.edu.coreskills;

<<<<<<< HEAD
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
=======
import androidx.appcompat.app.AppCompatActivity;import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
>>>>>>> 4a146dc433d2f6d0843c823b7da145b19d603cc7

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

<<<<<<< HEAD
    DatabaseHelper DB;


=======
>>>>>>> 4a146dc433d2f6d0843c823b7da145b19d603cc7
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        nameEditText = (EditText) findViewById(R.id.nameEditText);
        compIDEditText = (EditText) findViewById(R.id.compIDEditText);

        nameTextView = (TextView) findViewById(R.id.nameTextView);
        compIDTextView = (TextView) findViewById(R.id.compIDTextView);
<<<<<<< HEAD
        DB = new DatabaseHelper(this);
=======
>>>>>>> 4a146dc433d2f6d0843c823b7da145b19d603cc7

    }

    public void saveToDatabase(View view) {
        // Add code here to save to the database

<<<<<<< HEAD
        String nameText = nameEditText.getText().toString();
        String compId = compIDEditText.getText().toString();

        Boolean checkInsertData = DB.insertuserdata(compId,nameText);
        if (checkInsertData == true){
            Toast.makeText(this, "New Data Added",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "Not Inserted", Toast.LENGTH_SHORT).show();
        }


=======
>>>>>>> 4a146dc433d2f6d0843c823b7da145b19d603cc7
    }

    public void loadFromDatabase(View view) {

        // Add code here to load from the database

<<<<<<< HEAD
        Cursor res = DB.getdata();
        if (res.getCount()==0){
            Toast.makeText(this, "No Data Exists", Toast.LENGTH_SHORT).show();
            return;
        }

        nameTextView.setText(res.getString(1));
        compIDTextView.setText(res.getString(0));



=======
>>>>>>> 4a146dc433d2f6d0843c823b7da145b19d603cc7
    }
}
