package ir.honarmandpisheh.tohidstar.main.ui.foreman;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;



import java.util.List;

import ir.honarmandpisheh.tohidstar.BR;
import ir.honarmandpisheh.tohidstar.R;
import ir.honarmandpisheh.tohidstar.databinding.ListCardItemBinding;
import ir.honarmandpisheh.tohidstar.models.model.Person;

public class AdapterForeman extends RecyclerView.Adapter<AdapterForeman.ViewHolder> {
    private List<Person> personList;
    private CustomInterface.LongClick longClick;

    public void setLongClick(CustomInterface.LongClick longClick) {
        this.longClick = longClick;
    }



    public AdapterForeman(List<Person> personList) {

        this.personList=personList;

    }

    @NonNull
    @Override
    public AdapterForeman.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ListCardItemBinding binding=DataBindingUtil
                .inflate(LayoutInflater
                        .from(parent.getContext()),
                        R.layout.list_card_item,
                        parent,
                        false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        holder.bind(personList.get(position));
        holder.itemBinding.setLongClick(longClick);

    }


    @Override
    public int getItemCount() {
        return personList.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        ListCardItemBinding itemBinding;

        public ViewHolder(@NonNull ListCardItemBinding itemView) {
            super(itemView.getRoot());
            this.itemBinding=itemView;
            this.itemBinding.cardViewListCardItem.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    longClick.onLongClick(getAdapterPosition(),personList.get(getAdapterPosition()));
                    return true;
                }
            });


        }
        public void bind(Object obj){
            itemBinding.setVariable(BR.model,obj);
            itemBinding.executePendingBindings();

        }

    }

}
