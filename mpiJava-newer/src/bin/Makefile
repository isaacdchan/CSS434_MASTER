# Generated automatically from Makefile.in by configure.

JAVA_HOME=/usr/java/latest
ARCH=i386
JOS=linux
CC=/home/staff/jdlarios/opt/bin/mpicc

jvmlauncher: jvmlauncher.c
	$(CC) -DJRE_PATH='"${JAVA_HOME}/jre/lib/${ARCH}"' -I${JAVA_HOME}/include -I${JAVA_HOME}/include/${JOS} -o jvmlauncher jvmlauncher.c -ldl -lmpi

clean :
	rm -f jvmlauncher

