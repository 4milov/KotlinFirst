package retrofit.dictionary.xml

import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

val retrofit: Retrofit = Retrofit.Builder()
    .baseUrl("https://dictionary.yandex.net")
    .addConverterFactory(SimpleXmlConverterFactory.create())
    .build()

val yandexDictionaryService = retrofit.create(YandexDictionaryService::class.java)

fun main() {
    val response = yandexDictionaryService.lookup("ru-en", "стол").execute()
    if (response.isSuccessful) {
         val result = response.body()
        println(
            result?.defs?.get(0)?.text
        )
    }
}