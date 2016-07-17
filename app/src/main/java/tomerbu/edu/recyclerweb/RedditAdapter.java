package tomerbu.edu.recyclerweb;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import tomerbu.edu.recyclerweb.models.Reddit;

/**
 * Created by stud27 on 17/07/16.
 */
public class RedditAdapter extends RecyclerView.Adapter<RedditAdapter.RedditViewHolder> {

    private LayoutInflater inflater;
    private Context context;
    private ArrayList<Reddit> data;

    public RedditAdapter(Context context, ArrayList<Reddit> data) {
        this.context = context;
        this.data = data;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public RedditViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.reddit_item, parent, false);
        return new RedditViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RedditViewHolder holder, int position) {
        final Reddit reddit = data.get(position);
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(reddit.getUrl());
                Intent detailsIntent = new Intent(Intent.ACTION_VIEW, uri);
                v.getContext().startActivity(detailsIntent);
            }
        });

        holder.tvTitle.setText(reddit.getTitle());
        Context context = holder.ivReddit.getContext();

        String url = reddit.getThumbnail();
        if (url.length() > 6)
            Picasso.
                    with(context).
                    load(url).
                    placeholder(R.drawable.reddit_icon).
                    error(R.mipmap.ic_launcher).
                    into(holder.ivReddit);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public class RedditViewHolder extends RecyclerView.ViewHolder {
        View itemView;
        RelativeLayout layout;
        ImageView ivReddit;
        TextView tvTitle;

        public RedditViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            layout = (RelativeLayout) itemView.findViewById(R.id.layout);
            ivReddit = (ImageView) itemView.findViewById(R.id.ivReddit);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
        }
    }
}
