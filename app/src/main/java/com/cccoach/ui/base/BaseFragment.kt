package com.cccoach.ui.base

import android.app.Dialog
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.AdapterView
import android.widget.CompoundButton
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.cccoach.R
import com.cccoach.ui.snackBar.Snackbar
import com.cccoach.ui.snackBar.SnackbarManager
import com.cccoach.ui.snackBar.SnackbarType
import java.util.regex.Matcher
import java.util.regex.Pattern

open class BaseFragment : Fragment(), AdapterView.OnItemClickListener, View.OnClickListener,
    AdapterView.OnItemSelectedListener, CompoundButton.OnCheckedChangeListener
    {
//    ImageBottomPicker.OnImageSelectedListener,
//    ImageBottomPicker.OnErrorListener
    var baseActivity: BaseActivity? = null

//    var store: PrefStore? = null
//    var restFullClient: RestFullClient? = null
//    var api: API? = null
//    var timePickerDialog: SingleDateAndTimePickerDialog.Builder? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        baseActivity = activity as BaseActivity?

//        baseActivity!!.startProgressDialog()


    }


    override fun onResume() {
        super.onResume()
//        baseActivity!!.hideSoftKeyboard()
        baseActivity!!.invalidateOptionsMenu()
    }

    override fun onClick(v: View) {

    }


        fun popupSuccessAccount(){


            val dialogBuilder = AlertDialog.Builder(requireActivity())
            val layoutView = layoutInflater.inflate(R.layout.create_account_successfully_popup, null)
            dialogBuilder.setView(layoutView)
            val alertDialog = dialogBuilder.create()
            alertDialog.show()
        }


        fun isEmailValid(email: String?): Boolean {
            val pattern: Pattern
            val matcher: Matcher
            val EMAIL_PATTERN =
                "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"
            pattern = Pattern.compile(EMAIL_PATTERN)
            matcher = pattern.matcher(email)
            return matcher.matches()
        }


         fun showDialog() {
            var dialog = Dialog(baseActivity!!,R.style.CustomBottomSheetDialogTheme)
            dialog.setCancelable(true)
            dialog.setContentView(R.layout.create_account_successfully_popup)
            val dialogLL = dialog.findViewById(R.id.dialogLL) as LinearLayout
            dialogLL.setOnClickListener {
                dialog.dismiss()
            }

            dialog.show()

        }

    fun showToast(msg: String) {
        baseActivity!!.showToast(msg)
    }



    fun showToastOne(s: String) {
        baseActivity!!.showToastOne(s)
    }



    fun log(s: String) {
        baseActivity!!.log(s)
    }



    override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {

    }

    override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {

    }

    override fun onNothingSelected(parent: AdapterView<*>) {

    }

    override fun onCheckedChanged(buttonView: CompoundButton, isChecked: Boolean) {

    }

        fun showShortToast(message: String) {
            if (!isAdded) {
                return
            }
            Toast.makeText(
                requireContext(), message, Toast.LENGTH_SHORT
            ).show()
        }
        fun isValidPassword(password: String?): Boolean {

            val pattern: Pattern
            val matcher: Matcher
            val PASSWORD_PATTERN = "^" +
                    "(?=.*[@#$%^&+=])" +  // at least 1 special character
                    "(?=\\S+$)" +  // no white spaces
                    ".{8,}" +  // at least 8 characters
                    "$"
            pattern = Pattern.compile(PASSWORD_PATTERN)
            matcher = pattern.matcher(password)
            return matcher.matches()
        }



    /*fun chooseImagePicker(requestCode: Int, showRemove: Boolean) {
        val bottomPicker = ImageBottomPicker.Builder(baseActivity!!, requestCode)
            .setOnImageSelectedListener(this).setOnErrorListener(this).showRemoved(showRemove)
            .setCrop(false)
            .create()
        bottomPicker.show(baseActivity?.supportFragmentManager)
    }

    override fun onImageSelected(uri: Uri?, requestCode: Int) {

    }

    override fun onImageRemoved(isRemoved: Boolean, requestCode: Int) {
    }

    override fun onError(message: String?) {
    }

    override fun showError(message: String) {
        showToast(message)
    }

    override fun onErrorMessage(message: String) {
        showToastOne(message)
    }
*/


}
