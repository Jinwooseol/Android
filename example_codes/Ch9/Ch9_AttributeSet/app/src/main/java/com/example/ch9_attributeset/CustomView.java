package com.example.ch9_attributeset;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.annotation.Nullable;

public class CustomView extends AppCompatTextView {

    public CustomView(Context context) {
        super(context);
        init(context, null);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray a = context.getTheme().obtainStyledAttributes(
                    attrs,
                    R.styleable.CustomView,
                    0, 0);

            try {
                String customText = a.getString(R.styleable.CustomView_customText);
                int customColor = a.getColor(R.styleable.CustomView_customColor, Color.BLACK);

                setText(customText);
                setTextColor(customColor);
            } finally {
                a.recycle();
            }
        }
    }
}
