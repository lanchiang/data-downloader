package de.hpi.isg.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * @author Lan Jiang
 * @since 2019-07-22
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResourcesPojo {

    @JsonProperty("archiver")
    @Getter
    private String archiver;

    @JsonProperty("format")
    @Getter
    private String format;

    @JsonProperty("name")
    @Getter
    private String name;

    @JsonProperty("url")
    @Getter
    private String url;
}
