package lbx.xskin;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import lbx.xskinlib.base.xSkinBaseActivity;
import lbx.xskinlib.callback.ISkinChangingCallback;
import lbx.xskinlib.xSkin;

import static lbx.xskin.MainActivity.PATH;
import static lbx.xskin.MainActivity.PKN;

public class Main2Activity extends xSkinBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    /**
     * @param view
     */
    public void change(View view) {
        xSkin.getInstance().changeSkin(this, PATH, PKN, new ISkinChangingCallback() {
            @Override
            public void onStart() {
                Log.e("xys", "onStart");
            }

            @Override
            public void onError(Exception e) {
                Log.e("xys", "onError = " + e);
            }

            @Override
            public void onComplete() {
                Log.e("xys", "onComplete");
            }
        });
    }

    public void clear(View view) {
        xSkin.getInstance().removeSkin(this);
    }

    public void red(View view) {
        xSkin.getInstance().changeSkin(this, "red");
    }
}
