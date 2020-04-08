package ir.honarmandpisheh.tohidstar.main.ui.foreman;

import ir.honarmandpisheh.tohidstar.models.model.Person;

public interface CustomInterface {
    public void itemDeleted(int index);

    public interface LongClick{
    public void onLongClick(int index,Person person);
    }


}
