package dev.ahrsoft.modtoast

import android.content.Context
import android.content.Context.LAYOUT_INFLATER_SERVICE
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.core.content.ContextCompat
import androidx.core.text.HtmlCompat
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
    }else{
        Toast.makeText(this,
            HtmlCompat.fromHtml("<font color='red'>${text}</font>", HtmlCompat.FROM_HTML_MODE_LEGACY),
            Toast.LENGTH_LONG).show()
    }

    toastEgg.show()
}