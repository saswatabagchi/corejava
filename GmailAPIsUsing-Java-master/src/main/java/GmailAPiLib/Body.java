
package GmailAPiLib;

import java.util.HashMap;
import java.util.Map;

public class Body {

    private Integer size;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
