package com.bugrui.permission

/**
 * @Author:         BugRui
 * @Description:     java类作用描述
 * @CreateDate:     2021/7/6 5:18 PM
 * @UpdateUser:     更新者
 * @UpdateDate:     2021/7/6 5:18 PM
 * @UpdateRemark:   更新说明
 * @Version:        1.0
 */
abstract class OnPermissionRequestCallback :PermissionRequestCallback {

    override fun onForwardToSettings(deniedList: List<String>) {

    }

}

interface PermissionRequestCallback {

    /**
     * 关于转发到设置
     */
    fun onForwardToSettings(deniedList: List<String>)

    /**
     * 请求结果的回调。
     * @param allGranted 指示是否授予所有权限
     * @param grantedList 用户授予的所有权限
     * @param deniedList 用户拒绝的所有权限
     */
    fun onResult(allGranted: Boolean, grantedList: List<String>, deniedList: List<String>)
}
