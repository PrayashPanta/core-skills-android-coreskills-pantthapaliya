package csci.cs.twu.edu.coreskills;

<<<<<<< HEAD
import android.content.Context;
=======
>>>>>>> 4a146dc433d2f6d0843c823b7da145b19d603cc7
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import androidx.appcompat.app.AppCompatActivity;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/**

Assignment Notes: Add code here to make the accelerometer data on the screen update
as the device is rotated.

 https://developer.android.com/guide/topics/sensors/sensors_overview#sensors-coords
 https://blog.mindorks.com/using-android-sensors-android-tutorial




*/

public class AccelerometerActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager sensorManager;
    private Sensor mAccelerometer;

    TextView xTextView;
    TextView yTextView;
    TextView zTextView;
<<<<<<< HEAD
    private float curX,curY,curZ;
=======
>>>>>>> 4a146dc433d2f6d0843c823b7da145b19d603cc7

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);

        xTextView = (TextView)findViewById(R.id.xTextView);
        yTextView = (TextView)findViewById(R.id.yTextView);
        zTextView = (TextView)findViewById(R.id.zTextView);

        // Initialize your sensorManager and listeners here
<<<<<<< HEAD

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
=======
>>>>>>> 4a146dc433d2f6d0843c823b7da145b19d603cc7
    }

    @Override
    public void onResume() {
        super.onResume();
        // Add a line to register the Session Manager Listener
<<<<<<< HEAD
        sensorManager.registerListener(this,mAccelerometer,SensorManager.SENSOR_DELAY_NORMAL);

=======
>>>>>>> 4a146dc433d2f6d0843c823b7da145b19d603cc7
    }

    @Override
    public void onPause() {
        // Add the following line to unregister the Sensor Manager
<<<<<<< HEAD
        sensorManager.unregisterListener(this);

        super.onPause();

=======
        super.onPause();
>>>>>>> 4a146dc433d2f6d0843c823b7da145b19d603cc7
    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // No edits needed here.
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        // Add code here to update the screen
<<<<<<< HEAD
        curX = event.values[0];
        curY = event.values[1];
        curZ = event.values[2];

        xTextView.setText("X: " + curX);
        yTextView.setText("Y: " + curY);
        zTextView.setText("Z: " + curZ);


=======
>>>>>>> 4a146dc433d2f6d0843c823b7da145b19d603cc7
    }
}
