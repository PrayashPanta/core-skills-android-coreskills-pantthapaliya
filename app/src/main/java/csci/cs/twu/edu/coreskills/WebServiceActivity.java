package csci.cs.twu.edu.coreskills;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**

 Assignment Notes: This activity should pull data from a REST JSON API based upon
 the course requested in the EditText.
 We will use the Retrofit library to do this, since making network calls in Android
 otherwise require actions on a separate thread. Some helper code is provided in the LousListAPI
 classes and the Section class. DO NOT modify them.
 An example of consuming web service and display all courses in a department using the retrofit
 library can be found at:
 https://gitlab.com/csci3313sp20/louslistrestapi/



 Retrofit References:
 https://howtodoinjava.com/retrofit2/retrofit2-beginner-tutorial/

 */

public class WebServiceActivity extends AppCompatActivity {

    public static final String BASE_URL = "http://stardock.cs.virginia.edu/louslist/Courses/view/";

    EditText courseEditText;
    TextView courseNameTextView;
    TextView instructorTextView;
    TextView locationTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_service);

        courseEditText = (EditText) findViewById(R.id.courseEditText);
        courseNameTextView = (TextView) findViewById(R.id.courseNameTextView);
        instructorTextView = (TextView) findViewById(R.id.instructorTextView);
        locationTextView = (TextView) findViewById(R.id.locationTextView);


    }

    public void downloadData(View view) {

        // This will split the input from the user into an array.
        String[] courseToSearch = courseEditText.getText().toString().split(" ");

        String deptName = courseToSearch[0];
        String deptNumber = courseToSearch[1];



        // Task: create a service and a functioning REST client


        LousListAPIInterface apiService =
                LousListAPIClient.getClient().create(LousListAPIInterface.class);

        // Tasks: Execute the request asynchronously, download the data with the provided department
        // and course information and save in a List of of Section. Use the corresponding field's
        // value to populate the three placeholders
        // Hint: there is a method in List to return the element at the specified position
        // Hint2: there are methods in Section class to return a specified field value



        Call<List<Section>> call = apiService.sectionList(deptName,deptNumber);
        call.enqueue(new Callback<List<Section>>() {
            @Override
            public void onResponse(Call<List<Section>> call, Response<List<Section>> response) {
                List<Section> sections = response.body();
                String courseDisplay = "";
                if (sections.size() != 0) {
                    for (Section s : sections) {
                        String courseName = s.getCourseName();
                        String instructor = s.getInstructor();
                        String location = s.getLocation();

                        courseNameTextView.setText("Course: " + courseName);
                        instructorTextView.setText("Instructor: " + instructor);
                        locationTextView.setText("Location: " + location);
                    }


                }

                else{
                    Toast.makeText(WebServiceActivity.this, "NO COURSE FOUND. EXAMPLE: CS 1010", Toast.LENGTH_SHORT).show();
                }
            }



                @Override
                public void onFailure (Call<List<Section>> call, Throwable t){

                    Toast.makeText(WebServiceActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                }

        });

    }

}
