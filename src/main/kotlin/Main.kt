import java.util.*

fun main(args: Array<String>) {
    //regular expression in kotlin

    println("Hi. Welcome to regular expression console app in Kotlin.\n" +
            "Type a small note below, make sure you include name, gender, email address " +
            "phone number and indicate where you live, in the note.\n" +
            "Use this format: 'My name is __ and I" +
            " (come from) __, my email address is __ and my phone number is __. I am a __(male/female) \n")

    val genderPattern = Regex("(m|fem)(ale)", RegexOption.IGNORE_CASE)
    val namePattern = Regex("name is ([a-zA-Z]+)")
    val placePattern = Regex("come from ([a-zA-Z]+)")
    val emailPattern = Regex("([a-z0-9.]+)@([a-z]+)\\.([a-z]+)\\.?([a-z]+)?")

    //replace with your own phone country code: mine is 07/01/+254
    val numberPattern = Regex("(07|01|\\+254)([0-9]{8})", RegexOption.IGNORE_CASE)

    val scanner:Scanner = Scanner(System.`in`)
    print("So, tell me about yourself > ")
    val input = scanner.nextLine()

    //findAll() returns a set, list of all occurrences
    //val match = genderPattern.findAll(input).iterator()
    //use a for loop to get the values

    //Example test data:
    // Hi, my name is Aaron and I come from Nairobi. My email address is aaronmuuo60@gmail.com and my phone number is +254712345678. I am a male.

    //for single occurrences
    println("Your name: ${namePattern.find(input)?.value?.replace("name is ", "")?.trim()} \n" +
            "Your email: ${emailPattern.find(input)?.value?.trim()} \n" +
            "Your number: ${numberPattern.find(input)?.value?.trim()} \n" +
            "Your place: ${placePattern.find(input)?.value?.replace("come from ", "")?.trim()} \n" +
            "Your gender: ${genderPattern.find(input)?.value?.trim()} \n")

}