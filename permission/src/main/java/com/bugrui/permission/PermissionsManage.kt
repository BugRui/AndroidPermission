package com.bugrui.permission

import android.os.Build



/**
 * @Author:            BugRui
 * @CreateDate:        2019/11/28 16:03
 * @Description:       权限管理
 */
object PermissionsManager {


    private const val REQUEST_TASK = 101

    fun calendarTaskWithPermissionCheck(
        target: PermissionsDialog,
        permissions: Array<String>
    ) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (PermissionUtils.hasSelfPermissions(target.requireActivity(), permissions)) {
                target.onPermissionsTask()
            } else {
                target.requestPermissions(permissions, REQUEST_TASK)
//                if (PermissionUtils.shouldShowRequestPermissionRationale(target, permissions)) {
//                    target.showNeedsReason()
//                } else {
//                    target.requestPermissions(permissions, REQUEST_TASK)
//                }
            }
        } else {
            target.onPermissionsTask()
        }
    }

    fun onRequestPermissionsResult(
        target: PermissionsDialog, requestCode: Int,
        grantResults: IntArray,
        permissions: Array<String>
    ) {
        when (requestCode) {
            REQUEST_TASK -> {
                if (PermissionUtils.verifyPermissions(*grantResults)) {
                    target.onPermissionsTask()
                } else {
                    if (!PermissionUtils.shouldShowRequestPermissionRationale(
                            target,
                            permissions
                        )
                    ) {
                        target.onNeverAskAgain()
                    } else {
                        target.onDenied()
                    }
                }
            }
            else -> {
            }
        }
    }


}

