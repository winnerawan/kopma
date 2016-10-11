package id.ac.dharma_iswara.koperasimahasiswa.config;

import id.ac.dharma_iswara.koperasimahasiswa.model.UserStatus;
import id.ac.dharma_iswara.koperasimahasiswa.response.CartQtyResponse;
import id.ac.dharma_iswara.koperasimahasiswa.response.LoginResponse;
import id.ac.dharma_iswara.koperasimahasiswa.response.ProductsResponse;
import id.ac.dharma_iswara.koperasimahasiswa.response.UserStatusResponse;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Query;

/**
 * Created by winnerawan on 10/11/16.
 */
public interface ApiInterface {

    @POST("/customer/login")
    void authenticate(@Query("username") String username, @Query("password") String password, Callback<LoginResponse> cb);
    @GET("/customer/status")
    void status(Callback<UserStatusResponse> cb);
    @GET("/customer/status")
    void status2(Callback<UserStatus> cb);
    @GET("/index/index")
    void getcatalog(@Query("cmd") String cmd, Callback<ProductsResponse> cb);
    @POST("/cart/add")
    void addtocart(@Query("product_id") String product_id, @Query("qty") int qty, Callback<CartQtyResponse> cb);
}
