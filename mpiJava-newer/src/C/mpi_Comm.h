/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class mpi_Comm */

#ifndef _Included_mpi_Comm
#define _Included_mpi_Comm
#ifdef __cplusplus
extern "C" {
#endif
#undef mpi_Comm_SELF
#define mpi_Comm_SELF 1L
#undef mpi_Comm_WORLD
#define mpi_Comm_WORLD 2L
/*
 * Class:     mpi_Comm
 * Method:    GetComm
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_mpi_Comm_GetComm
  (JNIEnv *, jobject, jint);

/*
 * Class:     mpi_Comm
 * Method:    dup
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_mpi_Comm_dup
  (JNIEnv *, jobject);

/*
 * Class:     mpi_Comm
 * Method:    Size
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_mpi_Comm_Size
  (JNIEnv *, jobject);

/*
 * Class:     mpi_Comm
 * Method:    Rank
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_mpi_Comm_Rank
  (JNIEnv *, jobject);

/*
 * Class:     mpi_Comm
 * Method:    Compare
 * Signature: (Lmpi/Comm;Lmpi/Comm;)I
 */
JNIEXPORT jint JNICALL Java_mpi_Comm_Compare
  (JNIEnv *, jclass, jobject, jobject);

/*
 * Class:     mpi_Comm
 * Method:    Free
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_mpi_Comm_Free
  (JNIEnv *, jobject);

/*
 * Class:     mpi_Comm
 * Method:    Is_null
 * Signature: ()Z
 */
JNIEXPORT jboolean JNICALL Java_mpi_Comm_Is_1null
  (JNIEnv *, jobject);

/*
 * Class:     mpi_Comm
 * Method:    group
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_mpi_Comm_group
  (JNIEnv *, jobject);

/*
 * Class:     mpi_Comm
 * Method:    Test_inter
 * Signature: ()Z
 */
JNIEXPORT jboolean JNICALL Java_mpi_Comm_Test_1inter
  (JNIEnv *, jobject);

/*
 * Class:     mpi_Comm
 * Method:    GetIntercomm
 * Signature: (Lmpi/Comm;III)J
 */
JNIEXPORT jlong JNICALL Java_mpi_Comm_GetIntercomm
  (JNIEnv *, jobject, jobject, jint, jint, jint);

/*
 * Class:     mpi_Comm
 * Method:    send
 * Signature: (Ljava/lang/Object;IILmpi/Datatype;II)V
 */
JNIEXPORT void JNICALL Java_mpi_Comm_send
  (JNIEnv *, jobject, jobject, jint, jint, jobject, jint, jint);

/*
 * Class:     mpi_Comm
 * Method:    Recv
 * Signature: (Ljava/lang/Object;IILmpi/Datatype;IILmpi/Status;)Lmpi/Status;
 */
JNIEXPORT jobject JNICALL Java_mpi_Comm_Recv
  (JNIEnv *, jobject, jobject, jint, jint, jobject, jint, jint, jobject);

/*
 * Class:     mpi_Comm
 * Method:    Sendrecv
 * Signature: (Ljava/lang/Object;IILmpi/Datatype;IILjava/lang/Object;IILmpi/Datatype;IILmpi/Status;)Lmpi/Status;
 */
JNIEXPORT jobject JNICALL Java_mpi_Comm_Sendrecv
  (JNIEnv *, jobject, jobject, jint, jint, jobject, jint, jint, jobject, jint, jint, jobject, jint, jint, jobject);

/*
 * Class:     mpi_Comm
 * Method:    Sendrecv_replace
 * Signature: (Ljava/lang/Object;IILmpi/Datatype;IIIILmpi/Status;)Lmpi/Status;
 */
JNIEXPORT jobject JNICALL Java_mpi_Comm_Sendrecv_1replace
  (JNIEnv *, jobject, jobject, jint, jint, jobject, jint, jint, jint, jint, jobject);

/*
 * Class:     mpi_Comm
 * Method:    bsend
 * Signature: (Ljava/lang/Object;IILmpi/Datatype;II)V
 */
JNIEXPORT void JNICALL Java_mpi_Comm_bsend
  (JNIEnv *, jobject, jobject, jint, jint, jobject, jint, jint);

/*
 * Class:     mpi_Comm
 * Method:    ssend
 * Signature: (Ljava/lang/Object;IILmpi/Datatype;II)V
 */
JNIEXPORT void JNICALL Java_mpi_Comm_ssend
  (JNIEnv *, jobject, jobject, jint, jint, jobject, jint, jint);

/*
 * Class:     mpi_Comm
 * Method:    rsend
 * Signature: (Ljava/lang/Object;IILmpi/Datatype;II)V
 */
JNIEXPORT void JNICALL Java_mpi_Comm_rsend
  (JNIEnv *, jobject, jobject, jint, jint, jobject, jint, jint);

/*
 * Class:     mpi_Comm
 * Method:    Isend
 * Signature: (Ljava/lang/Object;IILmpi/Datatype;IILmpi/Request;)Lmpi/Request;
 */
JNIEXPORT jobject JNICALL Java_mpi_Comm_Isend
  (JNIEnv *, jobject, jobject, jint, jint, jobject, jint, jint, jobject);

/*
 * Class:     mpi_Comm
 * Method:    Ibsend
 * Signature: (Ljava/lang/Object;IILmpi/Datatype;IILmpi/Request;)Lmpi/Request;
 */
JNIEXPORT jobject JNICALL Java_mpi_Comm_Ibsend
  (JNIEnv *, jobject, jobject, jint, jint, jobject, jint, jint, jobject);

/*
 * Class:     mpi_Comm
 * Method:    Issend
 * Signature: (Ljava/lang/Object;IILmpi/Datatype;IILmpi/Request;)Lmpi/Request;
 */
JNIEXPORT jobject JNICALL Java_mpi_Comm_Issend
  (JNIEnv *, jobject, jobject, jint, jint, jobject, jint, jint, jobject);

/*
 * Class:     mpi_Comm
 * Method:    Irsend
 * Signature: (Ljava/lang/Object;IILmpi/Datatype;IILmpi/Request;)Lmpi/Request;
 */
JNIEXPORT jobject JNICALL Java_mpi_Comm_Irsend
  (JNIEnv *, jobject, jobject, jint, jint, jobject, jint, jint, jobject);

/*
 * Class:     mpi_Comm
 * Method:    Irecv
 * Signature: (Ljava/lang/Object;IILmpi/Datatype;IILmpi/Request;)Lmpi/Request;
 */
JNIEXPORT jobject JNICALL Java_mpi_Comm_Irecv
  (JNIEnv *, jobject, jobject, jint, jint, jobject, jint, jint, jobject);

/*
 * Class:     mpi_Comm
 * Method:    pack
 * Signature: (Ljava/lang/Object;IILmpi/Datatype;[BI)I
 */
JNIEXPORT jint JNICALL Java_mpi_Comm_pack
  (JNIEnv *, jobject, jobject, jint, jint, jobject, jbyteArray, jint);

/*
 * Class:     mpi_Comm
 * Method:    unpack
 * Signature: ([BILjava/lang/Object;IILmpi/Datatype;)I
 */
JNIEXPORT jint JNICALL Java_mpi_Comm_unpack
  (JNIEnv *, jobject, jbyteArray, jint, jobject, jint, jint, jobject);

/*
 * Class:     mpi_Comm
 * Method:    Pack_size
 * Signature: (ILmpi/Datatype;)I
 */
JNIEXPORT jint JNICALL Java_mpi_Comm_Pack_1size
  (JNIEnv *, jobject, jint, jobject);

/*
 * Class:     mpi_Comm
 * Method:    Iprobe
 * Signature: (IILmpi/Status;)Lmpi/Status;
 */
JNIEXPORT jobject JNICALL Java_mpi_Comm_Iprobe
  (JNIEnv *, jobject, jint, jint, jobject);

/*
 * Class:     mpi_Comm
 * Method:    Probe
 * Signature: (IILmpi/Status;)Lmpi/Status;
 */
JNIEXPORT jobject JNICALL Java_mpi_Comm_Probe
  (JNIEnv *, jobject, jint, jint, jobject);

/*
 * Class:     mpi_Comm
 * Method:    Attr_get
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_mpi_Comm_Attr_1get
  (JNIEnv *, jobject, jint);

/*
 * Class:     mpi_Comm
 * Method:    Topo_test
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_mpi_Comm_Topo_1test
  (JNIEnv *, jobject);

/*
 * Class:     mpi_Comm
 * Method:    Abort
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_mpi_Comm_Abort
  (JNIEnv *, jobject, jint);

/*
 * Class:     mpi_Comm
 * Method:    Errhandler_set
 * Signature: (Lmpi/Errhandler;)V
 */
JNIEXPORT void JNICALL Java_mpi_Comm_Errhandler_1set
  (JNIEnv *, jobject, jobject);

/*
 * Class:     mpi_Comm
 * Method:    errorhandler_get
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_mpi_Comm_errorhandler_1get
  (JNIEnv *, jobject);

/*
 * Class:     mpi_Comm
 * Method:    init
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_mpi_Comm_init
  (JNIEnv *, jclass);

#ifdef __cplusplus
}
#endif
#endif
