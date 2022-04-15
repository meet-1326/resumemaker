package com.raw.resumemaker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText edname,edsurename,edfathername,edmothername,edemail,edphon,edaddress,edreligion,ededuction,edhobby,eddate;
    Button reset,create,datepick;
    DatePicker date;
    RadioGroup gender;
    RadioButton button;
    CheckBox swiming,danceing,hacking,other;


    String name,surename,fathername,mothername,email,phon,address,religion,eduction,hobby,hobby_list;
    int d,m,y,chek=0,Gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edname = findViewById(R.id.edname);
        edsurename = findViewById(R.id.edsurename);
        edfathername = findViewById(R.id.edfathername);
        edmothername = findViewById(R.id.edmothername);
        eddate = findViewById(R.id.eddate);
        edemail = findViewById(R.id.edemail);
        edphon = findViewById(R.id.edphon);
        edaddress = findViewById(R.id.edaddress);
        edreligion = findViewById(R.id.edreligion);
        ededuction = findViewById(R.id.ededuction);
        edhobby = findViewById(R.id.edhobby);

        reset = findViewById(R.id.reset);
        create = findViewById(R.id.create);
        datepick = findViewById(R.id.datepick);

        date = findViewById(R.id.date);

        gender = findViewById(R.id.gender);

        swiming = findViewById(R.id.swiming);
        danceing = findViewById(R.id.danceing);
        hacking = findViewById(R.id.hacking);
        other = findViewById(R.id.other);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edname.setText("");
                edsurename.setText("");
                edfathername.setText("");
                edmothername.setText("");
                eddate.setText("");
                edemail.setText("");
                edphon.setText("");
                edaddress.setText("");
                edreligion.setText("");
                ededuction.setText("");
                edhobby.setText("");
            }
        });

        datepick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chek==0){
                    datepick.setText("Set");
                    date.setVisibility(View.VISIBLE);
                    chek=1;
                }else{
                    datepick.setText("Pick");
                    date.setVisibility(View.GONE);
                    y = date.getYear();
                    m = date.getMonth();
                    d = date.getDayOfMonth();
                    eddate.setText(d+"/"+m+"/"+y);
                    chek=0;
                }
            }
        });

        other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (other.isChecked()){
                    edhobby.setVisibility(View.VISIBLE);
                }else {
                    edhobby.setVisibility(View.GONE);
                }
            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(swiming.isChecked()){
                    hobby_list+="Swiming,";
                }else if(danceing.isChecked()){
                    hobby_list+="Danceing,";
                }else if(hacking.isChecked()){
                    hobby_list+="Hacking,";
                }

                hobby_list+=edhobby.getText().toString();

                name = edname.getText().toString();
                surename = edsurename.getText().toString();
                fathername = edfathername.getText().toString();
                mothername = edmothername.getText().toString();
                email = edemail.getText().toString();
                phon = edphon.getText().toString();
                address = edaddress.getText().toString();
                religion = edreligion.getText().toString();
                eduction = ededuction.getText().toString();
                hobby = hobby_list;

                Gender = gender.getCheckedRadioButtonId();
                button = findViewById(Gender);

////                Intent intent = new Intent(MainActivity.this,show.class);
//                intent.putExtra("name",name);
//                intent.putExtra("surename",surename);
//                intent.putExtra("fathername",fathername);
//                intent.putExtra("mothername",mothername);
//                intent.putExtra("date",eddate.getText().toString());
//                intent.putExtra("gender",button.getText().toString());
//                intent.putExtra("email",email);
//                intent.putExtra("phon",phon);
//                intent.putExtra("address",address);
//                intent.putExtra("religion",religion);
//                intent.putExtra("eduction",eduction);
//                intent.putExtra("religion",religion);
//                intent.putExtra("hobby",hobby);
//                startActivity(intent);
                hobby_list="";

            }
        });

    }
}