package ru.skillbranch.gameofthrones.features.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import ru.skillbranch.gameofthrones.R
import ru.skillbranch.gameofthrones.base.BaseFragment

class SplashFragment: BaseFragment() {

    private val viewModel: SplashViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_splash, container, false)
        viewModel.textEvent.observe(viewLifecycleOwner, Observer {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        })
        viewModel.networkException.observe(viewLifecycleOwner, Observer {
            Snackbar.make(view, R.string.network_error_splash_screen, Snackbar.LENGTH_INDEFINITE).also {
                it.view.findViewById<TextView>(com.google.android.material.R.id.snackbar_text).setLines(3)
                it.show()
            }
        })
        viewModel.goNextScreen.observe(viewLifecycleOwner, Observer {
            val a = SplashFragmentDirections.actionSplashFragmentToCharactersListFragment()
            findNavController().navigate(a)
        })
        return view
    }

    override fun onBackPressed() {}

}