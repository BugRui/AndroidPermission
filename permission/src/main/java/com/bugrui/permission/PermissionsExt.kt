package com.bugrui.permission

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.permissionx.guolindev.PermissionX
import com.permissionx.guolindev.request.ForwardScope
import com.permissionx.guolindev.request.InvisibleFragment
import com.permissionx.guolindev.request.PermissionBuilder


/**
 * @Author:            BugRui
 * @CreateDate:        2019/11/28 15:09
 * @Description:       权限ext
 */
fun FragmentActivity.applyPermission(
    vararg permissions: String,
    onForwardToSettings: ((deniedList: List<String>) -> Unit)? = null,
    onResult: ((allGranted: Boolean, grantedList: List<String>, deniedList: List<String>) -> Unit)? = null
) {
    applyPermission(permissions.toList(), onForwardToSettings, onResult)
}

fun Fragment.applyPermission(
    vararg permissions: String,
    onForwardToSettings: ((deniedList: List<String>) -> Unit)? = null,
    onResult: ((allGranted: Boolean, grantedList: List<String>, deniedList: List<String>) -> Unit)? = null
) {
    applyPermission(permissions.toList(), onForwardToSettings, onResult)
}

fun FragmentActivity.applyPermission(
    permissions: List<String>,
    onForwardToSettings: ((deniedList: List<String>) -> Unit)? = null,
    onResult: ((allGranted: Boolean, grantedList: List<String>, deniedList: List<String>) -> Unit)? = null
) {
    PermissionX.init(this)
        .permissions(permissions)
        .applyPermissionX(supportFragmentManager, onForwardToSettings, onResult)
}

fun Fragment.applyPermission(
    permissions: List<String>,
    onForwardToSettings: ((deniedList: List<String>) -> Unit)? = null,
    onResult: ((allGranted: Boolean, grantedList: List<String>, deniedList: List<String>) -> Unit)? = null
) {
    PermissionX.init(this)
        .permissions(permissions)
        .applyPermissionX(childFragmentManager, onForwardToSettings, onResult)
}


private fun PermissionBuilder.applyPermissionX(
    /**
     * fragment管理器
     */
    fragmentManager: FragmentManager,

    /**
     * 设置跳转应用程序设置当中手动开启权限
     */
    onForwardToSettings: ((deniedList: List<String>) -> Unit)?,
    /**
     *  allGranted 判断所有申请的权限都已通过
     *  grantedList 通过的权限集合
     *  deniedList 被拒绝的权限集合
     */
    onResult: ((allGranted: Boolean, grantedList: List<String>, deniedList: List<String>) -> Unit)?
) {
    this.onForwardToSettings { scope, deniedList ->
        if (onForwardToSettings != null) {
            onForwardToSettings(deniedList)
        } else {
            scope.showCustomForwardToSettingsDialog(deniedList)
        }
    }.request { allGranted, grantedList, deniedList ->
        if (onResult != null) {
            onResult(allGranted, grantedList ?: emptyList(), deniedList ?: emptyList())
        }

        //解决PermissionX处理完没有remove InvisibleFragment 导致一个activity使用了InvisibleFragment，另一个fragment也使用的时候报错
        val invisibleFragment = fragmentManager.findFragmentByTag("InvisibleFragment")
        if (invisibleFragment != null && invisibleFragment is InvisibleFragment) {
            Log.e("bugrui","remove InvisibleFragment")
            fragmentManager.beginTransaction()
                .remove(invisibleFragment)
                .commitAllowingStateLoss()
        }

    }
}


private fun ForwardScope.showCustomForwardToSettingsDialog(deniedList: List<String>) {
    showForwardToSettingsDialog(
        deniedList,
        "您已拒绝权限的申请，并不在询问，需要去应用程序设置当中手动开启权限",
        "去开启",
        "取消"
    )
}


