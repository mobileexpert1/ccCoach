package com.cccoach.ui.snackBar


import android.app.Activity
import android.graphics.Point
import android.os.Build
import android.view.Display

internal object DisplayCompat {

    private val IMPL: Impl

    internal abstract class Impl {
        internal abstract fun getSize(display: Display, outSize: Point)

        internal abstract fun getRealSize(display: Display, outSize: Point)
    }

    init {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            IMPL = DisplayCompatImplJBMR1()
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            IMPL = DisplayCompatImplHoneycombMR2()
        } else {
            IMPL = DisplayCompatImplPreHoneycombMR2()
        }
    }

    fun getSize(display: Display, outSize: Point) {
        IMPL.getSize(display, outSize)
    }

    fun getRealSize(display: Display, outSize: Point) {
        IMPL.getRealSize(display, outSize)
    }

    fun getWidthFromPercentage(targetActivity: Activity, mMaxWidthPercentage: Float?): Int {
        val display = targetActivity.windowManager.defaultDisplay
        val dispSize = Point()
        getRealSize(display, dispSize)

        return (dispSize.x * mMaxWidthPercentage!!).toInt()
    }
}
