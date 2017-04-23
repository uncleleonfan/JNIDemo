#include<jni.h>
jstring Java_com_leon_app2_MainActivity_hello(JNIEnv *env, jobject obj) {
    char *buf = "Hello World";
    return (*env)->NewStringUTF(env, buf);
}
