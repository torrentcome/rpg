package torrentcome.team.rgp.def

import torrentcome.team.rgp.R

data class Item(var space: Int, var attack: Int, var defence: Int, var hp: Int, var sp: Int)

enum class RACE(var id : Int) { HUMAN(R.drawable.human), ELF(R.drawable.elf), DWARF(R.drawable.dwarf) }
enum class GROUP { WARRIOR, PRIEST, ROGUE, WIZARD }

data class Natural(var strenght: Int, var widsom: Int, var charisma: Int, var dexterity: Int)

data class Hero(
    var race: RACE = RACE.HUMAN,
    var group: GROUP = GROUP.WARRIOR,
    var leftHand: Item? = null,
    var rightHand: Item? = null,
    var natural: Natural = Natural(
        strenght = 10,
        widsom = 10,
        charisma = 10,
        dexterity = 10
    )
)