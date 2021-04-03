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
import android.os.Bundle;
import android.widget.TextView;
<<<<<<< HEAD
import android.widget.Toast;
=======
>>>>>>> 4a146dc433d2f6d0843c823b7da145b19d603cc7

/**

 Assignment Notes: For this activity, every time you shake the device, the counter
 on the screen should go up.  Note that there is no specific "shake listener,"
 unless you build your own.  I chose to add a SensorEventListener to this Activity
 to listen for accelerometer movements.  You will have to determine what's hard enough
 a movement to warrant a "shake."



 */

public class ShakeActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager sensorManager;
    private Sensor mAccelerometer;
<<<<<<< HEAD
    private static final float SHAKE_THRESHOLD_GRAVITY = 5F;

    private int mShakeCount = 0;
    TextView shakeCountTextView;
    private boolean isInitialized;
    private final float NOISE = (float) 5.0;
    private float curX,curY,curZ, lastX, lastY, lastZ, xDiff,yDiff,zDiff;


=======
    private static final float SHAKE_THRESHOLD_GRAVITY = 1.25F;

    private int mShakeCount = 0;
    TextView shakeCountTextView;
>>>>>>> 4a146dc433d2f6d0843c823b7da145b19d603cc7

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shake);

<<<<<<< HEAD
        shakeCountTextView = findViewById(R.id.shakeCountTextView);

        // Add code to intialize the sensorManager and accelerometer
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
=======
        // Add code to intialize the sensorManager and accelerometer
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
        // Add a line to unregister the Sensor Manager

<<<<<<< HEAD
        sensorManager.unregisterListener(this);

        super.onPause();

=======
        super.onPause();
>>>>>>> 4a146dc433d2f6d0843c823b7da145b19d603cc7
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Nothing needs to be added here.
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        // Add code here to handle what happens when a sensor event occurs.

<<<<<<< HEAD
        curX = event.values[0];
        curY = event.values[1];
        curZ = event.values[2];



        if (isInitialized){
            xDiff = Math.abs(lastX - curX);
            yDiff = Math.abs(lastY - curY);
            zDiff = Math.abs(lastZ - curZ);

            if((xDiff> SHAKE_THRESHOLD_GRAVITY && yDiff > SHAKE_THRESHOLD_GRAVITY) ||
                    (yDiff > SHAKE_THRESHOLD_GRAVITY && zDiff > SHAKE_THRESHOLD_GRAVITY) ||
                    (xDiff> SHAKE_THRESHOLD_GRAVITY && zDiff > SHAKE_THRESHOLD_GRAVITY)){
                mShakeCount++;
                Toast.makeText(this, "Shake Detected", Toast.LENGTH_SHORT).show();
                shakeCountTextView.setText("Shake Count: " + mShakeCount);
            }
        }

        lastX = curX;
        lastY = curY;
        lastZ = curZ;
        isInitialized = true;












=======
>>>>>>> 4a146dc433d2f6d0843c823b7da145b19d603cc7
    }
}
