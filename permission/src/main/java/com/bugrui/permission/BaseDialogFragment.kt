package com.bugrui.permission

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager

/**
 * @Author: BugRui
 * @CreateDate: 2019/7/18 16:33
 * @Description: DialogFragment基类
 */
abstract class BaseDialogFragment : DialogFragment() {

    fun showDialog(manager: FragmentManager?) {
        if (isAdded) return
        show(manager!!, tag)
    }

    override fun dismiss() {
        if (!isAdded) return
        super.dismiss()
    }

    @get:LayoutRes
    protected abstract val layoutRes: Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return if (layoutRes != 0) {
            inflater.inflate(layoutRes, container, false)
        } else super.onCreateView(inflater, container, savedInstanceState)
    }

}