package ir.honarmandpisheh.tohidstar.main.ui.foreman;


import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;
import ir.honarmandpisheh.tohidstar.R;
import ir.honarmandpisheh.tohidstar.databinding.DialogForemanFragmentBinding;
import ir.honarmandpisheh.tohidstar.databinding.FragmentForemenBinding;
import ir.honarmandpisheh.tohidstar.models.model.Person;

public class ForemanFragment extends Fragment implements
        CustomInterface.LongClick {
    ForemanViewModel foremanViewModel;
    AdapterForeman adapterForeman;
    FragmentForemenBinding binding;
    DialogForemanFragmentBinding dialogBinding;
    public MutableLiveData<String>
            errorFirstName,errorLastName,errorMobileNumber,errorPersonalCode
            =new MutableLiveData<>();



    public View onCreateView(@NonNull LayoutInflater inflater,

                             ViewGroup container,
                             Bundle savedInstanceState) {
        foremanViewModel= ViewModelProviders.of(this).get(ForemanViewModel.class);
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_foremen,container,false);
        binding.setVm(foremanViewModel);
        initDialog();
        View root = inflater.inflate(R.layout.fragment_foremen, container, false);



        RecyclerView recyclerView=root.findViewById(R.id.recycler_fragment_foreman);
        recyclerView.setLayoutManager(new LinearLayoutManager(container.getContext()));
        adapterForeman=new AdapterForeman(foremanViewModel.getPersonMutable().getValue());

        adapterForeman.setLongClick(this::onLongClick);
        recyclerView.setAdapter(adapterForeman);

        foremanViewModel.getPersonMutable().observe(getViewLifecycleOwner(), new Observer<List<Person>>() {
            @Override
            public void onChanged(List<Person> people) {
            adapterForeman.notifyDataSetChanged();
            }
        });

        return root;

    }

    private void initDialog() {
        View dialog = LayoutInflater
                .from(getContext())
                .inflate(R.layout.dialog_foreman_fragment, null, false);
        AlertDialog alert = new AlertDialog.Builder( getContext()).create();
        alert.setView(dialog);

        dialogBinding = DialogForemanFragmentBinding.bind(dialog);
        dialogBinding.cancelDialogForemanFragment.setOnClickListener(v -> {
            alert.dismiss();
        });
        dialogBinding.setVm(foremanViewModel);
        dialogBinding.setLifecycleOwner(this);
        FloatingActionButton fab = getActivity().findViewById(R.id.fab);
        getActivity().findViewById(R.id.fab).setVisibility(View.VISIBLE);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogBinding.firstNameDialogForemanFragment.setText("");
                dialogBinding.lastNameDialogForemanFragment.setText("");
                dialogBinding.personalCodeDialogForemanFragment.setText("");
                dialogBinding.mobileNumberDialogForemanFragment.setText("");
                alert.show();

            }
        });


        Spinner spinner=dialog.findViewById(R.id.occupation_dialog_foreman_fragment);
        List<String> list=new ArrayList<String>();
        list.add("Worker");
        list.add("Foreman");
        list.add("Manager");

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getContext(),R.layout.support_simple_spinner_dropdown_item,list);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    public void showMessage(String message) {
        Snackbar.make(getView(), message, Snackbar.LENGTH_LONG).show();
    }

    @BindingAdapter("app:cleanForm")
    public static void cleanForm(EditText view, Boolean cleanForm){
        if (cleanForm)
            view.setText("");

    }


    @Override
    public void onLongClick(int index,Person person) {

        Snackbar.make(getView(), "Delete " + person.getLastName() +" ?", Snackbar.LENGTH_LONG)
                .setAction("yes", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        foremanViewModel.itemDeleted(index);
                    }
                }).show();
    }

}
