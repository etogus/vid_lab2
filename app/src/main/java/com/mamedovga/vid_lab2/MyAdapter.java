package com.mamedovga.vid_lab2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<String> items;
    private List<Integer> images;
    private Context context;

    public MyAdapter(Context context, List<String> items, List<Integer> images) {
        this.context = context;
        this.items = items;
        this.images = images;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view).linkAdapter(this);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.title.setText(items.get(position));
        holder.image.setImageResource(images.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private MyAdapter myAdapter;
        private TextView title;
        private ImageView image;
        private Button deleteButton;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.myTextView1);
            image = itemView.findViewById(R.id.myImageView);
            deleteButton = itemView.findViewById(R.id.delete);
            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    myAdapter.items.remove(getAdapterPosition());
                    myAdapter.notifyItemRemoved(getAdapterPosition());
                }
            });
        }

        public MyViewHolder linkAdapter(MyAdapter myAdapter) {
            this.myAdapter = myAdapter;
            return this;
        }
    }
}
