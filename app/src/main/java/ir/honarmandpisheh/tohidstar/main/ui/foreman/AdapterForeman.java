package ir.honarmandpisheh.tohidstar.main.ui.foreman;

import android.content.Context;
import android.database.Observable;
import android.net.sip.SipSession;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;



import java.util.List;
import java.util.zip.Inflater;

import ir.honarmandpisheh.tohidstar.BR;
import ir.honarmandpisheh.tohidstar.R;
import ir.honarmandpisheh.tohidstar.databinding.ListCardItemBinding;
import ir.honarmandpisheh.tohidstar.models.model.Person;

public class AdapterForeman extends RecyclerView.Adapter<AdapterForeman.ViewHolder> {
    private List<Person> personList;
    private CustomClickListener getItem;

    public void setInterfaceItem(CustomClickListener getItem) {
        this.getItem = getItem;
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
        holder.itemBinding.setClickListener(getItem);

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

        }
        public void bind(Object obj){
            itemBinding.setVariable(BR.model,obj);
            itemBinding.executePendingBindings();

        }

    }

}
