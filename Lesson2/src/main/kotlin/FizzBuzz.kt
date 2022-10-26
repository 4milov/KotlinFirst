// 4 ->
// 3 -> Fizz
// 5 -> Buzz
// 3 b 5 -> FizzBuzz
//

fun fizzbuzz(data: Int) =
    when {
        data % 15 == 0 -> "$data: FizzBuzz"
        data % 3  == 0 -> "$data: Fizz"
        data % 5  == 0 -> "$data: Buzz"
        else           -> "$data: "
    }


fun main(){
    for(i in 1..25){
        println(fizzbuzz(i))
    }
}