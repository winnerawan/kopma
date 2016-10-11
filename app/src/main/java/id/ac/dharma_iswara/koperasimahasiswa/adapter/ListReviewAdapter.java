package id.ac.dharma_iswara.koperasimahasiswa.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RatingBar;

import java.util.List;

import id.ac.dharma_iswara.koperasimahasiswa.R;
import id.ac.dharma_iswara.koperasimahasiswa.helper.MyTextView;
import id.ac.dharma_iswara.koperasimahasiswa.model.Review;

/**
 * Created by winnerawan on 10/9/16.
 */
public class ListReviewAdapter  extends RecyclerView.Adapter<ListReviewAdapter.ReviewViewHolder>{

    private List<Review> reviews;
    private Context context;
    private int rowLayout;

    public static class ReviewViewHolder extends RecyclerView.ViewHolder{
        LinearLayout reviewLayout;
        MyTextView nameView;
        MyTextView textView;
        RatingBar ratingBar;

        public ReviewViewHolder(View v) {
            super(v);
            reviewLayout = (LinearLayout) v.findViewById(R.id.reviewLayout);
            nameView = (MyTextView) v.findViewById(R.id.name);
            textView = (MyTextView) v.findViewById(R.id.review_text);
            ratingBar = (RatingBar) v.findViewById(R.id.ratings);
        }
    }
    public ListReviewAdapter(List<Review> reviews, int rowLayout, Context context) {
        this.reviews=reviews;
        this.context=context;
        this.rowLayout=rowLayout;
    }

    @Override
    public ReviewViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new ReviewViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ReviewViewHolder holder, int position) {
        holder.nameView.setText(reviews.get(position).getUname());
        holder.textView.setText(reviews.get(position).getRateContent());
        String rate = String.valueOf(reviews.get(position).getRateScore());
        if(rate==null) {
            holder.ratingBar.setRating(0);
        } else {
            holder.ratingBar.setRating(reviews.get(position).getRateScore()/20);
        }
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        holder.reviewLayout.setLayoutParams(params);
    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }
}
