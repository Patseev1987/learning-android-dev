package com.example.rings.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "rings")
data class Ring(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_ring")
    var idRing: Long = 0L,
    var diameter: Double = 0.0,
    @ColumnInfo(name = "inner_diameter")
    var innerDiameter: Double = 0.0,
    @ColumnInfo(name = "outside_diameter")
    var outsideDiameter: Double = 0.0,
    @ColumnInfo(name = "deep")
    var deep: Double = 0.0,
    @ColumnInfo(name = "thickness")
    var thickness: Double = 0.0,
    @ColumnInfo(name = "type_ring")
    var typeRing: String = ""
)