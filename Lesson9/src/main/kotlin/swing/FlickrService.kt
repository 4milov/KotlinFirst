package swing

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

// https://www.flickr.com
// /services/rest/?method=flickr.photos.search&api_key=e0f15adacd272533207aaded6b498a0a&format=json&nojsoncallback=1
// https://www.flickr.com
// /services/rest/?method=flickr.photos.search&api_key=7e8d8b37dd13b4d6e7b39d8097ae7bf0&format=json&nojsoncallback=1

// &text=Moscow
interface FlickrService {
    @GET("/services/rest/?method=flickr.photos.search&api_key=7e8d8b37dd13b4d6e7b39d8097ae7bf0&format=json&nojsoncallback=1")
    fun search (
        @Query("text")
        text : String,

        @Query("page")
        page: Int
    ) : Call<Result>


}