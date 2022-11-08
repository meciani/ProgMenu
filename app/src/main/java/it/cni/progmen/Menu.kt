package it.cni.progmen

class Menu {

    var creatorId : String? = null
    var titolo: String? = null
    var data: String? = null
    var piatto: String? = null
    var tipo: String? = null
    var ingredienti: String? = null

    constructor(creatorId: String?,titolo: String?,data: String?,piatto: String?,tipo:String?,ingredienti: String?){

        this.creatorId = creatorId
        this.titolo = titolo
        this.data = data
        this.piatto = piatto
        this.tipo = tipo
        this.ingredienti = ingredienti


    }


}