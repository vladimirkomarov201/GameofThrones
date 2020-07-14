package ru.skillbranch.gameofthrones.repositories.impls

import android.util.Log
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers
import ru.skillbranch.gameofthrones.data.local.converters.toDbEntity
import ru.skillbranch.gameofthrones.data.local.room.AppDatabase
import ru.skillbranch.gameofthrones.data.local.room.entity.character.Alias
import ru.skillbranch.gameofthrones.data.local.room.entity.character.CharacterDatabase
import ru.skillbranch.gameofthrones.data.local.room.entity.character.CharacterTitle
import ru.skillbranch.gameofthrones.data.local.room.entity.house.AncestralWeapon
import ru.skillbranch.gameofthrones.data.local.room.entity.house.HouseDatabase
import ru.skillbranch.gameofthrones.data.local.room.entity.house.HouseTitle
import ru.skillbranch.gameofthrones.data.local.room.entity.house.Seat
import ru.skillbranch.gameofthrones.data.remote.res.CharacterRes
import ru.skillbranch.gameofthrones.data.remote.res.HouseRes
import ru.skillbranch.gameofthrones.repositories.DatabaseRepository

class RoomDatabaseRepository(
    private val db: AppDatabase
): DatabaseRepository {

    private val TAG = RoomDatabaseRepository::class.simpleName

    override fun insertHouses(houses: List<HouseRes>): Single<List<Long>> {
        return Observable.fromIterable(houses)
            .flatMapSingle { houseRes ->
                db.getHouseDao().insert(houseRes.toDbEntity())
                    .doAfterSuccess { id ->
                        val houseTitles = db.getHouseTitleDao().insert(houseRes.titles.map {
                            HouseTitle(0, id, it)
                        })
                        val seatsInsert = db.getSeatDao().insert(houseRes.seats.map {
                            Seat(0, id, it)
                        })
                        val ancestralWeaponsInsert =
                            db.getAncestralWeaponDao().insert(houseRes.ancestralWeapons.map {
                                AncestralWeapon(0, id, it)
                            })
                        Single.merge(houseTitles, seatsInsert, ancestralWeaponsInsert)
                            .observeOn(Schedulers.io())
                            .subscribe()
                    }
                    .doOnError {
                        Log.e(TAG, "ERROR", it)
                    }
            }
            .toList()
    }

    override fun insertCharacters(characters: List<CharacterRes>): Single<List<Long>> {
        return Observable.fromIterable(characters)
            .flatMapSingle { characterRes ->
                db.getCharacterDao().insert(characterRes.toDbEntity())
                    .doAfterSuccess { id ->
                        val houseTitles = db.getCharacterTitleDao().insert(characterRes.titles.map {
                            CharacterTitle(0, id, it)
                        })
                        val aliasesInsert = db.getAliasDao().insert(characterRes.aliases.map {
                            Alias(0, id, it)
                        })
                        Single.merge(houseTitles, aliasesInsert)
                            .observeOn(Schedulers.io())
                            .subscribe()
                    }
                    .doOnError {
                        Log.e(TAG, "ERROR", it)
                    }
            }
            .toList()
    }

    override fun drop(): Completable {
        return Completable.fromAction { db.clearAllTables() }
    }

    override fun needUpdate(): Single<Boolean> {
        val houses = db.getHouseDao().getAll()
        val characters = db.getCharacterDao().getAll()
        return Maybe.zip(
            houses,
            characters,
            BiFunction<List<HouseDatabase>, List<CharacterDatabase>, Boolean> { housesResult, characterResult ->
                housesResult.isEmpty() && characterResult.isEmpty()
            }
        ).toSingle()
    }

}