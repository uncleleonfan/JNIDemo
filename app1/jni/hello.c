#include<jni.h>//引入jni头文件，里面申明了java 和 c的数据转换方法

 /**
  * 返回值 jstring数据类型在jni.h文件中使用了typedef定义
  * 方法名对应于java中的包名，一种映射关系
  * JNIEnv结构体指针
  * jobject 调用该方法的Java类，用于c调java代码
  */
 jstring Java_com_leon_jnidemo_MainActivity_hello(JNIEnv *env, jobject obj ) {
     char *buffer = "hello";
     return (*env)->NewStringUTF(env, buffer);
 }