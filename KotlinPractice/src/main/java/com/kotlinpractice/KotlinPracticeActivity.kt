package com.kotlinpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_kotlin_practice.*
import kotlin.random.Random

private const val TAG = "KotlinPracticeActivity"

class KotlinPracticeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_practice)
        printHelloWorld()
        displayString()
        randomNumberDemo()
        displayVariableType()
        typeConversions()
        handleNullables()
        listDemos()
        arrayListDemo()
        lambdaPractice()
        aboutExtensions()
        genericsPractice()
        typeCastingPractice()
        lateInitPractice()
        dataClassPractice()
        enumClassesPractice()
        sealedClassesPractice()
        nestedClassessPractice()

    }


    private fun printHelloWorld() {
        println("Hello World")
        var name = "Chandra"
        println("Hello $name")
        helloWorld_tv.text = "Hello $name"
    }


    fun displayString() {
        var message = "Hello world "
        println(message)

        /*
           A String can contain any letter, number ,character or symbol but it should not contain double quote and backslash\.
          If a string contains double quotes , they need to be escaped
          A character is escaped with a backslash \
          “The answer is \”yes\” so u can proceed
         */
        var stringWithDoubleQuotes = "This is \"string info \" with double quotes"
        println(stringWithDoubleQuotes)
        doubleQuote_tv.text = stringWithDoubleQuotes

        var stringWithBackSlash =
            "This is \\ string with Backslash and no need to escape forward slash/"
        println(stringWithBackSlash)
        backslash_tv.text = stringWithBackSlash

        var bunny = "Bunny is::\n(\\(\\ \n(-.-)\no_(\")(\")"
        bunny_tv.text = bunny
        var isSame = false
        isSame = stringWithDoubleQuotes.compareTo(stringWithBackSlash) == 0

        println("using CompareTo fncn b/w String ${isSame}")

        val client = "Mary"
        val products = 3
        val price = 30
        println("$client needs to pay a total of ${products * price}")

    }

    fun randomNumberDemo() {
        println(Random.nextInt())
        println(Random.nextInt(10))
        println(Random.nextInt(10, 20))
    }


    fun displayVariableType() {
        var integerTypeNumber = 7
        var pi = 3.144444444
        var large = 73500000000
        var myDouble = 22.22

        println(integerTypeNumber::class.java)
        println(pi::class.java)
        println(large::class.java)
        println(myDouble::class.java)

        //Declaring long and float explicitly
        var floatNum = 10.09F
        val longInfo = 123L

        println(floatNum::class.java)

        println(longInfo::class.java)


    }


    fun typeConversions() {
        var months = 12
        var longMonths = months.toLong()
        println(longMonths::class.java)
    }

    private fun handleNullables() {
        //Safecall
        var name: String? = "Chandra"
        println("Name length is ${name?.length}")
        //Elvis
        name = null
        println("Name length is ${name?.length ?: 0}")

        name = "Hello"
        println("Not null Assertion ${name!!.length}")
    }


    private fun listDemos() {
        println("Printing Lists ..........")
        val colorsList = listOf("Red", "Green", "blue", "Yellow", "blue")
        val newColrList = listOf("Red", "Green")
        println("$colorsList and its size is ${colorsList.size}")
        println(
            "$colorsList contains  all elements of $newColrList  using ${colorsList.containsAll(
                newColrList
            )}"
        )
        println("List contains ${colorsList.contains("Red")}")
        println("Retrieving elements of the list colorsList[1] ${colorsList[1]}")
        println("Retrieving elements of the list using get colorsList.get(1) ${colorsList.get(1)}")


        //If we need to create Empty list we need to specify type
        var emptyColorList = listOf<String>()
        println("Empty List $emptyColorList")

        val nullList = listOf("Red", "Green", null, "blue")
        println("NullableList $nullList  index of Red is ${nullList.indexOf("Red")}")
        println("Last Index of ${colorsList.lastIndexOf("blue")}")
    }

    private fun arrayListDemo() {
        // Its mutable list. Elements can be added/removed
        // All list fncs are available for ArrayList except some.
        val arrayListDemo = arrayListOf<String>("Blue", "Green", "REd")
        println("ArrayList ${arrayListDemo}")
        println("Added Elements ::: ${arrayListDemo.add("white")} \n Elements ${arrayListDemo}")
        println(
            "Removed Elements ::: ${arrayListDemo.remove("white")}\n" +
                    " Elements ${arrayListDemo}"
        )
        println(
            "Removed Elements  by Index:::removeAt(0) ${arrayListDemo.removeAt(0)}\n" +
                    " Elements ${arrayListDemo}"
        )

        val items = arrayListOf("pen", "phone", "paper", "mug", "table")
        val toBeRemoved = listOf("pen", "phone", "paper")
        items.removeAll(toBeRemoved)
        println("Remove ${toBeRemoved} and final removed items  as follows:::  $items")

        var arrayListFncn = arrayListOf<String>("Blue", "Green", "Yellow", "pink")
        println(" Original $arrayListFncn")
        arrayListFncn.set(0, "Red")
        println("After adding element at  0th position$arrayListFncn")

        val subList = arrayListFncn.subList(0, 2)
        println("SubList $subList")

        //Clear fncn clears all elements
        println("Clearing:: ${subList.clear()} $subList")
        println("is $subList empty ${subList.isEmpty()}")
    }


    private fun lambdaPractice() {
        //Lambda fncns are the fncns that don't have name. They are kind of Anonymous fncns.
        // Ex: val myLambda = {name : String -> println("Hello $name")}
        // The above Lambda variable can be passed as argument to  fncn which is called Higher Order fncn
        //HigherOrderFncs :
        println("In Lambda Practice::::::::::::::::::::::::::::")
        val myLambda = { name: String -> println("Hello\t$name") }
        val myArrayList = arrayListOf<String>("Red", "Blue", "Green")
        higherOrderFncn(myArrayList, myLambda)

        //2nd way of passing Lamda
        myArrayList.add("Yellow")
        higherOrderFncn(myArrayList) { name: String -> println("Hello\t$name") }

        higerOrderFncnExample2(
            arrayListOf<Int>(
                20,
                30,
                32,
                43,
                21,
                10,
                7,
                4,
                5
            )
        ) { myNumber: Int -> println("Even Number $myNumber") }


        hOFExample3(
            arrayListOf(
                "Client1",
                "Client2",
                "Client3",
                "Client4",
                "Client5",
                "Client6"
            )
        ) { name: String -> ("Hello $name") }

        commonHOF()
        higherOrderFncnPractice()
    }


    private fun higherOrderFncn(names: ArrayList<String>, lamdaFncn: (String) -> Unit) {

        for (name in names) {
            lamdaFncn(name)
        }
    }


    private fun higerOrderFncnExample2(numbs: ArrayList<Int>, lambdaFncn: (Int) -> Unit) {
        println("Higher Order Fncn with Even Numbers :::::::::::::::::::")
        for (numb in numbs) {
            if (numb % 2 == 0) {
                lambdaFncn(numb)
            }
        }
        println("Higher Order Fncn with Number divided by 10 :::::::::::::::::::")
        for (numb in numbs) {
            lambdaFncn(numb / 10)
        }
    }


    private fun hOFExample3(clients: ArrayList<String>, lambdaFncn: (String) -> String) {
        println("Client Info before Update $clients")
        for (i in 0 until clients.size) {
            clients[i] = lambdaFncn(clients.get(i))
        }
        println("Client Info Update $clients")
    }

    private fun commonHOF() {
        println("Common Higher ORder fncs::::::::")
        // Common Higher order fncns . The above fncs are manually implemented, but Kotlin provides
        //some common higher order fncns
        // forEach{} is such  higher order fncn provided by Kotlin
        val list =
            arrayListOf<String>("JOHN", "Kevin", "Mic", "CHANDRA", "MSDhoni", "Peterson", "Kumble")

        list.forEach { println("Hello $it") }


        //Filter Higher order fncn
        println("Filter Higher ORder Fncn......")

        list.filter { it.length < 5 }
            .forEach { println("List of Names filtered with length less than 5 $it") }


        //Map: Creates a new Collection based on the lambda that is provided in collection
        val sizes = list.map { it.length }
        println("Size of Names $sizes")

        //SortedBy: Is another HOF that returns new collection based on condition
        val sortedList = list.sortedBy { it.length }
        println("Sorted List using sortedBy $sortedList")
    }

    private fun higherOrderFncnPractice() {
        val ints = arrayListOf<Int>(23, 234, 54, 67, 78, 445)
        println("Ints before updation $ints")
        for (i in 0 until ints.size) {
            if (ints[i] % 2 == 0) {
                ints[i] = ints[i] / 2
            } else if (ints[i] % 2 == 1) {
                ints[i] = ints[i] * 2
            }

        }
        println("Ints after updation $ints and ints greater than 25 is ${ints.filter { it > 25 }}")


    }


    private fun aboutExtensions() {
        println("About Extensions ..............................................")
        //Allows us to extend a class   that we don't own or cannot modify it

        // Extension fncns provides the ability to extend a class with new functionality without having to inherit it
        // Added functionality is available in the current programm only not in other projects/programs
        // We can extend Functions, Properties, Companion Objects


        //The original class is not actually modified .
        // It's shortcut to make fncns available using the usual object.function notation

        println("abc".slimm())
        println("abc".someLength)
        val list = arrayListOf<String>("abc", "def", "efg", "pink")
        println("ArrayList Extension fncnc ${list.getNUmberOfElements()}")

        companionObjectExtensions()
    }

    //Extension Function
    fun String.slimm() = this.substring(1, length - 1)

    //Extension Property
    //Can only use Val not Var
    private val String.someLength: Int
        get() {
            println("Extension PRoperty.....")
            return 600
        }

    //Extension for ArrayList that returns the number of elements
    fun ArrayList<String>.getNUmberOfElements() = this.size


    private fun companionObjectExtensions() {
        //If a class has companion objects , we can extend or add functions to that class
        println("Companion Object Extensions .....")
        Book.addBook()
        println("Companion extension fncnc for double ${Double.getClassName()}")
    }

    class Book {
        companion object {

        }
    }

    fun Book.Companion.addBook() {
        println("Added Book fncn to Companion Object")
    }

    fun Double.Companion.getClassName() = "This is the Double Class"

    fun genericsPractice() {
        //Generics allow to make class generic that accepts any types of parameters.To pass generic type parameters to class
        //Generic Parameters allow to restrict a class to accept only certain types of parameters
        println("Generics Practice::::::::::::::::")
        val box = Box<String>()
        box.displayInfo("This is my Box of type String")
        val intBox = Box<Int>()
        intBox.displayInfo(20)
        val arrayListBox = Box<ArrayList<String>>()
        arrayListBox.displayInfo(arrayListOf("Hi", "Hello", "John", "Kevin"))
        val arrayIntListBox = Box<ArrayList<Int>>()
        arrayIntListBox.displayInfo(arrayListOf(1, 2, 3, 4, 5, 6))

        println("Generic Parameters Example :::::::")
        var geometry = Geometry<Square>()
        geometry.printArea(Square(), 20)

        var geo1 = Geometry<Circle>()
        geo1.printArea(Circle(), 30)
    }

    class Box<T> {
        fun displayInfo(info: T) {
            println("Converting argument to string ${info.toString()} and the argument is ${info}")
        }
    }

    abstract class Shape {
        abstract fun getArea(size: Int)
    }

    class Square : Shape() {
        override fun getArea(size: Int) {
            println("Square Area is ${size * size}")
        }

    }

    class Circle : Shape() {
        override fun getArea(size: Int) {
            println("Circle  Area is ${size * size * 3.1415}")
        }
    }

    class Geometry<T : Shape> {
        fun printArea(shape: T, size: Int) {
            shape.getArea(size)
            //  println("Area of the Shape is ${shape.getArea(size)}")
        }
    }

    //Type Casting
    //is -> Specifies an object is of certain type
    //as -> Allows an object to convert to different type
    //as? -> Null safety operator
    private fun typeCastingPractice() {
       val animals = getAnimals()
        animals.forEach {
            (it as? Cat)?.purr()
            (it as? Dog)?.bark()

        }

    }

    abstract class Animal {

    }

    class Cat : Animal() {
        fun purr() {
            println("In Purr fncn of Cat class")
        }
    }

    class Dog : Animal() {
        fun bark() {
            println("In Bark fncn of Dog class")
        }
    }

    fun getAnimals(): ArrayList<Animal> {
        val animals: ArrayList<Animal> = arrayListOf()
        for (i in 1..10) {
            animals.add(
                if (Random.nextInt() % 2 == 0)
                    Dog()
                else
                    Cat()

            )
        }
        return animals
    }

   private lateinit var  message : String
    private fun lateInitPractice(){
      message = fetchPrimeNumbers(arrayListOf(1,2,3,5,7,11,13,17,19))
        println(message)
        // Lazy Practice
        val bannedUserNameList = arrayListOf<String>("Micheal","Robert","Tom")
        val toBeCreateUserName : String = "Alice"
        if(!bannedUserNameList.contains(toBeCreateUserName)){
            val user : NewUser by lazy { NewUser(toBeCreateUserName)}
            user.printWelcomeMessage()
        }
    }

    private fun fetchPrimeNumbers(list : ArrayList<Int>) : String{
        val listSize = list.size
        val listPostion = Random.nextInt(listSize)
      //  return "Randomly Generated Prime Number ${list[listPostion].toString()}"
        return "Randomly Generated Prime Number ${list.random().toString()}"
    }

    class NewUser (userName : String){
        var name = userName
         fun printWelcomeMessage(){
             println("Hello $name")
         }
    }

    private fun dataClassPractice(){
        val blogList =  arrayListOf<Blog>()
        blogList.add(Blog("title1","content1", 10))
        blogList.add(Blog("title2","content2", 20))
        blogList.add(Blog("title3","content3", 30))

       println("original blog List $blogList")

        val blog1 = blogList[1].copy(title="newTitle3")
        val blog2 = blogList[2].copy(title = "newTitle2")

        blogList.add(blog1)
        blogList.add(blog2)


        println("Updated blog List $blogList")

    }
    data class Blog (val title : String, val content:String , val numberOfUsers : Int )


    private fun enumClassesPractice(){
        //Enum classes define a collection of constants
        //The constants are defined as objects
        println("${fetchMedal(1)}")
        println("${fetchMedal(2)}")
        println("${fetchMedal(3)}")
        println("${fetchMedal(4)}")

        println("Positon based on Medal won ${Medals.GOLD.name} and position ${Medals.GOLD.ordinal +1 } and calling fetchPosition for Broonze ${fetchPositon(Medals.BROONZE)}")

    }

    private fun fetchPositon(medal : Medals) : Int {
        return  medal.positon
    }
    private fun fetchMedal(positon : Int) : Medals{
        return when(positon){
            1 -> Medals.GOLD
            2 -> Medals.SILVER
            3 -> Medals.BROONZE
            else -> Medals.NONE
        }
    }
   enum class Medals(val positon: Int){
       GOLD(1),
       SILVER(2),
       BROONZE(3),
       NONE(4)
   }

    private fun sealedClassesPractice(){
        //Sealed classes are similar to Enums , but they define restricted hierarchy
        //We can use sealed classes to check whether an object is certain type or not
        //Sealed classes can't be instantiated, they can be extended as they r abstract
        //They r useful in 'When' expressions
        println("In Sealed Classes ::::::::::::::::::::::::::::::")
        val prize = fetchPrize()
        when(prize){
            is Vacation -> println("On Vacation")
            is Car -> println("On Car")
            is GiftCard -> println("On GiftCard")
        }
    }



fun fetchPrize(): Prizes{

    val prizeNum = Random.nextInt(3)
    println("Prize Number $prizeNum")
    return when(prizeNum){
       0 ->   BMV()
       1 ->   NewYork()
       else -> AmexCard()
   }
}



    private fun nestedClassessPractice(){
        Computer().bootUp()
    }


}

class Computer{
    private  val os = OperatingSystem()
   fun bootUp(){
       println("Computer Boots up")
       os.printOperatingSystemStatus()
       println("Computer is Ready")
   }

    private  inner class  OperatingSystem{
           fun printOperatingSystemStatus(){
               println("Operating System is Ready")
           }
    }

}
sealed class Prizes
sealed class Car : Prizes() {}
sealed class Vacation : Prizes(){}
sealed class GiftCard : Prizes(){}

class BMV : Car(){
     fun printMessage() = println("This is Car")
}
class  NewYork : Vacation(){
    fun printMessage() = println("This is Vacation")
}
class  AmexCard: GiftCard(){
    fun printMessage() = println("This is GiftCard")
}
//Variable Names:
//A Variable NAme can contains letters , digits and underscores
//A variable cannot contains spaces
//Names of Variables can start with letter or _  but  not number.
//  A Variable name cannot be key word
// Naming Convention - camelCase . Ex: var userName = "Abc"

//Constants:
//Constants are values that don't change. Available at compile time and can't be changed during execution
//Declared outside the functions

//Number Types
//Bytes = 8bits  short=16bits int=32bits long=64bits float=32bits double=64bits

//Operators
//The type of result  of an operation is same as the type of the largest operand in terms of memory
//Byte < short < int < long < float < double


//Null
//Arithmetic operations cannot be performed on null variables ,they can be performed only on non null variables
//But there is always replacement methods
//Ex: For Non-Null its a + b  where as for null variables a?.plus(b)


//Collections
//A way to group elements together. A collection will have zero or more elements.
// All elements in collections are of same type.

// Iterable <- Collection <-List,set   , Map is independent.
//Collection is type of Iterable and List and set are type of Collection and Map is independent collection with Key/val pairs
//List , set , Map are immutable
//MutableList,MutableSet, MutableMap are Mutable collections
//List: Is ordered collection of items. Elements can be accessed by their position(Index)
//List can contain duplicate elements Ex:[1,2,34,56,76]. All Elements are of Same Type.
//Set: Is a Group of Unique elements. No Duplicate Elements. Order has no significance.
//Map : Is a set of Key/Val pairs . Keys are unique , vals can be duplicate {1=one,2=Two}
//Iterator : Is an object that loops through elements of the collection