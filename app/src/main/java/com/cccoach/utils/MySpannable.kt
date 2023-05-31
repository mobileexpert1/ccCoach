package com.cccoach.utils

import android.content.Context
import android.text.TextPaint
import android.text.style.ClickableSpan
import android.view.View
import androidx.core.content.ContextCompat

open class MySpannable(isUnderline: Boolean, var colorIs: Int, var baseActivity: Context) :
    ClickableSpan() {
    private var isUnderline = true

    /**
     * Constructor
     */
    init {
        this.isUnderline = isUnderline
    }

    override fun updateDrawState(ds: TextPaint) {
        ds.isUnderlineText = isUnderline
        ds.color = ContextCompat.getColor(baseActivity, colorIs)
    }

    override fun onClick(widget: View) {}
}