package com.example.hmin205_tp2.ui.addContact;

import android.app.Notification;
import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.hmin205_tp2.R;

import java.util.ArrayList;
import java.util.Arrays;


public class addContactFragment extends Fragment {

    private addContactViewModel addContactViewModel;
    private Context mContext;
    ListView listView;
    EditText number, name, surname;

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        mContext = context;
    }


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        addContactViewModel =
                ViewModelProviders.of(this).get(addContactViewModel.class);

        View view = inflater.inflate(R.layout.fragment_addcontact, container, false);

        final ListView listView = view.findViewById(R.id.contactsList);
        String[] contacts = new String[]{
                "Alain_Térieur_0612325689",
                "Jean_Paul_0689654587",
                "Niska_Charo_0632458756",
                "Ninho_William_0659785426"
        };

        ArrayList<String> lst = new ArrayList<String>(Arrays.asList(contacts));


        listView.setVisibility(view.INVISIBLE);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(mContext, android.R.layout.simple_list_item_1, lst);
        System.out.println(listView);
        listView.setAdapter(arrayAdapter);


        number = view.findViewById(R.id.textNumber);
        name = view.findViewById(R.id.textName);
        surname = view.findViewById(R.id.textSurname);

        Button button = view.findViewById(R.id.button_add);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                final String strName = name.getText().toString();
                final String strSurname = surname.getText().toString();
                final String strNumber = number.getText().toString();

                System.out.println("it workds !");
                System.out.println(strName + "\n" + strSurname + "\n" + strNumber + "!");
                if(strName.isEmpty() || strSurname.isEmpty() || strNumber.isEmpty()){
                    Toast.makeText(getContext(),"Fill all the blanks !",Toast.LENGTH_LONG).show();
                }
                else {
                    String newValue = strName + "_" + strSurname + "_" + strNumber;
                    System.out.println(arrayAdapter);
                    listView.setVisibility(view.VISIBLE);
                    arrayAdapter.add(newValue);
                }
            }
        });
        return view;
    }




}
