/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class com_onionnetworks_fec_Native16Code */

#ifndef _Included_com_onionnetworks_fec_Native16Code
#define _Included_com_onionnetworks_fec_Native16Code
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     com_onionnetworks_fec_Native16Code
 * Method:    nativeEncode
 * Signature: ([[B[I[I[[B[III)V
 */
JNIEXPORT void JNICALL Java_com_onionnetworks_fec_Native16Code_nativeEncode
  (JNIEnv *, jobject, jobjectArray, jintArray, jintArray, jobjectArray, jintArray, jint, jint);

/*
 * Class:     com_onionnetworks_fec_Native16Code
 * Method:    nativeDecode
 * Signature: ([[B[I[III)V
 */
JNIEXPORT void JNICALL Java_com_onionnetworks_fec_Native16Code_nativeDecode
  (JNIEnv *, jobject, jobjectArray, jintArray, jintArray, jint, jint);

/*
 * Class:     com_onionnetworks_fec_Native16Code
 * Method:    nativeNewFEC
 * Signature: (II)V
 */
JNIEXPORT void JNICALL Java_com_onionnetworks_fec_Native16Code_nativeNewFEC
  (JNIEnv *, jobject, jint, jint);

/*
 * Class:     com_onionnetworks_fec_Native16Code
 * Method:    nativeFreeFEC
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_onionnetworks_fec_Native16Code_nativeFreeFEC
  (JNIEnv *, jobject);

/*
 * Class:     com_onionnetworks_fec_Native16Code
 * Method:    initFEC
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_onionnetworks_fec_Native16Code_initFEC
  (JNIEnv *, jclass);

#ifdef __cplusplus
}
#endif
#endif