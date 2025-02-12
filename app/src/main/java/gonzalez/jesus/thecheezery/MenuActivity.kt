package gonzalez.jesus.thecheezery

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        var btnCold: Button = findViewById(R.id.buttton_cold_drinks) as Button

        var intent: Intent = Intent(this, ProductosActivity::class.java)

        findViewById<Button>(R.id.buttton_cold_drinks).setOnClickListener {
            intent.putExtra("categoria", "coldDrinks")
            startActivity(intent)
        }

        findViewById<Button>(R.id.buttton_hot_drinks).setOnClickListener {
            intent.putExtra("categoria", "hotDrinks")
            startActivity(intent)
        }

        findViewById<Button>(R.id.button_sweets).setOnClickListener {
            intent.putExtra("categoria", "sweets")
            startActivity(intent)
        }

        findViewById<Button>(R.id.buttton_salties).setOnClickListener {
            intent.putExtra("categoria", "salties")
            startActivity(intent)
        }
    }
}