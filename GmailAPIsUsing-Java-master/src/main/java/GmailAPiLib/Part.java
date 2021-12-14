
package GmailAPiLib;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Part {

    @Override
	public String toString() {
		return "Part [body=" + body + ", filename=" + filename + ", headers=" + headers + ", mimeType=" + mimeType
				+ ", partId=" + partId + ", additionalProperties=" + additionalProperties + "]";
	}

	private Body__1 body;
    private String filename;
    private List<Header__1> headers = null;
    private String mimeType;
    private String partId;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Body__1 getBody() {
        return body;
    }

    public void setBody(Body__1 body) {
        this.body = body;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public List<Header__1> getHeaders() {
        return headers;
    }

    public void setHeaders(List<Header__1> headers) {
        this.headers = headers;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getPartId() {
        return partId;
    }

    public void setPartId(String partId) {
        this.partId = partId;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
