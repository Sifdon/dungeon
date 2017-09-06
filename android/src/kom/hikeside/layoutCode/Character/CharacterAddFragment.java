package kom.hikeside.layoutCode.Character;


import android.app.Fragment;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import kom.hikeside.Game.Objects.GameCharacter;
import kom.hikeside.Game.Objects.GameClass;
import kom.hikeside.R;
import kom.hikeside.layoutCode.Fragments.StatsFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class CharacterAddFragment extends Fragment {


    public CharacterAddFragment() {
        // Required empty public constructor
    }


    GameCharacter character = new GameCharacter("NotChosen", 0, GameClass.priest, 0,0,0,0,0,0);
    Bundle args = new Bundle();
    StatsFragment statsFragment = new StatsFragment();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_character_add, container, false);



        Button button_archer = (Button) v.findViewById(R.id.button_ar);

        button_archer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                character = new GameCharacter("NotChosen", 0, GameClass.archer, 5, 10, 7, 5, 7, 7);
            }
        });

        Button button_knight = (Button) v.findViewById(R.id.button_kn);
        button_knight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                character = new GameCharacter("NotChosen", 0, GameClass.knight, 10, 5, 10, 7, 5, 7);
            }
        });

        Button button_add = (Button) v.findViewById(R.id.button_add);
        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                View v = statsFragment.getView();
                statsFragment.loadCharacterCommon(v, character);
                statsFragment.loadCharacterStats(v, character);
            }
        });






        args.putSerializable("GameCharacter", character);
        statsFragment.setArguments(args);
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.layout_select_stats, statsFragment, statsFragment.getTag()).addToBackStack(statsFragment.getTag()).commit();





        return v;
    }

}