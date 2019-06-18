
#include <jni.h>


extern int main(int argc, char *argv[]);


JNIEXPORT void JNICALL
Java_com_banzhi_libbsdiff_BsPatch_bsPatch(JNIEnv *env, jclass type, jstring oldApk_,
                                            jstring patch_, jstring newApk_) {
    const char *oldApk = (*env)->GetStringUTFChars(env, oldApk_, 0);
    const char *patch = (*env)->GetStringUTFChars(env, patch_, 0);
    const char *newApk = (*env)->GetStringUTFChars(env, newApk_, 0);

    char *argv[] = {"", (char *) oldApk, (char *) newApk, (char *) patch};
    main(4, argv);
    (*env)->ReleaseStringUTFChars(env, oldApk_, oldApk);
    (*env)->ReleaseStringUTFChars(env, patch_, patch);
    (*env)->ReleaseStringUTFChars(env, newApk_, newApk);
}