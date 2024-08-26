package com.example.mascotas.menus;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mascotas.MainActivity;
import com.example.mascotas.R;
import com.example.mascotas.mail.MailSender;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import javax.mail.MessagingException;

public class Contacto extends AppCompatActivity {

    private TextInputLayout textInputNombre;
    private TextInputLayout textInputCorreo;
    private TextInputLayout textInputMensaje;
    private TextInputEditText editNombre;
    private TextInputEditText editCorreo;
    private TextInputEditText editMensaje;
    private Button botonEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_contacto);

        Toolbar toolbar = findViewById(R.id.miActionBar3);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        textInputNombre = findViewById(R.id.textInputNombre);
        textInputCorreo = findViewById(R.id.textInputCorreo);
        textInputMensaje = findViewById(R.id.textInputMensaje);
        editNombre = findViewById(R.id.textInputEditNombre);
        editCorreo = findViewById(R.id.textInputEditCorreo);
        editMensaje = findViewById(R.id.textInputEditMensaje);
        botonEnviar = findViewById(R.id.boton);

        botonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validarCampos()) {
                    enviarCorreo();
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private boolean validarCampos() {
        boolean esValido = true;

        if (editNombre.getText().toString().trim().isEmpty()) {
            textInputNombre.setError("Este campo es obligatorio");
            esValido = false;
        } else {
            textInputNombre.setError(null);
        }

        if (editCorreo.getText().toString().trim().isEmpty()) {
            textInputCorreo.setError("Este campo es obligatorio");
            esValido = false;
        } else {
            textInputCorreo.setError(null);
        }

        if (editMensaje.getText().toString().trim().isEmpty()) {
            textInputMensaje.setError("Este campo es obligatorio");
            esValido = false;
        } else {
            textInputMensaje.setError(null);
        }

        return esValido;
    }

    private void enviarCorreo() {
        String nombre = editNombre.getText().toString().trim();
        String correo = editCorreo.getText().toString().trim();
        String mensaje = editMensaje.getText().toString().trim();

        /* Tener presente que se debe tener habilitado el acceso a "aplicaciones poco seguras" en GMAIL */
        final String fromEmail = ""; //Acá ingresar el correo electrónico
        final String fromPassword = ""; //Acá ingresar la contraseña
        String subject = "Contacto desde la app de prueba";
        String messageBody = "Nombre: " + nombre + "\nCorreo: " + correo + "\nMensaje: " + mensaje;

        AsyncTask<Void, Void, Boolean> task = new AsyncTask<Void, Void, Boolean>() {
            @Override
            protected Boolean doInBackground(Void... params) {
                try {
                    MailSender sender = new MailSender(fromEmail, fromPassword);
                    sender.sendMail(correo, subject, messageBody);
                    return true;
                } catch (MessagingException e) {
                    Log.e("SendMail", "Error al enviar el correo: " + e.getMessage(), e);
                    e.printStackTrace();
                    return false;
                }
            }

            @Override
            protected void onPostExecute(Boolean success) {
                if (success) {
                    Toast.makeText(Contacto.this, "Correo enviado correctamente", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Contacto.this, "Error al enviar el correo", Toast.LENGTH_SHORT).show();
                }
                finish();

                Intent intent = new Intent(Contacto.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        };

        task.execute();
    }
}