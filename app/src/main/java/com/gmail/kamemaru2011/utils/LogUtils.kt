package com.gmail.kamemaru2011.utils

import android.util.Log
import com.gmail.kamemaru2011.utils.UtilsBehavior.Companion.isLOG

class LogUtils{
    companion object {

        fun v(msg: String) = v("", msg)
        fun v(tag:String, msg:String) = if(isLOG) Log.v(tag, msg) else null

        fun d(msg: String) = d("", msg)
        fun d(tag:String, msg:String) = if(isLOG) Log.d(tag, msg) else null

        fun i(msg: String) = i("", msg)
        fun i(tag:String, msg:String) = if(isLOG) Log.i(tag, msg) else null

        fun e(msg: String) = e("", msg)
        fun e(tag:String, msg:String) = if(isLOG) Log.e(tag, msg) else null

        val TAG_DEBUG = "DEBUG"
    }
}
