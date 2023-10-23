/*
 * ExternalInputInfo
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

package com.connectsdk.core;

import org.json.JSONException;
import org.json.JSONObject;


public class ExternalInputInfo implements JSONSerializable {
    String id;
    String name;
    boolean connected;
    String iconURL;

    JSONObject rawData;


    public ExternalInputInfo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String inputId) {
        this.id = inputId;
    }

    public String getName() {
        return name;
    }

    public void setName(String inputName) {
        this.name = inputName;
    }

    public void setRawData(JSONObject rawData) {
        this.rawData = rawData;
    }

    public JSONObject getRawData() {
        return rawData;
    }

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    public String getIconURL() {
        return iconURL;
    }

    public void setIconURL(String iconURL) {
        this.iconURL = iconURL;
    }

    @Override
    public JSONObject toJSONObject() throws JSONException {
        JSONObject obj = new JSONObject();

        obj.put("id", id);
        obj.put("name", name);
        obj.put("connected", connected);
        obj.put("icon", iconURL);
        obj.put("rawData", rawData);

        return obj;
    }
    // @endcond

    @Override
    public boolean equals(Object o) {
        if (o instanceof ExternalInputInfo) {
            ExternalInputInfo eii = (ExternalInputInfo) o;
            return this.id.equals(eii.id) &&
                    this.name.equals(eii.name);
        }
        return false;
    }
}
