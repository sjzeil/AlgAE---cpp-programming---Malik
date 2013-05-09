# 
# Makefile for Sorting Demo
#

include ../../../../../../../../make.config.$(OSTYPE)

BASE=edu/odu/cs/zeil/AlgAE/Demos/Sort
UTILS=edu/odu/cs/zeil/AlgAE/Demos/Utils
ANIMNAME=WeissJavaSort

CLASSES = \
        Supporting/Comparable.class \
        DataStructures/Sort.class \
        HeapTree.class \
        IntegerPair.class \
        SortDemo.class 


UTILCLASSES = \
        ../Utils/Alias.class \
        ../Utils/AliasArray.class \
        ../Utils/Indexable.class \
        ../Utils/VisibleInteger.class \
        ../Utils/VisibleVector.class \
        ../Utils/WhiteBox.class 


all: sortdemo.jar source/Sort.java


install:  
	$(INSTALL) -d $(JAVAINSTALLDIR)/$(ANIMNAME)
	$(INSTALL) sortdemo.jar $(JAVAINSTALLDIR)/$(ANIMNAME) 
	$(INSTALL) source/Sort.java $(JAVAINSTALLDIR)/$(ANIMNAME)
	$(INSTALL) source/Sort.java.idx $(JAVAINSTALLDIR)/$(ANIMNAME)
	sed -e 's^ANIMNAME^$(ANIMNAME)^' -f $(ALGAEBASE)/installsubs.sed < sortdemo.html > $(JAVAINSTALLDIR)/$(ANIMNAME)/sortdemo.html


clean: 
	$(RM) sortdemo.jar *.classes source/Sort.java*

cleaner: clean
	$(RM) $(JAVAINSTALLDIR)/$(ANIMNAME)/*
	rmdir $(JAVAINSTALLDIR)/$(ANIMNAME)


sortdemo.jar: $(UTILCLASSES) $(CLASSES) 
	cd $(ALGAEBASE)/java; $(JAR) $(BASE)/sortdemo.jar $(BASE)/*.class $(BASE)/Supporting/*.class $(BASE)/DataStructures/*.class $(UTILS)/*.class


source/Sort.java: DataStructures/Sort.java
	$(JAVARUN) FilterSource $? $@ $@.idx

run: all
	$(JAVARUN) edu.odu.cs.zeil.AlgAE.Demos.Sort.SortDemo -layout wide -source0 source/Sort.java -index0 source/Sort.java.idx -logfile sortdemo.log &

applet: install
	cd $(JAVAINSTALLDIR)/$(ANIMNAME); $(RUNAPPLET) sortdemo.html

