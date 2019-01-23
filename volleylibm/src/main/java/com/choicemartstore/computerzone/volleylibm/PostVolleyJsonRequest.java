package com.choicemartstore.computerzone.volleylibm;

import android.app.Activity;
import android.util.Log;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PostVolleyJsonRequest {
    private String  type;
    private Activity act;
    private VolleyJsonRespondsListener volleyJsonRespondsListener;
    private String networkurl;
    private JSONObject jsonObject = null;
    private JSONObject params;
    private JSONArray Aparams;
    private boolean isPost;
    private boolean isArray;

    public PostVolleyJsonRequest(Activity act, VolleyJsonRespondsListener volleyJsonRespondsListener, String type, String netnetworkUrl,JSONObject params,boolean isPost,boolean isArray) {
        this.act = act;
        this.volleyJsonRespondsListener = volleyJsonRespondsListener;
        this.type = type;
        this.networkurl = netnetworkUrl;
        this.params = params;
        this.isPost = isPost;
        this.isArray = isArray;
        //Log.d("REQUEST",isArray+"");

        sendRequest();

    }

    private void sendRequest() {
    //    Log.d("REQUEST 1",isArray+"");

        if(this.isArray == true){
            if(this.isPost == true){
                APostRequest();
                Log.d("Co ", "1");

            }else{
                Log.d("Co ", "2");

                AgetRequest();
            }
        }else{
            if(this.isPost == true){
                OPostRequest();
                Log.d("Co ", "3");

            }else{
                OgetRequest();
                Log.d("Co ", "4");

            }
        }



    }
    private  void OPostRequest(){
        //   Log.d("url", "url" + networkurl);
        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.POST,networkurl,params,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e("response", "response " + response);
                        JSONArray array = new JSONArray();
                        volleyJsonRespondsListener.onSuccessJson(response,array, type);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        try {
                            NetworkResponse response = error.networkResponse;
                            Log.e("response", "response " + response);
                            if (response != null) {
                                int code = response.statusCode;

                                String errorMsg = new String(response.data);
                                Log.e("response", "response" + errorMsg);
                                try {
                                    jsonObject = new JSONObject(errorMsg);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                String msg = jsonObject.optString("message");
                                volleyJsonRespondsListener.onFailureJson(code, msg);
                            } else {
                                String errorMsg = error.getMessage();
                                volleyJsonRespondsListener.onFailureJson(0, errorMsg);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });

        jsObjRequest.setRetryPolicy(new DefaultRetryPolicy(
                5000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        RequestQueue requestqueue = Volley.newRequestQueue(act);
        requestqueue.add(jsObjRequest);

    }
private void OgetRequest(){
    //   Log.d("url", "url" + networkurl);
    JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.GET,networkurl,params,
            new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    Log.e("response", "response " + response);
                    JSONArray array = new JSONArray();
                    volleyJsonRespondsListener.onSuccessJson(response,array, type);
                }
            },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    try {
                        NetworkResponse response = error.networkResponse;
                        Log.e("response", "response " + response);
                        if (response != null) {
                            int code = response.statusCode;

                            String errorMsg = new String(response.data);
                            Log.e("response", "response" + errorMsg);
                            try {
                                jsonObject = new JSONObject(errorMsg);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            String msg = jsonObject.optString("message");
                            volleyJsonRespondsListener.onFailureJson(code, msg);
                        } else {
                            String errorMsg = error.getMessage();
                            volleyJsonRespondsListener.onFailureJson(0, errorMsg);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

    jsObjRequest.setRetryPolicy(new DefaultRetryPolicy(
            5000,
            DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
            DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

    RequestQueue requestqueue = Volley.newRequestQueue(act);
    requestqueue.add(jsObjRequest);

}
    private  void APostRequest(){
        //   Log.d("url", "url" + networkurl);
        JsonArrayRequest jsObjRequest = new JsonArrayRequest(Request.Method.POST,networkurl,Aparams,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.e("response", "response " + response);
                        JSONObject Object = new JSONObject();
                        volleyJsonRespondsListener.onSuccessJson(Object,response, type);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        try {
                            NetworkResponse response = error.networkResponse;
                            Log.e("response", "response " + response);
                            if (response != null) {
                                int code = response.statusCode;

                                String errorMsg = new String(response.data);
                                Log.e("response", "response" + errorMsg);
                                try {
                                    jsonObject = new JSONObject(errorMsg);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                String msg = jsonObject.optString("message");
                                volleyJsonRespondsListener.onFailureJson(code, msg);
                            } else {
                                String errorMsg = error.getMessage();
                                volleyJsonRespondsListener.onFailureJson(0, errorMsg);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });

        jsObjRequest.setRetryPolicy(new DefaultRetryPolicy(
                5000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        RequestQueue requestqueue = Volley.newRequestQueue(act);
        requestqueue.add(jsObjRequest);

    }
    private void AgetRequest(){
        //   Log.d("url", "url" + networkurl);
        JsonArrayRequest jsObjRequest = new JsonArrayRequest(Request.Method.GET,networkurl,Aparams,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.e("response", "response " + response);
                        JSONObject Object = new JSONObject();

                        volleyJsonRespondsListener.onSuccessJson(Object,response, type);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        try {
                            NetworkResponse response = error.networkResponse;
                            Log.e("response", "response " + response);
                            if (response != null) {
                                int code = response.statusCode;

                                String errorMsg = new String(response.data);
                                Log.e("response", "response" + errorMsg);
                                try {
                                    jsonObject = new JSONObject(errorMsg);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                String msg = jsonObject.optString("message");
                                volleyJsonRespondsListener.onFailureJson(code, msg);
                            } else {
                                String errorMsg = error.getMessage();
                                volleyJsonRespondsListener.onFailureJson(0, errorMsg);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });

        jsObjRequest.setRetryPolicy(new DefaultRetryPolicy(
                5000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        RequestQueue requestqueue = Volley.newRequestQueue(act);
        requestqueue.add(jsObjRequest);

    }
}