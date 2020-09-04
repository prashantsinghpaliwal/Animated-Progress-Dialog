package com.bigsteptech.animatedprogressdialog

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.custom_progress_bar.view.*

object AnimatedProgressDialog {

    private lateinit var progressDialog: AlertDialog

    fun showProgressDialogWithJson(mContext: Context, rawJsonAnimation: Int) {

        val builder = AlertDialog.Builder(mContext)
        val inflatedView = LayoutInflater.from(mContext).inflate(R.layout.custom_progress_bar, null)
        inflatedView.animationJsonView.visibility =View.VISIBLE
        inflatedView.animationGifView.visibility=View.GONE
        inflatedView.animationJsonView.setAnimation(rawJsonAnimation)

        builder.setView(inflatedView)
        builder.setCancelable(false)
        progressDialog = builder.create()
        if (progressDialog.window != null) {
            progressDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
        progressDialog.show()

    }

    fun showProgressDialogWithGif(mContext: Context, gifAnimation: Int) {

        val builder = AlertDialog.Builder(mContext)
        val inflatedView = LayoutInflater.from(mContext).inflate(R.layout.custom_progress_bar, null)
        inflatedView.animationJsonView.visibility =View.GONE
        inflatedView.animationGifView.visibility=View.VISIBLE

        Glide.with(mContext).asGif().load(gifAnimation).into(inflatedView.animationGifView)
        builder.setView(inflatedView)
        builder.setCancelable(false)
        progressDialog = builder.create()
        if (progressDialog.window != null) {
            progressDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
        progressDialog.show()

    }

    fun hideProgressDialog() {
        if (progressDialog.isShowing()) progressDialog.dismiss()
    }
}