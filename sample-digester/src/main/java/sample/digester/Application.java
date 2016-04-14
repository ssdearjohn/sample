package sample.digester;

import sample.digester.model.ServiceGateway;
import sample.digester.model.Set;
import sample.digester.runtime.DigesterFactory;

import java.io.InputStream;

/**
 * Application.java
 * Description:main runner
 * Created by John.Huwenxuan on 2016/4/13.
 */
public class Application {

    public static void main(String[] args) {
        InputStream is = Application.class.getResourceAsStream("/parameters.xml");
        ServiceGateway serviceGateway = DigesterFactory.create(ServiceGateway.class, is);
        Object s = serviceGateway.getDistributors().get("234").getMerchants().get("00001").getParameters().get("mn2").getParameterValue();
        if(s instanceof Set){
            System.out.println(((Set) s).getSets());
        } else{
            System.out.println(s);
        }
    }

}
