package ru.skillbranch.gameofthrones.base

import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import ru.skillbranch.gameofthrones.utils.hideKeyboard

abstract class BaseFragment: Fragment() {

    private val destinationChangeListener =
        NavController.OnDestinationChangedListener { _, _, _ ->
            hideKeyboard()
        }

    override fun onStart() {
        super.onStart()
        findNavController().addOnDestinationChangedListener(destinationChangeListener)
        val callback = object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                onBackPressed()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)
    }

    override fun onStop() {
        findNavController().removeOnDestinationChangedListener(destinationChangeListener)
        super.onStop()
    }

    open fun onBackPressed(){
        findNavController().popBackStack()
    }

}