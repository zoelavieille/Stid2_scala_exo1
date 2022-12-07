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
    override def toString():String=rID+" "+mID+" "+etoile+" "+date
}

object Film{
    def loadMovieData(path:String):Array[Movie]=
    {
        var movies:Array[Movie]=Array.empty
        val bufferedSource = io.Source.fromFile(path)
        for (line <- bufferedSource.getLines){
            var values = line.split(",").map(_.trim)
            val movie = new Movie(values(0).toInt,values(1),values(2).toInt,values(3))
            movies = movies :+ movie
        }
        bufferedSource.close
        return movies;    
    }
     def loadReviewerData(path:String):Array[Reviewer]=
    {
        var reviewers:Array[Reviewer]=Array.empty
        val bufferedSource = io.Source.fromFile(path)
        for (line <- bufferedSource.getLines){
            var values = line.split(",").map(_.trim)
            val reviewer = new Reviewer(values(0).toInt,values(1))
            reviewers = reviewers :+ reviewer
        }
        bufferedSource.close
        return reviewers;    
    }
    def loadRatingData(path:String):Array[Rating]=
    {
        var ratings:Array[Rating]=Array.empty
        val bufferedSource = io.Source.fromFile(path)
        for (line <- bufferedSource.getLines){
            var values = line.split(",").map(_.trim)
            val rating = new Rating(values(0).toInt,values(1).toInt,values(2).toInt,values(3).substring(1,values(3).length()-1))
            ratings = ratings :+ rating
        }
        bufferedSource.close
        return ratings;   
    }
    def ex01_q01(movies:Array[Movie])
    {
        movies.filter(_.director=="\"Steven Spielberg\"").foreach(println)
    }
    
    def ex01_q02(ratings:Array[Rating]):Array[Rating]=
    {
        // rating.filter(_.etoile>3).foreach(x=>println(extractFilm(x.mID,movies)(0)))
        ratings.filter(_.etoile>3)
    }
  
   def extractFilm(p_mID: Int, movies:Array[Movie]): Array[Movie]=
   {
        return movies.filter(_.mID == p_mID)

   }
    def main(args: Array[String]) {        
        var movies : Array[Movie] =loadMovieData("data/movie.csv")
            /*println(movies(0))*/
        var reviewers : Array[Reviewer]=loadReviewerData("data/reviewer.csv")
            /*println(reviewers(0))*/ 
        var ratings : Array[Rating]=loadRatingData("data/rating.csv")
            /*println(ratings(0))*/
            
            /*ex01_q01(movies)*/
            ex01_q02(ratings).map(x=>extractFilm(x.mID,movies)(0).year).distinct.sorted.foreach(println)
            //map =trimap dans taled; et on fait un distinct dans l'ordre croissant 
        println(extractFilm(101,movies))
    }
}

