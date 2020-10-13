/*
 * *
 *  * Created by Achmad Fathullah on 10/13/20 8:56 PM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 10/13/20 8:56 PM
 *
 */

package id.co.homecredit.utils.extension

import android.content.Context
import android.content.ContextWrapper
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner

fun Context.lifecycleOwner(): LifecycleOwner? {
    var curContext = this
    var maxDepth = 20
    while (maxDepth-- > 0 && curContext !is LifecycleOwner) {
        curContext = (curContext as ContextWrapper).baseContext
    }
    return if (curContext is LifecycleOwner) {
        curContext
    } else {
        null
    }
}

fun Context.showToast(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}