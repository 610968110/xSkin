package lbx.xskinlib.skin;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import lbx.xskinlib.ResourceManager;
import lbx.xskinlib.xSkin;

/**
 * @author lbx
 * @date 2017/11/6.
 */

public enum SkinType {

    BACKGROUND("background") {
        @Override
        void apply(View view, String resName) {
            Drawable drawable = getResourceManager().getBackgroundByName(resName);
            if (drawable != null) {
                view.setBackgroundDrawable(drawable);
            }
        }
    }, TEXT_COLOR("textColor") {
        @Override
        void apply(View view, String resName) {
            ColorStateList colorStateList = getResourceManager().getColorByName(resName);
            if (colorStateList != null) {
                ((TextView) view).setTextColor(colorStateList);
            }
        }
    }, TEXT("text") {
        @Override
        void apply(View view, String resName) {
            String text = getResourceManager().getStringByName(resName);
            if (text != null) {
                ((TextView) view).setText(text);
            }
        }
    }, TEXT_SIZE("textSize") {
        @Override
        void apply(View view, String resName) {
            float px = getResourceManager().getDimensionByName(resName);
            if (px != -1F) {
                ((TextView) view).setTextSize(px);
            }
        }
    }, SRC("src") {
        @Override
        void apply(View view, String resName) {
            if (view instanceof ImageView) {
                Drawable drawable = getResourceManager().getBackgroundByName(resName);
                if (drawable != null) {
                    ((ImageView) view).setImageDrawable(drawable);
                }
            }
        }
    };

    private static ResourceManager getResourceManager() {
        return xSkin.getInstance().getResourceManager();
    }


    private String mValue;

    SkinType(String value) {
        mValue = value;
    }

    public String getValue() {
        return mValue;
    }

    abstract void apply(View view, String resName);
}
