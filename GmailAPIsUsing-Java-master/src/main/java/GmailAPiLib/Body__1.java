
package GmailAPiLib;

import java.util.HashMap;
import java.util.Map;

public class Body__1 {

    private String data;
    private Integer size;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

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
