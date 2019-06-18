package com.banzhi.libbsdiff;

import android.content.Context;

/**
 * <pre>
 * @author : No.1
 * @time : 2019/6/18.
 * @desciption :
 * @version :
 * </pre>
 */

public class PatchUtils {
    /**
     * @param context    上下文
     * @param patchPatch 查分包地址
     * @param callback   合成回调
     */
    public static void patchApk(Context context, String patchPatch, PatchCallback callback) {
        new DiffTask(callback).execute(context.getApplicationInfo().sourceDir, patchPatch, null);
    }

    /**
     * @param oldApkPath oldapk路径
     * @param patchPatch patch路径
     * @param callback   合成回调
     */
    public static void patchApk(String oldApkPath, String patchPatch, PatchCallback callback) {
        new DiffTask(callback).execute(oldApkPath, patchPatch, null);
    }

    /**
     * @param oldApkPath oldapk路径
     * @param patchPatch patch路径
     * @param newPath    newApk路径
     * @param callback   合成回调
     */
    public static void patchApk(String oldApkPath, String patchPatch, String newPath, PatchCallback callback) {
        new DiffTask(callback).execute(oldApkPath, patchPatch, newPath);
    }
}
