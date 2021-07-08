package com.bugrui.permission.callback;

import java.util.List;


public interface PermissionResultCallback {

    /**
     * 请求结果的回调。
     *
     * @param allGranted  指示是否授予所有权限
     * @param grantedList 用户授予的所有权限
     * @param deniedList  用户拒绝的所有权限
     */
    void onResult(Boolean allGranted, List<String> grantedList, List<String> deniedList);
}
