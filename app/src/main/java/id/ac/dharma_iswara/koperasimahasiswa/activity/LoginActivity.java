package id.ac.dharma_iswara.koperasimahasiswa.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import id.ac.dharma_iswara.koperasimahasiswa.R;
import id.ac.dharma_iswara.koperasimahasiswa.config.ApiInterface;
import id.ac.dharma_iswara.koperasimahasiswa.config.AppConfig;
import id.ac.dharma_iswara.koperasimahasiswa.helper.MyEditText;
import id.ac.dharma_iswara.koperasimahasiswa.helper.MyTextView;
import id.ac.dharma_iswara.koperasimahasiswa.helper.SQLiteHandler;
import id.ac.dharma_iswara.koperasimahasiswa.helper.SessionManager;
import id.ac.dharma_iswara.koperasimahasiswa.model.User;
import id.ac.dharma_iswara.koperasimahasiswa.response.LoginResponse;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class LoginActivity extends AppCompatActivity {

    public static final String TAG = LoginActivity.class.getSimpleName();
    MyEditText txtEmail, txtPassword;
    MyTextView signin;
    private SessionManager session;
    private ProgressDialog pDialog;
    private User user;
    private SQLiteHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtEmail = (MyEditText) findViewById(R.id.username);
        txtPassword = (MyEditText) findViewById(R.id.password);

        signin = (MyTextView) findViewById(R.id.signin);
        // Progress dialog
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);

        db = new SQLiteHandler(getApplicationContext());

        session = new SessionManager(getApplicationContext());

        // Check if user is already logged in or not
        if (session.isLoggedIn()) {
            // User is already logged in. Take him to main activity
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = txtEmail.getText().toString().trim();
                String pass = txtPassword.getText().toString().trim();
                //getCookies(email, pass);
                checkLogin(email, pass);
            }
        });

    }

    private void checkLogin(final  String email, final String password) {
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(AppConfig.BASE_API_URL).build();

        ApiInterface apiInterface = restAdapter.create(ApiInterface.class);

        apiInterface.authenticate(email, password, new Callback<LoginResponse>() {
            @Override
            public void success(LoginResponse result, Response response) {
                user = result.getUser();
                Log.e(TAG, "-----------LOG---------");
                Log.e(TAG, "USER "+result.getUser().toString());
                Log.e(TAG, "LOG  "+user.getEntityId());
                Log.e(TAG, "LOG  "+user.getName());
                Log.e(TAG, "LOG  "+user.getEmail());
                Log.e(TAG, "LOG  "+user.getAvatar());
                Log.e(TAG, "LOG  "+user.getTel());
                Log.e(TAG, "LOG  "+user.getSession());
                String nama = user.getName();
                Log.e(TAG, nama);
                String id = user.getEntityId();
                String email = user.getEmail();
                String sess = user.getSession();
                String ava = "avatar";
                String tel = "telepon";
                db.addUser(user.getEntityId(), user.getName(), user.getEmail(), ava, tel, user.getSession());
                session.setLogin(true);
                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                i.putExtra("session", sess);
                startActivity(i);

            }

            @Override
            public void failure(RetrofitError error) {
                Log.e(TAG, error.toString());
            }
        });
    }
}
