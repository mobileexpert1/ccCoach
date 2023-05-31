package com.cccoach.ui.snackBar


import android.annotation.TargetApi
import android.graphics.Point
import android.os.Build
import android.view.Display

@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
internal class DisplayCompatImplJBMR1 : DisplayCompat.Impl() {
    override fun getSize(display: Display, outSize: Point) {
        display.getSize(outSize)
    }

    override fun getRealSize(display: Display, outSize: Point) {
        display.getRealSize(outSize)
    }
}
