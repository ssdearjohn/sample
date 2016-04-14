package sample.digester.model;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Merchant.java
 * Description:a model means a Third-Party.
 * Created by John.Huwenxuan on 2016/4/13.
 */
public class Merchant implements Serializable{
    private String merchantId;
    private String merchantName;
    private HashMap<String, Parameter> parameters;

    public Merchant() {
        parameters = new HashMap<>();
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public HashMap<String, Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(HashMap<String, Parameter> parameters) {
        this.parameters = parameters;
    }

    public void addParameter(Parameter parameter){
        parameters.put(parameter.getParameterName(), parameter);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Merchant{");
        sb.append("merchantId='").append(merchantId).append('\'');
        sb.append(", merchantName='").append(merchantName).append('\'');
        sb.append(", parameter=").append(parameters);
        sb.append('}');
        return sb.toString();
    }
}
