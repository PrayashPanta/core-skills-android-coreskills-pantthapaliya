package csci.cs.twu.edu.coreskills;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Map;
/**

Assignment Notes: This activity should pull data from Firebase Firestore based upon
the course requested in the EditText.  There are only 4 entries in the database, for example,
 CSCI 3313. Your app should be able to pull other 3 entries, for example, CSCI 1403.
 Your code should populate the three placeholder variables.

 Reference this material for guidance:
 Initialize an instance of Cloud Firestore
 https://firebase.google.com/docs/firestore/quickstart

 Get a Document
 https://firebase.google.com/docs/firestore/query-data/get-data

 Hint: DocumentSnapShot has a method you can use to return the value of a field as a String
 https://firebase.google.com/docs/reference/android/com/google/firebase/firestore/DocumentSnapshot

*/

public class FirebaseActivity extends AppCompatActivity {

    EditText courseEditText;
    TextView courseNameTextView;
    TextView instructorTextView;
    TextView locationTextView;
    private static final String TAG = FirebaseActivity.class.getSimpleName();
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase);

        courseEditText = (EditText) findViewById(R.id.fbcourseEditText);
        courseNameTextView = (TextView) findViewById(R.id.fbcourseNameTextView);
        instructorTextView = (TextView) findViewById(R.id.fbinstructorTextView);
        locationTextView = (TextView) findViewById(R.id.fblocationTextView);

    }

    public void downloadFirebaseData(View view) {

        // This will split the input from the user into an array.
        String[] courseToSearch = courseEditText.getText().toString().split(" ");
        String name = courseToSearch[0];
        String id = courseToSearch[1];


        db = FirebaseFirestore.getInstance();

        // Task: initialize an instance of Cloud Firestore




        // Tasks: Retrieve the contents of a single document using the department and course information
        // provided by the user, then use the fields information in the document to populate the
        // three placeholders


        DocumentReference user = db.collection("CSCI").document(id);

        user.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {


                    if (task.isSuccessful()) {
                        DocumentSnapshot documentSnapshot = task.getResult();
                        if (documentSnapshot.exists()){
                            courseNameTextView.setText("Course Name: " + documentSnapshot.get("Course Name").toString());
                        instructorTextView.setText("Instructor: " + documentSnapshot.get("Instructor").toString());
                        locationTextView.setText("Location: " + documentSnapshot.get("Location").toString());

                        Toast.makeText(FirebaseActivity.this, "Data Fetched", Toast.LENGTH_SHORT).show();

                    }
                        else {
                            Toast.makeText(FirebaseActivity.this, "COURSE NUMBER DOESNOT EXIST", Toast.LENGTH_SHORT).show();
                        }


            }


            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });





    }
}
