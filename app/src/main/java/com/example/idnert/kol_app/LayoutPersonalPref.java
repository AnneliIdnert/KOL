package com.example.idnert.kol_app;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;


public class LayoutPersonalPref extends Fragment {

    private Controller controller;
    private Button save;
    private EditText firstName;
    private EditText lastName;
    private CheckBox male;
    private CheckBox female;
    private EditText personNo;

    public LayoutPersonalPref() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_layout_personal_pref, container, false);

        initContent(view);

        return view;
    }

    private void initContent(View view) {

        save= (Button)view.findViewById(R.id.btnSavePersonalInfo);
        firstName=(EditText)view.findViewById(R.id.firstname);
        lastName=(EditText)view.findViewById(R.id.lastname);
        personNo=(EditText)view.findViewById(R.id.edPersonno);
        male=(CheckBox)view.findViewById(R.id.cBoxMale);
        female=(CheckBox)view.findViewById(R.id.cBoxWoman);
    }

public  void setController(Controller controller){

    this.controller = controller;
}

}
