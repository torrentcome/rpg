package torrentcome.team.rgp

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import torrentcome.team.rgp.def.GROUP
import torrentcome.team.rgp.def.Hero
import torrentcome.team.rgp.def.RACE

class ChooseYourHeroActivity : AppCompatActivity() {

    private lateinit var model: HeroViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_your_hero)

        model = ViewModelProvider(this).get(HeroViewModel::class.java)

        val heroObserver = Observer<Hero> { newHero ->
            findViewById<LinearLayout>(R.id.characteristics).removeAllViews()

            val text0 = TextView(this)
            text0.text = "Strenght " + newHero.natural.strenght
            colorText(text0, newHero.natural.strenght)
            findViewById<LinearLayout>(R.id.characteristics).addView(text0)

            val text1 = TextView(this)
            text1.text = "Charisma " + newHero.natural.charisma
            colorText(text1, newHero.natural.charisma)
            findViewById<LinearLayout>(R.id.characteristics).addView(text1)

            val text2 = TextView(this)
            text2.text = "Dexterity " + newHero.natural.dexterity
            colorText(text2, newHero.natural.dexterity)
            findViewById<LinearLayout>(R.id.characteristics).addView(text2)

            val text3 = TextView(this)
            text3.text = "Widsom " + newHero.natural.widsom
            colorText(text3, newHero.natural.widsom)
            findViewById<LinearLayout>(R.id.characteristics).addView(text3)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                findViewById<ImageView>(R.id.image).setImageDrawable(getDrawable(newHero.race.id))
            }
        }

        model.heroO.observe(this, heroObserver)

        RACE.values().forEach {
            val radioButton = RadioButton(this)
            radioButton.text = it.name
            findViewById<RadioGroup>(R.id.race).addView(radioButton)
            radioButton.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) model.setRace(it)
            }
        }

        GROUP.values().forEach {
            val radioButton = RadioButton(this)
            radioButton.text = it.name
            findViewById<RadioGroup>(R.id.group).addView(radioButton)
            radioButton.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) model.setGroup(it)
            }
        }
    }

    private fun colorText(text0: TextView, va: Int) {
        if (va > 10) {
            text0.setTextColor(Color.GREEN)
        } else if (va < 10) {
            text0.setTextColor(Color.RED)
        }
    }
}