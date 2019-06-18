package com.banzhi.libbsdiff;

import java.io.File;

/**
 * <pre>
 * @author : No.1
 * @time : 2019/6/18.
 * @desciption :
 * @version :
 * </pre>
 */

public interface PatchCallback {
    void onPatch(File file);
}
