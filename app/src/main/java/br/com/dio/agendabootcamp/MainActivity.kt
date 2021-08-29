package br.com.dio.agendabootcamp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract
//import android.provider.CalendarContract.CONTENT_URI
import android.provider.CalendarContract.Events.* // Importa tudo
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSetEvent = findViewById(R.id.set_event) as Button
        btnSetEvent.setOnClickListener {

            val intent = Intent(Intent.ACTION_INSERT).setData(CONTENT_URI)
                .putExtra(TITLE, "Bootcamp Santander")
                .putExtra(EVENT_LOCATION, "Online")
                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, System.currentTimeMillis())
                .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, System.currentTimeMillis() + (60 * 60 * 1000)) // convertendo uma hora em milisegundos usando segundos como medida

            startActivity(intent)
        }
    }
}