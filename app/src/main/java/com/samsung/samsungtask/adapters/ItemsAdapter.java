package com.samsung.samsungtask.adapters;

import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.samsung.samsungtask.R;
import com.samsung.samsungtask.models.Task;

public class ItemsAdapter extends FirebaseRecyclerAdapter<Task, ItemsAdapter.UserViewHolder> {
    public ItemsAdapter(@NonNull FirebaseRecyclerOptions<Task> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull UserViewHolder holder, int position, @NonNull Task model) {
        holder.bind(model);
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new UserViewHolder(view);
    }

    class UserViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView idTextView;
        TextView infoTextView;
        TextView dateTextView;
        TextView importanceTextView;
        CheckBox checkBox;
        View divider;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            idTextView = itemView.findViewById(R.id.idTextView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            infoTextView = itemView.findViewById(R.id.infoTextView);
            dateTextView = itemView.findViewById(R.id.dateTextView);
            checkBox = itemView.findViewById(R.id.checkBox);
            importanceTextView = itemView.findViewById(R.id.importanceTextView);
            divider = itemView.findViewById(R.id.divider);
        }

        public void bind(Task task) {
            idTextView.setText(task.personName);
            nameTextView.setText(task.name);
            infoTextView.setText(task.info);
            importanceTextView.setText(task.importance);

            dateTextView.setText(task.date);

            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    System.out.println(b);
                    if (b) {
                        idTextView.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                        infoTextView.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                    }
                }
            });
        }
    }
}