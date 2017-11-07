package lbx.xskinlib.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v4.view.LayoutInflaterFactory;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.View;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import lbx.xskinlib.callback.ISkinChangedCallback;
import lbx.xskinlib.skin.SkinAttr;
import lbx.xskinlib.skin.SkinAttrManager;
import lbx.xskinlib.xSkin;

/**
 * @author lbx
 * @date 2017/11/6.
 */

public class xSkinBaseActivity extends AppCompatActivity implements LayoutInflaterFactory, ISkinChangedCallback {

    static final Class<?>[] sConstructorSignature = new Class[]{Context.class, AttributeSet.class};
    private static final Map<String, Constructor<? extends View>> sConstructorMap = new ArrayMap<>();
    private final Object[] mConstructorArgs = new Object[2];
    private static Method sCreateViewMethod;
    static final Class<?>[] sCreateViewSignature = new Class[]{View.class, String.class, Context.class, AttributeSet.class};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        LayoutInflaterCompat.setFactory(getLayoutInflater(), this);
        super.onCreate(savedInstanceState);
        xSkin.getInstance().addChangedListener(this);
    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        View view = getViewFromDelegate(parent, name, context, attrs);
        List<SkinAttr> themeAttrList = SkinAttrManager.getSkinAttrs(attrs, context);
        if (themeAttrList.isEmpty()) {
            return view;
        }
        if (view == null) {
            view = createViewFromTag(context, name, attrs);
        }
        xSkin.getInstance().inject(view, themeAttrList, this);
        return view;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        xSkin.getInstance().removeChangedListener(this);
    }

    private View getViewFromDelegate(View parent, String name, Context context, AttributeSet attrs) {
        AppCompatDelegate delegate = getDelegate();
        View view = null;
        try {
            if (sCreateViewMethod == null) {
                sCreateViewMethod = delegate.getClass().getMethod("createView", sCreateViewSignature);
            }
            view = (View) sCreateViewMethod.invoke(delegate, parent, name, context, attrs);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return view;
    }

    private View createViewFromTag(Context context, String name, AttributeSet attrs) {
        if (name.equals("view")) {
            name = attrs.getAttributeValue(null, "class");
        }
        try {
            mConstructorArgs[0] = context;
            mConstructorArgs[1] = attrs;
            if (-1 == name.indexOf('.')) {
                return createView(context, name, "android.widget.");
            } else {
                return createView(context, name, null);
            }
        } catch (Exception e) {
            return null;
        } finally {
            mConstructorArgs[0] = null;
            mConstructorArgs[1] = null;
        }
    }

    private View createView(Context context, String name, String prefix)
            throws ClassNotFoundException, InflateException {
        Constructor<? extends View> constructor = sConstructorMap.get(name);
        try {
            if (constructor == null) {
                Class<? extends View> clazz = context.getClassLoader().loadClass(
                        prefix != null ? (prefix + name) : name).asSubclass(View.class);
                constructor = clazz.getConstructor(sConstructorSignature);
                sConstructorMap.put(name, constructor);
            }
            constructor.setAccessible(true);
            return constructor.newInstance(mConstructorArgs);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void onSkinChanged() {
        try {
            xSkin.getInstance().apply(this);
        } catch (Exception e) {
            
        }
    }
}
