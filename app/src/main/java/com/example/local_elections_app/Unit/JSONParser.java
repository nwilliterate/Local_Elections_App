package com.example.local_elections_app.Unit;

import com.example.local_elections_app.Model.Candidate;
import com.example.local_elections_app.Model.Polls;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JSONParser {

    public ArrayList<Candidate> CadidateParser(String jsonString) {
        ArrayList<Candidate> candidatesArrayList;

        try {
            //{ response: { .. } }
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONObject response = jsonObject.getJSONObject("response");
            //{ response: { header: { .. }, body: { .. } } }
            JSONObject body = response.getJSONObject("body");
            // body: { items:{ .. }, numOfRows: ,pageNo:, totalCount: }
            JSONObject items = body.getJSONObject("items");

            // items : { item : { .. }}
            JSONArray item = items.getJSONArray("item");
            candidatesArrayList = new ArrayList<Candidate>(item.length());
            // 후보자 정보 입력
            for (int i = 0; i < item.length(); i++) {
                JSONObject itemJSONObject = item.getJSONObject(i);
                candidatesArrayList.add(new Candidate());
                candidatesArrayList.get(i).setSgTypecode(itemJSONObject.optInt("sgTypecode"));
                candidatesArrayList.get(i).setHuboid(itemJSONObject.optInt("huboid"));
                candidatesArrayList.get(i).setSggName(itemJSONObject.optString("sggName"));
                candidatesArrayList.get(i).setSdName(itemJSONObject.optString("sdName"));
                candidatesArrayList.get(i).setWiwName(itemJSONObject.optString("wiwName"));
                candidatesArrayList.get(i).setGiho(itemJSONObject.optInt("giho"));
                candidatesArrayList.get(i).setGihoSangse(itemJSONObject.optString("gihoSangse"));
                candidatesArrayList.get(i).setJdName(itemJSONObject.optString("jdName"));
                candidatesArrayList.get(i).setName(itemJSONObject.optString("name"));
                candidatesArrayList.get(i).setGender(itemJSONObject.optString("gender"));
                candidatesArrayList.get(i).setBirthday(itemJSONObject.optInt("birthday"));
                candidatesArrayList.get(i).setAge(itemJSONObject.optInt("age"));
                candidatesArrayList.get(i).setAddr(itemJSONObject.optString("addr"));
                candidatesArrayList.get(i).setJob(itemJSONObject.optString("job"));
                candidatesArrayList.get(i).setEdu(itemJSONObject.optString("edu"));
                candidatesArrayList.get(i).setCareer1(itemJSONObject.optString("career1"));
                candidatesArrayList.get(i).setCareer2(itemJSONObject.optString("career2"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return  null;
        }
        return candidatesArrayList;
    }

    public ArrayList<Polls> PollsParser(String jsonString) {
        ArrayList<Polls> pollsArrayList;

        try {
            //{ response: { .. } }
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONObject response = jsonObject.getJSONObject("response");
            //{ response: { header: { .. }, body: { .. } } }
            JSONObject body = response.getJSONObject("body");
            // body: { items:{ .. }, numOfRows: ,pageNo:, totalCount: }
            JSONObject items = body.getJSONObject("items");

            // items : { item : { .. }}
            JSONArray item = items.getJSONArray("item");
            pollsArrayList = new ArrayList<Polls>(item.length());
            // 후보자 정보 입력
            for (int i = 0; i < item.length(); i++) {
                JSONObject itemJSONObject = item.getJSONObject(i);
                pollsArrayList.add(new Polls());
                pollsArrayList.get(i).setPsName(itemJSONObject.optString("evPsName"));
                pollsArrayList.get(i).setSdName(itemJSONObject.optString("sdName"));
                pollsArrayList.get(i).setWiwName(itemJSONObject.optString("wiwName"));
                pollsArrayList.get(i).setEmdName(itemJSONObject.optString("emdName"));
                pollsArrayList.get(i).setPlaceName(itemJSONObject.optString("placeName"));
                pollsArrayList.get(i).setAddr(itemJSONObject.optString("addr"));
                pollsArrayList.get(i).setFloor(itemJSONObject.optString("floor"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        return pollsArrayList;
    }
}
