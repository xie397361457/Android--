package com.manager.incremental

import android.content.Context
import android.content.Intent
import android.net.Uri

/**
 * 使用kotlin给context添加扩展方法
 * 参数格式说明
 *     需要扩展的类.方法名(参数) : 返回值类型{ }
 * @author nuo
 */
//获取当前app版本号
fun Context.getVersionCode():Int{
    val packageManager = this.packageManager
    val packageInfo = packageManager.getPackageInfo(this.packageName,0)
    return packageInfo.versionCode
}
//获取当前app版本名字
fun Context.getVersionName():String{
    val packageManager = this.packageManager
    val packageInfo = packageManager.getPackageInfo(this.packageName,0)
    return packageInfo.versionName
}

//获取已安装APK文件目录
fun Context.getSourceApkPath() :String{
    val appInfo = this.packageManager.getApplicationInfo(this.packageName,0)
    return appInfo.sourceDir
}
//安装APK
fun Context.installApk(apkPath : String){
    val intent = Intent(Intent.ACTION_VIEW)
    intent.setDataAndType(Uri.parse("file://"+apkPath),"application/vnd.android.package-archive")
    this.startActivity(intent)
}