package sample.digester.model;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Distributor.java
 * Description:distributor means fund company.
 *              it can cooperate with a lot of merchant(Third-Party).
 * Created by John.Huwenxuan on 2016/4/13.
 */
public class Distributor implements Serializable{
    private String distributorId;
    private String distributorName;
    private HashMap<String, Merchant> merchants;
    private HashMap<String, Parameter> parameters;

    public Distributor() {
        merchants = new HashMap<>();
        parameters = new HashMap<>();
    }

    public String getDistributorId() {
        return distributorId;
    }

    public void setDistributorId(String distributorId) {
        this.distributorId = distributorId;
    }

    public String getDistributorName() {
        return distributorName;
    }

    public void setDistributorName(String distributorName) {
        this.distributorName = distributorName;
    }

    public HashMap<String, Merchant> getMerchants() {
        return merchants;
    }

    public void setMerchants(HashMap<String, Merchant> merchants) {
        this.merchants = merchants;
    }

    public void addMerchant(Merchant merchant){
        merchants.put(merchant.getMerchantId(), merchant);
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
        final StringBuilder sb = new StringBuilder("Distributor{");
        sb.append("distributorId='").append(distributorId).append('\'');
        sb.append(", distributorName='").append(distributorName).append('\'');
        sb.append(", merchants=").append(merchants);
        sb.append(", parameter=").append(parameters);
        sb.append('}');
        return sb.toString();
    }
}
