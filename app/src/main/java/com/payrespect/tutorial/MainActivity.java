package com.payrespect.tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button1,button2,easteregg2;
    EditText editText,easteregg1;
    RadioButton radioButton1,radioButton2;
    ImageView imageView1, imageView2;
    RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button) findViewById(R.id.btn1);
        button2 = (Button) findViewById(R.id.btn2);
        editText = (EditText) findViewById(R.id.email);
        radioButton1 = (RadioButton) findViewById(R.id.radiobtn1);
        radioButton2 = (RadioButton) findViewById(R.id.radiobtn2);
        imageView1 = (ImageView) findViewById(R.id.image);
        imageView2 = (ImageView) findViewById(R.id.image2);
        radioButton1 = (RadioButton) findViewById(R.id.radiobtn1);
        radioButton2 = (RadioButton) findViewById(R.id.radiobtn2);
        radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
        easteregg1 = (EditText) findViewById(R.id.easteregg1);
        easteregg2 = (Button) findViewById(R.id.easteregg2);
        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(getApplicationContext(),editText.getText(),Toast.LENGTH_SHORT).show();
            }
        });
        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(editText.getText().toString()));
                startActivity(intent);
            }
        });
        imageView1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(getApplicationContext(),R.string.easteregg,Toast.LENGTH_SHORT).show();
                easteregg1.setVisibility(View.VISIBLE);
                easteregg2.setVisibility(View.VISIBLE);

            }
        });
        easteregg2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast toast;
                if(easteregg1.getText().toString().equals(getResources().getString(R.string.easteregg5))){
                    toast = Toast.makeText(getApplicationContext(),R.string.easteregg3, Toast.LENGTH_SHORT);
                    easteregg1.setVisibility(View.INVISIBLE);
                    easteregg2.setVisibility(View.INVISIBLE);

                }else{
                    toast = Toast.makeText(getApplicationContext(),R.string.easteregg4, Toast.LENGTH_SHORT);
                }
                toast.show();
            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.radiobtn1:
                        imageView1.setVisibility(View.VISIBLE);
                        imageView2.setVisibility(View.INVISIBLE);
                        break;
                    case R.id.radiobtn2:
                        imageView2.setVisibility(View.VISIBLE);
                        imageView1.setVisibility(View.INVISIBLE);
                        break;
                }
            }
        });
    }
}
