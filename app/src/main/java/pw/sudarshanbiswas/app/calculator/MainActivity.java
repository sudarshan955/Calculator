package pw.sudarshanbiswas.app.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText studentIdEditText, firstNameEditText, lastNameEditText;
    String studentIdStr, firstNameStr, lastNameStr;
    Button addStudentButton, viewAllStudentButton;
    Student student;
    ArrayList<Student> studentList = new ArrayList<Student>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        addStudentButton = (Button) findViewById(R.id.addStudentButton);
        viewAllStudentButton = (Button) findViewById(R.id.viewAllStudentButton);

        studentIdEditText = (EditText) findViewById(R.id.studentIdEditText);
        firstNameEditText = (EditText) findViewById(R.id.firstNameEditText);
        lastNameEditText = (EditText) findViewById(R.id.lastNameEditText);

        addStudentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentIdStr = studentIdEditText.getText().toString();
                firstNameStr = firstNameEditText.getText().toString();
                lastNameStr = lastNameEditText.getText().toString();
                student = new Student();
                student.addStudent(studentIdStr, firstNameStr, lastNameStr);
                studentList.add(student);

                //Clear all text field
                studentIdEditText.setText("");
                firstNameEditText.setText("");
                lastNameEditText.setText("");
            }
        });


        viewAllStudentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle homeBundle = new Bundle();
                homeBundle.putSerializable("allStudentList", studentList);
                Intent homeIntent = new Intent(MainActivity.this, ViewAllStudentActivity.class);
                homeIntent.putExtras(homeBundle);
                startActivity(homeIntent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
