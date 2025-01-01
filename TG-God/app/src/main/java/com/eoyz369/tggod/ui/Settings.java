package com.eoyz369.tggod.ui;

import com.eoyz369.tggod.R;

import java.util.ArrayList;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;

public class Settings {
    public void uiSettings(ClassLoader classLoader) {
        XposedHelpers.findAndHookMethod("org.telegram.ui.Adapters.DrawerLayoutAdapter", classLoader, "resetItems", new Object[]{new XC_MethodHook() { // from class: com.eoyz369.tggod.ui.Settings.1
            protected void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                ArrayList arrayList = (ArrayList) XposedHelpers.getObjectField(methodHookParam.thisObject, "items");
                Object newInstance = XposedHelpers.findClass("org.telegram.ui.Adapters.DrawerLayoutAdapter$Item", (ClassLoader) null).getDeclaredConstructor(Integer.TYPE, Integer.TYPE, String.class).newInstance(99999, Integer.valueOf((int) R.drawable.god_icon), Integer.valueOf((int) R.string.app_name));
                for (int i = 0; i < arrayList.size(); i++) {
                    if ("Settings".equals((String) XposedHelpers.getObjectField(arrayList.get(i), "Settings"))) {
                        arrayList.add(i + 1, newInstance);
                        return;
                    }
                }
            }
        }});
    }
}
