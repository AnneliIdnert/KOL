package com.example.idnert.kol_app;


import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;


public class LayoutPersonalPref extends Fragment {

    private Controller controller;
    private Button save;
    private EditText firstName;
    private EditText lastName;
    private EditText personNo;
    private CheckBox smoking;
    private Button inputExercis;
    private RadioButton man;
    private RadioButton woman;

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

        save= (Button)view.findViewById(R.id.btnSavePersonalInfo);
        save.setOnClickListener(new addPersonalPref());

        firstName=(EditText)view.findViewById(R.id.firstname);
        lastName=(EditText)view.findViewById(R.id.lastname);
        personNo=(EditText)view.findViewById(R.id.edPersonno);
        man=(RadioButton)view.findViewById(R.id.rndButtnMan);
        woman=(RadioButton)view.findViewById(R.id.rndButtnFemale);
        smoking=(CheckBox)view.findViewById(R.id.cBoxSmoking);
        return view;
    }





    public void setController(Controller controller){this.controller = controller;}

    private class addPersonalPref implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String firstN = firstName.getText().toString();
            String lastN = lastName.getText().toString();
            String persNo = personNo.getText().toString();
            String sex= checkSex();
            String habit=smokingHabits();
            Log.d("AI", controller.toString());
            controller.data(firstN,lastN,persNo,sex,habit);

        }
        private String checkSex(){

            if(woman.isChecked()){

                return "Kvinna";
            }else if(man.isChecked()){
            return "Man";
            }
            return "NA";
        }
    }
    private String smokingHabits() {

        if (smoking.isChecked()) {
            return "Röker";
        }
            return "Röker ej";
    }


}
