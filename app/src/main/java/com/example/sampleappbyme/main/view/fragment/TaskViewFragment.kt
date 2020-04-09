package com.example.sampleappbyme.main.view.fragment

import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.lifecycle.Observer
import androidx.viewpager.widget.ViewPager
import com.example.sampleappbyme.R

import com.example.sampleappbyme.databinding.CardViewFragmentBinding
import com.example.sampleappbyme.databinding.TaskViewFragmentBinding
import com.example.sampleappbyme.main.data.Event
import com.example.sampleappbyme.main.ui.card.CardAdapter
import com.example.sampleappbyme.main.ui.card.CardItem
import com.example.sampleappbyme.main.ui.card.CardPagerAdapter
import com.example.sampleappbyme.main.view.MainActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import timber.log.Timber

class TaskViewFragment : Fragment() {

    private lateinit var binding: TaskViewFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Timber.i("creating fragment view")

        binding = TaskViewFragmentBinding.inflate(inflater, container, false).apply {

            viewmodel = (activity as MainActivity).obtainTaskViewModel().apply {
                newTaskEvent.observe((activity as MainActivity), Observer<Event<Unit>> { event ->
                    event.getContentIfNotHandled()?.let {
                        (activity as MainActivity).addNewTask()
                    }
                })
            }
        }

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onStart() {
        (activity as MainActivity).binding.fabAddTask.visibility = View.VISIBLE

        Timber.i("onStart")
        super.onStart()
    }

    override fun onResume() {

        Timber.i("onResume")
        super.onResume()
    }

    override fun onDestroy() {
        (activity as MainActivity).binding.fabAddTask.visibility = View.INVISIBLE

        super.onDestroy()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Timber.i("activity created")

        binding.viewmodel?.let {
//            view?.setupSnackbar(this, it.snackbarMessage, Snackbar.LENGTH_LONG)

        }



        binding.lifecycleOwner = this.viewLifecycleOwner

        setupFab()
//        setupListAdapter()
//        setupRefreshLayout()
    }

    private fun setupFab() {
        activity?.findViewById<FloatingActionButton>(R.id.fab_add_task)?.let {
            it.setOnClickListener {
                Timber.tag("fabTest").d("click!")
                binding.viewmodel?.addNewTask()
            }
        }
    }
}
