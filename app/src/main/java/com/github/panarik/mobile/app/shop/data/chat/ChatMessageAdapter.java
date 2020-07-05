package com.github.panarik.mobile.app.shop.data.chat;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.github.panarik.mobile.app.shop.R;

import java.util.List;

public class ChatMessageAdapter extends ArrayAdapter<ChatMessage> {

    public ChatMessageAdapter
            (Context context,
             int resource,
             List<ChatMessage> messages) {
        super(context, resource, messages);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = ((Activity) getContext())
                    .getLayoutInflater()
                    .inflate(R.layout.chat_message_item, parent, false);
        }

        ImageView chat_photoImageView = convertView.findViewById(R.id.chat_photoImageView);
        TextView chat_textTextView = convertView.findViewById(R.id.chat_textTextView);
        TextView chat_nameTextView = convertView.findViewById(R.id.chat_nameTextView);

        ChatMessage message = getItem(position);

        //выбор между отправкой сообщения или отправкой изображения
        boolean isText = message.getImageUrl() == null;

        //если фото нет, то отправляем в сообщении только текст
        if (isText){
            chat_textTextView.setVisibility(View.VISIBLE);
            chat_photoImageView.setVisibility(View.GONE);
            chat_textTextView.setText(message.getText());
        } else {
            //если есть фото, то текст скрываем
            chat_textTextView.setVisibility(View.GONE);
            chat_photoImageView.setVisibility(View.VISIBLE);
            //и загружаем фото
            Glide.with(chat_photoImageView.getContext())
                    .load(message.getImageUrl())
                    .into(chat_photoImageView);
        }

        //устанавливаем подпись в любом случае
        chat_nameTextView.setText(message.getName());

        return convertView;
    }
}
