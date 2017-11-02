/*
 * Copyright (c) 2016, Upnext Technologies Sp. z o.o.
 * All rights reserved.
 *
 * This source code is licensed under the BSD 3-Clause License found in the
 * LICENSE.txt file in the root directory of this source tree.
 */

package in.cm.bcon360.app.s2s.http.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TokenResponse {

    public enum Scope {
        s2s_api
    }

    @JsonProperty("access_token")
    public String accessToken;

    @JsonProperty("token_type")
    public String tokenType;

    @JsonProperty("expires_in")
    public long expiresIn;

    @JsonProperty("refresh_token")
    public String refreshToken;

    @JsonProperty("scope")
    public Scope scope;

    @JsonProperty("created_at")
    public long createdAt;
}
