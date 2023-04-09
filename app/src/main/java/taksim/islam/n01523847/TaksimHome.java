package taksim.islam.n01523847;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TaksimHome#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TaksimHome extends Fragment {
    int leftLimit = 97; // letter 'a'
    int rightLimit = 122; // letter 'z'
    int targetStringLength = 10;
    Random random = new Random();
    Random rand = new Random();
    RadioGroup Radiogroup;
    Button subbutton;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TaksimHome() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TaksimHome newInstance(String param1, String param2) {
        TaksimHome fragment = new TaksimHome();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.taksimhome, container, false);

        Radiogroup = view.findViewById(R.id.radiogroup);
        TextView txt_view = view.findViewById(R.id.textView2);
        subbutton = view.findViewById(R.id.button);
        subbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = Radiogroup.getCheckedRadioButtonId();
                switch (selectedId) {
                    case R.id.randomnumber:
                        int min = -50;
                        int max = 50;
                        int range = max - min + 1;
                        int randomNum = (int)(Math.random() * range) + min;

                        txt_view.setText(Integer.toString(randomNum));
                        break;
                    case R.id.randomtext:
                        String generatedString = random.ints(leftLimit, rightLimit + 1)
                                .limit(targetStringLength)
                                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                                .toString();
                        txt_view.setText(generatedString);
                        break;
                    case  R.id.firebase:

                }
            }
        });


        // Inflate the layout for this fragment
        return view;
    }

    public void randnumber(View view) {
        int randomNum = rand.nextInt(101) - 50;
        String randNumText = Integer.toString(randomNum);

    }
}