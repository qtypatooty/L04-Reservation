package sg.edu.rp.c346.id20006949.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Time;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText getName;
    EditText getMobile;
    EditText getSize;
    DatePicker datePicker;
    TimePicker timePicker;
    RadioGroup tablePreference;
    RadioButton Smoking;
    RadioButton NonSmoking;
    Button buttonReserve;
    Button buttonReset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getName = findViewById(R.id.getName);
        getMobile = findViewById(R.id.getMobile);
        getSize = findViewById(R.id.getSize);
        datePicker = findViewById(R.id.datePicker);
        timePicker = findViewById(R.id.timePicker);
        tablePreference = findViewById(R.id.TablePreference);
        Smoking = findViewById(R.id.Smoking);
        NonSmoking = findViewById(R.id.NonSmoking);
        buttonReserve = findViewById(R.id.buttonReserve);
        buttonReset = findViewById(R.id.buttonReset);


        Calendar thisCalendar = Calendar.getInstance();
        int currentYear = thisCalendar.get(thisCalendar.YEAR);
        int currentMonth = thisCalendar.get(thisCalendar.MONTH);
        int currentDay = thisCalendar.get(thisCalendar.DAY_OF_MONTH);

        datePicker.updateDate(2020,5,1);
        timePicker.setCurrentHour(19);
        timePicker.setCurrentMinute(30);



        buttonReserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = getName.getText().toString();
                String mobile = getMobile.getText().toString();
                String size = getSize.getText().toString();


                if(name.isEmpty() || mobile.isEmpty() || size.isEmpty() ||
                        tablePreference.getCheckedRadioButtonId() == -1){
                    Toast.makeText(MainActivity.this,"Please fill in the empty details",Toast.LENGTH_LONG).show();
                }
                else if(Smoking.isChecked()){
                    Toast.makeText(MainActivity.this ,"Reservations for a table of smoking has been made",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(MainActivity.this ,"Reservations for a table of non-smoking has been made ",Toast.LENGTH_LONG).show();
                }
            }
        });

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePicker.updateDate(2020,5,1);
                timePicker.setCurrentHour(19);
                timePicker.setCurrentMinute(30);

                getName.setText("");
                getSize.setText("");
                getMobile.setText("");
                tablePreference.clearCheck();
            }
        });

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                if(hourOfDay < 8 || hourOfDay > 20 ){
                    timePicker.setCurrentHour(20);
                    timePicker.setCurrentMinute(0);
                }
            }
        });
    }
}