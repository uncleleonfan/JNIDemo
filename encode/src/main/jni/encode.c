#include <jni.h>
void encode(char *cstr, int size) {
    char *p = cstr;
    char *q = &cstr[size-1];
    char temp;
    while (p < q) {
        temp = *p;
        *p = *q;
        *q = temp;
        p++;
        q--;
    }
}

jstring  Java_com_leon_encode_MainActivity_encode(JNIEnv * env, jobject obj, jstring jstr) {
    //加密

    //字符串长度
    jsize length =  (*env)->GetStringLength(env, jstr);
    //将jstring转换成char *
    char * cstr = malloc(length * sizeof(char) + 1);
    cstr[length] = '\0';//注意不要写成‘/0’
    (*env)->GetStringUTFRegion(env, jstr, 0, length, cstr);
    //实现加密算法  13845  ---》 54831  138452---》 254831
    encode(cstr, length);
    //返回加密结果
    jstring result = (*env)->NewStringUTF(env, cstr);
    return result;
}

jstring  Java_com_leon_encode_MainActivity_decode(JNIEnv * env, jobject obj, jstring jstr) {
    //加密

    //字符串长度
    jsize length =  (*env)->GetStringLength(env, jstr);
    //将jstring转换成char *
    char * cstr = malloc(length * sizeof(char) + 1);
    cstr[length] = '\0';//注意不要写成‘/0’
    (*env)->GetStringUTFRegion(env, jstr, 0, length, cstr);
    //实现加密算法  13845  ---》 54831  138452---》 254831
    encode(cstr, length);
    //返回加密结果
    jstring result = (*env)->NewStringUTF(env, cstr);
    return result;
}

