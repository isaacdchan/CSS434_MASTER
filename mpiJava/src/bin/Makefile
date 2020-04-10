# Generated automatically from Makefile.in by configure.

JAVA_HOME=/usr/java/jdk1.5.0_14/
ARCH=i386
JOS=linux
CC=/usr/local/mpich2/bin/mpicc

jvmlauncher: jvmlauncher.c
	$(CC) -DJRE_PATH='"${JAVA_HOME}/jre/lib/${ARCH}"' -I${JAVA_HOME}/include -I${JAVA_HOME}/include/${JOS} -o jvmlauncher jvmlauncher.c -ldl -lmpi

clean :
	rm -f jvmlauncher

