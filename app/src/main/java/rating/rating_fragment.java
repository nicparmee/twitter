package rating;

import android.app.Fragment;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.nicholasparmee.twitter.MainActivity;
import com.example.nicholasparmee.twitter.R;

/**
 * Created by nicholasparmee on 2018/07/07.
 * Under the project title Template_Kiosk_2
 */

public class rating_fragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter cAdapter;
    private RecyclerView.LayoutManager mLayoutManager;



    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_rating, container, false);

        String[] catagories = new String[3];

        catagories[0] = "Quality:";
        catagories[1] = "Friendlyness:";
        catagories[2] = "Service:";



        mRecyclerView = view.findViewById(R.id.my_recycler_view);

        mRecyclerView.setHasFixedSize(false);

        mLayoutManager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);


        cAdapter = new rating_adapter(catagories);
        mRecyclerView.setAdapter(cAdapter);



        return view;

    }


}
