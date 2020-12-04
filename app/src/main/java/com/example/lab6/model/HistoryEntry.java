package com.example.lab6.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "history")
public class HistoryEntry implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "sum")
    private String sum;
    @ColumnInfo(name = "first_number")
    private String firstNumber;
    @ColumnInfo(name = "second_number")
    private String secondNumber;

    public String getSum() {
        return sum;
    }

    public String getFirstNumber() {
        return firstNumber;
    }

    public String getSecondNumber() {
        return secondNumber;
    }

    public HistoryEntry(String sum, String firstNumber, String secondNumber) {
        this.sum = sum;
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public static final Creator<HistoryEntry> CREATOR = new Creator<HistoryEntry>() {
        @Override
        public HistoryEntry createFromParcel(Parcel in) {
            return new HistoryEntry(in);
        }

        @Override
        public HistoryEntry[] newArray(int size) {
            return new HistoryEntry[size];
        }
    };

    public String getTextRepresentation() {
        return String.format("Result of sum %1s and %2s = %3s", firstNumber, secondNumber, sum);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    protected HistoryEntry(Parcel in) {
        firstNumber = in.readString();
        secondNumber = in.readString();
        sum = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(firstNumber);
        dest.writeString(secondNumber);
        dest.writeString(sum);
    }
}
