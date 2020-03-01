package com.bdu.music;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
     Button register;
     EditText fn,usr,em,psw,phn;
     TextView back;
    AlertDialog.Builder	myAlertBuilder;
    RadioButton male;
    RadioButton  female;
    String gender;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        register=findViewById(R.id.submit_reg);
        fn=findViewById(R.id.fn_reg);
        usr=findViewById(R.id.usr_reg);
        em=findViewById(R.id.email_reg);
        psw=findViewById(R.id.pass_reg);
        phn=findViewById(R.id.phone_reg);
        back=findViewById(R.id.back_reg);
        male=findViewById(R.id.male_reg);
        female=findViewById(R.id.female_reg);
      	myAlertBuilder=	new AlertDialog.Builder(RegisterActivity.this);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });
       // (String phone,String fname, String username, String sex, String email, String password)
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    User user=new User(phn.getText().toString(),fn.getText().toString(),usr.getText().toString(),"male",em.getText().toString(),psw.getText().toString());
                    Add_User(user);
                } catch (Exception ex) {
                    Toast.makeText(getApplicationContext(),"shit", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public void Add_User(User user)
    {
        try {
            databaseHelper = new DatabaseHelper(getApplicationContext());
            if (user.getSex().isEmpty() && user.getFname().isEmpty() && user.getPhone().isEmpty() && user.getPassword().isEmpty() &&
                    user.getSex().isEmpty() && user.getEmail().isEmpty()) {
                myAlertBuilder.setTitle("Alert");
                myAlertBuilder.setMessage("some field is empty");
                myAlertBuilder.show();
            } else {
                long result = databaseHelper.insert(user);
                if (result <= 0) {
                    myAlertBuilder.setTitle("Alert");
                    myAlertBuilder.setMessage("Insertion Unsuccessfull");
                    myAlertBuilder.show();
                } else {
                    myAlertBuilder.setTitle("Alert");
                    myAlertBuilder.setMessage("Insertion successfull");
                    myAlertBuilder.show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            }
        }catch (Exception ex){
            Toast.makeText(getApplicationContext(),"shit"+user.getFname()+user.getEmail()+user.getSex(),Toast.LENGTH_SHORT).show();

        }
    }
}
