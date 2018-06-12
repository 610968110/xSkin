# xSkin

项目主页：https://github.com/610968110/xSkin

xSkin为一款插件式换肤的框架，应用可以集成该框架，留下对应接口，即可实现从另一个apk中提取资源的“插件是换肤”，主在保证apk不变的情况下，在若干个插件apk（即不同主题apk）中提取相应资源，完成动态换肤。     
        
目前支持:背景颜色、控件大小，背景图、字体大小和字体颜色的插件提取。      
---
一、集成方式      
=====
在module的build文件下：       
````Xml
compile 'com.lbx:xSkin:1.0.0'
````

需要权限：
```Xml
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
````

二、使用方法
====
第一步，以换文字颜色为例，要把颜色资源文件的开头以“xskin_”开头，如红色：
````Xml
<color name="xskin_colorAccent">#ff0000</color>
````

第二步，把要换文字颜色的控件id，声明为“xskin_”开头，如：
````Xml
    <TextView
        android:id="@+id/xskin_tv_main"
        android:layout_width="50dp"
        android:layout_height="50dp"
        android:background="@drawable/xskin_left_menu_icon"
        android:gravity="center"
        android:text="@string/xskin_text"
        android:textColor="@color/xskin_colorAccent"
        android:textSize="@dimen/xskin_textsize" />
````

第三步，新建一个项目，以同样的方式声明一个颜色，之一颜色的name和之前的相同，如黑色：
````Html
<color name="xskin_colorAccent">#000000</color>
````

编译apk，放到sd卡下的某个路径。

第四步，在主项目中调用方法：
````Java
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
````

除了换文字颜色，其他的同理。

四、更多用法
===
该框架还支持本app内动态换肤的用法，比如在项目中声明颜色：
````Xml
    <color name="xskin_colorAccent">#ffffff</color>
    <color name="xskin_colorAccent_red">#ff0000</color>
````

我们看到唯一的不同就是下方的颜色是以"_red"结尾，用于匹配主题，调用方法：
````Java
 xSkin.getInstance().changeSkin(this, "red");
````

其中的第二个参数，就是匹配主题用的。
