package com.choicemartstore.computerzone.volleylibm;

import org.json.JSONArray;
import org.json.JSONObject;

public interface VolleyJsonRespondsListener {

    public void onSuccessJson(JSONObject result, JSONArray resultA, String type);
    public void onFailureJson(int responseCode, String responseMessage);
}