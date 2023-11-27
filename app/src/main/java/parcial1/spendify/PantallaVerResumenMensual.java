package parcial1.spendify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class PantallaVerResumenMensual extends AppCompatActivity {

    private ArrayList<Double> gastosMensuales; // Supongamos que tienes una lista de gastos mensuales

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_ver_resumen_mensual);

        // Inicializa la lista de gastos mensuales (esto es solo un ejemplo)
        gastosMensuales = new ArrayList<>();
        gastosMensuales.add(100.0); // Reemplaza esto con tus datos reales
        gastosMensuales.add(150.0);

        // Calcula el total de gastos mensuales
        double totalGastosMensuales = calcularTotalGastosMensuales();

        // Muestra el total de gastos mensuales en el TextView correspondiente
        TextView textoTotalGastosMensuales = findViewById(R.id.texto_total_de_gastos_mensuales);
        textoTotalGastosMensuales.setText(getString(R.string.TextView_total_de_gastos_mensuales, totalGastosMensuales));

        // Configura el OnClickListener para el botón "Volver"
        Button botonVolver = findViewById(R.id.boton_volver);
        botonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volverAPantallaIndex();
            }
        });
    }

    private double calcularTotalGastosMensuales() {
        double total = 0.0;
        for (Double gasto : gastosMensuales) {
            total += gasto;
        }
        return total;
    }

    private void volverAPantallaIndex() {
        Intent intent = new Intent(this, PantallaIndex.class);
        startActivity(intent);
        finish(); // Cierra la actividad actual para que no quede en la pila de actividades
    }
}
