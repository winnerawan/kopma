package id.ac.dharma_iswara.koperasimahasiswa.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by winnerawan on 10/10/16.
 */
public class UserStatus {

    @SerializedName("entity_id")
    @Expose
    private String entityId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("avatar")
    @Expose
    private Object avatar;
    @SerializedName("tel")
    @Expose
    private Object tel;
    @SerializedName("session")
    @Expose
    private String session;

    /**
     *
     * @return
     * The entityId
     */
    public String getEntityId() {
        return entityId;
    }

    /**
     *
     * @param entityId
     * The entity_id
     */
    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The email
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     * The email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     * The avatar
     */
    public Object getAvatar() {
        return avatar;
    }

    /**
     *
     * @param avatar
     * The avatar
     */
    public void setAvatar(Object avatar) {
        this.avatar = avatar;
    }

    /**
     *
     * @return
     * The tel
     */
    public Object getTel() {
        return tel;
    }

    /**
     *
     * @param tel
     * The tel
     */
    public void setTel(Object tel) {
        this.tel = tel;
    }

    /**
     *
     * @return
     * The session
     */
    public String getSession() {
        return session;
    }

    /**
     *
     * @param session
     * The session
     */
    public void setSession(String session) {
        this.session = session;
    }
}
