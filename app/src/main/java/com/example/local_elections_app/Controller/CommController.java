package com.example.local_elections_app.Controller;

import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import com.example.local_elections_app.Model.Params;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class CommController {
    private String url = "http://127.0.0.1";
    private String TAG = "CommController";

    private class FindTask extends AsyncTask<Params, Void, String>{
        String msg = "";

        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        protected String doInBackground(Params... params) {
            Log.i(TAG, "Execute executeClient()");

            HttpClient client = new DefaultHttpClient();
            HttpPost post = new HttpPost(url);
            HttpResponse response = null;

            // Headers
            List<NameValuePair> nvPairs = new ArrayList<NameValuePair>();
            nvPairs.add(new BasicNameValuePair("sgTypecode", String.valueOf(params[0].getSgTypeCode())));
            nvPairs.add(new BasicNameValuePair("pageNo", "1"));
            nvPairs.add(new BasicNameValuePair("numOfRows", "15"));
            nvPairs.add(new BasicNameValuePair("sdName", params[0].getSdName()));
            nvPairs.add(new BasicNameValuePair("sggName",params[0].getSggName()));

            try {
                UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(nvPairs, "utf-8");
                post.setEntity(urlEncodedFormEntity);
                response = client.execute(post);
                Log.i(TAG, "After client.execute()");
            } catch (UnsupportedEncodingException e) {
                Log.e(TAG, "Unsupported Encoding used");
            } catch (ClientProtocolException e) {
                Log.e(TAG, "Client Protocol Exception");
            } catch (IOException e) {
                Log.e(TAG, "IOException in HttpPost");
            }

            if (response != null) {
                if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                    try {
                        BufferedReader reader = new BufferedReader(
                                new InputStreamReader(response.getEntity().getContent()));
                        StringBuilder sb = new StringBuilder();
                        String line;
                        while ((line = reader.readLine()) != null) {
                            sb.append(line);
                        }
                        msg = sb.toString();
                    } catch (IOException e) { Log.e(TAG, "IO Exception in reading from stream."); }
                } else { msg = "Status code other than HTTP 200 received"; }
            } else { msg = "Response is null"; }

            return msg;
        }
    }

    public String recvResponse(Params params){
        String result = null;
        FindTask findTask = new FindTask();

        try {
            result = findTask.execute(params).get();
        } catch (ExecutionException e) {
            Log.e(TAG, "ExecutionException");
        } catch (InterruptedException e) {
            Log.e(TAG, "InterruptedException");
        }
        return result;
    }
}
