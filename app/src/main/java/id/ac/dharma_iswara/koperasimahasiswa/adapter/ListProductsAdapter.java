package id.ac.dharma_iswara.koperasimahasiswa.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import org.ocpsoft.prettytime.PrettyTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import id.ac.dharma_iswara.koperasimahasiswa.R;
import id.ac.dharma_iswara.koperasimahasiswa.config.AppController;
import id.ac.dharma_iswara.koperasimahasiswa.helper.ItemClickSupport;
import id.ac.dharma_iswara.koperasimahasiswa.helper.MyTextView;
import id.ac.dharma_iswara.koperasimahasiswa.model.Products;

/*

 * Created by winnerawan on 10/7/16.

 */
public class ListProductsAdapter extends RecyclerView.Adapter<ListProductsAdapter.ProductsViewHolder> {
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();
    private List<Products> products;
    private int rowLayout;
    private Context context;

    public static class ProductsViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout productsLayout;
        TextView proName;
        NetworkImageView imageView;
        RatingBar rating;
        MyTextView price;
        MyTextView time;


        public ProductsViewHolder(View v) {
            super(v);
            productsLayout = (RelativeLayout) v.findViewById(R.id.productsLayout);
            proName = (TextView) v.findViewById(R.id.title);
            imageView = (NetworkImageView) v.findViewById(R.id.image);
            rating = (RatingBar) v.findViewById(R.id.ratings);
            price = (MyTextView) v.findViewById(R.id.price);
            time = (MyTextView) v.findViewById(R.id.timetext);
        }
    }

    public ListProductsAdapter(List<Products> products, int rowLayout, Context context) {
        this.products=products;
        this.rowLayout=rowLayout;
        this.context=context;
    }

    @Override
    public ProductsViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new ProductsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductsViewHolder holder, final int position) {
        holder.proName.setText(products.get(position).getName());
        String rate = products.get(position).getRatingSummary();
        if(rate==null) {
            holder.rating.setRating(0);
        } else {
            holder.rating.setRating(Integer.parseInt(products.get(position).getRatingSummary()) /20);
        }
        holder.price.setText("Rp "+products.get(position).getPrice());
        String humanTime = products.get(position).getNewsFromDate();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
        Date convertedDate = new Date();
        try {
            convertedDate = dateFormat.parse(humanTime);
        }catch (ParseException e) {
            e.printStackTrace();
        }
        PrettyTime p = new PrettyTime();
        String time = p.format(convertedDate);
        holder.time.setText(time);
        holder.imageView.setImageUrl(products.get(position).getImageUrl(), imageLoader);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        holder.productsLayout.setLayoutParams(params);

    }

    @Override
    public int getItemCount() {
        return products.size();
    }


}
