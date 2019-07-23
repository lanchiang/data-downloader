package de.hpi.isg.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

/**
 * Package is the synonym of dataset.
 *
 * @author Lan Jiang
 * @since 2019-07-22
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PackagePojo {

    @JsonProperty("resources")
    @Getter
    private List<ResourcesPojo> resourcesPojos;
}
