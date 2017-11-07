package lbx.xskinlib.skin;

import android.view.View;

import java.util.List;

/**
 * @author lbx
 */
public class SkinView {

    private View view;
    private List<SkinAttr> attrs;

    public SkinView(View view, List<SkinAttr> skinAttrs) {
        this.view = view;
        this.attrs = skinAttrs;
    }

    public void apply() {
        if (view != null) {
            for (SkinAttr attr : attrs) {
                attr.apply(view);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
