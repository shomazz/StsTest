package com.shomazzapp.ststest.dataStore

import com.shomazzapp.ststest.utils.getRandomValue
import com.shomazzapp.ststest.viewObjects.*
import java.util.*
import kotlin.random.Random

class VosDataStore {

    companion object {

        fun getNextItem(): Vo {
            return when (val i = Random.nextInt(4)) {
                0 -> getRandomNotice()
                1 -> getRandomEvent()
                2 -> getRandomMove()
                3 -> getRandomNew()
                else -> throw IllegalArgumentException("Not implemented case for number $i")
            }
        }

        private fun getRandomNew(): NewVo {
            val gateNumber = Random.nextInt(1, 99)
            return NewVo("New #$gateNumber")
        }

        private fun getRandomNotice(): NoticeVo {
            val noticeDate = Date()
            val gateNumber = Random.nextInt(1, 99)
            return NoticeVo(noticeDate, "Gate #$gateNumber")
        }

        private fun getRandomEvent(): EventVo {
            val start = Date()
            val end = Date()
            val eventNumber = Random.nextInt(1, 99)
            return EventVo("Event #$eventNumber", start, end)
        }

        private fun getRandomMove(): MoveVo {
            val placeNumber = Random.nextInt(1, 99)
            val time = Random.nextInt(1, 20)
            val timeInterval = TimeUnit::class.getRandomValue()
            return MoveVo(
                fromPlace = "Place #$placeNumber",
                toPlace = "Place #${placeNumber + 1}",
                estimateTime = TimeInterval(time, timeInterval)
            )
        }
    }
}