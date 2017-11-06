package com.manager.incremental

import android.app.Application
import android.content.Context
import android.util.Log
import java.io.File

/**
 * @author nuo
 */
class BsPatchManager {

    private var context : Context
    private var defaultNewPath : String
    private val BS_DIR = "bapatch" //差分默认路径
    private val BS_NEW_APK_NAME = "apk_new.apk"
    private var defaultOldPath : String
    private val TAG = "logcat_BsPatchManager"
    /**
     * 实例化构造
     */
    private constructor(context: Context){
        this.context = context
        defaultNewPath = context.cacheDir.absolutePath+File.separator+BS_DIR+File.separator+BS_NEW_APK_NAME
        defaultOldPath = context.getSourceApkPath()
    }

    /**
     * 静态方法,成员变量
     */
    companion object{
        private var bsManager : BsPatchManager? = null
        fun instance (application : Application){
            bsManager = BsPatchManager(application)
        }
    }

    /**
     * 开始合并apk
     * @param oldPath -> 当前应用apk路径
     * @param newPath -> 生成的新apk路径
     * @param patchPath -> 下载后的差分文件存放路径
     * @return result -> 0 失败,返回其它 成功
     */
    fun bsPatchBegin(patchPath : String,newPath : String = defaultNewPath,oldPath : String = defaultOldPath) : Int{
        //begin bsPatch
        var result = BsPatchNative.bspatch(oldPath,newPath,patchPath)//result == 0? fail : success
        if (result == 0){
            Log.d(TAG,"差分文件与APK合并失败")
        }else{
            Log.d(TAG,"差分文件与APK合并成功 : "+newPath)
        }
        return result
    }
}