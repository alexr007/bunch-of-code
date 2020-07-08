package logistics.amt._learn;

//import javax.xml.soap.*;


public class AMT2 {

//  public static void main(String... args) throws Exception {
//    SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
//    SOAPConnection conn_ = soapConnectionFactory.createConnection();
//
//    String url = "http://automototrade.com/wsdl/server.php?wsdl";
//    SOAPMessage soapResponse = conn_.call(createSOAPRequest(), url);
//
//    // print SOAP Response
//    System.out.print("Response SOAP Message:");
//    soapResponse.writeTo(System.out);
//
//    conn_.close();
//  }
//
//  private static SOAPMessage createSOAPRequest() throws Exception {
//    MessageFactory messageFactory = MessageFactory.newInstance();
//    SOAPMessage soapMessage = messageFactory.createMessage();
//    SOAPPart soapPart = soapMessage.getSOAPPart();
//
//    String serverURI = "http://ws.cdyne.com/";
//
//    // SOAP Envelope
//    SOAPEnvelope envelope = soapPart.getEnvelope();
//    envelope.addNamespaceDeclaration("example", serverURI);
//
//    /*
//    Constructed SOAP Request Message:
//    <SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/" xmlns:example="http://ws.cdyne.com/">
//      <SOAP-ENV:Header/>
//      <SOAP-ENV:Body>
//        <example:VerifyEmail>
//          <example:email>mutantninja@gmail.com</example:email>
//          <example:LicenseKey>123</example:LicenseKey>
//        </example:VerifyEmail>
//      </SOAP-ENV:Body>
//    </SOAP-ENV:Envelope>
//     */
//
//    // SOAP Body
//    SOAPBody soapBody = envelope.getBody();
//    SOAPElement soapBodyElem = soapBody.addChildElement("VerifyEmail", "example");
//    SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("email", "example");
//    soapBodyElem1.addTextNode("mutantninja@gmail.com");
//    SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("LicenseKey", "example");
//    soapBodyElem2.addTextNode("123");
//
//    MimeHeaders headers = soapMessage.getMimeHeaders();
//    headers.addHeader("SOAPAction", serverURI  + "VerifyEmail");
//
//    soapMessage.saveChanges();
//
//    /* Print the request message */
//    System.out.print("Request SOAP Message:");
//    soapMessage.writeTo(System.out);
//    System.out.println();
//
//    return soapMessage;
//  }

}
