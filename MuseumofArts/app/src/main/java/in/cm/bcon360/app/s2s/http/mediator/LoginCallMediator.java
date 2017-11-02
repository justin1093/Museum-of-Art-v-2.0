/*
 * Copyright (c) 2016, Upnext Technologies Sp. z o.o.
 * All rights reserved.
 *
 * This source code is licensed under the BSD 3-Clause License found in the
 * LICENSE.txt file in the root directory of this source tree.
 */

package in.cm.bcon360.app.s2s.http.mediator;

import android.content.Context;

import in.cm.bcon360.app.s2s.http.BeaconControlManager;
import in.cm.bcon360.app.s2s.http.HttpListener;
import in.cm.bcon360.app.s2s.http.response.TokenResponse;

public class LoginCallMediator extends HttpCallMediator<TokenResponse> {

    public LoginCallMediator(Context context, BeaconControlManager beaconControlManager, HttpListener listener) {
        super(context, beaconControlManager, listener);
    }

    public void logIn() {
        onStartCall();
    }

    @Override
    protected void execute() {
        call = beaconControlManager.logIn();
    }
}
