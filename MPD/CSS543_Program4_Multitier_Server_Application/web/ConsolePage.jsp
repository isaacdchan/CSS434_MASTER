<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : ConsolePage
    Created on : 2009/12/08, 14:34:04
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
                        <h:panelGrid columns="1" border="0" cellpadding="3" cellspacing="3">
                            <applet code="TCPClientApplet.class" codebase="./resources" width="1000" height="500">
                                <param name="port" value='${ConsolePage.port}'/>
                            </applet>
                            <h:panelGrid columns="2" border="0" cellpadding="3" cellspacing="3">
                                <h:commandButton action="#{ConsolePage.button1_action}" title="Continue" value="Continue"/>
                                <h:commandButton action="#{ConsolePage.button2_action}" title="Logout" value="Logout"/>
                            </h:panelGrid>
                        </h:panelGrid>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
