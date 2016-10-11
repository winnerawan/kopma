package id.ac.dharma_iswara.koperasimahasiswa.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import id.ac.dharma_iswara.koperasimahasiswa.model.UserStatus;

/**
 * Created by winnerawan on 10/10/16.
 */
public class UserStatusResponse {

    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("msg")
    @Expose
    private Object msg;
    @SerializedName("model")
    @Expose
    private List<UserStatus> model;

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
    public List<UserStatus> getModel() {
        return model;
    }

    public void setModel(List<UserStatus> model) {
        this.model = model;
    }
}
