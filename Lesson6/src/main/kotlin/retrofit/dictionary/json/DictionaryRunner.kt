package retrofit.dictionary.json

import retrofit.dictionary.json.json.DicResultJson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.awt.BorderLayout
import java.awt.FlowLayout
import java.awt.ScrollPane
import javax.swing.*

val retrofit: Retrofit = Retrofit.Builder()
    .baseUrl("https://dictionary.yandex.net")
//    .addConverterFactory(SimpleXmlConverterFactory.create())
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val yandexDictionaryService = retrofit.create(YandexDictionaryService::class.java)

fun main() {

    val frame = JFrame()
//    frame.preferredSize = Dimension(200, 100)
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE

    frame.contentPane.layout = BorderLayout(5, 5)

    val topPanel = JPanel()
    topPanel.layout = FlowLayout()

    topPanel.add(JLabel("tag:"))

    val text = JTextField(20)
    topPanel.add(text)

    val search = JButton("Search")
    topPanel.add(search)

    val list = JList<String>()
    list.layoutOrientation = JList.VERTICAL
    val bottom = ScrollPane(ScrollPane.SCROLLBARS_AS_NEEDED)
    bottom.add(list)
    frame.add(bottom, BorderLayout.SOUTH)

    search.addActionListener {

        yandexDictionaryService.lookup(text.text).enqueue(object : Callback<DicResultJson> {
            override fun onResponse(call: Call<DicResultJson>, response: Response<DicResultJson>) {
                println("onResponse")
                response.body().let {
                    val model = DefaultListModel<String>()
                    model.addElement(it?.def?.get(0)?.tr?.get(0)?.text.toString())
//                    .def?.get(0)?.tr?.get(0)?.text
                    SwingUtilities.invokeLater {
                        list.model = model
                    }
                }

            }

            override fun onFailure(call: Call<DicResultJson>, t: Throwable) {
                println("onFailure")

            }

        })
    }

    frame.contentPane.add(topPanel)

    frame.pack()
    frame.isVisible = true


//    val response = yandexDictionaryService.lookup("love").execute()
//    if (response.isSuccessful) {
//         val result = response.body()
//        println(
//            result?.def?.get(0)?.tr?.get(0)?.text
//        )
//    }
}