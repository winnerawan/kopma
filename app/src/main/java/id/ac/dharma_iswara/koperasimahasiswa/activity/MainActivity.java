package id.ac.dharma_iswara.koperasimahasiswa.activity;

import android.support.design.widget.NavigationView;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import id.ac.dharma_iswara.koperasimahasiswa.R;
import id.ac.dharma_iswara.koperasimahasiswa.adapter.ListProductsAdapter;
import id.ac.dharma_iswara.koperasimahasiswa.config.ApiInterface;
import id.ac.dharma_iswara.koperasimahasiswa.config.AppConfig;
import id.ac.dharma_iswara.koperasimahasiswa.helper.SQLiteHandler;
import id.ac.dharma_iswara.koperasimahasiswa.model.Products;
import id.ac.dharma_iswara.koperasimahasiswa.model.UserStatus;
import id.ac.dharma_iswara.koperasimahasiswa.response.CartQtyResponse;
import id.ac.dharma_iswara.koperasimahasiswa.response.ProductsResponse;
import id.ac.dharma_iswara.koperasimahasiswa.response.UserStatusResponse;
import retrofit.Callback;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    String session;
    static final String TAG = MainActivity.class.getSimpleName();
    private SQLiteHandler db;
    UserStatusResponse resp;
    List<UserStatus> users;
    DrawerLayout mDrawerLayout;
    List<Products> products;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new SQLiteHandler(getApplicationContext());

        HashMap<String, String> user = db.getUserDetails();

        String name = user.get("name");
        String email = user.get("email");
        session = user.get("session");

        Toolbar toolbar = (Toolbar) findViewById(R.id.menuToolbar);
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            VectorDrawableCompat indicator =
                    VectorDrawableCompat.create(getResources(), R.drawable.ic_menu, getTheme());
            indicator.setTint(ResourcesCompat.getColor(getResources(), R.color.colorwhite, getTheme()));
            supportActionBar.setHomeAsUpIndicator(indicator);
            supportActionBar.setTitle("");
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        //getProducts("catalog");

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        recyclerView = (RecyclerView) findViewById(R.id.re_list_pro);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        TextView nameView = (TextView) findViewById(R.id.name);
        TextView emailView = (TextView) findViewById(R.id.email);
        ImageView backView = (ImageView) findViewById(R.id.backNav);
        TextView logoutView = (TextView) findViewById(R.id.logout);
        TextView produkView = (TextView) findViewById(R.id.product);
        TextView cart_sizeView = (TextView) findViewById(R.id.cart_size);
        TextView cartView = (TextView) findViewById(R.id.cart);
        TextView kategoriView = (TextView) findViewById(R.id.category);
        TextView akunView = (TextView) findViewById(R.id.akun);
        TextView favView = (TextView) findViewById(R.id.fav);

        nameView.setText(name);
        emailView.setText(email);


        RestAdapter restAdapter = new RestAdapter.Builder()
                .setRequestInterceptor(new RequestInterceptor() {
                    @Override
                    public void intercept(RequestInterceptor.RequestFacade request) {

                    }
                })
                .setEndpoint(AppConfig.BASE_API_URL)
                .build();
        final ApiInterface apiInterface = restAdapter.create(ApiInterface.class);
        apiInterface.getcatalog("catalog", new Callback<ProductsResponse>() {
            @Override
            public void success(ProductsResponse productsResponse, Response response) {
                products = productsResponse.getModel();
                Log.e(TAG, productsResponse.getMsg());
                recyclerView.setAdapter(new ListProductsAdapter(products, R.layout.list_products, getApplicationContext()));
                Log.e(TAG, productsResponse.getCode().toString());
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e(TAG, "error"+error.getUrl());
            }
        });
    }

    private void addToCart(String product_id, int qty) {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setRequestInterceptor(new RequestInterceptor() {
                    @Override
                    public void intercept(RequestInterceptor.RequestFacade request) {
                        request.addHeader("Cookie", "frontend=" + session);
                    }
                })
                .setEndpoint(AppConfig.BASE_API_URL)
                .build();
        final ApiInterface apiInterface = restAdapter.create(ApiInterface.class);
        apiInterface.addtocart(product_id, qty, new Callback<CartQtyResponse>() {
            @Override
            public void success(CartQtyResponse cartQtyResponse, Response response) {
                Log.e(TAG, cartQtyResponse.getCode().toString());
                Log.e(TAG, cartQtyResponse.getMsg().toString());
                Log.e(TAG, response.getUrl());
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e(TAG, "erro cart"+error.toString());
            }
        });
    }

    private void getProducts(String catalog) {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setRequestInterceptor(new RequestInterceptor() {
                    @Override
                    public void intercept(RequestInterceptor.RequestFacade request) {
                        request.addHeader("Cookie", "frontend=" + session);
                    }
                })
                .setEndpoint(AppConfig.BASE_API_URL)
                .build();
        final ApiInterface apiInterface = restAdapter.create(ApiInterface.class);
        apiInterface.getcatalog(catalog, new Callback<ProductsResponse>() {
            @Override
            public void success(ProductsResponse productsResponse, Response response) {
                products = productsResponse.getModel();
                Log.e(TAG, productsResponse.getMsg());
                recyclerView.setAdapter(new ListProductsAdapter(products, R.layout.list_products, getApplicationContext()));
                Log.e(TAG, productsResponse.getCode().toString());
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e(TAG, error.getUrl());
            }
        });
    }
}
