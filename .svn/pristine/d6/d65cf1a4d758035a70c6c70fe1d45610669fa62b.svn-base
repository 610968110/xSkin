package lbx.xskinlib.skin;

import android.view.View;

public class SkinAttr {

    private String mResName;
    private SkinType mSkinAttr;


    SkinAttr(SkinType attrType,  String resName) {
        this.mSkinAttr = attrType;
        this.mResName = resName;
    }

    void apply(View view) {
        mSkinAttr.apply(view, mResName);
    }
}
