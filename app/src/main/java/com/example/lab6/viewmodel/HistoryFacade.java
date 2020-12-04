package com.example.lab6.viewmodel;

import android.content.Context;

import com.example.lab6.model.Database;
import com.example.lab6.model.HistoryEntry;

import java.util.List;

public class HistoryFacade {
    public static void addItem(Context context, HistoryEntry newItem) {
        Database.getInstance(context).historyDao().addHistoryEntry(newItem);
    }

    public static void deleteAll(Context context) {
        Database.getInstance(context).historyDao().deleteAll();
    }

    public static String getAllAsString(Context context) {
        List<HistoryEntry> history = Database.getInstance(context).historyDao().getAll();
        StringBuilder resultBuilder = new StringBuilder();
        for (HistoryEntry historyEntry : history) {
            resultBuilder.append(historyEntry.getTextRepresentation()).append("\n");
        }
        return resultBuilder.toString();
    }

    public static List<HistoryEntry> getAllAsList(Context context) {
        return Database.getInstance(context).historyDao().getAll();
    }
}
