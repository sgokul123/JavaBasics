package com.bridgelabz.mynewapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Calculator extends AppCompatActivity implements View.OnClickListener{
        Button buttonone,buttontwo,buttonthr,buttonfour,buttonfiv,buttonsix,buttonsev,buttonzero;
    Button buttoneght,buttonnign,buttonadd,buttonmin,buttonmul,buttondiv,buttcancel,buttequals,Back;
    Button buttongraph;
    String optr;
    int op2,op1;
    EditText disp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        buttequals=(Button)findViewById(R.id.equal);
         buttondiv=(Button)findViewById(R.id.div);
        buttonmul=(Button)findViewById(R.id.mul);
       buttonmin =(Button)findViewById(R.id.sub);
       buttoneght =(Button)findViewById(R.id.eight);
        buttonone=(Button)findViewById(R.id.one);
        buttontwo=(Button)findViewById(R.id.two);
        buttcancel=(Button)findViewById(R.id.cancel);
       buttonnign =(Button)findViewById(R.id.nine);
        buttonadd=(Button) findViewById(R.id.add);
        buttonsev=(Button)findViewById(R.id.seven);
        buttonsix=(Button)findViewById(R.id.six);
        Back=(Button) findViewById(R.id.back);
        buttonfiv=(Button)findViewById(R.id.five);
        buttonfour=(Button)findViewById(R.id.four);
        disp=(EditText) findViewById(R.id.display);
        buttonzero=(Button) findViewById(R.id.zero);
       buttonthr =(Button)findViewById(R.id.three);
        buttongraph=(Button)findViewById(R.id.buttongraph);
        Back.setOnClickListener(this);
        buttonmul.setOnClickListener(this);
        buttonadd.setOnClickListener(this);
        buttongraph.setOnClickListener(this);
        buttondiv.setOnClickListener(this);
        buttonmin.setOnClickListener(this);
        buttoneght.setOnClickListener(this);
        buttonone.setOnClickListener(this);
        buttontwo.setOnClickListener(this);
        buttonnign.setOnClickListener(this);
        buttonsev.setOnClickListener(this);
        buttonsix.setOnClickListener(this);
        buttonfiv.setOnClickListener(this);
        buttonfour.setOnClickListener(this);
        buttonthr.setOnClickListener(this);
        buttonzero.setOnClickListener(this);
        buttcancel.setOnClickListener(this);
        buttequals.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Editable str =  disp.getText();
        switch(view.getId()){
            case R.id.zero:
                str = str.append(buttonzero.getText());
                disp.setText(str);
                break;
            case R.id.one:
                 str = str.append(buttonone.getText());
                disp.setText(str);
                break;
            case R.id.two:

                str = str.append(buttontwo.getText());
                disp.setText(str);
                break;
            case R.id.three:

                str = str.append(buttonthr.getText());
                disp.setText(str);
                break;
            case R.id.four:

                str = str.append(buttonfour.getText());
                disp.setText(str);
                break;
            case R.id.five:

                str = str.append(buttonfiv.getText());
                disp.setText(str);
                break;
            case R.id.six:

                str = str.append(buttonsix.getText());
                disp.setText(str);
                break;
            case R.id.seven:

                str = str.append(buttoneght.getText());
                disp.setText(str);
                break;
            case R.id.eight:

                str = str.append(buttonnign.getText());
                disp.setText(str);

                break;
            case R.id.nine:
                  str = str.append(buttonzero.getText());
                disp.setText(str);
                break;
            case R.id.cancel:
                op1 = 0;
                op2 = 0;
                disp.setText("");
                disp.setHint("Do some Operation ");

                break;
            case R.id.add:
                optr = "+";
                op1 = Integer.parseInt(disp.getText().toString());
                disp.setText("");

                if(op2 != 0){
                        op2 = 0;
                        disp.setText("");
                    }
                else{
                    /*op2 = Integer.parseInt(disp.getText().toString());
                    disp.setText("");
                    op1 = op1 + op2;
                    disp.setText("Result : " + Integer.toString(op1));*/
                }
                break;
            case R.id.sub:
                optr = "-";
                   op1 = Integer.parseInt(disp.getText().toString());
                disp.setText("");
                if(op2 != 0){
                        op2 = 0;
                        disp.setText("");
                    }

                  else{
                   /* op2 = Integer.parseInt(disp.getText().toString());
                    disp.setText("");
                    op1 = op1 - op2;
                    disp.setText("Result : " + Integer.toString(op1));*/
                }
                break;
            case R.id.mul:
                optr = "*";
                   op1 = Integer.parseInt(disp.getText().toString());
                disp.setText("");
                if(op2 != 0){
                    op2 = 0;
                    disp.setText("");
                  }
                else{
                   /* op2 = Integer.parseInt(disp.getText().toString());
                    disp.setText("");
                    op1 = op1 * op2;
                    disp.setText("Result : " + Integer.toString(op1));*/
                }
                break;
            case R.id.div:
                optr = "/";
                 op1 = Integer.parseInt(disp.getText().toString());
                disp.setText("");
                if(op2 != 0){
                    op2 = 0;
                    disp.setText("");
                }
                else{
                   /* op2 = Integer.parseInt(disp.getText().toString());
                    disp.setText("");
                    "Result : " +op1 = op1 / op2;
                    disp.setText("Result : " + Integer.toString(op1));*/
                }
                break;
            case R.id.equal:
                op2 = Integer.parseInt(disp.getText().toString());
                if(!optr.equals("")){
                    if(op2 != 0){
                        if(optr.equals("+")){
                            disp.setText("");
							op1 = op1 + op2;
                            disp.setText(Integer.toString(op1));
                        }
                        else if(optr.equals("-")){
                            disp.setText("");
							op1 = op1 - op2;
                            disp.setText(Integer.toString(op1));

                        }
                        else if(optr.equals("*")){
                            disp.setText("");
							op1 = op1 * op2;
                            disp.setText(Integer.toString(op1));

                        }
                        else if(optr.equals("/")){
                            disp.setText("");
							op1 = op1 / op2;
                            disp.setText(Integer.toString(op1));
                        }
                        optr="";
                        op2=0;
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Enter Secound Number", Toast.LENGTH_LONG).show();
                    }
                }
                break;
            case  R.id.buttongraph:
              Intent intentgraph=new Intent(Calculator.this, Graphiks.class);
                startActivity(intentgraph);
                break;
            case  R.id.back:
               finish();
                break;
        }


    }
}
