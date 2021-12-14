
package GmailAPiLib;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Payload {

    private String historyId;
    private String id;
    private String internalDate;
    private List<String> labelIds = null;
    private Payload__1 payload;
    private Integer sizeEstimate;
    private String snippet;
    private String threadId;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getHistoryId() {
        return historyId;
    }

    public void setHistoryId(String historyId) {
        this.historyId = historyId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInternalDate() {
        return internalDate;
    }

    public void setInternalDate(String internalDate) {
        this.internalDate = internalDate;
    }

    public List<String> getLabelIds() {
        return labelIds;
    }

    public void setLabelIds(List<String> labelIds) {
        this.labelIds = labelIds;
    }

    public Payload__1 getPayload() {
        return payload;
    }

    public void setPayload(Payload__1 payload) {
        this.payload = payload;
    }

    public Integer getSizeEstimate() {
        return sizeEstimate;
    }

    public void setSizeEstimate(Integer sizeEstimate) {
        this.sizeEstimate = sizeEstimate;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public String getThreadId() {
        return threadId;
    }

    public void setThreadId(String threadId) {
        this.threadId = threadId;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
