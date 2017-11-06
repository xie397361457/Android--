package com.manager.incremental;

/**
 * 本地方法存放类,目前推荐使用java类,不建议kotlin进行配置此类
 * 一键生成c/c++头文件
 *         1.打开Android studio 命令工具Terminal
 *         2.cd app/src/main/java  -->进入到java目录下面
 *         3.javah 本类的package + 类名   eg:  javah com.manager.incremental.BsPatchNative
 *                                        注意:如果遇见-->错误: 编码GBK的不可映射字符此类错误,是由于jdk是国际版引起的
 *                                        可以使用这个命令 javah -encoding UTF-8 com.manager.incremental.BsPatchNative
 *         4.将生成的头文件移动到cpp文件夹下面,方便管理和使用
 * kotlin 1.配置static 需要加上@JvmStatic注解
 *        2.使用kotlin,不能使用javah 进行生成c/c++头文件
 *        3.使用kotlin,不能一键链接到指定的c/c++头文件函数方法
 *
 * @author nuo
 */

public class BsPatchNative {

    public static native int bspatch(String oldPath,String newPath,String patchPath);

    static {
        System.loadLibrary("BsPatch");
    }
}
