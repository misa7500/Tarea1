package com.example.rmisael.tarea;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText nombre,  hora, Fraccion ;
    Button Button_hola;
    TextView resultado;
    Integer hora_costo, hora_fracc;
    Calendar Hora;
    int     horaen_h,horaen_m,horasa_h,horasa_m,diferencia_h,diferencia_m,pago_hora,pago_min,pago;
    boolean ban = false,mostrar=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultado = (TextView) findViewById(R.id.Resultado);
        nombre = (EditText) findViewById(R.id.Nombre);
        hora = (EditText) findViewById(R.id.Hora);
        Fraccion = (EditText) findViewById(R.id.Fraccion);
        Button_hola = (Button) findViewById(R.id.Button_hola);
        Button_hola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             /*
                Button_hola.setText("Detener");
                Button_hola.setBackgroundColor(Color.GRAY);
                Button_hola.setText("Hola \n"+nombre.getText().toString());
            */
                Hora=Calendar.getInstance();
                hora_costo = Integer.valueOf(hora.getText().toString());
                hora_fracc = Integer.valueOf(Fraccion.getText().toString());


                    if (ban) {

                        ban = false;
                        Button_hola.setText("Empezar\n");
                        horasa_h = Hora.get(Calendar.HOUR_OF_DAY);
                        horasa_m = Hora.get(Calendar.MINUTE);
                        mostrar = false;


                    } else {
                        ban = true;
                        horaen_h = Hora.get(Calendar.HOUR_OF_DAY);
                        horaen_m = Hora.get(Calendar.MINUTE);
                        Button_hola.setText("Finalizar \n");
                        mostrar = true;
                        resultado.setText(" "+horaen_h+":"+horaen_m);
                    }


                    diferencia_h = horasa_h - horaen_h;
                    diferencia_m = horasa_m - horaen_m;

                if (diferencia_m < 0)
                {
                    diferencia_h =diferencia_h -1;
                    diferencia_m = diferencia_m + 60;
                }

                if(!mostrar) {
                    if (diferencia_m == 0)
                    {
                        pago_min = 0;
                    }
                    else if((diferencia_m /15)==0) {
                        pago_min = (hora_fracc * 1);
                    }
                    else if((diferencia_m /15)==1) {
                        pago_min = (hora_fracc * 2);
                    }
                    else if((diferencia_m /15)==2) {
                        pago_min = (hora_fracc * 3);
                    }
                    else if((diferencia_m /15)==3) {
                        diferencia_h++;
                        diferencia_m = 0;
                    }

                    pago_hora = (hora_costo*diferencia_h);
                    pago = pago_hora+pago_min;

                    if (diferencia_h == 0)
                        pago = pago + hora_costo;

                    resultado.setText("Tiempo Transcurrido en Horas: "+diferencia_h);
                    resultado.append("\nTiempo Transcurrido en Minutos: " + diferencia_m);
                    resultado.append("\nHora inicio"+ horaen_h+":"+horaen_m);
                    resultado.append("\nHora Salida"+ horasa_h+":"+horasa_m);

                    resultado.append("\n**********Por Pagar********** " +
                            "\n************  "+ pago+"  ************" );

                }
            }
        });
    }
}

