package id.ac.dharma_iswara.koperasimahasiswa.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by winnerawan on 10/9/16.
 */
public class Review {
    @SerializedName("uname")
    @Expose
    private String uname;
    @SerializedName("item_id")
    @Expose
    private String itemId;
    @SerializedName("rate_score")
    @Expose
    private Integer rateScore;
    @SerializedName("rate_content")
    @Expose
    private String rateContent;
    @SerializedName("rate_date")
    @Expose
    private String rateDate;
    @SerializedName("rate_title")
    @Expose
    private String rateTitle;

    /**
     *
     * @return
     * The uname
     */
    public String getUname() {
        return uname;
    }

    /**
     *
     * @param uname
     * The uname
     */
    public void setUname(String uname) {
        this.uname = uname;
    }

    /**
     *
     * @return
     * The itemId
     */
    public String getItemId() {
        return itemId;
    }

    /**
     *
     * @param itemId
     * The item_id
     */
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    /**
     *
     * @return
     * The rateScore
     */
    public Integer getRateScore() {
        return rateScore;
    }

    /**
     *
     * @param rateScore
     * The rate_score
     */
    public void setRateScore(Integer rateScore) {
        this.rateScore = rateScore;
    }

    /**
     *
     * @return
     * The rateContent
     */
    public String getRateContent() {
        return rateContent;
    }

    /**
     *
     * @param rateContent
     * The rate_content
     */
    public void setRateContent(String rateContent) {
        this.rateContent = rateContent;
    }

    /**
     *
     * @return
     * The rateDate
     */
    public String getRateDate() {
        return rateDate;
    }

    /**
     *
     * @param rateDate
     * The rate_date
     */
    public void setRateDate(String rateDate) {
        this.rateDate = rateDate;
    }

    /**
     *
     * @return
     * The rateTitle
     */
    public String getRateTitle() {
        return rateTitle;
    }

    /**
     *
     * @param rateTitle
     * The rate_title
     */
    public void setRateTitle(String rateTitle) {
        this.rateTitle = rateTitle;
    }
}
