/*
 * *
 *  * Created by Achmad Fathullah on 10/13/20 8:56 PM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 10/13/20 8:56 PM
 *
 */

package id.co.homecredit.utils.dialog

import android.app.Dialog
import android.content.Context
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import id.co.homecredit.R
import id.co.homecredit.utils.extension.lifecycleOwner

class LoadingDialog(context: Context) : Dialog(context) {
    init {
        window?.setBackgroundDrawableResource(android.R.color.transparent)
        setContentView(R.layout.dialog_loading)
    }

    private inner class ModuleLifecycleObserver : LifecycleObserver {
        fun addObserver(lifecycle: Lifecycle) = lifecycle.addObserver(this)

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        fun onDestroy() = dismiss()

        @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
        fun onPause() = dismiss()
    }

    private fun addLifecycleObserver(lifecycle: Lifecycle) {
        ModuleLifecycleObserver().addObserver(lifecycle)
    }

    fun show(isShown: Boolean, isCancelable: Boolean = false) {
        if (isShown) {
            setCancelable(isCancelable)
            super.show()
            context.lifecycleOwner()?.lifecycle?.let { addLifecycleObserver(it) }
        } else super.dismiss()


    }

    override fun show() {
        show(true)
    }
}