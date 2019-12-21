package logistics.amt;

import logistics.amt.number.NumberDetails;

import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class AMTDesign {
  public static void main(String[] args) throws ServiceException, RemoteException {
    String[] query1 = { "560059", "56005900", "L3K9124X0C" };
    List<String> query2 = Arrays.asList("82110037331", "53020444");

    AMT amt = new AMT();
    Collection<NumberDetails> numbers1 =  amt.fetchNumberDetails("12251PPA004");
    numbers1.forEach(System.out::println);
    Collection<NumberDetails> numbers2 =  amt.fetchNumberDetails(query1);
    numbers2.forEach(System.out::println);
    Collection<NumberDetails> numbers3 =  amt.fetchNumberDetails(query2);
    numbers3.forEach(System.out::println);
  }
}
