package com.banzhi.libbsdiff;

import android.os.AsyncTask;
import android.os.Environment;

import java.io.File;
import java.io.IOException;

/**
 * <pre>
 * @author : No.1
 * @time : 2019/6/18.
 * @desciption :
 * @version :
 * </pre>
 */

public class DiffTask extends AsyncTask<String, Void, File> {

    PatchCallback patchCallback;

    public DiffTask(PatchCallback patchCallback) {
        this.patchCallback = patchCallback;
    }

    @Override
    protected File doInBackground(String... strings) {
        String oldApk = strings[0];
        String patch = strings[1];
        String outPut = createNewApk(strings[2]).getAbsolutePath();
        BsPatch.bsPatch(oldApk, patch, outPut);
        return new File(outPut);
    }

    @Override
    protected void onPostExecute(File file) {
        super.onPostExecute(file);
        if (patchCallback != null) {
            patchCallback.onPatch(file);
        }
    }


    public void execute(String oldApkPath, String patchPath, String newApkPath) {
        super.execute(oldApkPath, patchPath, newApkPath);
    }


    private File createNewApk(String newPath) {
        String apkName;
        String path;
        if (newPath != null && newPath.endsWith(".apk")) {
            apkName = newPath.substring(newPath.lastIndexOf("/") + 1);
            path = newPath.substring(0, newPath.lastIndexOf("/"));
        } else {
            apkName = "bsdiff.apk";
            path = newPath == null ? Environment.getExternalStorageDirectory().getAbsolutePath() : newPath;
        }
        try {
            File newApk = new File(path, apkName);
            if (newApk.exists()) {
                newApk.delete();
                newApk.createNewFile();
            } else {
                newApk.createNewFile();
            }
            return newApk;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
