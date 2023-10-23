/*
 * DevicePicker
 * Connect SDK
 * 
 * Copyright (c) 2014 LG Electronics.
 * Created by Hyun Kook Khang on 19 Jan 2014
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.connectsdk.device;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

public class DevicePicker {
    Activity activity;
    ConnectableDevice device;

    public DevicePicker(Activity activity) {
        this.activity = activity;
    }

    public ListView getListView() {
        return new DevicePickerListView(activity);
    }

    public void pickDevice(ConnectableDevice device) {
        this.device = device;
    }

    public void cancelPicker() {
        if (device != null) {
            device.cancelPairing();
        }
        device = null;
    }

    public AlertDialog getPickerDialog(String message, final OnItemClickListener listener) {
        final DevicePickerListView view = new DevicePickerListView(activity);

        TextView title = (TextView) activity.getLayoutInflater().inflate(android.R.layout.simple_list_item_1, null);
        title.setText(message);

        final AlertDialog pickerDialog = new AlertDialog.Builder(activity)
        .setCustomTitle(title)
        .setCancelable(true)
        .setView(view)
        .create();

        view.setOnItemClickListener(new OnItemClickListener () {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                    long arg3) {
                listener.onItemClick(arg0, arg1, arg2, arg3);
                pickerDialog.dismiss();
            }
        });

        return pickerDialog;
    }
}
