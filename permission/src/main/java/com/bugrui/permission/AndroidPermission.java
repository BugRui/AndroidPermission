package com.bugrui.permission;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.bugrui.permission.callback.ForwardToSettingsCallback;
import com.bugrui.permission.callback.PermissionResultCallback;

import java.util.List;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;


public class AndroidPermission {

    public static void apply(
            FragmentActivity activity,
            final ForwardToSettingsCallback forwardToSettingsCallback,
            final PermissionResultCallback resultCallback,
            String... permission) {

        Function1<List<String>, Unit> function1 = null;

        if (forwardToSettingsCallback != null) {
            function1 = new Function1<List<String>, Unit>() {
                @Override
                public Unit invoke(List<String> strings) {
                    forwardToSettingsCallback.onForwardToSettings(strings);
                    return null;
                }
            };
        }

        PermissionsExtKt.applyPermission(activity, permission, function1, new Function3<Boolean, List<String>, List<String>, Unit>() {
            @Override
            public Unit invoke(Boolean aBoolean, List<String> strings, List<String> strings2) {
                resultCallback.onResult(aBoolean, strings, strings2);
                return null;
            }
        });
    }

    public static void apply(
            Fragment fragment,
            final ForwardToSettingsCallback forwardToSettingsCallback,
            final PermissionResultCallback resultCallback,
            String... permission) {

        Function1<List<String>, Unit> function1 = null;

        if (forwardToSettingsCallback != null) {
            function1 = new Function1<List<String>, Unit>() {
                @Override
                public Unit invoke(List<String> strings) {
                    forwardToSettingsCallback.onForwardToSettings(strings);
                    return null;
                }
            };
        }

        PermissionsExtKt.applyPermission(fragment, permission, function1, new Function3<Boolean, List<String>, List<String>, Unit>() {
            @Override
            public Unit invoke(Boolean aBoolean, List<String> strings, List<String> strings2) {
                resultCallback.onResult(aBoolean, strings, strings2);
                return null;
            }
        });
    }

}
