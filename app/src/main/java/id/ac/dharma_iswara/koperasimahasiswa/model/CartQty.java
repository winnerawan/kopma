package id.ac.dharma_iswara.koperasimahasiswa.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by winnerawan on 10/9/16.
 */
public class CartQty {
    @SerializedName("items_qty")
    @Expose
    private Integer itemsQty;

    /**
     *
     * @return
     * The itemsQty
     */
    public Integer getItemsQty() {
        return itemsQty;
    }

    /**
     *
     * @param itemsQty
     * The items_qty
     */
    public void setItemsQty(Integer itemsQty) {
        this.itemsQty = itemsQty;
    }
}
