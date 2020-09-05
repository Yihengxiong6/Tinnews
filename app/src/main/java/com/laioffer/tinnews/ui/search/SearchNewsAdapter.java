package com.laioffer.tinnews.ui.search;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.laioffer.tinnews.R;
import com.laioffer.tinnews.databinding.SearchNewsItemBinding;
import com.laioffer.tinnews.model.Article;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class SearchNewsAdapter extends RecyclerView.Adapter<SearchNewsAdapter.SearchNewsViewHolder> {
    // 1. Supporting data:
    // TODO
    private List<Article> articles = new ArrayList<>(); // recycled view 要用的数据

    public void setArticles(List<Article> newsList) {
        articles.clear(); // 有data进来先去掉以前的
        articles.addAll(newsList);
        notifyDataSetChanged(); // 告诉view重重新binding一遍新进来的数据
    }

    @NonNull
    @Override
    public SearchNewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // data 进来会create 3个viewHolder然后bind三个，当滑动后才会buffer
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_news_item, parent, false);
        return new SearchNewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchNewsViewHolder holder, int position) {
        Article article = articles.get(position);
        holder.favoriteImageView.setImageResource(R.drawable.ic_favorite_24dp);
        holder.itemTitleTextView.setText(article.title);
        Picasso.get().load(article.urlToImage).into(holder.itemImageView);
    }

    @Override
    public int getItemCount() {  // ready 的数据有多少个
        return articles.size();
    }


    public static class SearchNewsViewHolder extends RecyclerView.ViewHolder {

        ImageView favoriteImageView;
        ImageView itemImageView;
        TextView itemTitleTextView;

        // nonNull 这个不能存在null
        public SearchNewsViewHolder(@NonNull View itemView) { // view holder 对应每一个item (news item)
            super(itemView);
            SearchNewsItemBinding binding = SearchNewsItemBinding.bind(itemView);
            favoriteImageView = binding.searchItemFavorite;
            itemImageView = binding.searchItemImage;
            itemTitleTextView = binding.searchItemTitle;
        }
    }
}