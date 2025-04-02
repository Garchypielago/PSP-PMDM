package com.example.recycleview.model

class MainState {
    val pokemonsNames = mutableListOf("Bulbasaur", "Ivysaur", "Venosaur",
                                        "Charmander", "Charmeleon", "Charizard",
                                        "Squirtle", "Wartotle", "Blastoise",
                                        "Pidgey", "Pigeotto", "Pidgeot",
                                        "Ratttata", "Raticate",
                                        "Pichu", "Pikachu", "Raichu", "Vulpix", "Ninetales",
                                        "Aticuno", "Zapdos", "Moltres", "Mew", "Mewtwo")

    fun returnList(): List<String>{
        return pokemonsNames;
    }

    fun delete(position : Int): MyData{
        pokemonsNames.removeAt(position)
        return MyData(position, pokemonsNames)
    }

    fun add(position: Int, name: String): MyData{
        pokemonsNames.add(position, name)
        return MyData(position, pokemonsNames)
    }



}