package com.choicemartstore.computerzone.volleymulyi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements VolleyJsonRespondsListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        JSONObject params = new JSONObject();
        try {
            params.put("name","cat");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        new PostVolleyJsonRequest(this,this,"Object","https://api.myjson.com/bins/13sh6c",null,false,true);
        new PostVolleyJsonRequest(this,this,"ObjectS","https://dominionstores.com/wp-json/wp/v2/categories",params,true,false);
    }

    @Override
    public void onSuccessJson(JSONObject result, JSONArray resultA, String type) {
switch (type){
    case "Object":
        Log.d("OBJECT GET",result+"");
        Log.d("OBJECT GET",resultA+"");
        break;
    case "ObjectS":
        Log.d("OBJECT GET",result+"");
        break;

}
    }

    @Override
    public void onFailureJson(int responseCode, String responseMessage) {
        Log.d("OBJECT GET",responseMessage);

    }
}
