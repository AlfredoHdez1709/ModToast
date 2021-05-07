package dev.ahrsoft.modtoast

import android.content.Context
import android.content.Context.LAYOUT_INFLATER_SERVICE
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.os.Build
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.core.content.ContextCompat
import dev.ahrsoft.modtoast.databinding.ModToastBinding


enum class ModToast{
    ROUND, FLAT, BORDER
}

fun Context.ModToast(
    text : CharSequence?,
    duration : Int,
){
    val modToast = Toast.makeText(this, text, duration)
    val lengthShort = 0
    val lengthLong = 1

    modToast.setText(text)

    if (duration == lengthShort){
        Toast.LENGTH_SHORT
    } else if (duration == lengthLong){
        Toast.LENGTH_LONG
    }
    modToast.show()
}

fun Context.ModToast(
    text: CharSequence?,
    duration: Int,
    style : ModToast,
    @Nullable backgroundTint: Int?, @Nullable textColor: Int?, @Nullable imageRes: Int?
)
{
    val inflate = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater


    val binding = ModToastBinding.inflate(inflate)

    val lengthSHORT = 0
    val lengthLONG = 1
    binding.txtToastTitle.text = text

    when(style){
        ModToast.ROUND -> {
            binding.rootToas.setBackgroundResource(R.drawable.round)
        }
        ModToast.FLAT -> {
            binding.rootToas.setBackgroundResource(R.drawable.flat)
        }
        ModToast.BORDER -> {
            binding.rootToas.setBackgroundResource(R.drawable.border)
        }
    }

    if (duration == lengthSHORT){
        Toast.LENGTH_SHORT
    } else if (duration == lengthLONG){
        Toast.LENGTH_LONG
    }

    if (textColor != null) {
        binding.txtToastTitle.setTextColor(ContextCompat.getColor(this, textColor))
    }

    if (backgroundTint != null){
        binding.rootToas.background.colorFilter = PorterDuffColorFilter(ContextCompat.getColor(this, backgroundTint), PorterDuff.Mode.MULTIPLY)
    }

    if (imageRes != null) {
        binding.ivRes.setImageResource(imageRes)
    } else {
        binding.ivRes.visibility = View.GONE
    }

    val toastEgg = Toast(this)

    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.R){
        toastEgg.view = binding.root
        toastEgg.show()
    }else{
        show_toast_android_r(binding, this,text, duration, style, backgroundTint, textColor, imageRes)
    }
}

fun show_toast_android_r(binding: ModToastBinding,
                         context: Context,
                         text: CharSequence?,
                         duration: Int,
                         style : ModToast,
                         @Nullable backgroundTint: Int?,
                         @Nullable textColor: Int?,
                         @Nullable imageRes: Int?) {


    val lengthSHORT = 0
    val lengthLONG = 1
    binding.txtToastTitle.text = text

    when(style){
        ModToast.ROUND -> {
            binding.rootToas.setBackgroundResource(R.drawable.round)
        }
        ModToast.FLAT -> {
            binding.rootToas.setBackgroundResource(R.drawable.flat)
        }
        ModToast.BORDER -> {
            binding.rootToas.setBackgroundResource(R.drawable.border)
        }
    }

    var durationToast  = 0

    if (duration == lengthSHORT){
        durationToast = 300
    } else if (duration == lengthLONG){
        durationToast = 600
    }

    if (textColor != null) {
        binding.txtToastTitle.setTextColor(ContextCompat.getColor(context, textColor))
    }

    if (backgroundTint != null){
        binding.rootToas.background.colorFilter = PorterDuffColorFilter(ContextCompat.getColor(context, backgroundTint), PorterDuff.Mode.MULTIPLY)
    }

    if (imageRes != null) {
        binding.ivRes.setImageResource(imageRes)
    } else {
        binding.ivRes.visibility = View.GONE
    }


    val animation1 = AlphaAnimation(0f, 1f)
    animation1.duration = durationToast.toLong()
    animation1.fillAfter = true
    animation1.setAnimationListener(object : Animation.AnimationListener {
        override fun onAnimationStart(animation: Animation) {}
        override fun onAnimationRepeat(animation: Animation) {}
        override fun onAnimationEnd(animation: Animation) {
            object : CountDownTimer(2250, 1) {
                override fun onTick(millisUntilFinished: Long) {}
                override fun onFinish() {
                    hide_ad_hoc_toast(binding)
                }
            }.start()
        }
    })
    binding.rootToas.visibility = View.VISIBLE
    binding.rootToas.startAnimation(animation1)
}


fun hide_ad_hoc_toast(binding: ModToastBinding){
    val animation1 = AlphaAnimation(1f, 0f)
    animation1.duration = 300
    animation1.fillAfter = true
    animation1.setAnimationListener(object : Animation.AnimationListener {
        override fun onAnimationStart(animation: Animation) {}
        override fun onAnimationRepeat(animation: Animation) {}
        override fun onAnimationEnd(animation: Animation) {
            binding.rootToas.visibility = View.GONE
        }
    })
   binding.rootToas.startAnimation(animation1)
}
