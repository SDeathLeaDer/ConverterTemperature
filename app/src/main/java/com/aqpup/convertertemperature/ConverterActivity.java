package com.aqpup.convertertemperature;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import model.Converter;


public class ConverterActivity extends ActionBarActivity {

    private Converter converter;
    private Converter.TypeTemperature typeTemperatureInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convertor);

        final EditText etInput = (EditText)findViewById(R.id.edInput);
        final TextView tvOutput = (TextView)findViewById(R.id.tvOutput);
        RadioGroup rgInput = (RadioGroup) findViewById(R.id.rgInput);
        RadioGroup rgOutput = (RadioGroup) findViewById(R.id.rgOutput);
        converter = new Converter();

        rgInput.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rbCInput:
                        typeTemperatureInput = Converter.TypeTemperature.C;
                        break;
                    case R.id.rbFInput:
                        typeTemperatureInput = Converter.TypeTemperature.F;
                        break;
                    case R.id.rbKInput:
                        typeTemperatureInput = Converter.TypeTemperature.K;
                        break;

                }
            }
        });

        rgOutput.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Double input = Double.valueOf(etInput.getText().toString());
                Double output = null;

                switch (checkedId){
                    case R.id.rbCOutput:
                        output = converter.convert(typeTemperatureInput, Converter.TypeTemperature.C, input);
                        break;
                    case R.id.rbFOutput:
                        output = converter.convert(typeTemperatureInput, Converter.TypeTemperature.F, input);
                        break;
                    case R.id.rbKOutput:
                        output = converter.convert(typeTemperatureInput, Converter.TypeTemperature.K, input);
                        break;

                }

                if(output == null){
                    tvOutput.setText("");
                }else{
                    tvOutput.setText(output.toString());
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_convertor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
