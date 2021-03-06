package csci.cs.twu.edu.coreskills;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**

 Assignment Notes: The main activity with the set of buttons.
 You DO need to edit the TextViews on the screen to show your
 team member names and group name. If your team contains a 3rd member,
 you will need to edit the TextView to add your third team member name.

 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openGPS(View view) {
        Intent intent = new Intent(this, GPSActivity.class);
        startActivity(intent);
    }

    public void openShake(View view) {
        Intent intent = new Intent(this, ShakeActivity.class);
        startActivity(intent);
    }

    public void openAccelerometer(View view) {
        Intent intent = new Intent(this, AccelerometerActivity.class);
        startActivity(intent);
    }

    public void openCamera(View view) {
        Intent intent = new Intent(this, CameraActivity.class);
        startActivity(intent);
    }
    public void openSharedPreferences(View view) {
        Intent intent = new Intent(this, SharedPreferencesActivity.class);
        startActivity(intent);
    }
    public void openSQLite(View view) {
        Intent intent = new Intent(this, SQLiteActivity.class);
        startActivity(intent);
    }

    public void openWebService(View view) {
        Intent intent = new Intent(this, WebServiceActivity.class);
        startActivity(intent);
    }

    public void openFirebase(View view) {
        Intent intent = new Intent(this, FirebaseActivity.class);
        startActivity(intent);
    }


}
