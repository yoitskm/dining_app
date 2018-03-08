package mis.oblabs.com.takeorder.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;


import mis.oblabs.com.takeorder.R;
import mis.oblabs.com.takeorder.network.ApiRestAdapter;
import mis.oblabs.com.takeorder.pojo.ObjLogin;
import mis.oblabs.com.takeorder.pojo.ObjectLogin;
import mis.oblabs.com.takeorder.utils.Helper;
import mis.oblabs.com.takeorder.utils.SharedPreference;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {




    EditText eUsername , ePassword;
    TextView tForgotPass;
    Button bLogin;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        Log.wtf("TAG" , "Logging notwoeking");
        Log.d("TAG" , "Logging notwoeking");




        eUsername = (EditText) findViewById(R.id.etUsername);

        ePassword = (EditText) findViewById(R.id.etPassword);

        tForgotPass = (TextView) findViewById(R.id.tvForgotPass);

        bLogin = (Button) findViewById(R.id.bttnLogin);

        progressBar = (ProgressBar) findViewById(R.id.progressLogin);


        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(eUsername.getText().toString().equals("")){
                    eUsername.setError("Please enter username");
                    return;
                }


                if(ePassword.getText().toString().equals("")){
                    ePassword.setError("Please enter password");
                    return;
                }

                tryLogin();
            }
        });



















    }

    private void tryLogin() {

        progressBar.setVisibility(View.VISIBLE);




        Call<List<ObjLogin>> call = new ApiRestAdapter().getLogin(eUsername.getText().toString()  , ePassword.getText().toString());
        call.enqueue(new Callback<List<ObjLogin>>() {
            @Override
            public void onResponse(Call<List<ObjLogin>> call, Response<List<ObjLogin>> response) {
                progressBar.setVisibility(View.GONE);

//                Helper.showToast(LoginActivity.this , "Login Successful");

                List<ObjLogin> loginDetails = response.body();

                if(loginDetails.size()==0){
                    Helper.showToast(LoginActivity.this , "Invalid Credentials");


                }else{

                    ObjLogin data = loginDetails.get(0);
                    SharedPreference session = new SharedPreference();
                    session.saveValueWithKey(LoginActivity.this , "email" , eUsername.getText().toString());
                    session.saveValueWithKey(LoginActivity.this , "id" , data.getWaiterId());
                    startActivity(new Intent(LoginActivity.this , MainActivity.class));
                    finish();

                }

                //TODO add shared preference here






            }

            @Override
            public void onFailure(Call<List<ObjLogin>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Helper.showToast(LoginActivity.this , "Failed"+t.getMessage());
            }
        });
    }

}
