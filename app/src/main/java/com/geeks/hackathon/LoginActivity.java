package com.geeks.hackathon;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.budiyev.android.codescanner.ErrorCallback;
import com.google.gson.JsonObject;
import com.google.zxing.Result;

import api.WebServiceApiAdapterBuilder;
import api.response.CustomerLoginResponse;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private CodeScanner mCodeScanner;
    private LoginActivity activity = this;

    @BindView(R.id.login_et_id)
    EditText etID;


    @BindView(R.id.login_btn_login)
    Button btnLogin;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        final CodeScannerView scannerView = findViewById(R.id.scanner_view_login);
        mCodeScanner = new CodeScanner(this, scannerView);
        mCodeScanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull final Result result) {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        etID.setText(result.getText());
                        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                        startActivity(intent);

                        //TODO
                        //login(result.getText());
                       // Toast.makeText(activity, result.getText(), Toast.LENGTH_SHORT).show();
                    }
                });
            }

        });
        mCodeScanner.setErrorCallback(new ErrorCallback() {
            @Override
            public void onError(@NonNull final Exception error) {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(activity, error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        scannerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCodeScanner.startPreview();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login(etID.getText().toString());
                /*Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();*/

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mCodeScanner.startPreview();
    }

    @Override
    protected void onPause() {
        mCodeScanner.releaseResources();
        super.onPause();
    }

    private void login(String id) {
        //ProgressbarDialog.getProgressDialog(this).show();
        JsonObject customerLoginReq = new JsonObject();
        customerLoginReq.addProperty("id", id);

        Call<CustomerLoginResponse> loginCallBack = WebServiceApiAdapterBuilder.getInstance().login(id);
        loginCallBackFunction(loginCallBack);

        Log.v("Login", "called :: " );

    }

    private void loginCallBackFunction(Call<CustomerLoginResponse> callback) {
        callback.enqueue(new Callback<CustomerLoginResponse>() {
            @Override
            public void onResponse(Call<CustomerLoginResponse> call, Response<CustomerLoginResponse> response) {


                if (response.isSuccessful()) {
                    Log.v("Login", "response success :: " + response.code() + " ::  " + response.body().toString());
                    CustomerLoginResponse customerLoginResponse = response.body();
                    if(customerLoginResponse == null || customerLoginResponse.getId() == null){
                        Toast.makeText(activity, "Invalid User", Toast.LENGTH_SHORT).show();
                        return;

                    }
                    Log.v("Login", "response mapped to CustomerLoginReq :: " + customerLoginResponse.toString());

                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                }
                }

            @Override
            public void onFailure(Call<CustomerLoginResponse> call, Throwable t) {
                Log.v("Login", "onFailure :: " + t.getMessage() + " ::  " + call.toString());

                Toast.makeText(activity, "Internet Connection Failed ", Toast.LENGTH_SHORT).show();
            }

        });
    }
}
