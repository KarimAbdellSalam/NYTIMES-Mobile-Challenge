package dev.ny.challenge.ui.main;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import dev.ny.challenge.callbacks.OnInteractionListener;
import dev.ny.challenge.data.model.Article;
import dev.ny.challenge.databinding.ArticlesHeaderListItemBinding;
import dev.ny.challenge.databinding.ArticlesListItemBinding;
import dev.ny.challenge.ui.base.BaseViewHolder;

import java.util.List;

/**
 * Created by Karim Abdell Salam on 1,JAN,2021
 */
public class ArticleListAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    public static final int VIEW_TYPE_NORMAL = 1;
    private static final int VIEW_TYPE_HEADER = 2;

    private List<Article> listItems;

    private OnInteractionListener mListener;

    public ArticleListAdapter(List<Article> list) {
        this.listItems = list;
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0)
            return VIEW_TYPE_HEADER;
        return VIEW_TYPE_NORMAL;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Nullable
    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_NORMAL) {
            ArticlesListItemBinding itemBinding = ArticlesListItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            return new ViewHolder(itemBinding);
        } else {
            ArticlesHeaderListItemBinding itemBinding = ArticlesHeaderListItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            return new HeaderViewHolder(itemBinding);
        }
    }

    public void addItems(@NonNull List<Article> list) {
        int insertIndex = listItems.size();
        listItems.addAll(list);
        if (insertIndex != 0)
            notifyItemRangeInserted(insertIndex, list.size());
        else
            notifyDataSetChanged();
    }

    public void clearItems() {
        listItems.clear();
    }

    public void updateItems(@NonNull List<Article> list) {
        clearItems();
        listItems.addAll(list);
        notifyDataSetChanged();
    }

    public void removeLastItems() {
        if (listItems.get(listItems.size() - 1) == null) {
            listItems.remove(listItems.size() - 1);
            notifyItemRemoved(listItems.size());
        }
    }

    public void setOnInteractionListener(OnInteractionListener listener) {
        this.mListener = listener;
    }

    public class ViewHolder extends BaseViewHolder implements OnInteractionListener {

        private final ArticlesListItemBinding binding;

        public ViewHolder(ArticlesListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        @Override
        public void onBind(int position) {
            Article item = listItems.get(position);
            ArticleItemViewModel itemViewModel = new ArticleItemViewModel(item, position, this);
            binding.setViewModel(itemViewModel);
            binding.executePendingBindings();
        }

        @Override
        public void onItemClicked(Article item, int position) {
            if (mListener != null)
                mListener.onItemClicked(item, position);
        }

        public ArticlesListItemBinding getBinding() {
            return binding;
        }
    }

    public class HeaderViewHolder extends BaseViewHolder implements OnInteractionListener {

        private final ArticlesHeaderListItemBinding binding;

        public ArticlesHeaderListItemBinding getBinding() {
            return binding;
        }

        public HeaderViewHolder(ArticlesHeaderListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        @Override
        public void onBind(int position) {
            Article item = listItems.get(position);
            ArticleItemViewModel itemViewModel = new ArticleItemViewModel(item, position, this);
            binding.setViewModel(itemViewModel);
            binding.executePendingBindings();
        }

        @Override
        public void onItemClicked(Article item, int position) {
            if (mListener != null)
                mListener.onItemClicked(item, position);
        }

    }
}
