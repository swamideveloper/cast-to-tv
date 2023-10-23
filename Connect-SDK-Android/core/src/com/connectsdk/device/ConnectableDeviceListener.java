/*
 * ConnectableDeviceListener
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

import java.util.List;

import com.connectsdk.service.DeviceService;
import com.connectsdk.service.DeviceService.PairingType;
import com.connectsdk.service.command.ServiceCommandError;

public interface ConnectableDeviceListener {

    public void onDeviceReady(ConnectableDevice device);

    public void onDeviceDisconnected(ConnectableDevice device);

    public void onPairingRequired(ConnectableDevice device, DeviceService service, PairingType pairingType);

    public void onCapabilityUpdated(ConnectableDevice device, List<String> added, List<String> removed);

    public void onConnectionFailed(ConnectableDevice device, ServiceCommandError error);
}
