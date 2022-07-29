package com.example.ec3;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity implements Comunicacion {
    TextView textRegister;
    MaterialButton buttonlogin;
    TextInputEditText InputEmail, InputPassword;
    TextInputLayout InputlayoutEmail, InputlayoutPassword;
    String TextEmail, TextPassword;
    private ProgressBar pgbEjecutanto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textRegister = findViewById(R.id.textRegister);
        buttonlogin = findViewById(R.id.login_button);
        InputlayoutEmail = findViewById(R.id.login_inputlayout_email);
        InputlayoutPassword = findViewById(R.id.login_inputlayout_password);
        InputEmail = findViewById(R.id.login_input_email);
        InputPassword = findViewById(R.id.login_input_password);
        pgbEjecutanto = findViewById(R.id.pgbEjecutanto);

        textRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);


            }
        });

        buttonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextEmail = InputEmail.getText().toString();
                TextPassword = InputPassword.getText().toString();
                Log.e("Correo", TextEmail);
                Log.e("Contraseña", TextPassword);

                //Toggle de carga cuando se inicia sesión
                if (TextEmail.toString().equals("admin") && TextPassword.toString().equals("admin")) {
                    //valido el usuario y se dirige a la pantalla mainactivity.
                    new ToggleProgressBarValido(LoginActivity.this).execute(InputEmail.getText().toString(),
                            InputPassword.getText().toString(), 5000);
                    Intent inTent = new Intent(LoginActivity.this, MainActivity.class );
                    startActivity(inTent);
                    Toast.makeText(getApplicationContext(),"Bienvenido", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getApplicationContext(),"Usuario/Contraseña erronea", Toast.LENGTH_LONG).show();
                }

                if (TextUtils.isEmpty(TextEmail) || TextUtils.isEmpty(TextPassword)) {
                   if (TextUtils.isEmpty(TextEmail)) {
                        InputlayoutEmail.setError("Ingrese su correo");
                    } else {
                        InputlayoutEmail.setError(null);
                    }
                    if (TextUtils.isEmpty(TextPassword)) {
                        InputlayoutPassword.setError("Ingrese una contraseña");
                    } else {
                        InputlayoutPassword.setError(null);
                    }
                } else {

                }
            }
        });
    }

    @Override
    public void toggleProgressBar(boolean status) {
        if (status) {
            pgbEjecutanto.setVisibility(View.VISIBLE);
        } else {
            pgbEjecutanto.setVisibility(View.GONE);
        }
    }

}