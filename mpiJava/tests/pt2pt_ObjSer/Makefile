# Generated automatically from Makefile.in by configure.
# File         : Makefile
# Author       : Xinying Li, Sung-Hoon Ko
# Created      : Thu Apr  9 12:22:15 1998
# Revision     : ver 1.1
# Updated      : $Date: 2001/10/22 21:07:56 $
# Copyright: Northeast Parallel Architectures Center at Syracuse University 1998


SHELL=/bin/sh

srcdir      = .
top_srcdir  = ../..

VERSION = 1.00

mpiJavaHome = ../..
mpiJavaClasses = ../../lib/classes

JAVA_PATH = /usr/java/jdk1.5.0_14/

MPI_RUN  = ${MPI_PATH}/bin/mpirun -np
CLASS_PATH = -classpath .:${mpiJavaClasses}:${JAVA_PATH}/lib/classes.zip:${JAVA_PATH}/classes
JAVA_C = ${JAVA_PATH}/bin/javac

prefix      = /home2/beefcmdr/mpiJava

exec_prefix = ${prefix}
bindir      = ${exec_prefix}/bin

target=

VPATH = .:${srcdir}

all: update test check 

update: Makefile RunTests

Makefile: Makefile.in
	@echo 
	@echo Please configure the package to generate new makefile ...
	@exit 1

RunTests: RunTests.in
	@echo 
	@echo Please configure the package to generate new runtests ...
	@exit

test:test.java
	${JAVA_C} test.java

check: 
	./RunTests

summary:
	./summarize


clean:
	rm -f *.class core PI* *.jig *.out diffs

distclean:
	rm -f *.rec 

record:

compdep:

compare:

test: 
