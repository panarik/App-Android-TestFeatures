package com.github.panarik.smartFeatures.data.chat;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.github.panarik.smartFeatures.R;

import java.util.List;

public class ChatMessageAdapter extends ArrayAdapter<ChatMessage> {

    //поля для своих\чужих сообщений в чате
    private List<ChatMessage> messages;
    private Activity activity;

    public ChatMessageAdapter(Activity context, //передаем активити с разными сообщениями
                              int resource, List<ChatMessage> messages) {
        super(context, resource, messages);

        this.messages = messages;
        this.activity = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        ViewHolder viewHolder;
        LayoutInflater layoutInflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        //переключаем разметки message item в зависимости от состояния Boolean isMine
        ChatMessage chatMessage = getItem(position);
        int layoutResource = 0;
        int viewType = getItemViewType(position); //тип view. Теперь он получает flag со статусом сообщения

        if (viewType == 0) {
            layoutResource = R.layout.chat_my_message_item;
        } else {
            layoutResource = R.layout.chat_your_message_item;
        }


        if (convertView != null) //если существующий convertView
        {
            viewHolder = (ViewHolder) convertView.getTag();
        } else {
            //если новый convertView
            convertView = layoutInflater.inflate(layoutResource, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }

        //проверяем является ли сообщение текстом или изображением
        boolean isText = chatMessage.getImageUrl() == null;
        if (isText) //если текст
        {
            viewHolder.chat_messageTextView.setVisibility(View.VISIBLE);
            viewHolder.chat_messageImageView.setVisibility(View.GONE);
            viewHolder.chat_messageTextView.setText(chatMessage.getText());
        } else // если изображение
        {
            viewHolder.chat_messageTextView.setVisibility(View.GONE);
            viewHolder.chat_messageImageView.setVisibility(View.VISIBLE);
            //загружаем фото
            Glide.with(viewHolder.chat_messageImageView.getContext())
                    .load(chatMessage.getImageUrl())
                    .into(viewHolder.chat_messageImageView);
        }


        //до перехода на разные layout в сообщениях
        /*
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
        if (isText) {
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
         */

        return convertView;
    }


    //переопределяем метод getItemViewType() для использования с текущим viewType
    @Override
    public int getItemViewType(int position) {
        int flag;
        ChatMessage chatMessage = messages.get(position);
        if (chatMessage.getIsMine()) {
            flag = 0;
        } else {
            flag = 1;
        }
        return flag;
    }


    //возвращаем количество разметок
    @Override
    public int getViewTypeCount() {
        return 2;
    }

    //создаём ViewHolder аналогично RecycleView (для разных типов сообщений)
    private class ViewHolder {

        //поля для отображения разных сообщений в чате
        private ImageView chat_messageImageView;
        private TextView chat_messageTextView;

        public ViewHolder(View view) {
            chat_messageImageView = view.findViewById(R.id.chat_messageImageView);
            chat_messageTextView = view.findViewById(R.id.chat_messageTextView);
        }


    }
}
