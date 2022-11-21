package com.exalt.learning.sampleproj1;


import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class SOAPconnection extends WebServiceGatewaySupport {

    public Object callWebService(String url, Object request){
        return getWebServiceTemplate().marshalSendAndReceive(url, request);
    }
}
