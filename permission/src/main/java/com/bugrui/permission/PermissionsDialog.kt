package com.bugrui.permission

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import androidx.lifecycle.ViewModel

/**
 * @Author: BugRui
 * @CreateDate: 2019/11/28 17:00
 * @Description: 权限管理弹窗
 */
class PermissionsDialog : BasePermissionDialogFragment() {

    override val layoutRes: Int = 0
    private var listener: OnPermissionsTaskListener? = null
    private var mPermissions: Array<String>? = null

    fun setOnPermissionsTaskListener(listener: OnPermissionsTaskListener) {
        this.listener = listener
    }

    fun setNeedsPermission(permissions: Array<String>) {
        this.mPermissions = permissions
    }

//    internal fun showNeedsReason() {
//        listener?.showNeedsReason()
//        dismiss()
//    }

    internal fun onPermissionsTask() {
        listener?.onPermissionsTask()
        dismiss()
    }

    internal fun onNeverAskAgain() {
        listener?.onNeverAskAgain()
        dismiss()
    }

    internal fun onDenied() {
        listener?.onDenied()
        dismiss()
    }

    override fun onStart() {
        super.onStart()
        if (dialog == null) return
        val window = dialog!!.window ?: return
        val params = window.attributes ?: return
        window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        params.dimAmount = 0.0f // 通明度
        params.width = WindowManager.LayoutParams.WRAP_CONTENT
        params.height = WindowManager.LayoutParams.WRAP_CONTENT
        params.gravity = Gravity.CENTER
        window.attributes = params
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (mPermissions != null) {
            PermissionsManager.calendarTaskWithPermissionCheck(this, mPermissions!!)
        } else {
            dismiss()
        }
        return super.onCreateView(inflater, container, savedInstanceState)
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (mPermissions != null) {
            PermissionsManager.onRequestPermissionsResult(
                this,
                requestCode,
                grantResults,
                mPermissions!!
            )
        } else {
            dismiss()
        }
    }

}


interface PermissionsTaskListener {
    //    fun showNeedsReason()
    fun onPermissionsTask()
    fun onNeverAskAgain()
    fun onDenied()
}

abstract class OnPermissionsTaskListener : PermissionsTaskListener {
    //    override fun showNeedsReason() {}
    override fun onNeverAskAgain() {}
    override fun onDenied() {}
}