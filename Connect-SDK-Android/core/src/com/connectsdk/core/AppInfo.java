/*
 * AppInfo
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

public class AppInfo implements JSONSerializable {
    String id;
    String name;
    JSONObject raw;


    public AppInfo() {
    }


    public AppInfo(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.trim();
    }


    public JSONObject getRawData() {
        return raw;
    }

    public void setRawData(JSONObject data) {
        raw = data;
    }

    @Override
    public JSONObject toJSONObject() throws JSONException {
        JSONObject obj = new JSONObject();

        obj.put("name", name);
        obj.put("id", id);

        return obj;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof AppInfo) {
            AppInfo ai = (AppInfo) o;
            return this.id.equals(ai.id);
        }
        return super.equals(o);
    }
}
