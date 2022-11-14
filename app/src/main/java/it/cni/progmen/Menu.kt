package it.cni.progmen

class Menu {

    var creatorId : String? = null
    var titolo: String? = null
    var data: String? = null
    var piatto: String? = null
    var piatto2: String? = null
    var piatto3: String? = null
    var tipo: String? = null
    var tipo2: String? = null
    var tipo3: String? = null
    var ingredienti: String? = null

    constructor(creatorId: String?,titolo: String?,data: String?,piatto: String?,piatto2: String?,piatto3: String?,tipo:String?,
                tipo2:String?,tipo3:String?,ingredienti: String?){

        this.creatorId = creatorId
        this.titolo = titolo
        this.data = data
        this.piatto = piatto
        this.piatto2 = piatto2
        this.piatto3 = piatto3
        this.tipo = tipo
        this.tipo2 = tipo2
        this.tipo3 = tipo3
        this.ingredienti = ingredienti


    }


}