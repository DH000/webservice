
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package com.lin.umws.service.client;

import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.4
 * 2015-11-25T16:28:32.830+08:00
 * Generated source version: 3.1.4
 * 
 */

@javax.jws.WebService(
                      serviceName = "UserService",
                      portName = "UserServicePort",
                      targetNamespace = "http://service.umws.lin.com/",
                      wsdlLocation = "file:/usr/local/codes/git/webservice/ws-modules/cxf-server/src/main/resources/wsdl/user-doc.wsdl",
                      endpointInterface = "com.lin.umws.service.IUserService")
                      
public class UserServicePortImpl implements IUserService {

    private static final Logger LOG = Logger.getLogger(UserServicePortImpl.class.getName());

    /* (non-Javadoc)
     * @see com.lin.umws.service.IUserService#handlerUpload(javax.activation.DataHandler  handlerFile )*
     */
    public void handlerUpload(javax.activation.DataHandler handlerFile) { 
        LOG.info("Executing operation handlerUpload");
        System.out.println(handlerFile);
        try {
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.lin.umws.service.IUserService#mtomUpload(byte[]  mtomFile )*
     */
    public void mtomUpload(byte[] mtomFile) { 
        LOG.info("Executing operation mtomUpload");
        System.out.println(mtomFile);
        try {
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.lin.umws.service.IUserService#login(java.lang.String  username ,)java.lang.String  password )*
     */
    public com.lin.umws.service.client.User login(java.lang.String username,java.lang.String password) throws UserException_Exception    { 
        LOG.info("Executing operation login");
        System.out.println(username);
        System.out.println(password);
        try {
            com.lin.umws.service.client.User _return = null;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new UserException_Exception("UserException...");
    }

    /* (non-Javadoc)
     * @see com.lin.umws.service.IUserService#badUpload(byte[]  file )*
     */
    public void badUpload(byte[] file) { 
        LOG.info("Executing operation badUpload");
        System.out.println(file);
        try {
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.lin.umws.service.IUserService#add(com.lin.umws.service.User  user )*
     */
    public void add(com.lin.umws.service.client.User user) { 
        LOG.info("Executing operation add");
        System.out.println(user);
        try {
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.lin.umws.service.IUserService#list(*
     */
    public java.util.List<com.lin.umws.service.client.User> list() { 
        LOG.info("Executing operation list");
        try {
            java.util.List<com.lin.umws.service.client.User> _return = null;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.lin.umws.service.IUserService#delete(com.lin.umws.service.User  user )*
     */
    public void delete(com.lin.umws.service.client.User user) { 
        LOG.info("Executing operation delete");
        System.out.println(user);
        try {
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}