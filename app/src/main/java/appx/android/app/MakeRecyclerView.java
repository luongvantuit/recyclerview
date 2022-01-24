package appx.android.app;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import appx.android.recyclerview.IRecyclerView;

public class MakeRecyclerView extends IRecyclerView<Integer> {

    public MakeRecyclerView(@NonNull Context context) {
        super(context);
    }

    public MakeRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MakeRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onBindViewHolder(@NonNull IRecyclerView.ViewHolder holder, int position) {
        TextView view = holder.itemView.findViewById(R.id.m_text);
        view.setText(String.valueOf(getItems().get(position)));
    }

    @Override
    public int getItemLayoutId() {
        return R.layout.item_recyclerview;
    }
}
