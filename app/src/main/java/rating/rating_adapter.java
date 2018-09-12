package rating;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nicholasparmee.twitter.R;


/**
 * Created by nicholasparmee on 2018/02/23.
 */

public class rating_adapter extends RecyclerView.Adapter<rating_adapter.ViewHolder>{


    private int imagenum;
    private String[] scrollitems;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView image1;
        private ImageView image2;
        private ImageView image3;
        private ImageView image4;
        private ImageView image5;

        private TextView ratingTitle;


        private ViewHolder(View v) {
            super(v);

            image1 = v.findViewById(R.id.star1);
            image2 = v.findViewById(R.id.star2);
            image3 = v.findViewById(R.id.star3);
            image4 = v.findViewById(R.id.star4);
            image5 = v.findViewById(R.id.star5);
            ratingTitle = v.findViewById(R.id.rating_text);

        }

    }

    public rating_adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.ratingcard, parent, false);
        rating_adapter.ViewHolder vh = new rating_adapter.ViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        holder.ratingTitle.setText(scrollitems[position]);


        holder.image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.image1.setImageResource(R.drawable.stargold);
                holder.image2.setImageResource(R.drawable.star);
                holder.image3.setImageResource(R.drawable.star);
                holder.image4.setImageResource(R.drawable.star);
                holder.image5.setImageResource(R.drawable.star);
            }
        });

        holder.image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.image1.setImageResource(R.drawable.stargold);
                holder.image2.setImageResource(R.drawable.stargold);
                holder.image3.setImageResource(R.drawable.star);
                holder.image4.setImageResource(R.drawable.star);
                holder.image5.setImageResource(R.drawable.star);
            }
        });

        holder.image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                holder.image1.setImageResource(R.drawable.stargold);
                holder.image2.setImageResource(R.drawable.stargold);
                holder.image3.setImageResource(R.drawable.stargold);
                holder.image4.setImageResource(R.drawable.star);
                holder.image5.setImageResource(R.drawable.star);
            }
        });

        holder.image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                holder.image1.setImageResource(R.drawable.stargold);
                holder.image2.setImageResource(R.drawable.stargold);
                holder.image3.setImageResource(R.drawable.stargold);
                holder.image4.setImageResource(R.drawable.stargold);
                holder.image5.setImageResource(R.drawable.star);
            }
        });

        holder.image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                holder.image1.setImageResource(R.drawable.stargold);
                holder.image2.setImageResource(R.drawable.stargold);
                holder.image3.setImageResource(R.drawable.stargold);
                holder.image4.setImageResource(R.drawable.stargold);
                holder.image5.setImageResource(R.drawable.stargold);
            }
        });


    }


    public rating_adapter(String[] scrollitems){

        this.scrollitems = scrollitems;
    }


    @Override
    public int getItemCount() {
        return scrollitems.length;
    }



}
