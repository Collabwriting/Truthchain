package dev.truthchain.api.wrappers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter @Setter @Builder
@AllArgsConstructor @NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DkgResponse {

    @JsonProperty("UAL")
    private String ual;
    private String publicAssertionId;
    private DkgOperation operation;

    @Getter @Setter
    @AllArgsConstructor @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    protected class DkgOperation {
        private String operationId;
        private String status;
        private String errorType;
        private String errorMessage;
    }
}