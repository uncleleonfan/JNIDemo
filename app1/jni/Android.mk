#当前路径
LOCAL_PATH := $(call my-dir)
#清除
include $(CLEAR_VARS)
#so库的名字
LOCAL_MODULE := hello-jni
#源文件
LOCAL_SRC_FILES := hello.c
#指定生成共享库
include $(BUILD_SHARED_LIBRARY)