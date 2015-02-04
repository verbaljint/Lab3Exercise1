package th.ac.tu.siit.its333.lab3exercise1;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;


public class MainActivity extends ActionBarActivity {

    int cr = 0;         // Credits
    double gp = 0.0;    // Grade points
    double gpa = 0.0;   // Grade point average

    List<String> listCodes;
    List<Integer> listCredits;
    List<String> listGrades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listCodes = new ArrayList<String>();
        listCredits = new ArrayList<Integer>();
        listGrades = new ArrayList<String>();

        //Use listCodes.add("ITS333"); to add a new course code
        //Use listCodes.size() to refer to the number of courses in the list
    }

    public void calculateGPA(){
        int credit = 0;
        double gp = 0;
        double gpa = 0;

        for(int index = 0; index < listCodes.size() ; index++){
            credit = credit + listCredits.get(index);
            switch (Integer.parseInt(listGrades.get(index))){
                case R.id.rbA:
                    gp = gp + (4.0*listCredits.get(index));
                    break;
                case R.id.rbBP:
                    gp = gp + (3.5*listCredits.get(index));
                    break;
                case R.id.rbB:
                    gp = gp + (3.0*listCredits.get(index));
                    break;
                case R.id.rbCP:
                    gp = gp + (2.5*listCredits.get(index));
                    break;
                case R.id.rbC:
                    gp = gp + (2.0*listCredits.get(index));
                    break;
                case R.id.rbDP:
                    gp = gp + (1.5*listCredits.get(index));
                    break;
                case R.id.rbD:
                    gp = gp + (1.0*listCredits.get(index));
                    break;
                case R.id.rbF:
                    gp = gp + (0*listCredits.get(index));
                    break;
                default:
                    break;
            }
        }
        if(credit !=0) {
            gpa = gp / credit;
        }

        TextView tvCR = (TextView)findViewById(R.id.tvCR);
        TextView tvGP = (TextView)findViewById(R.id.tvGP);
        TextView tvGPA = (TextView)findViewById(R.id.tvGPA);

        tvCR.setText(Integer.toString(credit));
        tvGP.setText(Double.toString(gp));
        tvGPA.setText(Double.toString(gpa));
    }

    public void buttonClicked(View v) {

        int id = v.getId();

        switch (id){
            case R.id.button:
                listCodes = new ArrayList<String>();
                listCredits = new ArrayList<Integer>();
                listGrades = new ArrayList<String>();
                calculateGPA();
                break;
            case R.id.button2:
                Intent i = new Intent(this, CourseActivity.class);
                startActivityForResult(i, 99);
                break;
            case R.id.button3:
                break;
            case R.id.button4:
                Intent x = new Intent(this,CourseListActivity.class);
                String[] courseListToBeDisplayed = new String[listCodes.size()];
                for(int index = 0; index < listCodes.size(); index++){
                    switch (Integer.parseInt(listGrades.get(index))){
                        case R.id.rbA:
                            courseListToBeDisplayed[index] = listCodes.get(index) + " (" + listCredits.get(index) + "credits) =" + " A";
                            break;
                        case R.id.rbBP:
                            courseListToBeDisplayed[index] = listCodes.get(index) + " (" + listCredits.get(index) + "credits) =" + " B+";
                            break;
                        case R.id.rbB:
                            courseListToBeDisplayed[index] = listCodes.get(index) + " (" + listCredits.get(index) + "credits) =" + " B";
                            break;
                        case R.id.rbCP:
                            courseListToBeDisplayed[index] = listCodes.get(index) + " (" + listCredits.get(index) + "credits) =" + " C+";
                            break;
                        case R.id.rbC:
                            courseListToBeDisplayed[index] = listCodes.get(index) + " (" + listCredits.get(index) + "credits) =" + " C";
                            break;
                        case R.id.rbDP:
                            courseListToBeDisplayed[index] = listCodes.get(index) + " (" + listCredits.get(index) + "credits) =" + " D+";
                            break;
                        case R.id.rbD:
                            courseListToBeDisplayed[index] = listCodes.get(index) + " (" + listCredits.get(index) + "credits) =" + " D";
                            break;
                        case R.id.rbF:
                            courseListToBeDisplayed[index] = listCodes.get(index) + " (" + listCredits.get(index) + "credits) =" + " F";
                            break;
                    }

                }
                String[] dummy = new String[1];
                dummy[0] = "";

                if(listCodes.size()==0){
                    x.putExtra("fromMA", dummy);
                }else{
                    x.putExtra("fromMA", courseListToBeDisplayed);
                }

                startActivity(x);
                break;
            default:
                break;
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 99){
            if (resultCode == RESULT_OK) {
                String[] temp = data.getStringArrayExtra("fromCA");
                listCodes.add(temp[0]);
                listCredits.add(Integer.parseInt(temp[1]));
                listGrades.add(temp[2]);

                calculateGPA();
            }
        }
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
