package app.demo.example.com.trailtracker.model

import android.arch.persistence.room.*
import android.location.Location
import android.os.Parcelable
import com.google.android.gms.maps.model.LatLng
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.android.parcel.Parcelize
import java.util.*

/**
 *
 * Created by Guillermo Bonafonte Criado
 *
 */
@Parcelize
@Entity(tableName = "route")
@TypeConverters(RouteConverter::class)
data class Route (

    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @ColumnInfo(name = "name")
    var name: String? = null,

    @ColumnInfo(name = "start_date")
    var startDate: Date? = Date(),

    @ColumnInfo(name = "duration")
    var duration: Long? = null,

    @ColumnInfo(name = "locations")
    var locations: MutableList<LatLng> = mutableListOf()
) : Parcelable

class RouteConverter {

    @TypeConverter
    fun fromMutableList(locations: MutableList<LatLng>?): String {
        return GsonBuilder().create().toJson(locations)
    }

    @TypeConverter
    fun fromJson(json: String?): MutableList<LatLng> {
        return Gson().fromJson(json, Array<LatLng>::class.java).toMutableList()
    }

    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return if (value == null) Date() else Date(value)
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }
}