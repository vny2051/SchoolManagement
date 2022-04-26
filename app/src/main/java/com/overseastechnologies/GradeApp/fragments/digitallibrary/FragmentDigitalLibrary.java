package com.overseastechnologies.GradeApp.fragments.digitallibrary;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.overseastechnologies.GradeApp.Books;
import com.overseastechnologies.GradeApp.adapters.BooksAdapter;
import com.overseastechnologies.GradeApp.adapters.DigitalLibraryAdapter;
import com.overseastechnologies.GradeApp.models.DigitalLibrary;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import GradeApp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentDigitalLibrary#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentDigitalLibrary extends Fragment {
    RecyclerView recyclerView;
    List<DigitalLibrary> list;
    DigitalLibraryAdapter digitalLibraryAdapter;
    String apiUrl = "http://schoolmanagement.jihsuyaainfotech.in/api/student/digitalLibrabry";
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentDigitalLibrary() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentLiveClasses.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentDigitalLibrary newInstance(String param1, String param2) {
        FragmentDigitalLibrary fragment = new FragmentDigitalLibrary();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_digital_library, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.rv_digital_library);
        list = new ArrayList<>();

        method1();
    }

    private void method1() {


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, apiUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    Toast.makeText(getContext(), response.getString("status"), Toast.LENGTH_SHORT).show();

                    JSONArray jsonArray = response.getJSONArray("data");
//                    for (int i = 0; i <= jsonArray.length(); i++) {
//                        Toast.makeText(getContext(), jsonArray.getJSONObject(i).getString("id") +"\n"+ jsonArray.getJSONObject(i).getString("url"), Toast.LENGTH_SHORT).show();
//                    }


                    for (int i = 0; i <= jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        DigitalLibrary digitalLibrary = new DigitalLibrary();
                        digitalLibrary.setId(jsonObject.getInt("id"));
                        digitalLibrary.setStd(jsonObject.getInt("class"));
                        digitalLibrary.setSubject(jsonObject.getString("subName"));
                        digitalLibrary.setType(jsonObject.getString("type"));
                        digitalLibrary.setUrl(jsonObject.getString("url"));

                        list.add(digitalLibrary);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                digitalLibraryAdapter = new DigitalLibraryAdapter(getContext(), list);
                recyclerView.setAdapter(digitalLibraryAdapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "onErrorResponse method executed..!" + error.toString(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> header = new HashMap<String, String>();
                header.put("Developerkey", "schlMana20Ge22");

                return header;
            }

            @Override
            public byte[] getBody() {

                //another way of sending body raw data...
//                            String str = "{\"emailID\":\"" + email + "\",\"password\":\"" + password + "\"}";
//                            return str.getBytes();

                SharedPreferences sharedPreferences = requireContext().getSharedPreferences("StudentInfo", MODE_PRIVATE);

                JSONObject bodyParameters = new JSONObject();
                try {
                    bodyParameters.put("studentID", "11111");
                    bodyParameters.put("class", "10");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return bodyParameters.toString().getBytes();

            }
        };


        RequestQueue queue = Volley.newRequestQueue(requireContext());
        queue.add(jsonObjectRequest);
    }


}