package kom.hikeside.Custom.MarkerInfoWindows;

/**
 * Created by Koma on 29.08.2017.
 */

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import kom.hikeside.R;

/**
 * Created by Koma on 29.08.2017.
 */

public class LootFragment extends Fragment {
    TextView textViewTitle;
    TextView textViewInfo;

    @Nullable
    @Override
    public View onCreateView(
            LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.window_loot, container, false);



        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.tv_button:
                        setupDialog();
                        break;
                    default:
                        break;
                }

            }
        };

        view.findViewById(R.id.tv_button).setOnClickListener(onClickListener);
        textViewTitle = (TextView) view.findViewById(R.id.tv_lat);
        textViewInfo = (TextView) view.findViewById(R.id.tv_lng);
        fragmentInfo("SampleTitle", "SampleText");

    }

    private void setupDialog(){
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());

        alertDialog.setTitle("Loot");
        alertDialog.setMessage("Взять мешок?");

        final EditText input = new EditText(getActivity());
        final String strInput = input.getText().toString();
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        input.setLayoutParams(lp);
        alertDialog.setView(input);
        //alertDialog.setIcon(R.drawable.ic_vpn_key_black_24dp);


        alertDialog.setPositiveButton("ОК",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {
                        Toast.makeText(getActivity(), "Looting...", Toast.LENGTH_SHORT).show();
                       //getLoot


                    }
                });

        alertDialog.setNegativeButton("Назад",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        alertDialog.show();
    }

    public void fragmentInfo(String title, String text){

        textViewTitle.setText(title);
        textViewInfo.setText(text);

    }
}