package de.hpi.isg.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * @author Lan Jiang
 * @since 2019-07-22
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DownloadPojo {

    @JsonProperty("result")
    @Getter
    private ResultPojo result;
}
