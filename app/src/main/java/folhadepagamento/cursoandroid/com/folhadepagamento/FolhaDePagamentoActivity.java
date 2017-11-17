package folhadepagamento.cursoandroid.com.folhadepagamento;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;


public class FolhaDePagamentoActivity extends AppCompatActivity {

    private EditText horaExtra;
    private EditText faltasMensais;
    private EditText mesReferente;
    private Button calcularValor;
    private TextView valorTotal;
    private EditText salarioFuncionario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_folha_de_pagamento);

        horaExtra = (EditText) findViewById(R.id.horaExtraId);
        faltasMensais = (EditText) findViewById(R.id.faltasMensaisId);
        mesReferente = (EditText) findViewById(R.id.mesReferenteId);
        calcularValor = (Button) findViewById(R.id.calcularTotalId);
        valorTotal = (TextView) findViewById(R.id.pagamentoId);
        salarioFuncionario = (EditText) findViewById(R.id.valorSalarioId);

        calcularValor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String hora = horaExtra.getText().toString();
                String falta = faltasMensais.getText().toString();
                String mes = mesReferente.getText().toString();
                String salario = salarioFuncionario.getText().toString();


                if (salario.isEmpty()) {
                    Validator.validateNotNull(salarioFuncionario, "Preencha o campo salário");
                }else if (hora.isEmpty()){
                    Validator.validateNotNull(horaExtra, "Preencha o campo Horas extras");
                }else if (falta.isEmpty()) {
                    Validator.validateNotNull(faltasMensais, "Preencha o campo faltas no mês");
                }else if (mes.isEmpty()) {
                    Validator.validateNotNull(mesReferente, "Preencha o campo mês referente");
                }else {

                    int valorSalario = Integer.parseInt(salario);

                    int valorHora = Integer.parseInt(hora);
                    int valorTotalHora = (valorHora * 6) + valorSalario;

                    int valorFalta = Integer.parseInt(falta);
                    int valorFaltaPagamento = valorTotalHora - (valorFalta * 30);

                    valorTotal.setText("O salário do funcionario é " + valorFaltaPagamento + " reais.");

                }

            }
        });

    }
}

