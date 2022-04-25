package com.overseastechnologies.GradeApp.fragments.studymaterial;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;
import com.overseastechnologies.GradeApp.adapters.BooksAdapter;
import com.overseastechnologies.GradeApp.Books;
import com.overseastechnologies.GradeApp.activities.LoginActivityPass;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import GradeApp.R;
import GradeApp.databinding.FragmentBooksBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentBooks#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentBooks extends Fragment {

    FragmentBooksBinding binding;

    RecyclerView recyclerView;
    List<Books> list1;
    BooksAdapter booksAdapter;
    String apiUrl = "http://schoolmanagement.jihsuyaainfotech.in/api/student/studyMaterialsList";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentBooks() {
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
    public static FragmentBooks newInstance(String param1, String param2) {
        FragmentBooks fragment = new FragmentBooks();
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
        return inflater.inflate(R.layout.fragment_books, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.bookListRecycler);
        list1 = new ArrayList<>();

        method1();

    }

    private void method1() {


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, apiUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray jsonArray = response.getJSONArray("data");

                    for (int i = 0; i <= jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        Books books = new Books();
                        books.setId(jsonObject.getInt("id"));
                        books.setName(jsonObject.getString("Name"));
                        books.setPdfLink(new URL(jsonObject.getString("pdf")));

                        list1.add(books);

                        Toast.makeText(getContext(), jsonObject.getInt("id")+"\n"+jsonObject.getString("Name")+"\n"+ jsonObject.getString("pdf") , Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException | MalformedURLException e) {
                    e.printStackTrace();
                }
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                booksAdapter = new BooksAdapter(getContext(), list1);
                recyclerView.setAdapter(booksAdapter);
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
                header.put("Developerkey", " schlMana20Ge22");

                return header;
            }

        };


        RequestQueue queue = Volley.newRequestQueue(requireContext());
        queue.add(jsonObjectRequest);
    }


}