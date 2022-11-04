package com.game.tictactoe

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MainActivity : AppCompatActivity() {
    var gamerPos = 1
    val firstGamerList = mutableListOf<Int>()
    val secondGamerList = mutableListOf<Int>()
    lateinit var gamer1Text: TextView
    lateinit var gamer2Text: TextView
    lateinit var gamerPosText: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gamer1Text = findViewById(R.id.gamer1_name)
        gamer2Text = findViewById(R.id.gamer2_name)
        gamerPosText = findViewById(R.id.str)


        for (i in 1..9){
            val btnId = "btn_$i"
            val resId = resources.getIdentifier(btnId, "id", packageName)
             finByList.add(findViewById<Button>(resId))
        }
        showDialog()

        findViewById<MaterialButton>(R.id.refresh_brn).setOnClickListener {
            restart()
        }
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

        queue()
        if (winner != 0) {
            if (winner == 1){
                winGamer2++
                gamerPosText.text = "X winner"
            }else{
                winGamer1++
                gamerPosText.text = "0 winner"
            }
            gamer1Text.text = "0-Gamer: $winGamer1"
            gamer2Text.text = "X-Gamer: $winGamer2"
            gameOver()
        }
    }
    private fun queue(){
        if (gamerPos == 1) {
            gamerPosText.text = "Turn X"
        } else {
            gamerPosText.text = "Turn 0"
        }
    }

    companion object {
        var winGamer1 = 0
        var winGamer2 = 0
        val finByList = mutableListOf<Button>()
    }

    private fun gameOver() {
        finByList.forEach {
            it.isEnabled = false
        }
    }

    private fun restart() {
        finByList.forEach {
            it.text = null
            it.isEnabled = true
        }
        queue()
        firstGamerList.clear()
        secondGamerList.clear()

    }

    private fun showDialog() {
        val view = layoutInflater.inflate(R.layout.gamers_names_ly, null)
        MaterialAlertDialogBuilder(this, R.style.ThemeOverlay_App_MaterialAlertDialog).apply {
            setTitle("Title")
            setView(view)
            setMessage("Lorem ipsum message")
            setNeutralButton("Chiqish") { dialog, which ->
                // Respond to neutral button press
            }
            setNegativeButton("Bekor qilish") { dialog, which ->
                // Respond to negative button press
            }
            setPositiveButton("Saqlash") { dialog, which ->
                // Respond to positive button press
            }
            show()
        }

    }

    private fun showToast(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
    }
}