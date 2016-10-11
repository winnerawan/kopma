package id.ac.dharma_iswara.koperasimahasiswa.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import id.ac.dharma_iswara.koperasimahasiswa.model.User;

/**
 * Created by winnerawan on 10/11/16.
 */
public class LoginResponse {

    @SerializedName("code")
    @Expose
    public Integer code;
    @SerializedName("msg")
    @Expose
    public Object msg;
    @SerializedName("model")
    @Expose
    public User user;

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
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
