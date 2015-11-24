
package com.lin.umws.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.lin.umws.service package. 
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

    private final static QName _BadUploadResponse_QNAME = new QName("http://service.umws.lin.com/", "badUploadResponse");
    private final static QName _MtomUploadResponse_QNAME = new QName("http://service.umws.lin.com/", "mtomUploadResponse");
    private final static QName _License_QNAME = new QName("http://service.umws.lin.com/", "license");
    private final static QName _DeleteResponse_QNAME = new QName("http://service.umws.lin.com/", "deleteResponse");
    private final static QName _BadUpload_QNAME = new QName("http://service.umws.lin.com/", "badUpload");
    private final static QName _MtomUpload_QNAME = new QName("http://service.umws.lin.com/", "mtomUpload");
    private final static QName _LoginResponse_QNAME = new QName("http://service.umws.lin.com/", "loginResponse");
    private final static QName _Add_QNAME = new QName("http://service.umws.lin.com/", "add");
    private final static QName _AddResponse_QNAME = new QName("http://service.umws.lin.com/", "addResponse");
    private final static QName _HandlerUploadResponse_QNAME = new QName("http://service.umws.lin.com/", "handlerUploadResponse");
    private final static QName _ListResponse_QNAME = new QName("http://service.umws.lin.com/", "listResponse");
    private final static QName _HandlerUpload_QNAME = new QName("http://service.umws.lin.com/", "handlerUpload");
    private final static QName _Delete_QNAME = new QName("http://service.umws.lin.com/", "delete");
    private final static QName _List_QNAME = new QName("http://service.umws.lin.com/", "list");
    private final static QName _Login_QNAME = new QName("http://service.umws.lin.com/", "login");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.lin.umws.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UserType }
     * 
     */
    public UserType createUserType() {
        return new UserType();
    }

    /**
     * Create an instance of {@link LoginResponseType }
     * 
     */
    public LoginResponseType createLoginResponseType() {
        return new LoginResponseType();
    }

    /**
     * Create an instance of {@link AddResponseType }
     * 
     */
    public AddResponseType createAddResponseType() {
        return new AddResponseType();
    }

    /**
     * Create an instance of {@link EmptyType }
     * 
     */
    public EmptyType createEmptyType() {
        return new EmptyType();
    }

    /**
     * Create an instance of {@link ListType }
     * 
     */
    public ListType createListType() {
        return new ListType();
    }

    /**
     * Create an instance of {@link LoginType }
     * 
     */
    public LoginType createLoginType() {
        return new LoginType();
    }

    /**
     * Create an instance of {@link DeleteType }
     * 
     */
    public DeleteType createDeleteType() {
        return new DeleteType();
    }

    /**
     * Create an instance of {@link ListResponseType }
     * 
     */
    public ListResponseType createListResponseType() {
        return new ListResponseType();
    }

    /**
     * Create an instance of {@link HandlerUploadType }
     * 
     */
    public HandlerUploadType createHandlerUploadType() {
        return new HandlerUploadType();
    }

    /**
     * Create an instance of {@link LicenseType }
     * 
     */
    public LicenseType createLicenseType() {
        return new LicenseType();
    }

    /**
     * Create an instance of {@link DeleteResponseType }
     * 
     */
    public DeleteResponseType createDeleteResponseType() {
        return new DeleteResponseType();
    }

    /**
     * Create an instance of {@link BadUploadType }
     * 
     */
    public BadUploadType createBadUploadType() {
        return new BadUploadType();
    }

    /**
     * Create an instance of {@link UserException }
     * 
     */
    public UserException createUserException() {
        return new UserException();
    }

    /**
     * Create an instance of {@link MtomUploadType }
     * 
     */
    public MtomUploadType createMtomUploadType() {
        return new MtomUploadType();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmptyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.umws.lin.com/", name = "badUploadResponse")
    public JAXBElement<EmptyType> createBadUploadResponse(EmptyType value) {
        return new JAXBElement<EmptyType>(_BadUploadResponse_QNAME, EmptyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmptyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.umws.lin.com/", name = "mtomUploadResponse")
    public JAXBElement<EmptyType> createMtomUploadResponse(EmptyType value) {
        return new JAXBElement<EmptyType>(_MtomUploadResponse_QNAME, EmptyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LicenseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.umws.lin.com/", name = "license")
    public JAXBElement<LicenseType> createLicense(LicenseType value) {
        return new JAXBElement<LicenseType>(_License_QNAME, LicenseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.umws.lin.com/", name = "deleteResponse")
    public JAXBElement<DeleteResponseType> createDeleteResponse(DeleteResponseType value) {
        return new JAXBElement<DeleteResponseType>(_DeleteResponse_QNAME, DeleteResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BadUploadType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.umws.lin.com/", name = "badUpload")
    public JAXBElement<BadUploadType> createBadUpload(BadUploadType value) {
        return new JAXBElement<BadUploadType>(_BadUpload_QNAME, BadUploadType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MtomUploadType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.umws.lin.com/", name = "mtomUpload")
    public JAXBElement<MtomUploadType> createMtomUpload(MtomUploadType value) {
        return new JAXBElement<MtomUploadType>(_MtomUpload_QNAME, MtomUploadType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.umws.lin.com/", name = "loginResponse")
    public JAXBElement<LoginResponseType> createLoginResponse(LoginResponseType value) {
        return new JAXBElement<LoginResponseType>(_LoginResponse_QNAME, LoginResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.umws.lin.com/", name = "add")
    public JAXBElement<UserType> createAdd(UserType value) {
        return new JAXBElement<UserType>(_Add_QNAME, UserType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.umws.lin.com/", name = "addResponse")
    public JAXBElement<AddResponseType> createAddResponse(AddResponseType value) {
        return new JAXBElement<AddResponseType>(_AddResponse_QNAME, AddResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmptyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.umws.lin.com/", name = "handlerUploadResponse")
    public JAXBElement<EmptyType> createHandlerUploadResponse(EmptyType value) {
        return new JAXBElement<EmptyType>(_HandlerUploadResponse_QNAME, EmptyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.umws.lin.com/", name = "listResponse")
    public JAXBElement<ListResponseType> createListResponse(ListResponseType value) {
        return new JAXBElement<ListResponseType>(_ListResponse_QNAME, ListResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HandlerUploadType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.umws.lin.com/", name = "handlerUpload")
    public JAXBElement<HandlerUploadType> createHandlerUpload(HandlerUploadType value) {
        return new JAXBElement<HandlerUploadType>(_HandlerUpload_QNAME, HandlerUploadType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.umws.lin.com/", name = "delete")
    public JAXBElement<DeleteType> createDelete(DeleteType value) {
        return new JAXBElement<DeleteType>(_Delete_QNAME, DeleteType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.umws.lin.com/", name = "list")
    public JAXBElement<ListType> createList(ListType value) {
        return new JAXBElement<ListType>(_List_QNAME, ListType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.umws.lin.com/", name = "login")
    public JAXBElement<LoginType> createLogin(LoginType value) {
        return new JAXBElement<LoginType>(_Login_QNAME, LoginType.class, null, value);
    }

}
