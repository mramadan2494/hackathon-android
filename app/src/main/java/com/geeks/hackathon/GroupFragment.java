package com.geeks.hackathon;

import android.content.Context;
import android.content.Intent;
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
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

import api.WebServiceApiAdapterBuilder;
import api.response.CustomerLoginResponse;
import api.response.User;
import api.response.UsersResponse;
import butterknife.BindView;
import butterknife.ButterKnife;
import fastAdapterItems.LocationsAdapter;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class GroupFragment extends Fragment {

    @BindView(R.id.group_recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.map_btn)
    Button mapButton;

    Context context;

    int screenType = 0;

    LocationsAdapter locationsAdapter;
    public GroupFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public void initUI(View view){
        context = getActivity();
        ButterKnife.bind(this, view);

        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uri = String.format(Locale.ENGLISH, "geo:%f,%f", 30.05611, 31.23944);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                context.startActivity(intent);
            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        /*ArrayList<User> data = new ArrayList<>();
        data.add(new User("Mohamed"));
        data.add(new User("Ramadan"));
        data.add(new User("Ali"));*/
        setGroupUsers();




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_group, container, false);
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

                    JSONArray jsonarray = new JSONArray();

                    try {
                        jsonarray = new JSONArray(responseStr);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    if (jsonarray == null)
                        return;
                    for (int i = 0; i < jsonarray.length(); i++) {
                        JSONObject jsonobject = null;
                        try {
                            jsonobject = jsonarray.getJSONObject(i);
                            String name = jsonobject.getString("userName");
                            String phone = jsonobject.getString("phone");
                            groupUsers.add(new User(name,phone));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }


                    Log.v("GroupFragment", "response mapped to CustomerLoginReq :: " + users.toString());
                    locationsAdapter = new LocationsAdapter( context ,groupUsers , 0);
                    recyclerView.setAdapter(locationsAdapter);


                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.v("GroupFragment", "onFailure :: " + t.getMessage() + " ::  " + call.toString());
                Toast.makeText(getActivity(), "Internet Connection Failed ", Toast.LENGTH_SHORT).show();
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
