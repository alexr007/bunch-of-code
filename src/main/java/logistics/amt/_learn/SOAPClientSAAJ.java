package logistics.amt._learn;

import javax.xml.soap.*;

public class SOAPClientSAAJ {

  public static void main(String... args) {
    String soapEndpointUrl = "http://www.webservicex.net/uszip.asmx";
    String soapAction = "http://www.webserviceX.NET/GetInfoByCity";

    callSoapWebService(soapEndpointUrl, soapAction);
  }

  private static void createSoapEnvelope(SOAPMessage soapMessage) throws SOAPException {
    SOAPPart soapPart = soapMessage.getSOAPPart();

    String namespace = "https://automototrade.com/wsdl/server.php";
    String namespaceURI = "https://automototrade.com";

    SOAPEnvelope envelope = soapPart.getEnvelope();
    envelope.addNamespaceDeclaration(namespace, namespaceURI);
    SOAPBody soapBody = envelope.getBody();
    SOAPElement soapBodyElem = soapBody.addChildElement("getMultPrice", namespace);
    SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("USCity", namespace);
    soapBodyElem1.addTextNode("New York");
    SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("USCity", namespace);
//    soapBodyElem2.addTextNode()
    soapBodyElem2.addTextNode("New York");

            /*
            Constructed SOAP Request Message:
            <SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/" xmlns:myNamespace="http://www.webserviceX.NET">
                <SOAP-ENV:Header/>
                <SOAP-ENV:Body>
                    <myNamespace:GetInfoByCity>
                        <myNamespace:USCity>New York</myNamespace:USCity>
                    </myNamespace:GetInfoByCity>
                </SOAP-ENV:Body>
            </SOAP-ENV:Envelope>
            */

    // SOAP Body


  }

  private static void callSoapWebService(String soapEndpointUrl, String soapAction) {
    try {
      SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
      SOAPConnection soapConnection = soapConnectionFactory.createConnection();

      // Send SOAP Message to SOAP Server
      SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(soapAction), soapEndpointUrl);

      // Print the SOAP Response
      System.out.println("Response SOAP Message:");
      soapResponse.writeTo(System.out);
      System.out.println();

      soapConnection.close();
    } catch (Exception e) {
      System.err.println("\nError occurred while sending SOAP Request to Server!\nMake sure you have the correct endpoint URL and SOAPAction!\n");
      e.printStackTrace();
    }
  }

  private static SOAPMessage createSOAPRequest(String soapAction) throws Exception {
    MessageFactory messageFactory = MessageFactory.newInstance();
    SOAPMessage soapMessage = messageFactory.createMessage();

    createSoapEnvelope(soapMessage);

    MimeHeaders headers = soapMessage.getMimeHeaders();
    headers.addHeader("SOAPAction", soapAction);

    soapMessage.saveChanges();

    /* Print the request message, just for debugging purposes */
    System.out.println("Request SOAP Message:");
    soapMessage.writeTo(System.out);
    System.out.println("\n");

    return soapMessage;
  }

}
