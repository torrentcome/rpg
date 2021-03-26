package torrentcome.team.rgp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val choose = findViewById<Button>(R.id.choose)
        choose.setOnClickListener {
            goToChooseYourHero()
        }
    }

    private fun goToChooseYourHero() {
        this.startActivity(Intent(this, ChooseYourHeroActivity::class.java))
    }
}