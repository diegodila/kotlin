package com.ten.app10

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.ten.app10.databinding.FragmentHomeBinding

const val MULT = "*"
const val SOMA = "+"
const val SUB = "-"
const val DIV = "/"


class HomeFragment : Fragment() {

    private lateinit var bindings: FragmentHomeBinding
    private var operation = ""
    var correct_answer = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bindings = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return bindings.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val answerOne = Integer.parseInt(bindings.userAnswer.text.toString())
        val answerTwo = Integer.parseInt(bindings.userAnswer2.text.toString())
        correct_answer = setupQuestion(answerOne, answerTwo)

        bindings.next.setOnClickListener {
            val action =
                HomeFragmentDirections.actionHomeFragmentToNegativeFragment(correct_answer)
            findNavController().navigate(action)
        }
    }

    private fun setupQuestion(question_num1: Int, question_num2: Int): Int {
        val operations = listOf(MULT, DIV, SOMA, SUB)
        operation = operations.random()

        when (operation) {
            MULT -> correct_answer = question_num1.times(question_num2)
            DIV -> correct_answer = question_num1.div(question_num2)
            SUB -> correct_answer = question_num1.minus(question_num2)
            else -> correct_answer = question_num1.plus(question_num2)
        }
        return correct_answer
    }

}