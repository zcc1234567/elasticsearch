/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the Elastic License;
 * you may not use this file except in compliance with the Elastic License.
 */
package org.elasticsearch.xpack.core.security.action.saml;

import org.elasticsearch.action.ActionRequest;
import org.elasticsearch.action.ActionRequestValidationException;
import org.elasticsearch.common.Nullable;
import org.elasticsearch.common.Strings;

import static org.elasticsearch.action.ValidateActions.addValidationError;

/**
 * Represents a request to invalidate a SAML session using a {@code LogoutRequest}.
 */
public final class SamlInvalidateSessionRequest extends ActionRequest {

    @Nullable
    private String realmName;

    @Nullable
    private String assertionConsumerServiceURL;

    private String queryString;

    public SamlInvalidateSessionRequest() {
    }

    @Override
    public ActionRequestValidationException validate() {
        ActionRequestValidationException validationException = null;
        if (Strings.isNullOrEmpty(queryString)) {
            validationException = addValidationError("queryString is missing", validationException);
        }
        return validationException;
    }

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public String getRealmName() {
        return realmName;
    }

    public void setRealmName(String realmName) {
        this.realmName = realmName;
    }

    public String getAssertionConsumerServiceURL() {
        return assertionConsumerServiceURL;
    }

    public void setAssertionConsumerServiceURL(String assertionConsumerServiceURL) {
        this.assertionConsumerServiceURL = assertionConsumerServiceURL;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "realmName='" + realmName + '\'' +
                ", assertionConsumerServiceURL='" + assertionConsumerServiceURL + '\'' +
                ", url-query=" + queryString.length() + " chars" +
                '}';
    }

}
