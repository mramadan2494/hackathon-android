package com.geeks.hackathon;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import api.WebServiceApiAdapterBuilder;
import api.response.User;
import butterknife.BindView;
import butterknife.ButterKnife;
import fastAdapterItems.LocationsAdapter;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PlacesFragment extends Fragment {
    @BindView(R.id.places_recycler_view)
    RecyclerView recyclerView;

    Context context;

    LocationsAdapter locationsAdapter;
    public PlacesFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public void initUI(View view){
        context = getActivity();
        ButterKnife.bind(this, view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        /*ArrayList<User> data = new ArrayList<>();
        data.add(new User("Mohamed"));
        data.add(new User("Ramadan"));
        data.add(new User("Ali"));*/
        ArrayList<User> data = new ArrayList<>();
        data.add(new User("Bus"));
        data.add(new User("Mina home"));
        data.add(new User("Great Mosque of Mecca"));
        data.add(new User("Mount Arafat"));

        locationsAdapter = new LocationsAdapter( context ,data , 1);
        recyclerView.setAdapter(locationsAdapter);
        setGroupUsers();




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_places, container, false);
        initUI(view);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {

    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }



    private void setGroupUsers() {
        //ProgressbarDialog.getProgressDialog(this).show();
        JsonObject customerLoginReq = new JsonObject();


        Call<ResponseBody> usersCallBack = WebServiceApiAdapterBuilder.getInstance().getUsers();
        getUsersCallBackFunction(usersCallBack);

    }

    private void getUsersCallBackFunction(Call<ResponseBody> callback) {
        callback.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {


                if (response.isSuccessful()) {
                    Log.v("GroupFragment", "response success :: " + response.code() + " ::  " + response.body().toString());
                    ResponseBody users = response.body();

                    String responseStr = getResponseString(response);

                    Log.v("GroupFragment", "onResponse response " + responseStr);
                    ArrayList<User> groupUsers=new ArrayList<>();

                    JSONArray jsonarray = null;
                    try {
                        jsonarray = new JSONArray(responseStr);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    for (int i = 0; i < jsonarray.length(); i++) {
                        JSONObject jsonobject = null;
                        try {
                            jsonobject = jsonarray.getJSONObject(i);
                            String name = jsonobject.getString("name");
                            String phone = jsonobject.getString("phone");
                            groupUsers.add(new User(name,phone));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }


                    Log.v("GroupFragment", "response mapped to CustomerLoginReq :: " + users.toString());




                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.v("GroupFragment", "onFailure :: " + t.getMessage() + " ::  " + call.toString());
            }

        });
    }
    private String getResponseString(Response<ResponseBody> response) {
        String responseStr;
        try {
            responseStr = response.body().string();
        } catch (NullPointerException e) {
            e.printStackTrace();
            responseStr = "";
        } catch (IOException e) {
            e.printStackTrace();
            responseStr = "";
        }

        return responseStr;
    }
}
