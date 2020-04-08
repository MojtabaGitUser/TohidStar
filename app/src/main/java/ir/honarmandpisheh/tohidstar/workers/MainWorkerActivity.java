package ir.honarmandpisheh.tohidstar.workers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import ir.honarmandpisheh.tohidstar.R;
import ir.honarmandpisheh.tohidstar.databinding.ActivityMainWorkerBinding;


public class MainWorkerActivity extends AppCompatActivity {
    ActivityMainWorkerBinding binding;
    MainWorkerViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel= ViewModelProviders.of(this).get(MainWorkerViewModel.class);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main_worker);
        binding.setVm(viewModel);

    }
}
