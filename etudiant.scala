class Etudiant(nomEtu:String, prenomEtu:String,ageEtu:Int,adresseEtu:String) {
    var nom: String=nomEtu
    var prenom: String=prenomEtu
    var age: Int=ageEtu 
    var adresse: String=adresseEtu
    def changeAge(newAge:Int)
    {
        age=newAge
    }
    def changeAdresse(newAdresse:String)
    {
        adresse=newAdresse
    }
    override def toString():String=nom+" "+prenom+" "+age+" "+adresse
}
// class note(numero etudiant, nom du module, la note)
class Note(numEtu:Int, nomMod:String, notes:Int){
    var numero: Int=numEtu
    var module: String=nomMod
    var note: Int=notes
    def changeNote(newNote:Int)
    {
        note=newNote
    }
    override def toString():String="L'étudiant "+numero+" en "+module+" a eu "+note
}
object STID2{
    def main(args: Array[String]) {
        val etudiant1 = new Etudiant("Jean", "Philippe", 20, "15 rue de niort, 79000")
        println(etudiant1.nom+" "+etudiant1.age)
        etudiant1.changeAge(21);
        println(etudiant1.nom+" "+etudiant1.age)
        etudiant1.changeAge(22);
        println(etudiant1.nom+" "+etudiant1.age)
        etudiant1.changeAdresse("14 rue de Poitiers");
        println(etudiant1.nom+" "+etudiant1.age)
        println(etudiant1.toString())
        // un 2eme objet
        val etudiant2= new Etudiant("zoe", "lavieille", 19, "5 rue du Galuchet niort, 79000")
        etudiant2.changeAdresse("395 rue de la Vanille")
        println(etudiant2.toString())
        val note1= new Note(1,"mathématiques",17)
        println(note1.toString())
    }
}