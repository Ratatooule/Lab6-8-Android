package com.example.lab6.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab6.R;
import com.example.lab6.model.HistoryEntry;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryItemViewHolder> {

    private ArrayList<HistoryEntry> history;

    HistoryAdapter() {
        history = new ArrayList<>();
    }

    void initialize(ArrayList<HistoryEntry> history) {
        this.history = history;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HistoryItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.history_item, viewGroup, false);
        return new HistoryItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryItemViewHolder historyItemViewHolder, int i) {
        historyItemViewHolder.bind(history.get(i));
    }

    @Override
    public int getItemCount() {
        return history.size();
    }

    class HistoryItemViewHolder extends RecyclerView.ViewHolder {

        private TextView historyText;

        HistoryItemViewHolder(View itemView) {
            super(itemView);
            historyText = itemView.findViewById(R.id.history_text);
        }

        void bind(final HistoryEntry historyItem) {
            historyText.setText(historyItem.getTextRepresentation());
        }
    }
}

