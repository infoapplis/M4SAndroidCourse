package androidcourse.dev.firebasestudent;

import android.app.ProgressDialog;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private Button btnsubmit;
    private EditText txtid;
    private EditText txtfirstname;
    private ProgressDialog etatEnr;
    private DatabaseReference rootRef;


    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        rootRef = FirebaseDatabase.getInstance().getReference();

        //etatEnr = new ProgressDialog(getActivity().getApplicationContext());
        //etatEnr.setMessage("Loading...");

        txtid = (EditText)rootView.findViewById(R.id.txtid);
        txtfirstname = (EditText)rootView.findViewById(R.id.txtfirstname);
        btnsubmit=(Button) rootView.findViewById(R.id.btnsubmit);
        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controleSaisie();
            }
        });

        return rootView;
    }

    public void controleSaisie(){
        String id = txtid.getText().toString().trim();
        String firstname = txtfirstname.getText().toString().trim();

        if(TextUtils.isEmpty(id)){
            Toast t = Toast.makeText(getActivity().getApplicationContext(), "Please enter id", Toast.LENGTH_LONG);
            t.show();
            return;
        }

        if(TextUtils.isEmpty(firstname)){
            Toast t = Toast.makeText(getActivity().getApplicationContext(), "Please enter first name", Toast.LENGTH_LONG);
            t.show();
            return;
        }

        //etatEnr.setMessage("Saving Student...");
        //etatEnr.show();

        Student student= new Student(id,firstname);
        rootRef.push().setValue(student);
        Toast t = Toast.makeText(getActivity().getApplicationContext(), "Success !", Toast.LENGTH_LONG);
        t.show();
    }

}
