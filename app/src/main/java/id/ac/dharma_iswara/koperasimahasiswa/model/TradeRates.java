package id.ac.dharma_iswara.koperasimahasiswa.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by winnerawan on 10/9/16.
 */
public class TradeRates {
    @SerializedName("total_results")
    @Expose
    private Integer totalResults;
    @SerializedName("trade_rates")
    @Expose
    private List<Review> reviews = new ArrayList<Review>();

    /**
     *
     * @return
     * The totalResults
     */
    public Integer getTotalResults() {
        return totalResults;
    }

    /**
     *
     * @param totalResults
     * The total_results
     */
    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    /**
     *
     * @return
     * The tradeRates
     */
    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
