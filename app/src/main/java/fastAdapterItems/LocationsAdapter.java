package fastAdapterItems;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.geeks.hackathon.R;

import java.util.ArrayList;
import java.util.Currency;
import java.util.Locale;

import api.response.User;
import butterknife.BindView;
import butterknife.ButterKnife;



/**
 * Created by Mohamed Ramadan on 2/6/2018.
 */

public class LocationsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_ITEM = 1;

    private int screenType = 0;

   Context  context;
    ArrayList<User> data;
    public LocationsAdapter(Context context , ArrayList<User> data , int screenType) {
        this.context = context;

        this.data=data;

        this.screenType = screenType;

    }





    @Override
    public int getItemViewType(int position) {
        return 0;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;

            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.location_item, parent, false);
            return new ItemViewHolder(v);



    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);


            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;

           /* Picasso.get()
                    .load(BASE_URL + "/" + item.getImage())
                    .transform(new CircleTransformation())
                    .placeholder(R.drawable.pizza)
                    .into(((ItemViewHolder) holder).ivProductProfileImage);*/
            User user = data.get(position);
            itemViewHolder.ivFirst.setText(user.getUserName());

            if(screenType == 0 ){

                itemViewHolder.ivSecond.setText(user.getPhone());
            }
            else{
              // itemViewHolder.ivSecond.setIm

                Resources res = context.getResources(); /** from an Activity */
                itemViewHolder.ivProductProfileImage.setImageDrawable(res.getDrawable(R.drawable.home));
            }




        }



    @Override
    public int getItemCount() {
        //return itemList.size();
        //return data.size();

        return data.size();
    }


    protected static class ItemViewHolder extends RecyclerView.ViewHolder {
        //bind item views
        @BindView(R.id.item_image)
        ImageView ivProductProfileImage;

        @BindView(R.id.item_first)
        TextView ivFirst;
        @BindView(R.id.item_second)
        TextView ivSecond;


        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }



}
