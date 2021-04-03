package csci.cs.twu.edu.coreskills;

<<<<<<< HEAD
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
=======
import android.content.Intent;
import android.content.pm.PackageManager;
>>>>>>> 4a146dc433d2f6d0843c823b7da145b19d603cc7
import android.net.Uri;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
<<<<<<< HEAD
import android.provider.MediaStore;
=======
>>>>>>> 4a146dc433d2f6d0843c823b7da145b19d603cc7
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

<<<<<<< HEAD
import java.io.FileNotFoundException;
import java.io.InputStream;

=======
>>>>>>> 4a146dc433d2f6d0843c823b7da145b19d603cc7
/**

Assignment Notes: Add code here to make the call either the camera or
the image library to update the imageView on the screen.  Note that there
are NUMEROUS different ways to do this, some better than others, and many
don't work well together at all.

I used the following tutorials:
https://androidkennel.org/android-camera-access-tutorial/
 https://medium.com/@hasangi/capture-image-or-choose-from-gallery-photos-implementation-for-android-a5ca59bc6883
*/

public class CameraActivity extends AppCompatActivity {

    static final int TAKE_PHOTO_PERMISSION = 1;
    static final int REQUEST_TAKE_PHOTO = 2;
    static final int PICK_IMAGE_REQUEST = 3;

    ImageView imageView;
    Button takePictureButton;
<<<<<<< HEAD
    Button choosePictureButton;

    Uri file;
    private String stringPath;
    private Intent iData;
=======

    Uri file;
>>>>>>> 4a146dc433d2f6d0843c823b7da145b19d603cc7

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        takePictureButton = (Button) findViewById(R.id.takePictureButton);
        imageView = (ImageView) findViewById(R.id.imageView);
<<<<<<< HEAD
        choosePictureButton = (Button) findViewById(R.id.imageLibraryButton);
=======
>>>>>>> 4a146dc433d2f6d0843c823b7da145b19d603cc7

        // We are giving you the code that checks for permissions
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            takePictureButton.setEnabled(false);
            ActivityCompat.requestPermissions(this, new String[] { android.Manifest.permission.CAMERA, android.Manifest.permission.WRITE_EXTERNAL_STORAGE }, TAKE_PHOTO_PERMISSION);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        // This is called when permissions are either granted or not for the app
        // You do not need to edit this code.

        if (requestCode == TAKE_PHOTO_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED
                    && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                takePictureButton.setEnabled(true);
            }
        }
    }

    public void takePicture(View view) {
        // Add code here to start the process of taking a picture
        // Note you can send an intent to the camera to take a picture...
        // So start by considering that!

<<<<<<< HEAD
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,2);
=======
>>>>>>> 4a146dc433d2f6d0843c823b7da145b19d603cc7
    }

    public void getImageFromLibrary(View view) {
        // Add code here to start the process of getting a picture from the library
<<<<<<< HEAD
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},PICK_IMAGE_REQUEST);
        }
        else{
            Intent intent = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.INTERNAL_CONTENT_URI);
            startActivityForResult(intent,PICK_IMAGE_REQUEST);

        }
=======
>>>>>>> 4a146dc433d2f6d0843c823b7da145b19d603cc7

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        // Add code here to handle results from both taking a picture or pulling
        // from the image gallery.

        if (requestCode == REQUEST_TAKE_PHOTO) {
           // Add here.
<<<<<<< HEAD

            Bitmap takeImage = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(takeImage);

        }
        else if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK) {
            //Add here.
            if (data != null){
                file = data.getData();
                iData = data;
                try {
                    InputStream inputStream = getContentResolver().openInputStream(file);
                    Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                    imageView.setImageBitmap(bitmap);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }


            }


=======
        }
        else if (requestCode == PICK_IMAGE_REQUEST) {
            //Add here.
>>>>>>> 4a146dc433d2f6d0843c823b7da145b19d603cc7

        }
    }

    // Add other methods as necessary here



}
