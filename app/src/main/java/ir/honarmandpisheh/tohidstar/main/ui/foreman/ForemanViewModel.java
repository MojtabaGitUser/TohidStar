package ir.honarmandpisheh.tohidstar.main.ui.foreman;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import ir.honarmandpisheh.tohidstar.models.model.Person;


public class ForemanViewModel extends ViewModel implements CustomClickListener {
    private MutableLiveData<List<Person>> mPersonMutable;
    List<Person> list;
    public ForemanViewModel() {
        mPersonMutable=new MutableLiveData<>();

         list=new ArrayList<>();

        for(int i=0;i<20;i++){

            list.add(new Person("fi_"+i,"la_"+i,"per_"+i,"mob_"+i, Person.Occupation.WORKER));

        }
        mPersonMutable.setValue(list);

    }

    public MutableLiveData<List<Person>> getPersonMutable() {
        return mPersonMutable;
    }

    @Override
    public void itemDeleted(Person person) {

        list.remove(person);
        mPersonMutable.setValue(list);

    }
}
