package com.lifeistech.android.musicalinstrument

import android.media.MediaPlayer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Gravity
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.flagment_quiz.*
import kotlinx.android.synthetic.main.flagment_quiz.view.*
import kotlin.collections.ArrayList


class QuizFragment : Fragment() {
    private val question_list: ArrayList<Question> = arrayListOf()
    private var question_num: Int = 0
    private var current = 0
    // 現在の問題
    private var current_question: Question = Question("","","","", 0)

    private var imageView: ImageView? = null
    private var button1: Button? = null
    private var button2: Button? = null
    private var button3: Button? = null
    private var button4: Button? = null
    private var nextButton: Button? = null

    var mediaPlayer: MediaPlayer = MediaPlayer()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.flagment_quiz, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        imageView = this.view!!.findViewById(R.id.playView) as ImageView
        button1 = this.view!!.findViewById(R.id.button1) as Button
        button2 = this.view!!.findViewById(R.id.button2) as Button
        button3 = this.view!!.findViewById(R.id.button3) as Button
        button4 = this.view!!.findViewById(R.id.button4) as Button
        val answerView = this.view!!.findViewById(R.id.answerView) as TextView
        nextButton = this.view!!.findViewById(R.id.nextButton) as Button
        makeQuestion()
        startQuestion()

        // クイズに答えたらtoastを表示して、次の問題を出す
        button1?.setOnClickListener{
            answerView.text = click(view.button1.text.toString())
        }
        button2?.setOnClickListener{
            answerView.text = click(view.button2.text.toString())
        }
        button3?.setOnClickListener{
            answerView.text = click(view.button3.text.toString())
        }
        button4?.setOnClickListener{
            answerView.text = click(view.button4.text.toString())
        }
        nextButton?.setOnClickListener{
            nextQuestion()
        }
    }

    private fun makeQuestion() {
        val q1 = Question("ピアノ", "オルガン", "アコーディオン", "チェンバロ", R.raw.piano)
        val q2 = Question("バンジョー", "ギター", "ベース", "ウクレレ", R.raw.banjo)
        val q3 = Question("テナーサックス", "バリトンサックス", "アルトサックス", "ソプラノサックス", R.raw.tenor_sax)
        val q4 = Question("ヴィオラ","バイオリン","チェロ","コントラバス",R.raw.viola)
        val q5 = Question("ティンパニー","バスドラム","タブラ","タム",R.raw.tynpani)
        question_list.add(q1)
        question_list.add(q2)
        question_list.add(q3)
        question_list.add(q4)
        question_list.add(q5)
    }

    private fun startQuestion() {
        question_num = question_list.size
        nextQuestion()
    }

    private fun nextQuestion() {
        answerView.text = ""
        if (current >= question_num) {
            // 次の問題がもう無い時
            toastMake("クイズはこれで全部だよ！", 0, 600)
            makeQuestion()
            startQuestion()
            return
        }

        current_question = question_list[current]

        val choice_text = current_question.getChoices()
        playView?.setOnClickListener {
            mediaPlayer = MediaPlayer.create(context, current_question.getMusic())
            mediaPlayer.start()
        }
        mediaPlayer.stop()
        button1?.text = choice_text[0]
        button2?.text = choice_text[1]
        button3?.text = choice_text[2]
        button4?.text = choice_text[3]

        current += 1
    }

    private fun toastMake(message: String, x: Int, y: Int) {
        val toast = Toast.makeText(context, message, Toast.LENGTH_LONG)
        // 位置調整
        toast.setGravity(Gravity.CENTER, x, y)
        toast.show()
    }

    // ボタンがタップされた時に呼ばれるイベントリスナー
    private fun click(answer: String) :String{
        //右辺にボタン内のテキスト入れたい
        val text: String
        if (answer == current_question._answer) {
            //正解時の処理 toast表示
            text = "正解！！"
        }else{
            text = "不正解！"
        }
        return text
    }

    class Question(answer: String, wrong_1: String, wrong_2: String, wrong_3: String, music: Int){
        var _answer: String = answer
        var _wrong_1: String = wrong_1
        var _wrong_2: String = wrong_2
        var _wrong_3: String = wrong_3
        var _music: Int = music

        // シャッフルした問題の選択肢を返すメソッド
        fun getChoices(): List<String> {
            // ボタンの位置をランダムにする
            val list = listOf(_answer, _wrong_1, _wrong_2, _wrong_3)
            val shuffuled : List<String> = list.shuffled()

            return shuffuled
        }

        fun getMusic(): Int{
            return _music
        }
    }
}
