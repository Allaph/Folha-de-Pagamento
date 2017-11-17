package folhadepagamento.cursoandroid.com.folhadepagamento;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText nomeFuncionario;
    private Button acessarFolha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nomeFuncionario = (EditText) findViewById(R.id.nomeFuncionarioId);
        acessarFolha = (Button) findViewById(R.id.acessarFolhaId);

        acessarFolha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomeDigitado = nomeFuncionario.getText().toString();
                if (nomeDigitado.isEmpty()){
                    Validator.validateNotNull(nomeFuncionario, "Preencha o campo nome");
                }else{
                    startActivity(new Intent(MainActivity.this, FolhaDePagamentoActivity.class));
                }
            }
        });

    }
}
