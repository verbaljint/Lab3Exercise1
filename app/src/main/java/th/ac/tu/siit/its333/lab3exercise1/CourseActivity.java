package th.ac.tu.siit.its333.lab3exercise1;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;


public class CourseActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
    }

    public void addCourse(View v){
        EditText etCode = (EditText)findViewById(R.id.etCode);
        EditText etCR = (EditText)findViewById(R.id.etCR);
        RadioGroup RG = (RadioGroup)findViewById(R.id.rdGr);

        String[] temp = new String[3];

        temp[0] = etCode.getText().toString();
        temp[1] = etCR.getText().toString();
        temp[2] = Integer.toString(RG.getCheckedRadioButtonId());

        Intent result = new Intent();
        result.putExtra("fromCA", temp);
        setResult(RESULT_OK,result);
        System.out.println(temp[0]);
        System.out.println(temp[1]);
        System.out.println(temp[2]);

        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_course, menu);
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
