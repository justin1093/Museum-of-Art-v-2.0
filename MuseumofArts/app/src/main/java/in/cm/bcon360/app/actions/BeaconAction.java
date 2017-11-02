/*
 * Copyright (c) 2016, Upnext Technologies Sp. z o.o.
 * All rights reserved.
 *
 * This source code is licensed under the BSD 3-Clause License found in the
 * LICENSE.txt file in the root directory of this source tree.
 */

package in.cm.bcon360.app.actions;

public class BeaconAction {
    public final String actionName;
    public final long timestamp;

    public BeaconAction(String actionName, long timestamp) {
        this.actionName = actionName;
        this.timestamp = timestamp;
    }
}