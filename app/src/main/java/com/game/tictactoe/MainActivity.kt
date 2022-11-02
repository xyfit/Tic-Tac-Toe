package com.game.tictactoe

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var gamerPos = 1
    val firstGamerList = mutableListOf<Int>()
    val secondGamerList = mutableListOf<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun onClickBtn(view: View) {
        val btnSelected: Button = view as Button
        var btnNum = 0
        when (btnSelected.id) {
            R.id.btn_1 -> {
                showToast("btn 1")
                btnNum = 1
            }
            R.id.btn_2 -> {
                showToast("btn 2")
                btnNum = 2
            }
            R.id.btn_3 -> {
                showToast("btn 3")
                btnNum = 3
            }
            R.id.btn_4 -> {
                showToast("btn 4")
                btnNum = 4
            }
            R.id.btn_5 -> {
                showToast("btn 5")
                btnNum = 5
            }
            R.id.btn_6 -> {
                showToast("btn 6")
                btnNum = 6
            }
            R.id.btn_7 -> {
                showToast("btn 8")
                btnNum = 7
            }
            R.id.btn_8 -> {
                showToast("btn 8")
                btnNum = 8
            }
            R.id.btn_9 -> {
                showToast("btn 9")
                btnNum = 9
            }
        }
        startGame(btnNum, btnSelected)
    }

    private fun startGame(btnNum: Int, btn: Button) {
        if (gamerPos == 1) {
            btn.text = "X"
            this.gamerPos = 2
            firstGamerList.add(btnNum)
        } else {
            btn.text = "0"
            this.gamerPos = 1
            secondGamerList.add(btnNum)
        }
            btn.isEnabled = false
            checkWinner()
    }

    private fun checkWinner() {
        var winner = 0

        /*row*/
        // 1-qator
        if (firstGamerList.contains(1) && firstGamerList.contains(2) && firstGamerList.contains(3)) {
            winner = 1
        }
        if (secondGamerList.contains(1) && secondGamerList.contains(2) && secondGamerList.contains(3)) {
            winner = 2
        }
        // 2-qator
        if (firstGamerList.contains(4) && firstGamerList.contains(5) && firstGamerList.contains(6)) {
            winner = 1
        }
        if (secondGamerList.contains(4) && secondGamerList.contains(5) && secondGamerList.contains(6)) {
            winner = 2
        }
        // 3-qator
        if (firstGamerList.contains(7) && firstGamerList.contains(8) && firstGamerList.contains(9)) {
            winner = 1
        }
        if (secondGamerList.contains(7) && secondGamerList.contains(8) && secondGamerList.contains(9)) {
            winner = 2
        }

        /*column*/
        // 1 - ustun
        if (firstGamerList.contains(1) && firstGamerList.contains(4) && firstGamerList.contains(7)) {
            winner = 1
        }
        if (secondGamerList.contains(1) && secondGamerList.contains(4) && secondGamerList.contains(7)) {
            winner = 2
        }
        // 2 - ustun
        if (firstGamerList.contains(2) && firstGamerList.contains(5) && firstGamerList.contains(8)) {
            winner = 1
        }
        if (secondGamerList.contains(2) && secondGamerList.contains(5) && secondGamerList.contains(8)) {
            winner = 2
        }
        // 3 - ustun
        if (firstGamerList.contains(3) && firstGamerList.contains(6) && firstGamerList.contains(9)) {
            winner = 1
        }
        if (secondGamerList.contains(3) && secondGamerList.contains(6) && secondGamerList.contains(9)) {
            winner = 2
        }

        //cross 1
        if (firstGamerList.contains(1) && firstGamerList.contains(5) && firstGamerList.contains(9)) {
            winner = 1
        }
        if (secondGamerList.contains(1) && secondGamerList.contains(5) && secondGamerList.contains(9)) {
            winner = 2
        }

        //cross 2
        if (firstGamerList.contains(3) && firstGamerList.contains(5) && firstGamerList.contains(7)) {
            winner = 1
        }
        if (secondGamerList.contains(3) && secondGamerList.contains(5) && secondGamerList.contains(7)) {
            winner = 2
        }

        if (winner != 0) {
            val str = findViewById<TextView>(R.id.str)
            if (gamerPos == 1) {
                str.text = "0 yutti"
            } else {
                str.text = "X yutti"
            }

        }
}
    private fun gameOver(){

    }

private fun showToast(s: String) {
    Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
}
}