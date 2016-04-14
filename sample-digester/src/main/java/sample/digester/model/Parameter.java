package sample.digester.model;

import java.io.Serializable;

/**
 * Parameter.java
 * Description:parameter model
 * Created by John.Huwenxuan on 2016/4/13.
 */
public class Parameter<T> implements Serializable {
    private String parameterName;
    private T parameterValue;
    private String parameterDescribe;

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public T getParameterValue() {
        return parameterValue;
    }

    public void setParameterValue(T parameterValue) {
        this.parameterValue = parameterValue;
    }

    public String getParameterDescribe() {
        return parameterDescribe;
    }

    public void setParameterDescribe(String parameterDescribe) {
        this.parameterDescribe = parameterDescribe;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Parameter{");
        sb.append("parameterName='").append(parameterName).append('\'');
        sb.append(", parameterValue=").append(parameterValue);
        sb.append(", parameterDescribe='").append(parameterDescribe).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
