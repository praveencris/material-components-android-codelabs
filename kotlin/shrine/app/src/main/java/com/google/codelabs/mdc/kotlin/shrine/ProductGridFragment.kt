package com.google.codelabs.mdc.kotlin.shrine

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.codelabs.mdc.kotlin.shrine.network.ProductEntry
import kotlinx.android.synthetic.main.shr_product_grid_fragment.view.*

class ProductGridFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.shr_product_grid_fragment, container, false)

        //Setup the toolbar
        (activity as AppCompatActivity).setSupportActionBar(view.app_bar)

        //Setup the Recycler View
        view.recyclerView.setHasFixedSize(true)
        view.recyclerView.layoutManager = GridLayoutManager(context,2, RecyclerView.VERTICAL,false)
        val adapter = ProductCardRecyclerViewAdapter(ProductEntry.initProductEntryList(resources))
        view.recyclerView.adapter = adapter

        val largePadding = resources.getDimensionPixelSize(R.dimen.shr_product_grid_spacing)
        val smallPadding = resources.getDimensionPixelSize(R.dimen.shr_product_grid_spacing_small)

        view.recyclerView.addItemDecoration(ProductGridItemDecoration(largePadding,smallPadding))


        return  view;
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.shr_toolbar_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
}
