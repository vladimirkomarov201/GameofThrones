package ru.skillbranch.gameofthrones.utils

import android.app.Activity
import android.content.Context
import android.os.IBinder
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.fragment.app.Fragment


fun Activity.showKeyboard(field: EditText){
    field.requestFocus()
    val imm = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
    imm?.showSoftInput(field, InputMethodManager.SHOW_IMPLICIT)
}

fun Activity.hideKeyboard(){
    val imm = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
    imm?.hideSoftInputFromWindow(this.currentFocus?.windowToken, 0)
}

fun Fragment.showKeyboard(field: EditText){
    this.activity?.showKeyboard(field)
}

fun Fragment.hideKeyboard(){
    this.activity?.hideKeyboard()
}

fun View.showKeyboard(field: EditText){
    field.requestFocus()
    val imm = this.context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
    imm?.showSoftInput(field, InputMethodManager.SHOW_IMPLICIT)
}

fun View.hideKeyboard(windowToken: IBinder){
    val imm = this.context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
    imm?.hideSoftInputFromWindow(windowToken, 0)
}