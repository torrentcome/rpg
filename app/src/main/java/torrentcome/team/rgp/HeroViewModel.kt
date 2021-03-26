package torrentcome.team.rgp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import torrentcome.team.rgp.def.GROUP
import torrentcome.team.rgp.def.Hero
import torrentcome.team.rgp.def.Natural
import torrentcome.team.rgp.def.RACE

class HeroViewModel : ViewModel() {
    private val _currentHero: MutableLiveData<Hero> by lazy { MutableLiveData<Hero>() }
    val heroO: LiveData<Hero> = _currentHero

    init {
        val hero = Hero()
        _currentHero.postValue(hero)
    }

    fun setRace(it: RACE) {
        val natural = when (it) {
            RACE.HUMAN -> Natural(10, 10, 10, 10)
            RACE.ELF -> Natural(8, 10, 12, 10)
            RACE.DWARF -> Natural(12, 10, 8, 10)
        }
        _currentHero.postValue(Hero(race = it, natural = natural))
    }

    fun setGroup(it: GROUP) {
        when (it) {
            GROUP.WARRIOR -> { }
            GROUP.PRIEST -> { }
            GROUP.ROGUE -> { }
            GROUP.WIZARD -> { }
        }
    }

}
