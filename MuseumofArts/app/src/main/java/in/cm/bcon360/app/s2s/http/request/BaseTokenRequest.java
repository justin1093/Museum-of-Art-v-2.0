/*
 * Copyright (c) 2016, Upnext Technologies Sp. z o.o.
 * All rights reserved.
 *
 * This source code is licensed under the BSD 3-Clause License found in the
 * LICENSE.txt file in the root directory of this source tree.
 */

package in.cm.bcon360.app.s2s.http.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class BaseTokenRequest {

    // Only password type is currently needed
    public enum GrantType {password}

    @JsonProperty("client_id")
    public String clientId;

    @JsonProperty("client_secret")
    public String clientSecret;

    @JsonProperty("grant_type")
    public GrantType grantType;

    public BaseTokenRequest(String clientId, String clientSecret, GrantType grantType) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.grantType = grantType;
    }
}
