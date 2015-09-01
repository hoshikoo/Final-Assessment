package nyc.c4q;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class PaceCalculatorActivity extends FragmentActivity {
//    EditText inputDistance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pace_calculator);

        PlaceholderFragment fragment = new PlaceholderFragment();
        FragmentManager fm =  getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft = ft.add(R.id.container, fragment);
        ft.commit();

//
//
//
//        final String distanceStr = inputDistance.getText().toString();
//
//        final String timeMinStr = inputTimeMin.getText().toString();
//        final String timeSecStr = inputTimeSec.getText().toString();
//
//        final String paceMinStr = inputPaceMin.getText().toString();
//        final String paceSecStr = inputPaceSec.getText().toString();
//
//
//
//        buttonCalculate.setOnClickListener(new View.OnClickListener() {
//
//               @Override
//               public void onClick(View v) {
//
//                    if (distanceStr == null || distanceStr.trim().equals("")){
//                        //time *pace = distance
//                        int timeMin = Integer.parseInt(timeMinStr);
//                        int timeSec = Integer.parseInt(timeSecStr);
//                        int time = (timeMin * 60) + timeSec;
//
//                        final int paceMin = Integer.parseInt(paceMinStr);
//                        final int paceSec = Integer.parseInt(paceSecStr);
//                        final int pace = (paceMin * 60) +paceSec;
//
//                         inputDistance.setText(String.valueOf(time / pace));
//                    }
//
//                   if ((timeMinStr == null || timeMinStr.trim().equals("") ) && (timeSecStr == null || timeSecStr.trim().equals("") )){
//                       //distance / pace =time
//
//                       int sec;
//                       int min;
//                       int distance = Integer.parseInt(distanceStr);
//                       final int paceMin = Integer.parseInt(paceMinStr);
//                       final int paceSec = Integer.parseInt(paceSecStr);
//                       final int pace = (paceMin * 60) +paceSec;
//                       int result = distance / pace;
//
//                       if(result<60){
//                           inputTimeSec.setText(String.valueOf(result));
//                       }else{
//                           sec = result % 60;
//                           min = (result - sec)/60;
//                           inputTimeMin.setText(String.valueOf(min));
//                           inputTimeSec.setText(String.valueOf(sec));
//                       }
//
//                   }
//
//                   if ((paceMinStr == null || paceMinStr.trim().equals(""))&& (paceSecStr == null || paceSecStr.trim().equals(""))){
//                       //pace = time / Distance
//
//                       int timeMin = Integer.parseInt(timeMinStr);
//                       int timeSec = Integer.parseInt(timeSecStr);
//                       int time = (timeMin * 60) + timeSec;
//                       int distance = Integer.parseInt(distanceStr);
//                       int result = time / distance;
//                       int sec;
//                       int min;
//
//                       if(result<60){
//                           inputPaceSec.setText(String.valueOf(result));
//                       }else{
//                           sec = result % 60;
//                           min = (result - sec)/60;
//                           inputPaceMin.setText(String.valueOf(min));
//                           inputPaceSec.setText(String.valueOf(sec));
//                       }
//
//
//                   }
//               }
//           }
//
//        );

    }

    public static class PlaceholderFragment extends Fragment {

        EditText etInputDistance;
        EditText etInputTimeMin;
        EditText etInputTimeSec;
        EditText etInputPaceMin;
        EditText etInputPaceSec;
        Button buttonCalculate;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            View fragmentView = inflater.inflate(R.layout.fragment_pace_calculator, container, false);
            etInputDistance = (EditText) fragmentView.findViewById(R.id.input_distance);
            etInputTimeMin = (EditText) fragmentView.findViewById(R.id.input_time_min);
            etInputTimeSec = (EditText) fragmentView.findViewById(R.id.input_time_sec);
            etInputPaceMin = (EditText) fragmentView.findViewById(R.id.input_pace_min);
            etInputPaceSec = (EditText) fragmentView.findViewById(R.id.input_pace_sec);
            buttonCalculate = (Button) fragmentView.findViewById(R.id.button_calculate);

            buttonCalculate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    final String distanceStr = etInputDistance.getText().toString();

                    final String timeMinStr = etInputTimeMin.getText().toString();
                    final String timeSecStr = etInputTimeSec.getText().toString();

                    final String paceMinStr = etInputPaceMin.getText().toString();
                    final String paceSecStr = etInputPaceSec.getText().toString();
                     //check int is more than 0 or not

                    int timeMin = 0;
                    int timeSec = 0;
                    int paceMin = 0;
                    int paceSec = 0;
                    double distance = 0.0;

                    if (!isEmpty(timeMinStr)) {
                        try {
                            timeMin = Integer.parseInt(timeMinStr);
                        }catch (Exception e){
                            return;
                        }
                    }

                    if (!isEmpty(timeSecStr)) {
                        try {
                            timeSec = Integer.parseInt(timeSecStr);
                        }catch (Exception e){
                            return;
                        }
                    }

                    if (!isEmpty(paceMinStr)) {
                        try {
                            paceMin = Integer.parseInt(paceMinStr);
                        }catch (Exception e){
                            return;
                        }
                    }

                    if (!isEmpty(paceSecStr)) {
                        try {
                            paceSec = Integer.parseInt(paceSecStr);
                        }catch (Exception e){
                            return;
                        }
                    }

                    if (!isEmpty(distanceStr)) {
                        try {
                            distance = Double.parseDouble(distanceStr);
                        }catch (Exception e){
                            return;
                        }
                    }

;
                    double time = (timeMin * 60) + timeSec;
                    double pace = (paceMin * 60) + paceSec;



                    if (distance == 0 && time > 0.0 && pace > 0.0) {

                        double ditanceResult = time / pace;
                        etInputDistance.setText(String.valueOf(ditanceResult));
                    }

                    else if (time == 0.0 && pace > 0.0 && distance > 0.0) {
                        //distance / pace =time

                        double result = (distance * 1.0) * pace;

                        int sec = (int) (result % 60);
                        int min = (int) ((result - sec) / 60);
                        etInputTimeMin.setText(String.valueOf(min));
                        etInputTimeSec.setText(String.valueOf(sec));

                    }

                    if (pace == 0.0 && distance > 0.0  && time > 0.0) {
                        //pace = time / Distance

                        double result = time / distance;
                        int sec;
                        int min;

                        sec = (int) (result % 60);
                        min = (int) ((result - sec) / 60);
                        etInputPaceMin.setText(String.valueOf(min));
                        etInputPaceSec.setText(String.valueOf(sec));
                    }
                }
            });
//
            return fragmentView;
        }

        private void calculate() {

        }

        private boolean isEmpty(String str) {
            if (str == null || str.trim().equals("")){
                return true;
            }
            return false;
        }


    }

}
