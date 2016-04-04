package com.example.vollettest;

import java.util.HashMap;
import java.util.Map;

import javax.xml.transform.ErrorListener;
import javax.xml.transform.TransformerException;

import org.json.JSONObject;

import com.android.volley.Request.Method;
import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		String url = " http://apis.baidu.com/apistore/mobilephoneservice/mobilephone?";
//		volley_GET(url);
		volley_POST(url);
	}
	private void volley_POSTByString(String url) {
		Map<String, String> mParams = new HashMap<String, String>();
		mParams.put("tel","18811346383");
		JSONObject jb = new JSONObject(mParams);
		JsonObjectRequest request = new JsonObjectRequest(Method.POST, url,
				jb, new Listener<JSONObject>() {

					@Override
					public void onResponse(JSONObject response) {
						System.out.println("回调成功");
						System.out.println(response.toString());
						Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_LONG).show();
					}
				}, new Response.ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {
						System.out.println("回调失败");
						Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();
					}

				}){
				
//				@Override
//					protected Map<String, String> getParams() throws AuthFailureError {
//						Map<String, String> mParams = new HashMap<String, String>();
//						mParams.put("tel","18811346383");
//						return mParams;
//					}
				@Override
					public Map<String, String> getHeaders() throws AuthFailureError {
						Map<String, String> mHeaders = new HashMap<String, String>();	
						mHeaders.put("apikey", "0189c092aa9d54134339c92b19154cee");
						return mHeaders;
					}
		};
		request.setTag("getRequest");
		MyApplication.getHttpQueues().add(request);		
	}
	private void volley_POST(String url) {
		Map<String, String> mParams = new HashMap<String, String>();
		mParams.put("tel","18811346383");
		JSONObject jb = new JSONObject(mParams);
		JsonObjectRequest request = new JsonObjectRequest(Method.POST, url,
				jb, new Listener<JSONObject>() {

					@Override
					public void onResponse(JSONObject response) {
						System.out.println("回调成功");
						System.out.println(response.toString());
						Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_LONG).show();
					}
				}, new Response.ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {
						System.out.println("回调失败");
						Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();
					}

				}){
				
//				@Override
//					protected Map<String, String> getParams() throws AuthFailureError {
//						Map<String, String> mParams = new HashMap<String, String>();
//						mParams.put("tel","18811346383");
//						return mParams;
//					}
				@Override
					public Map<String, String> getHeaders() throws AuthFailureError {
						Map<String, String> mHeaders = new HashMap<String, String>();	
						mHeaders.put("apikey", "0189c092aa9d54134339c92b19154cee");
						return mHeaders;
					}
		};
		request.setTag("getRequest");
		MyApplication.getHttpQueues().add(request);		
	}

	private void volley_GET(String url) {
		
		
		JsonObjectRequest request = new JsonObjectRequest(Method.GET, url,
				null, new Listener<JSONObject>() {

					@Override
					public void onResponse(JSONObject response) {
						System.out.println("回调成功");
						System.out.println(response.toString());
						Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_LONG).show();
					}
				}, new Response.ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {
						System.out.println("回调失败");
						Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();
					}

				}){
				Map<String, String> mHeaders = new HashMap<String, String>();
			public Map<String, String> getHeaders() {
				mHeaders.put("apikey", "0189c092aa9d54134339c92b19154cee");
			    return mHeaders;
			  }
		};
		request.setTag("getRequest");
		MyApplication.getHttpQueues().add(request);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
