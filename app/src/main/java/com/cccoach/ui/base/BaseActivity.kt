package com.cccoach.ui.base

import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.app.Dialog
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.location.Location
import android.location.LocationManager
import android.net.ConnectivityManager
import android.net.wifi.WifiManager
import android.os.*
import android.provider.Settings
import android.util.Base64
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.ktx.BuildConfig
import com.cccoach.R
import com.cccoach.ui.activities.LoginSignUpActivity
import com.cccoach.ui.activities.MainActivity
import com.cccoach.ui.snackBar.Snackbar
import com.cccoach.ui.snackBar.SnackbarManager
import com.cccoach.ui.snackBar.SnackbarType
import com.cccoach.utils.Const
import com.cccoach.utils.NetworkUtil


import org.json.JSONObject
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

open class BaseActivity : AppCompatActivity(), View.OnClickListener {

    fun changeDateFormatFromDate(sourceDate: Date?, targetDateFormat: String?): String {
        if (sourceDate == null || targetDateFormat == null || targetDateFormat.isEmpty()) {
            return ""
        }
        val outputDateFormat = SimpleDateFormat(targetDateFormat, Locale.getDefault())
        return outputDateFormat.format(sourceDate)
    }

    fun changeDateFormatLocale(
        dateString: String?,
        sourceDateFormat: String,
        targetDateFormat: String,
        locale: String,
    ): String {
        if (dateString == null || dateString.isEmpty()) {
            return ""
        }
        val inputDateFromat = SimpleDateFormat(sourceDateFormat, Locale.getDefault())
        var date = Date()
        try {
            date = inputDateFromat.parse(dateString)
        } catch (e: ParseException) {
            if (BuildConfig.DEBUG) {
                e.printStackTrace()
            }
        }

        val outputDateFormat = SimpleDateFormat(targetDateFormat, Locale(locale))
        return outputDateFormat.format(date)
    }
    fun showToast(msg: String) {
        SnackbarManager.create(
            Snackbar.with(this).duration(Snackbar.SnackbarDuration.LENGTH_SHORT)
                .type(SnackbarType.MULTI_LINE)
                .text(msg)
        )!!.show()
    }

    fun gotoLoginSignUpActivity(is_logout: Int = Const.NO) {
        val intent = Intent(this, LoginSignUpActivity::class.java)
        intent.putExtra(Const.IS_LOGOUT, is_logout)
        startActivity(intent)
        finish()
    }

    fun gotMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
    /*  private fun checkDate(checkDate: String) {
          val cal = Calendar.getInstance()
          val dateFormat = SimpleDateFormat(Const.YYYY_MM_DD)
          var serverDate: Date? = null
          try {
              serverDate = dateFormat.parse(checkDate)
              cal.time = serverDate
              val currentcal = Calendar.getInstance()
              if (currentcal.after(cal)) {
                  val builder = AlertDialog.Builder(this)
                  builder.setMessage(getString(R.string.build_expired_info))
                  builder.setTitle(getString(R.string.build_expired))
                  builder.setCancelable(false)
                  builder.setNegativeButton(getString(R.string.close)) { _, _ -> exitFromApp() }
                  val alert = builder.create()
                  alert.show()
              }
          } catch (e: ParseException) {
              handleException(e)
          }

      }

      private fun checkPlayServices(): Boolean {
          val apiAvailability = GoogleApiAvailability.getInstance()
          val resultCode = apiAvailability.isGooglePlayServicesAvailable(this)
          if (resultCode != ConnectionResult.SUCCESS) {
              if (apiAvailability.isUserResolvableError(resultCode)) {
                  apiAvailability.getErrorDialog(
                      this,
                      resultCode,
                      Const.PLAY_SERVICES_RESOLUTION_REQUEST
                  )!!.show()
              } else {
                  if (BuildConfig.DEBUG) {
                      log(getString(R.string.this_device_is_not_supported))
                  }
                  finish()
              }
              return false
          }
          return true
      }*/

/*    fun checkPermissions(
        perms: Array<String>,
        requestCode: Int,
        permCallback: PermCallback,
    ): Boolean {
        this.permCallback = permCallback
        this.reqCode = requestCode
        val permsArray = ArrayList<String>()
        var hasPerms = true
        for (perm in perms) {
            if (ContextCompat.checkSelfPermission(
                    this,
                    perm
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                permsArray.add(perm)
                hasPerms = false
            }
        }
        return if (!hasPerms) {
            val permsString = arrayOfNulls<String>(permsArray.size)
            for (i in permsArray.indices) {
                permsString[i] = permsArray[i]
            }
//            ActivityCompat.requestPermissions(this@BaseActivity, permsString, Const.PERMISSION_ID)
            false
        } else
            true
    }*/


    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }

    private fun exitFromApp() {
        finish()
        finishAffinity()
    }

/*
    fun hideSoftKeyboard(): Boolean {
        try {
            if (currentFocus != null) {
                inputMethodManager!!.hideSoftInputFromWindow(this.currentFocus!!.windowToken, 0)
                return true
            }
        } catch (e: Exception) {
            handleException(e)
        }

        return false
    }
*/

    fun isValidMail(email: String): Boolean {
        return email.matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+".toRegex())
    }

    fun isValidPassword(password: String): Boolean {
        return password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[!&^%$#@()=*/.+_-])(?=\\S+$).{8,}$".toRegex())
    }

/*
    fun keyHash() {
        try {
            val info = packageManager.getPackageInfo(packageName, PackageManager.GET_SIGNATURES)
            for (signature in info.signatures) {
                val md = MessageDigest.getInstance("SHA")
                md.update(signature.toByteArray())
                if (BuildConfig.DEBUG) {
                    Log.e(
                        "KeyHash:>>>>>>>>>>>>>>>",
                        "" + Base64.encodeToString(md.digest(), Base64.DEFAULT)
                    )
                }
            }
        } catch (e: PackageManager.NameNotFoundException) {
            handleException(e)
        } catch (e: NoSuchAlgorithmException) {
            handleException(e)
        }

    }
*/

    fun log(string: String) {
        if (BuildConfig.DEBUG) {
            Log.e("BaseActivity", string)
        }
    }


    fun log(title: String, message: String?) {
        if (BuildConfig.DEBUG) {
            Log.e(title, message ?: "")
        }
    }

/*
    private fun progressDialog() {
        progressDialog = Dialog(this)
        val view = View.inflate(this, R.layout.progress_dialog, null)
        progressDialog!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
        progressDialog!!.setContentView(view)
        progressDialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        txtMsgTV = view.findViewById<View>(R.id.txtMsgTV) as TextView

        val image: AppCompatImageView = view.findViewById<View>(R.id.logoIV) as AppCompatImageView
        progressDialog!!.setCancelable(false)
        val rotate = RotateAnimation(
            0f,
            180f,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        )
        rotate.duration = 50000
        rotate.interpolator = LinearInterpolator()
        image.startAnimation(rotate)
    }
*/


    /* open fun errorSnackBar(
         errorString: String,
         call: Call<String>?,
         callBack: Callback<String>?,
     ): SnackbarManager? {
         val buttonText: String = if (call != null && callBack != null) {
             getString(R.string.retry_cap)
         } else {
             getString(R.string.exit_caps)
         }
         val snackBar: Snackbar = Snackbar.with(this)
             .type(SnackbarType.MULTI_LINE)
             .text(errorString)
             .duration(Snackbar.SnackbarDuration.LENGTH_INDEFINITE)
             .actionLabel(buttonText)
             .actionListener(object : ActionClickListener {
                 override fun onActionClicked(snackbar: Snackbar) {
                     if (call != null && callBack != null) {
                         onSyncStart()
                         call.clone().enqueue(callBack)
                     } else {
                         finish()
                     }
                 }

             })
         return SnackbarManager.create(snackBar)
     }




     private fun failureErrorDialog(
         errorString: String,
         call: Call<String>?,
         callBack: Callback<String>?,
     ): android.app.AlertDialog? {
         if (call != null && callBack != null) {
             failureDailog!!.setMessage(errorString).setCancelable(false)
                 .setNegativeButton(getString(R.string.exit_caps)) { _, _ -> finish() }
                 .setPositiveButton(getString(R.string.retry_cap)) { _, _ ->
                     onSyncStart()
                     call.clone().enqueue(callBack)
                 }
         } else failureDailog!!.setMessage(errorString).setCancelable(false)
             .setPositiveButton(getString(R.string.exit_caps)) { _, _ -> finish() }
         failureAlertDialog = failureDailog!!.create()
         return failureAlertDialog
     }
 */


    /*  fun showToast(msg: String) {
          SnackbarManager.create(
              Snackbar.with(this).duration(Snackbar.SnackbarDuration.LENGTH_SHORT)
                  .type(SnackbarType.MULTI_LINE)
                  .text(msg)
          )!!.show()
      }*/

    fun showToastOne(msg: String) {
        Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT).show()
    }


    override fun onClick(v: View) {

    }

    override fun onDestroy() {
        super.onDestroy()
//        unregisterNetworkBroadcast()
    }

//    fun backAction() {
//        if (exit) {
//            finishAffinity()
//        } else {
//            showToastOne(getString(R.string.press_one_more_time))
//            exit = true
//            Handler(Looper.getMainLooper()).postDelayed({ exit = false }, (2 * 1000).toLong())
//        }
//    }

    interface PermCallback {
        fun permGranted(resultCode: Int)

        fun permDenied(resultCode: Int)
    }

/*    inner class NetworksBroadcast : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val status = NetworkUtil.getConnectivityStatusString(context)
            if (status == null && networkAlertDialog != null) {
                networkStatus = null
                networkAlertDialog.dismiss()
            } else if (status != null && networkStatus == null)
//                showNoNetworkDialog(status)
        }
    }*/

    open fun handelException(e: java.lang.Exception) {
        if (BuildConfig.DEBUG) {
            e.printStackTrace()
        }
    }

    override fun onResume() {
        super.onResume()
        //checkDate(Const.DATE_CHECK)
    }

    /* @SuppressLint("SimpleDateFormat")
     fun changeDateFormatToGmt(
         dateString: String?,
         sourceDateFormat: String,
         targetDateFormat: String,
     ): String {
         if (dateString == null || dateString.isEmpty()) {
             return ""
         }
         val inputDateFormat = SimpleDateFormat(sourceDateFormat)
         var date = Date()
         try {
             date = inputDateFormat.parse(dateString)!!
         } catch (e: ParseException) {
             handleException(e)
         }

         val outputDateFormat = SimpleDateFormat(targetDateFormat)
         outputDateFormat.timeZone = TimeZone.getTimeZone("GMT 00:00")
         return outputDateFormat.format(date)
     }
 */
    @SuppressLint("SimpleDateFormat")
    fun changeDateFormatGmtToLocal(
        dateString: String?,
        sourceDateFormat: String,
        targetDateFormat: String,
    ): String {
        if (dateString == null || dateString.isEmpty()) {
            return ""
        }
        val inputDateFormat = SimpleDateFormat(sourceDateFormat)
        inputDateFormat.timeZone = TimeZone.getTimeZone("UTC")
        var date = Date()
        try {
            date = inputDateFormat.parse(dateString)!!
        } catch (e: ParseException) {
            if (BuildConfig.DEBUG) {
                e.printStackTrace()
            }
        }

        val outputDateFormat = SimpleDateFormat(targetDateFormat)
        return outputDateFormat.format(date)
    }


/*
    fun getTimingWishes(): String {
        val c = Calendar.getInstance()

        val time = when (c[Calendar.HOUR_OF_DAY]) {
            in 0..11 -> {
                getString(R.string.good_morning)
            }
            in 12..15 -> {
                getString(R.string.good_afternoon)
            }
            in 16..20 -> {
                getString(R.string.good_eveing)
            }
            in 21..23 -> {
                getString(R.string.good_nigh)
            }
            else -> {
                ""
            }
        }
        return time
    }
*/

    fun removeArrayDuplicates(duplicates: Array<String>): Array<String> {
        return listOf(*duplicates).toSet().toTypedArray()
    }


    fun timeDifferenceInMinutes(format: String, startDate: String, endDate: String): Long {
        val simpleDateFormat = SimpleDateFormat(format, Locale.ENGLISH)
        val date1 = simpleDateFormat.parse(startDate)
        val date2 = simpleDateFormat.parse(endDate)
        return TimeUnit.MILLISECONDS.toMinutes(date2!!.time - date1!!.time)
    }

    fun capitalizeString(str: String): String {
        var retStr = str
        try { // We can face index out of bound exception if the string is null
            retStr = str.substring(0, 1).uppercase(Locale.getDefault()) + str.substring(1)
        } catch (e: Exception) {
        }
        return retStr
    }

    /* fun closeTimePicker() {
         if (timePickerDialog != null) {
             timePickerDialog!!.close()
             timePickerDialog = null
         }
     }
 */
    /*   fun openTimePickerHours(
           title: String,
           text: AppCompatEditText?,
           displayAmPm: Boolean,
           futureMin: Int = 1,
           formattedStartTime: String? = "",
           endDate: String? = "",
           isStartTime: Boolean? = false,
       ) {

           val myFormat = Const.TIME_WITH_AM_PM

           if (isStartTime!!) {
               timePickerDialog = SingleDateAndTimePickerDialog.Builder(this)
               timePickerDialog!!.curved()
                   .bottomSheet()
                   .title(title)
                   .displayDays(false)
                   .displayMonth(false)
                   .displayYears(false)
                   .displayHours(true)
                   .displayMinutes(true)
                   .displayAmPm(displayAmPm)
                   .mustBeOnFuture()
                   .mainColor(
                       ContextCompat.getColor(
                           this,
                           R.color.colorPrimaryDark
                       )
                   )
                   .titleTextColor(
                       ContextCompat.getColor(
                           this,
                           R.color.colorPrimaryDark
                       )
                   )
                   .minutesStep(futureMin)
                   .displayListener(object : SingleDateAndTimePickerDialog.DisplayListener {

                       override fun onDisplayed(picker: SingleDateAndTimePicker) {

                       }

                       fun onClosed(picker: SingleDateAndTimePicker?) {
                           // On dialog closed
                           timePickerDialog = null
                       }
                   })
                   .listener { date ->
                       text!!.setText(date.getStringDate(myFormat))
                   }
                   .display()
           } else {
               timePickerDialog = SingleDateAndTimePickerDialog.Builder(this)
               timePickerDialog!!.curved()
                   .bottomSheet()
                   .title(title)
                   .displayDays(false)
                   .displayMonth(false)
                   .displayYears(false)
                   .displayHours(true)
                   .displayMinutes(true)
                   .displayAmPm(displayAmPm)
                   .mustBeOnFuture()
                   .mainColor(
                       ContextCompat.getColor(
                           this,
                           R.color.colorPrimaryDark
                       )
                   )
                   .titleTextColor(
                       ContextCompat.getColor(
                           this,
                           R.color.colorPrimaryDark
                       )
                   )
                   .minutesStep(futureMin)
                   .displayListener(object : SingleDateAndTimePickerDialog.DisplayListener {

                       override fun onDisplayed(picker: SingleDateAndTimePicker) {

                       }

                       fun onClosed(picker: SingleDateAndTimePicker?) {
                           // On dialog closed
                           timePickerDialog = null
                       }
                   })
                   .listener { date ->
                       val startTime = changeDateFormat(
                           formattedStartTime,
                           Const.SIMPLE_DATE_TIME_WITH_SEC,
                           Const.TIME_WITH_SEC
                       )

                       val finalEndTime = changeDateFormatFromDate(
                           date,
                           Const.TIME_WITH_SEC
                       )
                       timePickerDialog = if (thirtyMinutesDifferenceTime(
                               startTime,
                               finalEndTime, endDate
                           ) == 0L
                       ) {
                           text!!.setText(date.getStringDate(myFormat))
                           null
                       } else {
                           showToastOne(getString(R.string.end_time_should_half_greater_than_start_time))
                           null
                       }
                   }
                   .display()
           }
       }*/

    /*  private fun thirtyMinutesDifferenceTime(
          startTime: String,
          endTime: String,
          date: String?,
      ): Long {
          val simpleDateFormat = SimpleDateFormat(Const.OUTPUT_DATE_TIME_WITH_SEC, Locale.ENGLISH)
          val date1 = simpleDateFormat.parse(changeDateFormatNew("$date $startTime"))
          val date2 = simpleDateFormat.parse(changeDateFormatNew("$date $endTime"))
          val timeDiff = TimeUnit.MILLISECONDS.toMinutes(date2!!.time - date1!!.time)
          return when {
              timeDiff > 0 -> {
                  val diff = timeDiff % 30
                  diff
              }
              else -> {
                  1
              }
          }

      }
  */
    open fun setToolbar(
        title: String = "",
        isTitle: Boolean = true,
        isToolbar: Boolean = true,
        toolbarColor: Int = R.color.White,
        textColor: Int = R.color.Black,
        isBottom: Boolean = true,
    ) {

    }

//     fun gotoLoginFrag() {
//        supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
//        replaceFragment(LoginFragment(), R.id.frame_container)
//
//    }
}
