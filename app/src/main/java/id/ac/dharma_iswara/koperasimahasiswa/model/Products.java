package id.ac.dharma_iswara.koperasimahasiswa.model;

/**
 * Created by winnerawan on 10/7/16.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Products {

    @SerializedName("entity_id")
    @Expose
    private String entityId;
    @SerializedName("sku")
    @Expose
    private String sku;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("rating_summary")
    @Expose
    private String ratingSummary;
    @SerializedName("reviews_count")
    @Expose
    private String reviewsCount;
    @SerializedName("news_from_date")
    @Expose
    private String newsFromDate;
    @SerializedName("news_to_date")
    @Expose
    private String newsToDate;
    @SerializedName("special_from_date")
    @Expose
    private Object specialFromDate;
    @SerializedName("special_to_date")
    @Expose
    private Object specialToDate;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("url_key")
    @Expose
    private String urlKey;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("regular_price_with_tax")
    @Expose
    private String regularPriceWithTax;
    @SerializedName("final_price_with_tax")
    @Expose
    private String finalPriceWithTax;
    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("stock_level")
    @Expose
    private Integer stockLevel;


    public Products() {
    }

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
     * The sku
     */
    public String getSku() {
        return sku;
    }

    /**
     *
     * @param sku
     * The sku
     */
    public void setSku(String sku) {
        this.sku = sku;
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
     * The ratingSummary
     */
    public String getRatingSummary() {
        return ratingSummary;
    }

    /**
     *
     * @param ratingSummary
     * The rating_summary
     */
    public void setRatingSummary(String ratingSummary) {
        this.ratingSummary = ratingSummary;
    }

    /**
     *
     * @return
     * The reviewsCount
     */
    public String getReviewsCount() {
        return reviewsCount;
    }

    /**
     *
     * @param reviewsCount
     * The reviews_count
     */
    public void setReviewsCount(String reviewsCount) {
        this.reviewsCount = reviewsCount;
    }

    /**
     *
     * @return
     * The newsFromDate
     */
    public String getNewsFromDate() {
        return newsFromDate;
    }

    /**
     *
     * @param newsFromDate
     * The news_from_date
     */
    public void setNewsFromDate(String newsFromDate) {
        this.newsFromDate = newsFromDate;
    }

    /**
     *
     * @return
     * The newsToDate
     */
    public String getNewsToDate() {
        return newsToDate;
    }

    /**
     *
     * @param newsToDate
     * The news_to_date
     */
    public void setNewsToDate(String newsToDate) {
        this.newsToDate = newsToDate;
    }

    /**
     *
     * @return
     * The specialFromDate
     */
    public Object getSpecialFromDate() {
        return specialFromDate;
    }

    /**
     *
     * @param specialFromDate
     * The special_from_date
     */
    public void setSpecialFromDate(Object specialFromDate) {
        this.specialFromDate = specialFromDate;
    }

    /**
     *
     * @return
     * The specialToDate
     */
    public Object getSpecialToDate() {
        return specialToDate;
    }

    /**
     *
     * @param specialToDate
     * The special_to_date
     */
    public void setSpecialToDate(Object specialToDate) {
        this.specialToDate = specialToDate;
    }

    /**
     *
     * @return
     * The imageUrl
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     *
     * @param imageUrl
     * The image_url
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     *
     * @return
     * The urlKey
     */
    public String getUrlKey() {
        return urlKey;
    }

    /**
     *
     * @param urlKey
     * The url_key
     */
    public void setUrlKey(String urlKey) {
        this.urlKey = urlKey;
    }

    /**
     *
     * @return
     * The price
     */
    public String getPrice() {
        return price;
    }

    /**
     *
     * @param price
     * The price
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     *
     * @return
     * The regularPriceWithTax
     */
    public String getRegularPriceWithTax() {
        return regularPriceWithTax;
    }

    /**
     *
     * @param regularPriceWithTax
     * The regular_price_with_tax
     */
    public void setRegularPriceWithTax(String regularPriceWithTax) {
        this.regularPriceWithTax = regularPriceWithTax;
    }

    /**
     *
     * @return
     * The finalPriceWithTax
     */
    public String getFinalPriceWithTax() {
        return finalPriceWithTax;
    }

    /**
     *
     * @param finalPriceWithTax
     * The final_price_with_tax
     */
    public void setFinalPriceWithTax(String finalPriceWithTax) {
        this.finalPriceWithTax = finalPriceWithTax;
    }

    /**
     *
     * @return
     * The symbol
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     *
     * @param symbol
     * The symbol
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     *
     * @return
     * The stockLevel
     */
    public Integer getStockLevel() {
        return stockLevel;
    }

    /**
     *
     * @param stockLevel
     * The stock_level
     */
    public void setStockLevel(Integer stockLevel) {
        this.stockLevel = stockLevel;
    }

}