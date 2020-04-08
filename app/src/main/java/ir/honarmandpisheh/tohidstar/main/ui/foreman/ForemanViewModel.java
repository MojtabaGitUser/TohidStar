package ir.honarmandpisheh.tohidstar.main.ui.foreman;

import android.app.Application;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import ir.honarmandpisheh.tohidstar.databinding.DialogForemanFragmentBinding;
import ir.honarmandpisheh.tohidstar.models.model.Person;


public class ForemanViewModel extends AndroidViewModel implements CustomInterface {
    private MutableLiveData<List<Person>> mPersonMutable;
    private List<Person> list;
    public MutableLiveData<Boolean> okClick=new MutableLiveData<>(false);
    public MutableLiveData<String>
            errorFirstName, errorLastName,errorMobileNumber, errorPersonalCode;
    public Person model=new Person();

    public ForemanViewModel(@NonNull Application application) {
        super(application);
        mPersonMutable=new MutableLiveData<>();
        list=new ArrayList<>();
        errorFirstName= new MutableLiveData<>();
        errorLastName= new MutableLiveData<>();
        errorMobileNumber = new MutableLiveData<>();
        errorPersonalCode= new MutableLiveData<>();
        mPersonMutable.setValue(list);

    }


    public MutableLiveData<List<Person>> getPersonMutable() {
        return mPersonMutable;
    }

    @Override
    public void itemDeleted(int index) {
        list.remove(index);
        mPersonMutable.setValue(list);

    }

    public void addForeman(){
        if(!model.isFirstNameValid()){
            errorFirstName.setValue("Input valid first name");
        }else {
                errorFirstName.setValue("");
        }
        if (!model.isLastNameValid()){
            errorLastName.setValue("Input valid last name");}else{
            errorLastName.setValue("");
        }
        if (!model.isMobileNumberValid()){
            errorMobileNumber.setValue("Input valid mobile");}else{
            errorMobileNumber.setValue("");
        }
        if (!model.isPersonalCodeValid()){
            errorPersonalCode.setValue("Input valid personal code");}else {
            errorPersonalCode.setValue("");
        }


        if (errorPersonalCode.getValue().equals("")
        && errorMobileNumber.getValue().equals("")
        && errorLastName.getValue().equals("")
        && errorFirstName.getValue().equals("")){

            model.setOccupation(Person.Occupation.FOREMAN);
            list.add(model);
            mPersonMutable.setValue(list);
            //register foreman in here
            Toast.makeText(getApplication(), model.getFirstName()+":"+model.getLastName(), Toast.LENGTH_SHORT).show();
        }



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                errorFirstName.setValue("");
                errorLastName.setValue("");
                errorMobileNumber.setValue("");
                errorPersonalCode.setValue("");

//                model.clean();


            }
        },3000);
        okClick.setValue(true);

    }

}
