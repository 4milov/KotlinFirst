package swing

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.awt.BorderLayout
import java.awt.FlowLayout
import java.awt.ScrollPane
import javax.swing.DefaultListModel
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JList
import javax.swing.JPanel
import javax.swing.JTextField
import javax.swing.SwingUtilities
import javax.swing.text.DefaultEditorKit.DefaultKeyTypedAction

val retrofit: Retrofit = Retrofit.Builder()
    .baseUrl("https://www.flickr.com")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val flickrService = retrofit.create(FlickrService::class.java)


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
//        println(Thread.currentThread().id)
//        thread {
//            println( Thread.currentThread().id)
//            println(text.text)
//            println("starting")
//            Thread.sleep(2_000)
//            println("ending")
//            SwingUtilities.invokeLater{
//                print(Thread.currentThread().id)
//            }
//        }
        flickrService.search(text.text, 12).enqueue(object : Callback<swing.Result> {

            override fun onResponse(call: Call<swing.Result>, response: Response<swing.Result>) {
                println("onResponse")
                response.body()?.let {

                    val model = DefaultListModel<String>()

                    for (s in it.photos.photo) {
                        model.addElement(s.title.toString())
                    }
                    SwingUtilities.invokeLater {
                        list.model = model
                    }
                }
            }

            override fun onFailure(call: Call<swing.Result>, t: Throwable) {
                println("onFailure")

            }


        })
    }

    frame.contentPane.add(topPanel)

    frame.pack()
    frame.isVisible = true

}