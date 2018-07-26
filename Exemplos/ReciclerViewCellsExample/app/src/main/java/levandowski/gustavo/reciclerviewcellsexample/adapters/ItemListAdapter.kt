package levandowski.gustavo.reciclerviewcellsexample.adapters

import android.content.Context
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import levandowski.gustavo.reciclerviewcellsexample.R
import levandowski.gustavo.reciclerviewcellsexample.adapters.items.ItemListRow

open class ItemListAdapter (var items:ArrayList<ItemListRow>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val numberPair = 0
    private val numberOdd = 1
    private val numberDefault = 2


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView: View

        when (viewType) {
            numberPair -> {
                itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_cell_number_pair, parent, false)
                return PairCell(itemView)
            }
            numberOdd -> {
                itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_cell_number_odd, parent, false)
                return OddCell(itemView)
            } else -> {
                itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_cell_is_empty, parent, false)
                return ItemCell(itemView)
           }
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
      val cell = items[position]

     if(cell.isPair) {
         val viewHolder = holder as PairCell
         viewHolder.titleLabel.text = cell.titleReciclerView
         viewHolder.titleLabel.setTextColor(Color.GRAY)
     }else if(cell.isOdd) {
         val viewHolder = holder as OddCell
         viewHolder.titleLabel.text = cell.titleReciclerView
         viewHolder.titleLabel.setTextColor(Color.BLUE)
     } else {
         val viewHolder = holder as ItemCell
         viewHolder.titleLabel.text =  cell.titleReciclerView
         viewHolder.titleLabel.setTextColor(Color.BLACK)
     }
    }

    override fun getItemCount(): Int {
        return  items.count()
    }

    override fun getItemViewType(position: Int): Int {

        if (items[position].isPair)
            return numberPair

        else if (items[position].isOdd)
            return numberOdd


        else
            return numberDefault

    }

    class PairCell(view: View):RecyclerView.ViewHolder(view) {
        val titleLabel: TextView = view.findViewById(R.id.text_number_pair)
    }

    class OddCell(view: View):RecyclerView.ViewHolder(view) {
        val titleLabel: TextView = view.findViewById(R.id.text_number_odd)
    }

    class ItemCell(view: View) : RecyclerView.ViewHolder(view) {
        val titleLabel: TextView = view.findViewById(R.id.text_number_isempty)
    }

}