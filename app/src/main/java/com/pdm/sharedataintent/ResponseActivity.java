package com.pdm.sharedataintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.pdm.sharedataintent.databinding.ActivityResponseBinding;

public class ResponseActivity extends AppCompatActivity {

    private ActivityResponseBinding reponseBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        reponseBinding = ActivityResponseBinding.inflate(getLayoutInflater());
        View view = reponseBinding.getRoot();
        setContentView(view);

        Bundle extras = getIntent().getExtras();

        if ( extras != null) {
            reponseBinding.nomeTv.setText( extras.getString("nome")  );
            reponseBinding.idadeTv.setText(  extras.getString("idade"));
        }
    }
}