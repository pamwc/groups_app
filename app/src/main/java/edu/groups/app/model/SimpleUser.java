package edu.groups.app.model;

import android.os.Parcel;
import android.os.Parcelable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Dawid Świnoga on 19.11.2017.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimpleUser implements Parcelable {
    private String username;
    private String firstName;
    private String surname;

    protected SimpleUser(Parcel in) {
        username = in.readString();
        firstName = in.readString();
        surname = in.readString();
    }

    public static final Creator<SimpleUser> CREATOR = new Creator<SimpleUser>() {
        @Override
        public SimpleUser createFromParcel(Parcel in) {
            return new SimpleUser(in);
        }

        @Override
        public SimpleUser[] newArray(int size) {
            return new SimpleUser[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(username);
        parcel.writeString(firstName);
        parcel.writeString(surname);
    }
}
