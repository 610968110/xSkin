package lbx.xskinlib.skin;

import android.content.Context;
import android.util.AttributeSet;

import java.util.ArrayList;
import java.util.List;

import lbx.xskinlib.config.xSkinConfig;

public class SkinAttrManager {

    public static List<SkinAttr> getSkinAttrs(AttributeSet attrs, Context context) {
        List<SkinAttr> themeAttrs = new ArrayList<>();
        SkinAttr themeAttr;
        for (int i = 0; i < attrs.getAttributeCount(); i++) {
            String attrName = attrs.getAttributeName(i);
            String attrValue = attrs.getAttributeValue(i);
            SkinType attrType = getThemeAttrType(attrName);
            if (attrType == null) {
                continue;
            }
            if (attrValue.startsWith("@")) {
                int id = Integer.parseInt(attrValue.substring(1));
                String entryName = context.getResources().getResourceEntryName(id);
                if (entryName.startsWith(xSkinConfig.SKIN_START)) {
                    themeAttr = new SkinAttr(attrType, entryName);
                    themeAttrs.add(themeAttr);
                }
            }
        }
        return themeAttrs;
    }

    private static SkinType getThemeAttrType(String attrName) {
        for (SkinType attrType : SkinType.values()) {
            if (attrType.getValue().equals(attrName)) {
                return attrType;
            }
        }
        return null;
    }

}
