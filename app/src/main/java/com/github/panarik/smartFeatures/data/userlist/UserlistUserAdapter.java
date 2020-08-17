package com.github.panarik.smartFeatures.data.userlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.panarik.smartFeatures.R;
import com.github.panarik.smartFeatures.data.chat.ChatUser;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

import java.util.ArrayList;

public class UserlistUserAdapter
        extends RecyclerView.Adapter<UserlistUserAdapter.UserViewHolder> {

    private ArrayList<ChatUser> users;
    private OnUserClickListener listener;

    public interface OnUserClickListener {
        void onUserClick(int position);
    }

    public void setOnUserClickListener(OnUserClickListener listener) {
        this.listener = listener;
    }

    public UserlistUserAdapter(ArrayList<ChatUser> users){
        this.users = users;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.userlist_user_item, viewGroup, false);
        UserViewHolder viewHolder = new UserViewHolder(view, listener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder userViewHolder, int i) {
        ChatUser currentUser = users.get(i);
        userViewHolder.userList_avatar_imageView.setImageResource(currentUser.getAvatarMockUpResource());
        userViewHolder.userList_userName_textView.setText(currentUser.getUserName());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {

        public ImageView userList_avatar_imageView;
        public TextView userList_userName_textView;

        public UserViewHolder(@NonNull View itemView, final OnUserClickListener listener) {
            super(itemView);
            userList_avatar_imageView = itemView.findViewById(R.id.userList_avatar_imageView);
            userList_userName_textView = itemView.findViewById(R.id.userList_userName_textView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();

                        if (position != RecyclerView.NO_POSITION) {
                            listener.onUserClick(position);
                        }
                    }

                }
            });

        }
    }
}
