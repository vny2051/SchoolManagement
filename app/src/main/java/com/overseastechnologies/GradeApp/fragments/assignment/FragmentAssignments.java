package com.overseastechnologies.GradeApp.fragments.assignment;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import GradeApp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentAssignments#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentAssignments extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentAssignments() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentAssignments.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentAssignments newInstance(String param1, String param2) {
        FragmentAssignments fragment = new FragmentAssignments();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    ListView lv;
    String tutorials[] = {"Maths","Science","Social Science","Gujarati","Hindi","Computer","Sanskrit"};
    String apiUrl = "http://schoolmanagement.jihsuyaainfotech.in/api/student/subjectList"; //url for getting all subject & their name of the student.


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
        return inflater.inflate(R.layout.fragment_assignments, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        lv = view.findViewById(R.id.lv_subjects);

        getAllSubjects();
        process1();
    }

    private void getAllSubjects() {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, apiUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
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
                    bodyParameters.put("studentID", sharedPreferences.getString("studentId",""));
                    bodyParameters.put("class", sharedPreferences.getString("standard",""));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return bodyParameters.toString().getBytes();

            }
        };


    }

    private void process1() {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>( getContext(), R.layout.support_simple_spinner_dropdown_item, tutorials );
        lv.setAdapter(arrayAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getContext(), "You Clicked On : "+arrayAdapter.getItem(i), Toast.LENGTH_SHORT).show();

//                switch (arrayAdapter.getItem(i)){
//                    case
//                }
            }
        });
    }

    private void process2(){
        
    }



}