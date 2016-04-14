package sample.digester.model;

import java.io.Serializable;
import java.util.HashMap;

/**
 * ServiceGateway.java
 * Description:the model of our ServiceGateway.it can supply multiple fund company used.
 * Created by John.Huwenxuan on 2016/4/13.
 */
public class ServiceGateway implements Serializable {
    private String hostId;
    private String vendor;
    private String user;
    private String expiration;
    private String generated;
    private String version;
    private HashMap<String, Distributor> distributors;

    public ServiceGateway() {
        distributors = new HashMap<>();
    }

    public String getHostId() {
        return hostId;
    }

    public void setHostId(String hostId) {
        this.hostId = hostId;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String getGenerated() {
        return generated;
    }

    public void setGenerated(String generated) {
        this.generated = generated;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public HashMap<String, Distributor> getDistributors() {
        return distributors;
    }

    public void setDistributors(HashMap<String, Distributor> distributors) {
        this.distributors = distributors;
    }

    public void addDistributor(Distributor distributor){
        distributors.put(distributor.getDistributorId(), distributor);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ServiceGateway{");
        sb.append("hostId='").append(hostId).append('\'');
        sb.append(", vendor='").append(vendor).append('\'');
        sb.append(", user='").append(user).append('\'');
        sb.append(", expiration='").append(expiration).append('\'');
        sb.append(", generated='").append(generated).append('\'');
        sb.append(", version='").append(version).append('\'');
        sb.append(", distributors=").append(distributors);
        sb.append('}');
        return sb.toString();
    }
}
