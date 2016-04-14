package sample.digester.runtime.delegate.rule;

import org.apache.commons.digester.Rule;
import org.xml.sax.Attributes;
import sample.digester.model.Parameter;
import sample.digester.model.Set;

/**
 * SetCreateRule.java
 * Description:once Set element create, the rule will intercept it.
 * Created by John.Huwenxuan on 2016/4/14.
 */
public class SetCreateRule extends Rule {

    @Override
    public void begin(String namespace, String name, Attributes attributes) throws Exception {
        Parameter parameter = (Parameter) digester.peek();
        Object pv = parameter.getParameterValue();
        int length = attributes.getLength();

        if(length != 0) {
            Set set = null;
            for (int i = 0; i < length; i++) {
                if(null != pv && pv instanceof Set){
                    set = (Set) pv;
                } else {
                    set = new Set();
                }
                set.addSets(attributes.getValue("key"),attributes.getValue("value"));
            }
            parameter.setParameterValue(set);
        }
    }

}
