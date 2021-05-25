package com.ten.app10

import android.nfc.tech.MifareUltralight
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
    private var question_num1 = 0
    private var question_num2 = 0
    private var correct_answer = 0

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
        setupQuestion()

        bindings.next.setOnClickListener {
            val answer = Integer.parseInt(bindings.userAnswer.text.toString())
            if (answer == correct_answer) {
                val action = HomeFragmentDirections.actionHomeFragmentToPositiveFragment()
                findNavController().navigate(action)


            } else {
                val action =
                    HomeFragmentDirections.actionHomeFragmentToNegativeFragment(correct_answer)
                findNavController().navigate(action)
            }
        }

    }

    private fun setupQuestion() {
        question_num1 = (1..25).random()
        question_num2 = (1..25).random()
        val operations = listOf(MULT, DIV, SOMA, SUB)
        operation = operations.random()

        when (operation) {
            MULT -> correct_answer = question_num1.times(question_num2)
            DIV -> correct_answer = question_num1.div(question_num2)
            SUB -> correct_answer = question_num1.minus(question_num2)
            else -> correct_answer = question_num1.plus(question_num2)
        }

        bindings.question.text = "$question_num1 $operation ${question_num2}"
    }

}