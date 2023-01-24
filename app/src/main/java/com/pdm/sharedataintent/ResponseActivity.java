package com.pdm.sharedataintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
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
            reponseBinding.nameTv.setText( getString(R.string.non) + " " + extras.getString("nome")  );
            reponseBinding.idadeTv.setText( getString(R.string.idd)  + extras.getString("idade"));
        }

        //finish();
    }

    public void finish(){
        Intent data = new Intent();
        data.putExtra("resultado", "Nos somos Maus a Android! xD");
        setResult(RESULT_OK,data);
        super.finish();
    }

    public void openweb(View view){

        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://github.com/ataidechilaule"));
        startActivity(intent);

    }



}