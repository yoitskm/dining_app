package mis.oblabs.com.takeorder.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by ato on 05/11/17.
 */

public class Helper {


    public static ProgressDialog progressDialog;

    public static void showToast(Context context , String msg){

        Toast.makeText(context , msg , Toast.LENGTH_SHORT).show();

    }

    public static void showLongToast(Context context , String msg){

        Toast.makeText(context , msg , Toast.LENGTH_LONG).show();

    }


    public static void showLoading(Context context, String msg){


        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(msg);

        progressDialog.show();






    }

    public static int getMonth(){
        final Calendar c = Calendar.getInstance();

        return c.get(Calendar.MONTH);
    }

    public static int getYear(){
        final Calendar c = Calendar.getInstance();

        return c.get(Calendar.YEAR);

    }


    public static void hideLoading(){
        if(progressDialog.isShowing()){
            progressDialog.dismiss();
        }
    }

    public static String today(){
        Calendar c = Calendar.getInstance();
        System.out.println("Current time => " + c.getTime());

        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        return  df.format(c.getTime());
    }
}
