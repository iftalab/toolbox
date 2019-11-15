package com.iftalab.toolbox;

import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageUtil {
    public static final void loadImage(String imagePath, ImageView imageView) {
        Glide.with(imageView)
                .load(imagePath)
                .centerCrop()
                .into(imageView);
    }
}
