/*
 * Copyright 2015 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.apiman.plugins.keycloak_oauth_policy.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * Application role mappings
 *
 * @author Marc Savy <msavy@redhat.com>
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({ "application", "requiredRoles" })
public class ApplicationRoleMapping {

    /**
     * Application
     *
     */
    @JsonProperty("application")
    private String application;
    /**
     * Required Roles
     *
     */
    @JsonProperty("requiredRoles")
    private List<RequiredRole> requiredRoles = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * Application
     *
     * @return The application
     */
    @JsonProperty("application")
    public String getApplication() {
        return application;
    }

    /**
     * Application
     *
     * @param application
     *            The application
     */
    @JsonProperty("application")
    public void setApplication(String application) {
        this.application = application;
    }

    /**
     * Required Roles
     *
     * @return The requiredRoles
     */
    @JsonProperty("requiredRoles")
    public List<RequiredRole> getRequiredRoles() {
        return requiredRoles;
    }

    /**
     * Required Roles
     *
     * @param requiredRoles
     *            The requiredRoles
     */
    @JsonProperty("requiredRoles")
    public void setRequiredRoles(List<RequiredRole> requiredRoles) {
        this.requiredRoles = requiredRoles;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(application).append(requiredRoles).append(additionalProperties)
                .toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ApplicationRoleMapping) == false) {
            return false;
        }
        ApplicationRoleMapping rhs = ((ApplicationRoleMapping) other);
        return new EqualsBuilder().append(application, rhs.application)
                .append(requiredRoles, rhs.requiredRoles)
                .append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
