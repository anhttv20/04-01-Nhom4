package com.example.a04_01_nhom4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
    implements View.OnClickListener{
    private EditText et1,et2;
    private TextView txt;
    private Button btAdd;
    private Spinner sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        btAdd.setOnClickListener(this);

        //event handle btAdd
//        btAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                double n1,n2;
//                try{
//                    n1=Double.parseDouble(et1.getText().toString());
//                    n2=Double.parseDouble(et2.getText().toString());
//                    txt.setText("Sum:"+(n1+n2));
//                }catch(NumberFormatException e){
//                    System.out.println(e);
//                }
//            }
//        });
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                double n1, n2;
                try {
                    n1 = Double.parseDouble(et1.getText().toString());
                    n2 = Double.parseDouble(et2.getText().toString());
                    String op=sp.getSelectedItem().toString();
                    String rs=cal(n1,n2,op);
                    txt.setText(rs);
                } catch (NumberFormatException e) {
                    System.out.println(e);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void initView() {
        et1=findViewById(R.id.n1);
        et2=findViewById(R.id.n2);
        txt=findViewById(R.id.result);
        btAdd=findViewById(R.id.btAdd);
        sp=findViewById(R.id.sp);
        String[] st=getResources().getStringArray(R.array.op);
        ArrayAdapter adapter=new ArrayAdapter(this,
                R.layout.spinner_item,st);
        adapter.setDropDownViewResource(R.layout.spinner_item);
        sp.setAdapter(adapter);
    }
     private String cal(double n1,double n2,String op){
          String t="";
          switch (op){
              case "+":t="Sum:"+(n1+n2);
                  break;
              case "-":t="Substract:"+(n1-n2);
                  break;
              case "x":t="Multiply:"+(n1*n2);
                  break;
              case ":":if(n2==0){
                         t="not divide by zero";
                       }else
                     t="Divide:"+(n1/n2);
                  break;
          }
          return t;
     }
    @Override
    public void onClick(View v) {
        if(v==btAdd) {
            double n1, n2;
            try {
                n1 = Double.parseDouble(et1.getText().toString());
                n2 = Double.parseDouble(et2.getText().toString());
                txt.setText("Sum:" + (n1 + n2));
            } catch (NumberFormatException e) {
                System.out.println(e);
            }
        }
    }
}
