package mis.oblabs.com.takeorder.utils;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;
import android.util.Log;

import java.util.Calendar;

/**
 * Created by beyondthebox on 21/11/16.
 */


public class TimePicker extends DialogFragment
        implements TimePickerDialog.OnTimeSetListener {


    String timeHour = "00";
    String timeMinute = "00";

    public String getTimeHour() {
        return timeHour;
    }

    public String getTimeMinute() {
        return timeMinute;
    }

    SelectSingleItemCallback callback;

    public void setCallback(SelectSingleItemCallback callback) {
        this.callback = callback;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current time as the default values for the picker
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        // Create a new instance of TimePickerDialog and return it
        return new TimePickerDialog(getActivity(), this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));
    }

    @Override
    public void onTimeSet(android.widget.TimePicker timePicker, int i, int i1) {

        Log.d("time picker" , "time hour : "+i);
        Log.d("time picker" , "time min : "+i1);
        timeMinute = ""+i1;
        timeMinute = String.format("%02d", i1);
        Log.d("time picker" , "time munute formated : "+timeMinute);
        if(i>12){
            timeHour = ""+(i-12);
            timeHour = String.format("%02d", (i-12));
            Log.d("time picker" , "time hour formated : "+timeHour);

            timeMinute = timeMinute+" PM";
        }else{
            timeHour = ""+i;
            timeHour = String.format("%02d", i);
            Log.d("time picker" , "time hour formated : "+timeHour);

            timeMinute = timeMinute+" AM";
        }

        callback.selectedItem(timeHour+" : "+timeMinute);
    }
}