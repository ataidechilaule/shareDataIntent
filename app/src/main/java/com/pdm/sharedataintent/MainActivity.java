package com.pdm.sharedataintent;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//importar binding Pacote+databinding+"nome da view"
import com.pdm.sharedataintent.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    //Criar Objecto do binding
    private ActivityMainBinding bindingMain;

    private static final int REQUEST_CODE = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);

        //Instancição
        bindingMain = ActivityMainBinding.inflate(getLayoutInflater());
        //View
        View view = bindingMain.getRoot();
        //Set view
        setContentView(view);
    }

    public void setName (View view){
        //Set de dados no textview resultado, do EditText
        bindingMain.resultadoTv.setText(getString(R.string.bv) + " " + bindingMain.nameEd.getText().toString() );
    }

    public void secondActivity (View view){

        //Criar Intent Explicita
        Intent i = new Intent(this, ResponseActivity.class);

        //Addicionar dados ao Bundle
        i.putExtra("nome", bindingMain.nameEd.getText().toString());
        i.putExtra("idade", "17");

        //Iniciar Segunda Activity
        //startActivity(i);
        startActivityForResult(i, REQUEST_CODE);

    }

    protected void onActivityResult
            (int requestCode, int resultCode, Intent intent) {

        super.onActivityResult(requestCode, resultCode, intent);

        if(requestCode == REQUEST_CODE  && resultCode == RESULT_OK){

            if (intent.hasExtra("resultado")){
                bindingMain.resultadoTv.setText(intent.getStringExtra("resultado"));
            }
        }

    }


}