
package com.lin;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.Holder;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "MyService", targetNamespace = "http://service.webservice.lin.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface MyService {


    /**
     * 
     * @return
     *     returns java.util.List<com.lin.User>
     */
    @WebMethod
    @WebResult(name = "user", targetNamespace = "http://service.webservice.lin.com/")
    @RequestWrapper(localName = "list", targetNamespace = "http://service.webservice.lin.com/", className = "com.lin.List")
    @ResponseWrapper(localName = "listResponse", targetNamespace = "http://service.webservice.lin.com/", className = "com.lin.ListResponse")
    @Action(input = "http://service.webservice.lin.com/MyService/listRequest", output = "http://service.webservice.lin.com/MyService/listResponse")
    public List<User> list();

    /**
     * 
     * @param username
     * @param password
     * @return
     *     returns com.lin.User
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(name = "user", targetNamespace = "http://service.webservice.lin.com/")
    @RequestWrapper(localName = "login", targetNamespace = "http://service.webservice.lin.com/", className = "com.lin.Login")
    @ResponseWrapper(localName = "loginResponse", targetNamespace = "http://service.webservice.lin.com/", className = "com.lin.LoginResponse")
    @Action(input = "http://service.webservice.lin.com/MyService/loginRequest", output = "http://service.webservice.lin.com/MyService/loginResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://service.webservice.lin.com/MyService/login/Fault/Exception")
    })
    public User login(
        @WebParam(name = "username", targetNamespace = "")
        String username,
        @WebParam(name = "password", targetNamespace = "")
        String password)
        throws Exception_Exception
    ;

    /**
     * 
     * @param user
     */
    @WebMethod
    @RequestWrapper(localName = "addUser", targetNamespace = "http://service.webservice.lin.com/", className = "com.lin.AddUser")
    @ResponseWrapper(localName = "addUserResponse", targetNamespace = "http://service.webservice.lin.com/", className = "com.lin.AddUserResponse")
    @Action(input = "http://service.webservice.lin.com/MyService/addUserRequest", output = "http://service.webservice.lin.com/MyService/addUserResponse")
    public void addUser(
        @WebParam(name = "user", targetNamespace = "http://service.webservice.lin.com/", mode = WebParam.Mode.INOUT)
        Holder<User> user);

    /**
     * 
     * @param authInfo
     * @param parameters
     * @return
     *     returns com.lin.HeaderMessageResponse
     */
    @WebMethod
    @WebResult(name = "headerMessageResponse", targetNamespace = "http://service.webservice.lin.com/", partName = "result")
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @Action(input = "http://service.webservice.lin.com/MyService/headerMessageRequest", output = "http://service.webservice.lin.com/MyService/headerMessageResponse")
    public HeaderMessageResponse headerMessage(
        @WebParam(name = "headerMessage", targetNamespace = "http://service.webservice.lin.com/", partName = "parameters")
        HeaderMessage parameters,
        @WebParam(name = "authInfo", targetNamespace = "http://service.webservice.lin.com/", header = true, partName = "authInfo")
        String authInfo);

}