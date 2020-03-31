package ir.honarmandpisheh.tohidstar.main.ui.foreman;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;
import ir.honarmandpisheh.tohidstar.R;
import ir.honarmandpisheh.tohidstar.models.model.Person;

public class ForemanFragment extends Fragment {
    ForemanViewModel foremanViewModel;
    AdapterForeman adapterForeman;
    FloatingActionButton fab;
    AlertDialog alert;
    public View onCreateView(@NonNull LayoutInflater inflater,

                             ViewGroup container,
                             Bundle savedInstanceState) {
        foremanViewModel= ViewModelProviders.of(this).get(ForemanViewModel.class);
        initDialog();
        View root = inflater.inflate(R.layout.fragment_foremen, container, false);


        FloatingActionButton fab = getActivity().findViewById(R.id.fab);
        getActivity().findViewById(R.id.fab).setVisibility(View.VISIBLE);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                alert.show();
//                Snackbar.make(view, "Foreman Fragment", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });
        final RecyclerView recyclerView=root.findViewById(R.id.recycler_fragment_foreman);
        recyclerView.setLayoutManager(new LinearLayoutManager(container.getContext()));
        adapterForeman=new AdapterForeman(foremanViewModel.getPersonMutable().getValue());
        adapterForeman.setInterfaceItem(foremanViewModel);
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
        LayoutInflater factory=LayoutInflater.from(getContext());
        View dialog=factory.inflate(R.layout.dialog_foreman_fragment,null);
        dialog.findViewById(R.id.ok_dialog_foreman_fragment).setOnClickListener(v->{

        });
        dialog.findViewById(R.id.cancel_dialog_foreman_fragment).setOnClickListener(v->{
            alert.dismiss();
        });
        alert=new AlertDialog.Builder(getContext()).create();
        alert.setView(dialog);
//        Spinner spinner=dialog.findViewById(R.id.occupation_dialog_foreman_fragment);
//        List<String> list=new ArrayList<String>();
//        list.add("Worker");
//        list.add("Foreman");
//        list.add("Manager");
//
//        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getContext(),R.layout.support_simple_spinner_dropdown_item,list);
//        spinner.setAdapter(adapter);
//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
    }


}
