package appx.android.recyclerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public abstract class IRecyclerView<T> extends RecyclerView {

    private List<T> mItems;

    public IRecyclerView(@NonNull Context context) {
        this(context, null);
    }

    public IRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public IRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialization();
    }

    private void initialization() {
        final IRecyclerView<T>.Adapter mAdapter = new IRecyclerView<T>.Adapter();
        final LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        mItems = new ArrayList<>();
        IRecyclerView.this.setAdapter(mAdapter);
        IRecyclerView.this.setLayoutManager(mLayoutManager);
    }

    public class Adapter extends RecyclerView.Adapter<IRecyclerView.ViewHolder> {

        @NonNull
        @Override
        public IRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(IRecyclerView.this.getItemLayoutId(), parent, false);
            return new IRecyclerView.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull IRecyclerView.ViewHolder holder, int position) {
            IRecyclerView.this.onBindViewHolder(holder, position);
        }


        @Override
        public int getItemCount() {
            return IRecyclerView.this.getItemCount();
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

    }

    abstract public void onBindViewHolder(@NonNull IRecyclerView.ViewHolder holder, int position);

    abstract public int getItemLayoutId();

    public int getItemCount() {
        if (IRecyclerView.this.getItems() == null) {
            return 0;
        }
        return IRecyclerView.this.getItems().size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void notifyDataSetChanged() {
        post(() -> {
            if (getAdapter() != null) {
                getAdapter().notifyDataSetChanged();
            }
        });
    }

    public void setItems(List<T> items) {
        IRecyclerView.this.mItems = items;
        IRecyclerView.this.notifyDataSetChanged();
    }

    public List<T> getItems() {
        return mItems;
    }


}
