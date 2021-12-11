package br.com.cscdesenvolvimento.account.soap;

import br.com.cscdesenvolvimento.AccountDetail;
import br.com.cscdesenvolvimento.GetAccountDetailRequest;
import br.com.cscdesenvolvimento.GetAccountDetailResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import java.math.BigInteger;
import java.util.Date;
import java.util.GregorianCalendar;

@Endpoint
public class AccountDetailEndPoint {

   @PayloadRoot(namespace = "http://cscdesenvolvimento.com.br", localPart = "GetAccountDetailRequest")
   @ResponsePayload
   public GetAccountDetailResponse processRequest(@RequestPayload GetAccountDetailRequest request) throws DatatypeConfigurationException {
       GetAccountDetailResponse getAccountDetailResponse = new GetAccountDetailResponse();

       AccountDetail accountDetail = new AccountDetail();
       accountDetail.setAccountType(AccountType.CURRENT.name());
       accountDetail.setAccountHolderId(BigInteger.ONE);
       accountDetail.setBalance(12000.00);

       GregorianCalendar gregorianCalendar = new GregorianCalendar();
       gregorianCalendar.setTime(new Date());
       accountDetail.setCreationDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar));

       getAccountDetailResponse.setAccountDetail(accountDetail);

        return getAccountDetailResponse;
    }

    private enum AccountType {
       CURRENT;
    }
}
