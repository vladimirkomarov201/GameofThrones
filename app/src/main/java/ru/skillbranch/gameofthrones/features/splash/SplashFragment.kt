package ru.skillbranch.gameofthrones.features.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ru.skillbranch.gameofthrones.R
import ru.skillbranch.gameofthrones.base.BaseFragment

class SplashFragment: BaseFragment() {

    private lateinit var viewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SplashViewModel::class.java)
    }

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
            Toast.makeText(requireContext(), "network", Toast.LENGTH_SHORT).show()
        })
        viewModel.goNextScreen.observe(viewLifecycleOwner, Observer {
            Toast.makeText(requireContext(), "next", Toast.LENGTH_SHORT).show()
        })
        return view
    }

    override fun onBackPressed() {}

}