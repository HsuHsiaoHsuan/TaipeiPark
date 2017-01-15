package funnybrain.hsu.idv.taipeipark;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import funnybrain.hsu.idv.taipeipark.restful.model.Park;

public class ParkAdapter extends RecyclerView.Adapter<ParkAdapter.ViewHolder> {
    private final Context mContext;
    private List<Park> list;

    public ParkAdapter(Context context, List<Park> list) {
        mContext = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_park, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(list.get(position).getParkName() + "\n" + list.get(position).getPicName());
        Glide.with(mContext).load(list.get(position).getImage()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_img) ImageView image;
        @BindView(R.id.tv_title) TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
