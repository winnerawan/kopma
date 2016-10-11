package id.ac.dharma_iswara.koperasimahasiswa.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import id.ac.dharma_iswara.koperasimahasiswa.model.TradeRates;

/**
 * Created by winnerawan on 10/9/16.
 */
public class ReviewResponse {

    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("model")
    @Expose
    private TradeRates model;

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
    public TradeRates getModel() {
        return model;
    }

    /**
     *
     * @param model
     * The model
     */
    public void setModel(TradeRates model) {
        this.model = model;
    }
}
