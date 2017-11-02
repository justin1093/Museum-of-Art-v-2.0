/*
 * Copyright (c) 2016, Upnext Technologies Sp. z o.o.
 * All rights reserved.
 *
 * This source code is licensed under the BSD 3-Clause License found in the
 * LICENSE.txt file in the root directory of this source tree.
 */

package  in.cm.bcon360.app.info;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class InformationFragment extends Fragment {

    public static InformationFragment getInstance() {
        return new InformationFragment();
    }

    public interface LogoutCallback {
        void logout();
    }

    private View logoutButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
     /*  View view = inflater.inflate(R.layout.fragment_information, container, false);

        logoutButton = view.findViewById(R.id.logout_button);
        logoutButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ((LogoutCallback) getActivity()).logout();
            }
        });*/

        return null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        logoutButton = null;
    }
}