# Volley Multi Request 

[![N|Solid](http://dashboards.tk/sami.png)](https://super-sami.com/)

This library makes thing easier for an android developer when they tried to call a Volley request .



 
# New Features!

  - Can call Multiple requests at the same time 
  - JSON Array and JSON OBJECT support
  - POST and GET REQUEST 
  - Clean backend because of just one line code




### STEP 1
Just add the bleow maven url on allprojects root level gradle .

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
	

### STEP 2
add the below code on app level gradle

        dependencies {
	        implementation 'com.github.dksami:Volley-Multi-Request-:master-SNAPSHOT'
	}

	
### STEP 3
Implement the interface 
    
      public class MainActivity extends AppCompatActivity implements VolleyJsonRespondsListener {

### STEP 4
Import the Methods by left click and generate 
```sh
  @Override
    public void onSuccessJson(JSONObject result, JSONArray resultA, String type) {
}
  @Override
    public void onFailureJson(int responseCode, String responseMessage) {

    }
```

### NOW Call the API 
Now call as many api as you wanted to Call them like this 

```sh
   new PostVolleyJsonRequest(this,this,"Object","https://api.myjson.com/bins/13sh6c",null,false,true);
        new PostVolleyJsonRequest(this,this,"ObjectS","https://domin.com/wp-json/wp/v2/categories",params,true,false);
```
### FETCHING THE DATA
And lastly Simply by Type fetch your response
```  @Override
    public void onSuccessJson(JSONObject result, String type) {
   switch (type) {
            case "Objects":
              ##fetch data from here
                break;
       
   }
```


AS CLEAN AS IT CAN BE 
## PARAMETERS


| Parameters | Details |
| ------ | ------ |
| Context | Context of MainActivity from where you are calling the api |
| Interface Context | Context of the interface, if implement call the activity Context |
| Type | A String that can be used to fetch the response  |
| URL | Request URL of JSON |
| paramsO | JsonObject params for JSONOJECTRequest |
| paramsA | JsonArray params for JSONArrayRequest |
| isPost | True is Post Request |
| isArray | True if Array |




# License
----

MIT


**Free Software, Hell Yeah!**
