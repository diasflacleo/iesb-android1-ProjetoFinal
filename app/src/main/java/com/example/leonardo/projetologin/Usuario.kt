package com.example.leonardo.projetologin

import android.arch.persistence.room.*


@Entity(tableName = "usuario")
data class Usuario (

        @PrimaryKey(autoGenerate = true) var uid: Int = 0,
        @ColumnInfo(name = "usuario_email") var email: String = "",
        @ColumnInfo(name = "usuario_senha") var senha: String = ""
        )


@Dao
interface RoomDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUsuario(usu: Usuario)

    @Update
    fun updateUsuario(usu: Usuario)

    @Delete
    fun deleteUsuario(usu: Usuario)

    @Query("SELECT * FROM usuario")
    fun usuarios(): Array<Usuario>

}




@Database(entities = [(Usuario::class)], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun romDao(): RoomDAO
}
