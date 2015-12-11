
package com.lin;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.lin package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddUser_QNAME = new QName("http://service.webservice.lin.com/", "addUser");
    private final static QName _ListResponse_QNAME = new QName("http://service.webservice.lin.com/", "listResponse");
    private final static QName _List_QNAME = new QName("http://service.webservice.lin.com/", "list");
    private final static QName _Login_QNAME = new QName("http://service.webservice.lin.com/", "login");
    private final static QName _HeaderMessage_QNAME = new QName("http://service.webservice.lin.com/", "headerMessage");
    private final static QName _User_QNAME = new QName("http://service.webservice.lin.com/", "user");
    private final static QName _Exception_QNAME = new QName("http://service.webservice.lin.com/", "Exception");
    private final static QName _AddUserResponse_QNAME = new QName("http://service.webservice.lin.com/", "addUserResponse");
    private final static QName _LoginResponse_QNAME = new QName("http://service.webservice.lin.com/", "loginResponse");
    private final static QName _AuthInfo_QNAME = new QName("http://service.webservice.lin.com/", "authInfo");
    private final static QName _HeaderMessageResponse_QNAME = new QName("http://service.webservice.lin.com/", "headerMessageResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.lin
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link AddUserResponse }
     * 
     */
    public AddUserResponse createAddUserResponse() {
        return new AddUserResponse();
    }

    /**
     * Create an instance of {@link HeaderMessageResponse }
     * 
     */
    public HeaderMessageResponse createHeaderMessageResponse() {
        return new HeaderMessageResponse();
    }

    /**
     * Create an instance of {@link ListResponse }
     * 
     */
    public ListResponse createListResponse() {
        return new ListResponse();
    }

    /**
     * Create an instance of {@link AddUser }
     * 
     */
    public AddUser createAddUser() {
        return new AddUser();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link List }
     * 
     */
    public List createList() {
        return new List();
    }

    /**
     * Create an instance of {@link HeaderMessage }
     * 
     */
    public HeaderMessage createHeaderMessage() {
        return new HeaderMessage();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.lin.com/", name = "addUser")
    public JAXBElement<AddUser> createAddUser(AddUser value) {
        return new JAXBElement<AddUser>(_AddUser_QNAME, AddUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.lin.com/", name = "listResponse")
    public JAXBElement<ListResponse> createListResponse(ListResponse value) {
        return new JAXBElement<ListResponse>(_ListResponse_QNAME, ListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link List }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.lin.com/", name = "list")
    public JAXBElement<List> createList(List value) {
        return new JAXBElement<List>(_List_QNAME, List.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.lin.com/", name = "login")
    public JAXBElement<Login> createLogin(Login value) {
        return new JAXBElement<Login>(_Login_QNAME, Login.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HeaderMessage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.lin.com/", name = "headerMessage")
    public JAXBElement<HeaderMessage> createHeaderMessage(HeaderMessage value) {
        return new JAXBElement<HeaderMessage>(_HeaderMessage_QNAME, HeaderMessage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link User }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.lin.com/", name = "user")
    public JAXBElement<User> createUser(User value) {
        return new JAXBElement<User>(_User_QNAME, User.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.lin.com/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.lin.com/", name = "addUserResponse")
    public JAXBElement<AddUserResponse> createAddUserResponse(AddUserResponse value) {
        return new JAXBElement<AddUserResponse>(_AddUserResponse_QNAME, AddUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.lin.com/", name = "loginResponse")
    public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
        return new JAXBElement<LoginResponse>(_LoginResponse_QNAME, LoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.lin.com/", name = "authInfo")
    public JAXBElement<String> createAuthInfo(String value) {
        return new JAXBElement<String>(_AuthInfo_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HeaderMessageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.lin.com/", name = "headerMessageResponse")
    public JAXBElement<HeaderMessageResponse> createHeaderMessageResponse(HeaderMessageResponse value) {
        return new JAXBElement<HeaderMessageResponse>(_HeaderMessageResponse_QNAME, HeaderMessageResponse.class, null, value);
    }

}
