package id.ac.dharma_iswara.koperasimahasiswa.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import id.ac.dharma_iswara.koperasimahasiswa.R;
import id.ac.dharma_iswara.koperasimahasiswa.helper.MyTextView;
import id.ac.dharma_iswara.koperasimahasiswa.helper.SessionManager;

public class SplashActivity extends AppCompatActivity {

    SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        session = new SessionManager(getApplicationContext());

        if (session.isLoggedIn()) {
            // User is already logged in. Take him to main activity
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

        MyTextView regis = (MyTextView) findViewById(R.id.exit);
        MyTextView login = (MyTextView) findViewById(R.id.login);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });

        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent i = new Intent(SplashActivity.this, RegisterActivity.class);
                //startActivity(i);
            }
        });
    }
}
