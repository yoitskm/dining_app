package mis.oblabs.com.takeorder.utils;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;

import java.util.Calendar;

/**
 * Created by beyondthebox on 21/11/16.
 */


public  class DatePicker extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {


    String year = "0" , month = "0" , day = "0";

    public String getYear() {
        return year;
    }

    public String getMonth() {
        return month;
    }

    public String getDay() {
        return day;
    }


    SelectSingleItemCallback callback;

    public void setCallback(SelectSingleItemCallback callback) {
        this.callback = callback;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }



    @Override
    public void onDateSet(android.widget.DatePicker datePicker, int year, int month, int day) {
        Log.d("date picker" , "date day : "+day);
        Log.d("date picker" , "date month : "+month);
        Log.d("date picker" , "date year : "+year);
        this.year = ""+year;
        this.month = ""+(month+1);
        this.day = ""+day;
        callback.selectedItem(day+"-"+(month+1)+"-"+year);

    }
}
