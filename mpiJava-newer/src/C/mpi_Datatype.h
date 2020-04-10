/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class mpi_Datatype */

#ifndef _Included_mpi_Datatype
#define _Included_mpi_Datatype
#ifdef __cplusplus
extern "C" {
#endif
#undef mpi_Datatype_UNDEFINED
#define mpi_Datatype_UNDEFINED -1L
#undef mpi_Datatype_NULL
#define mpi_Datatype_NULL 0L
#undef mpi_Datatype_BYTE
#define mpi_Datatype_BYTE 1L
#undef mpi_Datatype_CHAR
#define mpi_Datatype_CHAR 2L
#undef mpi_Datatype_SHORT
#define mpi_Datatype_SHORT 3L
#undef mpi_Datatype_BOOLEAN
#define mpi_Datatype_BOOLEAN 4L
#undef mpi_Datatype_INT
#define mpi_Datatype_INT 5L
#undef mpi_Datatype_LONG
#define mpi_Datatype_LONG 6L
#undef mpi_Datatype_FLOAT
#define mpi_Datatype_FLOAT 7L
#undef mpi_Datatype_DOUBLE
#define mpi_Datatype_DOUBLE 8L
#undef mpi_Datatype_PACKED
#define mpi_Datatype_PACKED 9L
#undef mpi_Datatype_LB
#define mpi_Datatype_LB 10L
#undef mpi_Datatype_UB
#define mpi_Datatype_UB 11L
#undef mpi_Datatype_OBJECT
#define mpi_Datatype_OBJECT 12L
/*
 * Class:     mpi_Datatype
 * Method:    init
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_mpi_Datatype_init
  (JNIEnv *, jclass);

/*
 * Class:     mpi_Datatype
 * Method:    GetDatatype
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_mpi_Datatype_GetDatatype
  (JNIEnv *, jobject, jint);

/*
 * Class:     mpi_Datatype
 * Method:    GetContiguous
 * Signature: (ILmpi/Datatype;)V
 */
JNIEXPORT void JNICALL Java_mpi_Datatype_GetContiguous
  (JNIEnv *, jobject, jint, jobject);

/*
 * Class:     mpi_Datatype
 * Method:    GetVector
 * Signature: (IIILmpi/Datatype;)V
 */
JNIEXPORT void JNICALL Java_mpi_Datatype_GetVector
  (JNIEnv *, jobject, jint, jint, jint, jobject);

/*
 * Class:     mpi_Datatype
 * Method:    GetHvector
 * Signature: (IIILmpi/Datatype;)V
 */
JNIEXPORT void JNICALL Java_mpi_Datatype_GetHvector
  (JNIEnv *, jobject, jint, jint, jint, jobject);

/*
 * Class:     mpi_Datatype
 * Method:    GetIndexed
 * Signature: ([I[ILmpi/Datatype;)V
 */
JNIEXPORT void JNICALL Java_mpi_Datatype_GetIndexed
  (JNIEnv *, jobject, jintArray, jintArray, jobject);

/*
 * Class:     mpi_Datatype
 * Method:    GetHindexed
 * Signature: ([I[ILmpi/Datatype;)V
 */
JNIEXPORT void JNICALL Java_mpi_Datatype_GetHindexed
  (JNIEnv *, jobject, jintArray, jintArray, jobject);

/*
 * Class:     mpi_Datatype
 * Method:    GetStruct
 * Signature: ([I[I[Lmpi/Datatype;ZIZI)V
 */
JNIEXPORT void JNICALL Java_mpi_Datatype_GetStruct
  (JNIEnv *, jobject, jintArray, jintArray, jobjectArray, jboolean, jint, jboolean, jint);

/*
 * Class:     mpi_Datatype
 * Method:    extent
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_mpi_Datatype_extent
  (JNIEnv *, jobject);

/*
 * Class:     mpi_Datatype
 * Method:    size
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_mpi_Datatype_size
  (JNIEnv *, jobject);

/*
 * Class:     mpi_Datatype
 * Method:    lB
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_mpi_Datatype_lB
  (JNIEnv *, jobject);

/*
 * Class:     mpi_Datatype
 * Method:    uB
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_mpi_Datatype_uB
  (JNIEnv *, jobject);

/*
 * Class:     mpi_Datatype
 * Method:    commit
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_mpi_Datatype_commit
  (JNIEnv *, jobject);

/*
 * Class:     mpi_Datatype
 * Method:    free
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_mpi_Datatype_free
  (JNIEnv *, jobject);

#ifdef __cplusplus
}
#endif
#endif
