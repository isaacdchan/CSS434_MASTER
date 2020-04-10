# Generated automatically from Makefile.in by configure.
# File         : Makefile
# Author       : Xinying Li, Sung-Hoon Ko
# Created      : Thu Apr  9 12:22:15 1998
# Revision     : ver 1.1
# Updated      : $Date: 2002/07/04 19:23:15 $
# Copyright: Northeast Parallel Architectures Center at Syracuse University 1998


SHELL=/bin/sh

srcdir      = .
top_srcdir  = ../..

VERSION = 1.00

prefix      = /home2/beefcmdr/mpiJava

exec_prefix = ${prefix}
bindir      = ${exec_prefix}/bin

target=

VPATH = .:${srcdir}

all: update check 

update: Makefile RunTests

Makefile: Makefile.in
	@echo 
	@echo Please configure the package to generate new makefile ...
	@exit 1

RunTests: RunTests.in
	@echo 
	@echo Please configure the package to generate new runtests ...
	@exit


check: 
	./RunTests


clean:
	rm -f *.class core PI* *.jig

distclean:
	rm -f *.rec 

record:

compdep:

compare:

test: 
