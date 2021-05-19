package com.fiap.appnac

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.fiap.appnac.databinding.FragmentHomeBinding


const val MULT = "MULTIPLICAÇÃO"
const val SOMA = "SOMA"
const val SUB = "SUBTRAÇÃO"
const val DIV = "DIVISÃO"

class HomeFragment : Fragment() {

    private lateinit var bindings: FragmentHomeBinding
    private var operation = ""
    private var correct_answer = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindings = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return bindings.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        operationRandom()


        bindings.next.setOnClickListener {
            val answer = Integer.parseInt(bindings.userAnswer.text.toString())
            val answerTwo = Integer.parseInt(bindings.userAnswerTwo.text.toString())
            questionAnswer(answer,answerTwo,operation)

            val action =
                HomeFragmentDirections.actionHomeFragmentToResultFragment(correct_answer)
            findNavController().navigate(action)

        }
    }

    private fun questionAnswer(question_num1:Int, question_num2: Int, operation: String) {

        when (operation) {
            MULT -> correct_answer = question_num1.times(question_num2)
            DIV -> correct_answer = question_num1.div(question_num2)
            SUB -> correct_answer = question_num1.minus(question_num2)
            else -> correct_answer = question_num1.plus(question_num2)
        }
    }

    private fun operationRandom() : String {
        val operations = listOf(MULT, DIV, SOMA, SUB)
        operation = operations.random();
        bindings.question.text = "$operation"
        return operation

    }
}