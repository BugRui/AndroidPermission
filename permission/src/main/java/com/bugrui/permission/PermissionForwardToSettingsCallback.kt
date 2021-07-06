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
public interface PermissionForwardToSettingsCallback {

    /**
     * 关于转发到设置
     */
    fun onForwardToSettings(deniedList: List<String>)
}