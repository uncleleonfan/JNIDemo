#include <jni.h>
void Java_com_leon_calljava_MainActivity_callC(JNIEnv * jniEnv, jobject obj) {
    //调用java里面的函数
    //1 . 找到java代码的 class文件
    //    jclass      (*FindClass)(JNIEnv*, const char*);
    jclass dpclazz = (*jniEnv)->FindClass(jniEnv,"com/leon/calljava/MainActivity");
    //2 寻找class里面的方法
    //   jmethodID   (*GetMethodID)(JNIEnv*, jclass, const char*, const char*);
    jmethodID method = (*jniEnv)->GetMethodID(jniEnv, dpclazz,"calledByC","()V");
    //3. 调用Java方法
    (*jniEnv)->CallVoidMethod(jniEnv, obj, method);
}