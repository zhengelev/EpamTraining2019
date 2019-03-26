package com.epam;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.epam.cleancodetest.R;

import java.util.Random;

public class AvatarView extends RelativeLayout {
    private ImageView avatarImage;

    public AvatarView(Context context) {
        super(context);
        init();
    }

    public AvatarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AvatarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.avatar_view, this);
        setGravity(Gravity.BOTTOM);
        avatarImage = findViewById(R.id.avatar_view_image);
        avatarImage.setOnClickListener(onClickColorChange);
    }

    private void changeImageColor() {
        Random random = new Random();
        avatarImage.setColorFilter(Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256)));
    }

    OnClickListener onClickColorChange = new OnClickListener() {
        @Override
        public void onClick(View v) {
            changeImageColor();
        }
    };
}
