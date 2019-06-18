package com.banzhi.libbsdiff;

/**
 * <pre>
 * @author : No.1
 * @time : 2019/6/18.
 * @desciption :
 * @version :
 * </pre>
 */

public class BsPatch {
    static {
        System.loadLibrary("bspatch");
    }


    public static native void bsPatch(String oldApk, String patch, String newApk);


}
