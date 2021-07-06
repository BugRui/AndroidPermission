package com.bugrui.permission;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import java.util.List;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/**
 * @Author: BugRui
 * @Description: java类作用描述
 * @CreateDate: 2021/7/6 5:14 PM
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/7/6 5:14 PM
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class AndroidPermission {

    public static void apply(FragmentActivity activity, final OnPermissionRequestCallback callback, String... permission) {
        PermissionsExtKt.applyPermission(activity, permission, new Function1<List<String>, Unit>() {
            @Override
            public Unit invoke(List<String> strings) {
                callback.onForwardToSettings(strings);
                return null;
            }
        }, new Function3<Boolean, List<String>, List<String>, Unit>() {
            @Override
            public Unit invoke(Boolean aBoolean, List<String> strings, List<String> strings2) {
                callback.onResult(aBoolean, strings, strings2);
                return null;
            }
        });
    }

    public static void apply(Fragment fragment, final OnPermissionRequestCallback callback, String... permission) {
        PermissionsExtKt.applyPermission(fragment, permission, new Function1<List<String>, Unit>() {
            @Override
            public Unit invoke(List<String> strings) {
                callback.onForwardToSettings(strings);
                return null;
            }
        }, new Function3<Boolean, List<String>, List<String>, Unit>() {
            @Override
            public Unit invoke(Boolean aBoolean, List<String> strings, List<String> strings2) {
                callback.onResult(aBoolean, strings, strings2);
                return null;
            }
        });
    }

}
