package id.ac.dharma_iswara.koperasimahasiswa.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import id.ac.dharma_iswara.koperasimahasiswa.model.CartQty;

/**
 * Created by winnerawan on 10/9/16.
 */
public class CartQtyResponse {

    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("msg")
    @Expose
    private Object msg;
    @SerializedName("model")
    @Expose
    private CartQty model;

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
    public Object getMsg() {
        return msg;
    }

    /**
     *
     * @param msg
     * The msg
     */
    public void setMsg(Object msg) {
        this.msg = msg;
    }

    /**
     *
     * @return
     * The model
     */
    public CartQty getModel() {
        return model;
    }

    /**
     *
     * @param model
     * The model
     */
    public void setModel(CartQty model) {
        this.model = model;
    }
}
