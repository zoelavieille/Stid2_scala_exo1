import java.text.SimpleDateFormat
import java.util.Date

class Movie(movieID:Int, titre:String, annee:Int, directeur:String){
    var mID: Int=movieID
    var title: String=titre
    var year: Int=annee 
    var director: String=directeur
    def changeTitle(newTitle:String)
    {
        title=newTitle
    }
    def changeYear(newYear:Int)
    {
        year=newYear
    }
    def changeDirector(newDirector:String)
    {
        director=newDirector
    }
    override def toString():String=mID+" "+title+" "+year+" "+director
}

class Reviewer(revueID:Int, nom:String){
    var rID: Int=revueID
    var name: String=nom
    def changeName(newName:String)
    {
        name=newName
    }
    override def toString():String=rID+" "+name
}


class Rating(revueID:Int, movieID:Int, stars:Int, rgDate:String){
   
    var rID: Int=revueID
    var mID: Int=movieID
    var etoile: Int=stars 
    val format = new SimpleDateFormat("yyyy-MM-dd")
    var date = format.parse(rgDate)
    def changeStars(newStars:Int)
    {
        etoile=newStars
    }
    def changeDate(newDate:String)
    {
        date = format.parse(newDate)
    }
    override def toString():String=rID+" "+mID+" "+etoile+" "+format+" "+date
}

object Film{
    def main(args: Array[String]) {
        val film1 = new Movie(1, "yoyo", 2020, "Philippe Lavieille")
        println(film1.toString())
        val revue1 = new Reviewer(1, "coucou")
        println(revue1.toString())
        val rating1 = new Rating(1,1,1,"2018-03-03")
        println(rating1.toString())
        rating1.changeDate("2001-10-15")
        println(rating1.toString())
    }
}