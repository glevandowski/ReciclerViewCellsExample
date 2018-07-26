package levandowski.gustavo.reciclerviewcellsexample.views

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import levandowski.gustavo.reciclerviewcellsexample.R
import levandowski.gustavo.reciclerviewcellsexample.adapters.ItemListAdapter
import levandowski.gustavo.reciclerviewcellsexample.adapters.items.ItemListRow


class MainActivity : AppCompatActivity() {

    private lateinit var recyclerListAdapter: ItemListAdapter
    private lateinit var recyclerView: RecyclerView

    private lateinit var valuesList : ArrayList<Int>
    private var items: ArrayList<ItemListRow> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        valuesList = ArrayList()
        this.setValues()
        this.setupReciclerView()
        this.setupList(valuesList)
    }

    fun setValues(){
        for(i in 0.. 10000)
        valuesList.add(i)

    }
    fun setupReciclerView(){
        recyclerView = findViewById(R.id.recicler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    fun setListAdapter(list: ArrayList<ItemListRow>) {
        recyclerListAdapter = ItemListAdapter(list)
        recyclerView.adapter = recyclerListAdapter
    }

    fun setupList( arrayNumbers: ArrayList<Int>) {
        var listItemView: ItemListRow
        items = ArrayList<ItemListRow>()

        if(arrayNumbers.size == 0 ){

            listItemView = ItemListRow()
            listItemView.titleReciclerView = "Nenhum dado para exibir"
            listItemView.isPair = false
            listItemView.isOdd = false
            items.add(listItemView)

        }else {

        for (i in   arrayNumbers) {

                if (i % 2 == 0) {
                    listItemView = ItemListRow()
                    listItemView.titleReciclerView = " ${i} -> é par"
                    listItemView.isPair = true

                    items.add(listItemView)

                } else {
                    listItemView = ItemListRow()
                    listItemView.titleReciclerView = " ${i} -> é impar"
                    listItemView.isOdd = true

                    items.add(listItemView)
                }
            }
        }
        setListAdapter(items)
        recyclerListAdapter.notifyDataSetChanged()
    }
}
