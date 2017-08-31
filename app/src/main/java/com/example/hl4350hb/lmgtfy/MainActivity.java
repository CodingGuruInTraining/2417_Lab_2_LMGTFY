package com.example.hl4350hb.lmgtfy;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button webSearchButton = (Button) findViewById(R.id.google_search_button);
        final EditText webSearchBox = (EditText) findViewById(R.id.google_search_box);
        final TextView confirmSearchText = (TextView) findViewById(R.id.show_search_text);

        webSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchString = webSearchBox.getText().toString();
                confirmSearchText.setText("Searching for " + searchString);

                Toast.makeText(MainActivity.this, "Searching for " + searchString, Toast.LENGTH_LONG).show();

                String uriText = "https://www.google.com/search?q=" + searchString;
                Uri searchUri = Uri.parse(uriText);

                Intent browserIntent = new Intent(Intent.ACTION_VIEW, searchUri);
                startActivity(browserIntent);
            }
        });
    }
}
