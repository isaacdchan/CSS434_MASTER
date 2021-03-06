/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class mpi_Intercomm */

#ifndef _Included_mpi_Intercomm
#define _Included_mpi_Intercomm
#ifdef __cplusplus
extern "C" {
#endif
#undef mpi_Intercomm_SELF
#define mpi_Intercomm_SELF 1L
#undef mpi_Intercomm_WORLD
#define mpi_Intercomm_WORLD 2L
/*
 * Class:     mpi_Intercomm
 * Method:    Remote_size
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_mpi_Intercomm_Remote_1size
  (JNIEnv *, jobject);

/*
 * Class:     mpi_Intercomm
 * Method:    remote_group
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_mpi_Intercomm_remote_1group
  (JNIEnv *, jobject);

/*
 * Class:     mpi_Intercomm
 * Method:    merge
 * Signature: (Z)J
 */
JNIEXPORT jlong JNICALL Java_mpi_Intercomm_merge
  (JNIEnv *, jobject, jboolean);

#ifdef __cplusplus
}
#endif
#endif
