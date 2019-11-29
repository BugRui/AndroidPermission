package com.bugrui.permission

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*

/**
 * @Author: BugRui
 * @CreateDate: 2019/11/28 17:00
 * @Description: 权限管理弹窗
 */
class PermissionsDialog(listener: OnPermissionsTaskListener) : BaseDialogFragment() {
    override val layoutRes: Int = 0
    override fun onStart() {
        super.onStart()
        if (dialog == null) return
        val window = dialog!!.window ?: return
        val params = window.attributes ?: return
        window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        params.dimAmount = 0.0f // 通明度
        params.width = WindowManager.LayoutParams.MATCH_PARENT
        params.height = WindowManager.LayoutParams.MATCH_PARENT
        params.gravity = Gravity.CENTER
        window.attributes = params
    }

    private var listener: OnPermissionsTaskListener? = null

    init {
        this.listener = listener
    }


    private var mPermissions: Array<String>? = null

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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        PermissionsManager.calendarTaskWithPermissionCheck(this, mPermissions!!)
        return super.onCreateView(inflater, container, savedInstanceState)
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        PermissionsManager.onRequestPermissionsResult(
            this,
            requestCode,
            grantResults,
            mPermissions!!
        )
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