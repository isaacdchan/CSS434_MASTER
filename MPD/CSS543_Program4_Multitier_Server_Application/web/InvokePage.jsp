<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : invokePage
    Created on : 2009/11/28, 15:02:09
    Author     : fumitakakawasaki
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head id="head1">
                    <webuijsf:link id="link1" url="/resources/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <webuijsf:form id="form1">
                        <h:panelGrid border="0" cellpadding="3" cellspacing="3" columns="2" id="gridPanel1">
                            <webuijsf:image id="image1" url="/resources/uw_huskies_logo.gif"/>
                            <h:panelGrid border="0" cellpadding="5" cellspacing="3" columns="3" headerClass="login-heading" id="gridPanel2">
                                <f:facet name="header">
                                    <h:outputText value="Remote MPI Java Client"/>
                                </f:facet>
                                <h:messages globalOnly="true" styleClass="errorMessage"/>
                                <h:panelGroup/>
                                <h:panelGroup/>
                                <h:outputLabel for="fileUpload1">
                                    <h:outputText value="Enter jar file name:"/>
                                </h:outputLabel>
                                <webuijsf:upload binding="#{InvokePage.upload}" id="fileUpload1" required="true" uploadedFile="#{InvokePage.jarFile}" valueChangeListenerExpression="#{InvokePage.fileUpload1_processValueChange}"/>
                                <h:message for="fileUpload1" styleClass="errorMessage"/>
                                <h:outputLabel for="commandInput">
                                    <h:outputText value="Enter command with arguments:"/>
                                </h:outputLabel>
                                <h:inputText id="commandInput" maxlength="100" required="true" requiredMessage="Please fill in this field." size="40" value="#{InvokePage.command}"/>
                                <h:message for="commandInput" styleClass="errorMessage"/>
                                <h:outputLabel for="numCPUInput">
                                    <h:outputText value="Enter number of CPUs:"/>
                                </h:outputLabel>
                                <h:inputText converter="#{InvokePage.numberConverter1}" converterMessage="Please enter a valid number."
                                    id="numCPUInput" maxlength="3" required="true"
                                    requiredMessage="Please fill in this field." size="3" value="#{InvokePage.numCPU}"/>
                                <h:message for="numCPUInput" styleClass="errorMessage"/>
                                <h:panelGroup/>
                                <h:commandButton action="#{InvokePage.exec}" title="Submit" value="Submit"/>
                                <h:panelGroup/>
                            </h:panelGrid>
                        </h:panelGrid>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
