package sample.digester.runtime.delegate;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;
import sample.digester.model.*;
import sample.digester.runtime.delegate.rule.SetCreateRule;

import java.io.IOException;
import java.io.InputStream;

/**
 * ServiceGatewayDelegate.java
 * Description:particular annalyse delegate of ServiceGateway
 * Created by John.Huwenxuan on 2016/4/13.
 */
public class ServiceGatewayDelegate implements Delegate<ServiceGateway> {

    @Override
    public ServiceGateway digeste(InputStream is) {
        Digester digester = new Digester();
        ServiceGateway serviceGateway = null;
        try {
            createNodeServiceGateway(digester);
            //
            serviceGateway = (ServiceGateway) digester.parse(is);
        } catch(SAXException | IOException e){
            e.printStackTrace();
        }
        return serviceGateway;
    }

    private void createNodeServiceGateway(Digester digester){
        final String sPattern = "ServiceGateway";
        //
        digester.addObjectCreate(sPattern, ServiceGateway.class);
        digester.addSetProperties(sPattern, "hostId", "hostId");
        digester.addSetProperties(sPattern, "vendor", "vendor");
        digester.addSetProperties(sPattern, "user", "user");
        digester.addSetProperties(sPattern, "expiration", "expiration");
        digester.addSetProperties(sPattern, "generated", "generated");
        digester.addSetProperties(sPattern, "version", "version");
        createNodeDistributor(digester);
    }

    private void createNodeDistributor(Digester digester){
        final String sdPattern = "ServiceGateway/Distributor";
        //
        digester.addObjectCreate(sdPattern, Distributor.class);
        digester.addSetNext(sdPattern, "addDistributor");
        digester.addSetProperties(sdPattern, "distributorId", "distributorId");
        digester.addSetProperties(sdPattern, "distributorName", "distributorName");
        createNodeDistributorParameter(digester);
        createNodeMerchant(digester);
    }

    private void createNodeDistributorParameter(Digester digester){
        final String sdpPattern = "ServiceGateway/Distributor/Parameter";
        //
        digester.addObjectCreate(sdpPattern, Parameter.class);
        digester.addSetNext(sdpPattern, "addParameter");
        digester.addSetProperties(sdpPattern, "parameterName", "parameterName");
        digester.addSetProperties(sdpPattern, "parameterValue", "parameterValue");
        digester.addSetProperties(sdpPattern, "parameterDescribe", "parameterDescribe");
        createNodeDistributorParameterSet(digester);
    }

    private void createNodeDistributorParameterSet(Digester digester){
        final String sdpsPattern = "ServiceGateway/Distributor/Parameter/Set";
        digester.addRule(sdpsPattern, new SetCreateRule());
        digester.addObjectCreate(sdpsPattern, Set.class);
        digester.addSetProperties(sdpsPattern, "key", "key");
        digester.addSetProperties(sdpsPattern, "value", "value");
    }

    private void createNodeMerchant(Digester digester){
        final String sdmPattern = "ServiceGateway/Distributor/Merchant";
        digester.addObjectCreate(sdmPattern, Merchant.class);
        digester.addSetNext(sdmPattern, "addMerchant");
        digester.addSetProperties(sdmPattern, "merchantId", "merchantId");
        digester.addSetProperties(sdmPattern, "merchantName", "merchantName");
        createNodeMerchantParameter(digester);

    }

    private void createNodeMerchantParameter(Digester digester){
        final String sdmpPattern = "ServiceGateway/Distributor/Merchant/Parameter";
        //
        digester.addObjectCreate(sdmpPattern, Parameter.class);
        digester.addSetNext(sdmpPattern, "addParameter");
        digester.addSetProperties(sdmpPattern, "parameterName", "parameterName");
        digester.addSetProperties(sdmpPattern, "parameterValue", "parameterValue");
        digester.addSetProperties(sdmpPattern, "parameterDescribe", "parameterDescribe");
        createNodeMerchantParameterSet(digester);
    }

    private void createNodeMerchantParameterSet(Digester digester){
        final String sdmpsPattern = "ServiceGateway/Distributor/Merchant/Parameter/Set";
        digester.addRule(sdmpsPattern, new SetCreateRule());
        digester.addObjectCreate(sdmpsPattern, Set.class);
        digester.addSetProperties(sdmpsPattern, "key", "key");
        digester.addSetProperties(sdmpsPattern, "value", "value");
    }
}
