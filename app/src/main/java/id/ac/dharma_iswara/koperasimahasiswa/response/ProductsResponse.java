package id.ac.dharma_iswara.koperasimahasiswa.response;

/**
 * Created by winnerawan on 10/7/16.
 */
import android.app.ProgressDialog;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import id.ac.dharma_iswara.koperasimahasiswa.model.Products;

public class ProductsResponse {

    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("model")
    @Expose
    private List<Products> model = new ArrayList<Products>();

    /**
     *
     * @return
     * The code
     */
    public Integer getCode() {
        return code;
    }

    /**
     *
     * @param code
     * The code
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     *
     * @return
     * The msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     *
     * @param msg
     * The msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     *
     * @return
     * The model
     */
    public List<Products> getModel() {
        return model;
    }

    public void setModel(List<Products> model) {
        this.model = model;
    }
}