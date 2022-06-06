package com.example.views;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtNome;
    private EditText edtEmail;
    private EditText edtTel;
    private Switch swtWhats;
    private RadioGroup rdgPeriodo;
    private RadioButton rdbManha;
    private RadioButton rdbTarde;
    private RadioButton rdbNoite;
    private CheckBox chkInternet;
    private CheckBox chkTelefone;
    private CheckBox chkTv;
    private CheckBox chkStreaming;
    private Button btnLimpar;
    private Button btnExibir;
    private LinearLayout lblDados;
    private TextView txtNome;
    private TextView txtEmail;
    private TextView txtTelefone;
    private TextView txtWhats;
    private TextView txtPeriodo;
    private TextView txtPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNome = findViewById(R.id.edtNome);
        edtEmail = findViewById(R.id.edtEmail);
        edtTel = findViewById(R.id.edtTelefone);
        swtWhats = findViewById(R.id.swtWhats);
        rdgPeriodo = findViewById(R.id.rdgPeriodo);
        rdbManha = findViewById(R.id.rdbManha);
        rdbTarde = findViewById(R.id.rdbTarde);
        rdbNoite = findViewById(R.id.rdbNoite);
        chkInternet = findViewById(R.id.chkInternet);
        chkTelefone = findViewById(R.id.chkTelefone);
        chkTv = findViewById(R.id.chkTv);
        chkStreaming = findViewById(R.id.chkStreaming);
        btnLimpar = findViewById(R.id.btnCancelar);
        btnExibir = findViewById(R.id.btnOK);

        btnLimpar.setOnClickListener(this);
        btnExibir.setOnClickListener(this);

        lblDados = findViewById(R.id.lblDados);
        txtNome = findViewById(R.id.txtNome);
        txtEmail = findViewById(R.id.txtEmail);
        txtTelefone = findViewById(R.id.txtTelefone);
        txtWhats = findViewById(R.id.txtWhats);
        txtPeriodo = findViewById(R.id.txtPeriodo);
        txtPref = findViewById(R.id.txtPref);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnOK){
            //Toast.makeText(this, "Exibir", Toast.LENGTH_LONG).show();
            lblDados.setVisibility(View.VISIBLE);
            txtNome.setText("Nome: " + edtNome.getText().toString());
            txtEmail.setText(edtEmail.getText().toString());
            txtTelefone.setText(edtTel.getText().toString());
            if (swtWhats.isChecked())
                txtWhats.setText("WhatsApp: " + swtWhats.getTextOn());
            else
                txtWhats.setText("WhatsApp: " + swtWhats.getTextOff());

            int idrdbSelecionado = rdgPeriodo.getCheckedRadioButtonId();
            if (idrdbSelecionado > 0){
                RadioButton rdbSelecionado = findViewById(idrdbSelecionado);
                txtPeriodo.setText("Período: " + rdbSelecionado.getText().toString());
            }

            String pref="";
            if (chkInternet.isChecked())
                pref = chkInternet.getText().toString();
            if (chkTelefone.isChecked()) {
                pref += " ";
                pref += chkTelefone.getText().toString();
            }
            if(chkTv.isChecked()){
                pref += " ";
                pref += chkTv.getText().toString();
            }
            if(chkStreaming.isChecked()){
                pref += " ";
                pref += chkStreaming.getText().toString();
            }
            txtPref.setText("Preferências: " + pref);

        }
        else if (view.getId() == R.id.btnCancelar){
            //Toast.makeText(this,"Limpar", Toast.LENGTH_SHORT).show();
            edtNome.setText("");
            edtEmail.setText("");
            edtTel.setText("");
            swtWhats.setChecked(false);
            rdgPeriodo.clearCheck();
            chkInternet.setChecked(false);
            chkTelefone.setChecked(false);
            chkStreaming.setChecked(false);
            chkTv.setChecked(false);
            lblDados.setVisibility(View.INVISIBLE);
        }
    }
}