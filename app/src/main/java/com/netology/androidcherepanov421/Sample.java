package com.netology.androidcherepanov421;

import android.content.Intent;
import android.graphics.drawable.Drawable;

class Sample {
    private final Drawable mPicPlace;
    private final Intent intent;

    private final String title;
    private final String category;



    Sample(String title, String category, Drawable mPicPlace, Intent intent) {

        this.title = title;
        this.category = category;
        this.mPicPlace = mPicPlace;
        this.intent = intent;
    }

    String getTitle() {

        return title;

    }

    String getCategory() {

        return category;

    }

    Drawable getScreenshot()
    {

        return mPicPlace;

    }

    Intent getIntent() {

        return intent;
    }
}
