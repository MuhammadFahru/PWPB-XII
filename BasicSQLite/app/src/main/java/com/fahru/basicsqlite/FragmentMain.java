package com.fahru.basicsqlite;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import java.util.List;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.fahru.basicsqlite.database.DatabaseHelper;

public class FragmentMain extends Fragment implements View.OnClickListener, RecyclerViewAdapter.OnUserClickListener {

    RecyclerView recyclerView;
    EditText edtName,edtAge;
    TextView warning;
    Button btnSubmit;
    RecyclerView.LayoutManager layoutManager;
    Context context;
    List<PersonBean> listPersonInfo;

    public FragmentMain() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        context = getActivity();
        recyclerView = view.findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        edtName = view.findViewById(R.id.edtname);
        warning = view.findViewById(R.id.warning);
        warning.setVisibility(View.GONE);
        edtAge = view.findViewById(R.id.edtage);
        btnSubmit = view.findViewById(R.id.btnsubmit);
        btnSubmit.setOnClickListener(this);
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        DatabaseHelper db = new DatabaseHelper(context);
        listPersonInfo = db.selectUserData();
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(context,listPersonInfo,this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnsubmit){
            DatabaseHelper db = new DatabaseHelper(context);
            PersonBean currentPerson = new PersonBean();
            String btnStatus=btnSubmit.getText().toString();
            if(btnStatus.equals("Submit")) {
                currentPerson.setName(edtName.getText().toString());
                currentPerson.setAge(Integer.parseInt(edtAge.getText().toString()));
                db.insert(currentPerson);
            }
            if(btnStatus.equals("Update")){
                currentPerson.setName(edtName.getText().toString());
                currentPerson.setAge(Integer.parseInt(edtAge.getText().toString()));
                db.update(currentPerson);
                edtName.setFocusable(true);
                edtName.setFocusableInTouchMode(true);
            }
            setupRecyclerView();
            edtName.setText("");
            edtAge.setText("");
            edtName.setFocusable(true);
            edtName.setFocusableInTouchMode(true);
            warning.setVisibility(View.GONE);
            btnSubmit.setText("Submit");
        }
    }

    @Override
    public void onUserClick(PersonBean currentPerson, String action) {
        if(action.equals("Edit")){
            edtName.setText(currentPerson.getName()+"");
            edtAge.setText(currentPerson.getAge()+"");
            warning.setText("Nama Tidak Bisa Di Edit Karena PRIMARY KEY !");
            warning.setVisibility(View.VISIBLE);
            edtName.setFocusable(false);
            btnSubmit.setText("Update");
        }
        if(action.equals("Delete")){
            DatabaseHelper db = new DatabaseHelper(context);
            db.delete(currentPerson.getName());
            setupRecyclerView();
        }
    }
}