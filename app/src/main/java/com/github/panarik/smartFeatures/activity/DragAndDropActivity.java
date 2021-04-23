package com.github.panarik.smartFeatures.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.panarik.smartFeatures.R;

public class DragAndDropActivity extends AppCompatActivity {

    private int total = 0;
    private int fail = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_and_drop);

        final Button dragButton = findViewById(R.id.dragAndDrop_button);
        final LinearLayout upLayout = findViewById(R.id.dragAndDrop_linerLayout_up);
        final TextView dropTotalTextVew = findViewById(R.id.dragAndDrop_totalTextView);
        final TextView dropSuccessTextVew = findViewById(R.id.dragAndDrop_successTextView);

        upLayout.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View view, DragEvent dragEvent) {
                final int dragAction = dragEvent.getAction();
                switch (dragAction) {
                    case DragEvent.ACTION_DRAG_STARTED:
                        break;
                    case DragEvent.ACTION_DRAG_EXITED:
                        break;
                    case DragEvent.ACTION_DRAG_ENTERED:
                        break;
                    case DragEvent.ACTION_DROP: {
                        fail++;
                        return true;
                    }
                    case DragEvent.ACTION_DRAG_ENDED: {
                        total++;
                        int value = total - fail;
                        dropSuccessTextVew.setText("Успешно: " + value);
                        dropTotalTextVew.setText("Всего: "+total);
                        return true;
                    }
                    default:
                        break;
                }
                return true;
            }
        });

        dragButton.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadow = new View.DragShadowBuilder(dragButton);
                view.startDrag(data, shadow, null, 0);
                return false;
            }
        });


    }
}