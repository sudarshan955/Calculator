package pw.sudarshanbiswas.app.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewAllStudentActivity extends AppCompatActivity {

    TextView allStudentListTextView;
    String id, firstName, lastName, allStudentInfoStr = "";
    Button homeButton;
    Bundle viewAllStudentBundle;
    ArrayList<Student> studentArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_student);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        allStudentListTextView = (TextView) findViewById(R.id.allStudentListTextView);
        homeButton = (Button) findViewById(R.id.homeButton);

        try {
            viewAllStudentBundle = getIntent().getExtras();
            studentArrayList = (ArrayList<Student>) viewAllStudentBundle.getSerializable("allStudentList");

            for (Student student : studentArrayList) {
                id = String.valueOf(student.getId());
                firstName = String.valueOf(student.getFirstName());
                lastName = String.valueOf(student.getLastName());
                allStudentInfoStr += "ID: " + id + "\nName: " + firstName + " " + lastName + "\n\n";
            }

            allStudentListTextView.setText(allStudentInfoStr);

        } catch (Exception myException) {
            myException.printStackTrace();
        }

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewAllStudentListIntent = new Intent(ViewAllStudentActivity.this, MainActivity.class);
                startActivity(viewAllStudentListIntent);
            }
        });
    }

}
