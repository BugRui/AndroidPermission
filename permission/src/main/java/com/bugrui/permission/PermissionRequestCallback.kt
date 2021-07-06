package com.bugrui.permission

/**
 * @Author:         BugRui
 * @Description:     java类作用描述
 * @CreateDate:     2021/7/6 4:08 PM
 * @UpdateUser:     更新者
 * @UpdateDate:     2021/7/6 4:08 PM
 * @UpdateRemark:   更新说明
 * @Version:        1.0
 */
interface PermissionRequestCallback {
    /**
     * 请求结果的回调。
     * @param allGranted 指示是否授予所有权限
     * @param grantedList 用户授予的所有权限
     * @param deniedList 用户拒绝的所有权限
     */
    fun onResult(allGranted: Boolean, grantedList: List<String>, deniedList: List<String>)
}
