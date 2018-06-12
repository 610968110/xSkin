package lbx.xskin;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;

import java.io.File;

import lbx.xskinlib.base.xSkinBaseActivity;
import lbx.xskinlib.callback.ISkinChangingCallback;
import lbx.xskinlib.xSkin;

/**
 * @author lbx
 */
public class MainActivity extends xSkinBaseActivity {

    public static final String PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "123.apk";
    public static final String PKN = "lbx.skintest";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= 21) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            }
        }
    }

    /**
     * @param view
     */
    public void change(View view) {
        /**
         * @param Context 上下文
         * @param apkPath 插件apk的路径，包括apk名，比如存在sd卡的某个文件夹下 *** / *** / 123.apk
         * @param pkgName 包名，插件apk的包名，需要根据该包名
         * @param callback 回调
         */
        xSkin.getInstance().changeSkin(this, PATH, PKN, new ISkinChangingCallback() {
            @Override
            public void onStart() {
                //开始换肤
                Log.e("xys", "onStart");
            }

            @Override
            public void onError(Exception e) {
                //换肤失败
                Log.e("xys", "onError = " + e);
            }

            @Override
            public void onComplete() {
                //换肤完成
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

    public void green(View view) {
        startActivity(new Intent(this, Main2Activity.class));
    }
}
