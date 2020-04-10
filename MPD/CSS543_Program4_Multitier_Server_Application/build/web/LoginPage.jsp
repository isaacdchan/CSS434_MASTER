<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : Page1
    Created on : 2009/11/28, 14:42:06
    Author     : fumitakakawasaki
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head id="head1">
                    <webuijsf:link id="link1" url="/resources/stylesheet.css"/>
                    <title>
                        <h:outputText value="Remote MPI Java CLient"/>
                    </title>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <webuijsf:form id="form1">
                        <h:panelGrid columns="2" border="0" cellpadding="3" cellspacing="3">
                            <h:graphicImage url="/resources/uw_huskies_logo.gif"/>
                            <h:panelGrid columns="3" border="0" cellpadding="5" cellspacing="3" headerClass="login-heading">
                                <f:facet name="header">
                                    <h:outputText value="Remote MPI Java Client"/>
                                </f:facet>
                                <h:messages globalOnly="true" styleClass="errorMessage"/>
                                <h:panelGroup/>
                                <h:panelGroup/>
                                <h:outputLabel for="userNameInput">
                                    <h:outputText value="Enter your user name:"/>
                                </h:outputLabel>
                                <h:inputText id="userNameInput" maxlength="30" required="true" requiredMessage="Please fill in this field." 
                                             size="20" value="#{LoginPage.userName}"/>
                                <h:message for="userNameInput" styleClass="errorMessage"/>
                                <h:outputLabel for="userIdInput">
                                    <h:outputText value="Enter your student ID:"/>
                                </h:outputLabel>
                                <h:inputText converter="#{LoginPage.numberConverter1}" converterMessage="Please enter a valid ID."
                                            id="userIdInput" maxlength="20" required="true" requiredMessage="Please fill in this field." 
                                            size="20" value="#{LoginPage.studentID}"/>
                                <h:message for="userIdInput" styleClass="errorMessage"/>
                                <h:panelGroup/>
                                <h:commandButton action="#{LoginPage.login}" title="Submit" value="Submit"/>
                                <h:panelGroup/>
                             </h:panelGrid>
                        </h:panelGrid>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
