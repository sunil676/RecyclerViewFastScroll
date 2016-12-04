package com.sunil.recyclerviewfastscroll;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.simplecityapps.recyclerview_fastscroll.views.FastScrollRecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sunil on 12/3/16.
 */

public class RecyclerItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements FastScrollRecyclerView.SectionedAdapter {

    private List<ItemModel> itemModels;
    private Context context;

    public RecyclerItemAdapter(Context context, List<ItemModel> wallTalls) {
        this.itemModels = wallTalls;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return itemModels.size();
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout, viewGroup, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ItemModel model = itemModels.get(position);
        initializeViews(model, holder, position);
    }


    private void initializeViews(ItemModel model, final RecyclerView.ViewHolder holder, int position) {

        String imageUrl = model.getImagePath();
        if (imageUrl != null && !imageUrl.isEmpty()){
            Glide.with(context)
                    .load(imageUrl)
                    .into(((ItemViewHolder)holder).imageView);

            }
            ((ItemViewHolder)holder).name.setText(model.getName());
        }

        @NonNull
        @Override
        public String getSectionName(int position) {
            return Character.toString(itemModels.get(position).getName().charAt(0));
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.imageView)
        ImageView imageView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
