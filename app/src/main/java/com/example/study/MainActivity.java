package com.example.study;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private TextWatcher watcher;

    public static void start(Context context, int layoutId) {
        Intent starter = new Intent(context, MainActivity.class);
        starter.putExtra(TAG, layoutId);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Intent starterIntent = getIntent();
        final int layoutId = starterIntent.getIntExtra(TAG, R.layout.activity_main);

        setContentView(layoutId);

        Log.i(TAG, "onCreate: ");

        final ViewGroup container = findViewById(R.id.container_view);
        Log.i(TAG, "onCreate: ");

        Button buttonProbe = findViewById(R.id.button_probe);
        buttonProbe.setOnClickListener(this::handleButtonProbeClick);

        TextView textView = findViewById(R.id.text_view_1);

        EditText editText = findViewById(R.id.edit_text);
        
        editText.addTextChangedListener(createWatcher(textView));

         watcher = createWatcher(buttonProbe);

        editText.addTextChangedListener(watcher);
        

    };

    public TextWatcher createWatcher (TextView element) {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                element.setText(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
    }
    
    public void handleButtonProbeClick(View v) {
        {
            TextView textView = findViewById(R.id.text_view_1);
            Log.i(TAG, "onClick + OnCreate ");
            EditText editText = findViewById(R.id.edit_text);
            editText.removeTextChangedListener(watcher);

            final String text = textView.getText().toString();
            Log.i(TAG, "handleButtonProbeClick: click");
            Log.i(TAG, "text: " + text);
            Toast.makeText(MainActivity.this, "Hello", Toast.LENGTH_LONG).show();
        }
    };

}