package nyc.c4q;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PaceCalculatorActivity extends FragmentActivity {
    EditText inputDistance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pace_calculator);

        inputDistance   = (EditText)findViewById(R.id.input_distance);
        final EditText inputTimeMin   = (EditText)findViewById(R.id.input_time_min);
        final EditText inputTimeSec    = (EditText) findViewById(R.id.input_time_sec);
        final EditText inputPaceMin    = (EditText)findViewById(R.id.input_pace_min);
        final EditText inputPaceSec    = (EditText) findViewById(R.id.input_pace_sec);
        Button buttonCalculate = (Button) findViewById(R.id.button_calculate);


        final String distanceStr = inputDistance.getText().toString();

        final String timeMinStr = inputTimeMin.getText().toString();
        final String timeSecStr = inputTimeSec.getText().toString();

        final String paceMinStr = inputPaceMin.getText().toString();
        final String paceSecStr = inputPaceSec.getText().toString();



        buttonCalculate.setOnClickListener(new View.OnClickListener() {

               @Override
               public void onClick(View v) {

                    if (distanceStr == null || distanceStr.trim().equals("")){
                        //time *pace = distance
                        int timeMin = Integer.parseInt(timeMinStr);
                        int timeSec = Integer.parseInt(timeSecStr);
                        int time = (timeMin * 60) + timeSec;

                        final int paceMin = Integer.parseInt(paceMinStr);
                        final int paceSec = Integer.parseInt(paceSecStr);
                        final int pace = (paceMin * 60) +paceSec;

                         inputDistance.setText(String.valueOf(time / pace));
                    }

                   if ((timeMinStr == null || timeMinStr.trim().equals("") ) && (timeSecStr == null || timeSecStr.trim().equals("") )){
                       //distance / pace =time

                       int sec;
                       int min;
                       int distance = Integer.parseInt(distanceStr);
                       final int paceMin = Integer.parseInt(paceMinStr);
                       final int paceSec = Integer.parseInt(paceSecStr);
                       final int pace = (paceMin * 60) +paceSec;
                       int result = distance / pace;

                       if(result<60){
                           inputTimeSec.setText(String.valueOf(result));
                       }else{
                           sec = result % 60;
                           min = (result - sec)/60;
                           inputTimeMin.setText(String.valueOf(min));
                           inputTimeSec.setText(String.valueOf(sec));
                       }

                   }

                   if ((paceMinStr == null || paceMinStr.trim().equals(""))&& (paceSecStr == null || paceSecStr.trim().equals(""))){
                       //pace = time / Distance

                       int timeMin = Integer.parseInt(timeMinStr);
                       int timeSec = Integer.parseInt(timeSecStr);
                       int time = (timeMin * 60) + timeSec;
                       int distance = Integer.parseInt(distanceStr);
                       int result = time / distance;
                       int sec;
                       int min;

                       if(result<60){
                           inputPaceSec.setText(String.valueOf(result));
                       }else{
                           sec = result % 60;
                           min = (result - sec)/60;
                           inputPaceMin.setText(String.valueOf(min));
                           inputPaceSec.setText(String.valueOf(sec));
                       }


                   }
               }
           }

        );

    }



}
