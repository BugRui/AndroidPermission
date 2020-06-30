package com.bugrui.permission

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity


/**
 * @Author:            BugRui
 * @CreateDate:        2019/11/28 15:09
 * @Description:       权限ext
 */

private val permissionsTaskListener = object : OnPermissionsTaskListener() {
    override fun onPermissionsTask() {
    }
}

fun FragmentActivity.permissionCheck(
    permissions: Array<String>,
    listener: OnPermissionsTaskListener = permissionsTaskListener
) {
    val dialog = PermissionsDialog()
    dialog.setOnPermissionsTaskListener(listener)
    dialog.setNeedsPermission(permissions)
    dialog.showDialog(supportFragmentManager)
}


fun Fragment.permissionCheck(
    permissions: Array<String>,
    listener: OnPermissionsTaskListener = permissionsTaskListener
) {
    val dialog = PermissionsDialog()
    dialog.setOnPermissionsTaskListener(listener)
    dialog.setNeedsPermission(permissions)
    dialog.showDialog(childFragmentManager)
}

