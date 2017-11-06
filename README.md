# Android--
Android增量更新的实现

###使用方法
 1.incremental作为library导入工程
 2.实例化BsPatchManager
 2.调用方法bsPatchBegin
 
 
 //实例化合并APK管理器
 var bsPatchManager = BsPatchManager(application)
 
 //调用方法开始合并
 bsPatchManager.bsPatchBegin(...)
 
 

