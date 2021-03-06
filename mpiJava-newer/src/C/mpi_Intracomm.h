/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class mpi_Intracomm */

#ifndef _Included_mpi_Intracomm
#define _Included_mpi_Intracomm
#ifdef __cplusplus
extern "C" {
#endif
#undef mpi_Intracomm_SELF
#define mpi_Intracomm_SELF 1L
#undef mpi_Intracomm_WORLD
#define mpi_Intracomm_WORLD 2L
/*
 * Class:     mpi_Intracomm
 * Method:    split
 * Signature: (II)J
 */
JNIEXPORT jlong JNICALL Java_mpi_Intracomm_split
  (JNIEnv *, jobject, jint, jint);

/*
 * Class:     mpi_Intracomm
 * Method:    creat
 * Signature: (Lmpi/Group;)J
 */
JNIEXPORT jlong JNICALL Java_mpi_Intracomm_creat
  (JNIEnv *, jobject, jobject);

/*
 * Class:     mpi_Intracomm
 * Method:    Barrier
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_mpi_Intracomm_Barrier
  (JNIEnv *, jobject);

/*
 * Class:     mpi_Intracomm
 * Method:    bcast
 * Signature: (Ljava/lang/Object;IILmpi/Datatype;I)V
 */
JNIEXPORT void JNICALL Java_mpi_Intracomm_bcast
  (JNIEnv *, jobject, jobject, jint, jint, jobject, jint);

/*
 * Class:     mpi_Intracomm
 * Method:    gather
 * Signature: (Ljava/lang/Object;IILmpi/Datatype;Ljava/lang/Object;IILmpi/Datatype;I)V
 */
JNIEXPORT void JNICALL Java_mpi_Intracomm_gather
  (JNIEnv *, jobject, jobject, jint, jint, jobject, jobject, jint, jint, jobject, jint);

/*
 * Class:     mpi_Intracomm
 * Method:    gatherv
 * Signature: (Ljava/lang/Object;IILmpi/Datatype;Ljava/lang/Object;I[I[ILmpi/Datatype;I)V
 */
JNIEXPORT void JNICALL Java_mpi_Intracomm_gatherv
  (JNIEnv *, jobject, jobject, jint, jint, jobject, jobject, jint, jintArray, jintArray, jobject, jint);

/*
 * Class:     mpi_Intracomm
 * Method:    scatter
 * Signature: (Ljava/lang/Object;IILmpi/Datatype;Ljava/lang/Object;IILmpi/Datatype;I)V
 */
JNIEXPORT void JNICALL Java_mpi_Intracomm_scatter
  (JNIEnv *, jobject, jobject, jint, jint, jobject, jobject, jint, jint, jobject, jint);

/*
 * Class:     mpi_Intracomm
 * Method:    scatterv
 * Signature: (Ljava/lang/Object;I[I[ILmpi/Datatype;Ljava/lang/Object;IILmpi/Datatype;I)V
 */
JNIEXPORT void JNICALL Java_mpi_Intracomm_scatterv
  (JNIEnv *, jobject, jobject, jint, jintArray, jintArray, jobject, jobject, jint, jint, jobject, jint);

/*
 * Class:     mpi_Intracomm
 * Method:    allgather
 * Signature: (Ljava/lang/Object;IILmpi/Datatype;Ljava/lang/Object;IILmpi/Datatype;)V
 */
JNIEXPORT void JNICALL Java_mpi_Intracomm_allgather
  (JNIEnv *, jobject, jobject, jint, jint, jobject, jobject, jint, jint, jobject);

/*
 * Class:     mpi_Intracomm
 * Method:    allgatherv
 * Signature: (Ljava/lang/Object;IILmpi/Datatype;Ljava/lang/Object;I[I[ILmpi/Datatype;)V
 */
JNIEXPORT void JNICALL Java_mpi_Intracomm_allgatherv
  (JNIEnv *, jobject, jobject, jint, jint, jobject, jobject, jint, jintArray, jintArray, jobject);

/*
 * Class:     mpi_Intracomm
 * Method:    alltoall
 * Signature: (Ljava/lang/Object;IILmpi/Datatype;Ljava/lang/Object;IILmpi/Datatype;)V
 */
JNIEXPORT void JNICALL Java_mpi_Intracomm_alltoall
  (JNIEnv *, jobject, jobject, jint, jint, jobject, jobject, jint, jint, jobject);

/*
 * Class:     mpi_Intracomm
 * Method:    alltoallv
 * Signature: (Ljava/lang/Object;I[I[ILmpi/Datatype;Ljava/lang/Object;I[I[ILmpi/Datatype;)V
 */
JNIEXPORT void JNICALL Java_mpi_Intracomm_alltoallv
  (JNIEnv *, jobject, jobject, jint, jintArray, jintArray, jobject, jobject, jint, jintArray, jintArray, jobject);

/*
 * Class:     mpi_Intracomm
 * Method:    reduce
 * Signature: (Ljava/lang/Object;ILjava/lang/Object;IILmpi/Datatype;Lmpi/Op;I)V
 */
JNIEXPORT void JNICALL Java_mpi_Intracomm_reduce
  (JNIEnv *, jobject, jobject, jint, jobject, jint, jint, jobject, jobject, jint);

/*
 * Class:     mpi_Intracomm
 * Method:    allreduce
 * Signature: (Ljava/lang/Object;ILjava/lang/Object;IILmpi/Datatype;Lmpi/Op;)V
 */
JNIEXPORT void JNICALL Java_mpi_Intracomm_allreduce
  (JNIEnv *, jobject, jobject, jint, jobject, jint, jint, jobject, jobject);

/*
 * Class:     mpi_Intracomm
 * Method:    reduce_scatter
 * Signature: (Ljava/lang/Object;ILjava/lang/Object;I[ILmpi/Datatype;Lmpi/Op;)V
 */
JNIEXPORT void JNICALL Java_mpi_Intracomm_reduce_1scatter
  (JNIEnv *, jobject, jobject, jint, jobject, jint, jintArray, jobject, jobject);

/*
 * Class:     mpi_Intracomm
 * Method:    scan
 * Signature: (Ljava/lang/Object;ILjava/lang/Object;IILmpi/Datatype;Lmpi/Op;)V
 */
JNIEXPORT void JNICALL Java_mpi_Intracomm_scan
  (JNIEnv *, jobject, jobject, jint, jobject, jint, jint, jobject, jobject);

/*
 * Class:     mpi_Intracomm
 * Method:    GetCart
 * Signature: ([I[ZZ)J
 */
JNIEXPORT jlong JNICALL Java_mpi_Intracomm_GetCart
  (JNIEnv *, jobject, jintArray, jbooleanArray, jboolean);

/*
 * Class:     mpi_Intracomm
 * Method:    GetGraph
 * Signature: ([I[IZ)J
 */
JNIEXPORT jlong JNICALL Java_mpi_Intracomm_GetGraph
  (JNIEnv *, jobject, jintArray, jintArray, jboolean);

#ifdef __cplusplus
}
#endif
#endif
