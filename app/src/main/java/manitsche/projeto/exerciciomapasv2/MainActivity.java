package manitsche.projeto.exerciciomapasv2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.github.chrisbanes.photoview.PhotoView;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroupEstados;
    RadioButton radioButtonRS, radioButtonSC, radioButtonPR;
    CheckBox checkBoxPopulacao, checkBoxArea, checkBoxIDH, checkBoxNumeroDeMunicipios;
    TextView textViewInformacao;
    Button bSair;
    PhotoView layoutPhotoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroupEstados = findViewById(R.id.radioGroupEstados);
        radioButtonRS = findViewById(R.id.radioButtonRS);
        radioButtonSC = findViewById(R.id.radioButtonSC);
        radioButtonPR = findViewById(R.id.radioButtonPR);
        checkBoxPopulacao = findViewById(R.id.checkBoxPopulacao);
        checkBoxArea = findViewById(R.id.checkBoxArea);
        checkBoxIDH = findViewById(R.id.checkBoxIDH);
        checkBoxNumeroDeMunicipios = findViewById(R.id.checkBoxNumeroDeMunicipios);
        textViewInformacao = findViewById(R.id.textViewInformacao);
        bSair = findViewById(R.id.bSair);
        layoutPhotoView = findViewById(R.id.layoutPhotoView);

        radiobuttonEstadosListener();
        checkboxListener();

        bSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void checkboxListener() {
        CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                atualizaInformacoes();
            }
        };

        checkBoxPopulacao.setOnCheckedChangeListener(listener);
        checkBoxArea.setOnCheckedChangeListener(listener);
        checkBoxIDH.setOnCheckedChangeListener(listener);
        checkBoxNumeroDeMunicipios.setOnCheckedChangeListener(listener);
    }

    public void radiobuttonEstadosListener() {
        radioGroupEstados.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioButtonRS) {
                    layoutPhotoView.setImageResource(R.drawable.rio_grande_do_sul);
                    atualizaInformacoes();
                }
                if (checkedId == R.id.radioButtonSC) {
                    layoutPhotoView.setImageResource(R.drawable.santa_catarina);
                    atualizaInformacoes();
                }
                if (checkedId == R.id.radioButtonPR) {
                    layoutPhotoView.setImageResource(R.drawable.parana);
                    atualizaInformacoes();
                }
            }
        });
    }

    public void atualizaInformacoes() {
        String texto = "";

        if (radioButtonRS.isChecked()) {
            if (checkBoxPopulacao.isChecked()) {
                texto += "População: Aproximadamente 11.422.973 (2020)\n";
            }
            if (checkBoxArea.isChecked()) {
                texto += "Área: Cerca de 281.748 km²\n";
            }
            if (checkBoxIDH.isChecked()) {
                texto += "IDH: 0,774 (2019)\n";
            }
            if (checkBoxNumeroDeMunicipios.isChecked()) {
                texto += "Número de municípios: 497";
            }
        }

        if (radioButtonSC.isChecked()) {
            if (checkBoxPopulacao.isChecked()) {
                texto += "População: Aproximadamente 7.252.502 (2020)\n";
            }
            if (checkBoxArea.isChecked()) {
                texto += "Área: Cerca de 95.736 km²\n";
            }
            if (checkBoxIDH.isChecked()) {
                texto += "IDH: 0,774 (2019)\n";
            }
            if (checkBoxNumeroDeMunicipios.isChecked()) {
                texto += "Número de municípios: 295";
            }
        }

        if (radioButtonPR.isChecked()) {
            if (checkBoxPopulacao.isChecked()) {
                texto += "População: Aproximadamente 11.516.840 (2020)\n";
            }
            if (checkBoxArea.isChecked()) {
                texto += "Área: Cerca de 199.314 km²\n";
            }
            if (checkBoxIDH.isChecked()) {
                texto += "IDH: 0,770 (2019)\n";
            }
            if (checkBoxNumeroDeMunicipios.isChecked()) {
                texto += "Número de municípios: 399";
            }
        }

        textViewInformacao.setText(texto);
    }

}