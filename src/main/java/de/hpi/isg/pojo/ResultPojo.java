package de.hpi.isg.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

/**
 * @author Lan Jiang
 * @since 2019-07-22
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultPojo {

    @JsonProperty("count")
    @Getter
    private int count;

    @JsonProperty("results")
    @Getter
    private List<PackagePojo> packagePojos;
}
