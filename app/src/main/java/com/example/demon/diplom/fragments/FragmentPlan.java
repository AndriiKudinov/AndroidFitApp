package com.example.demon.diplom.fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.demon.diplom.DipsActivity;
import com.example.demon.diplom.PlankActivity;
import com.example.demon.diplom.PullActivity;
import com.example.demon.diplom.PushActivity;
import com.example.demon.diplom.R;
import com.example.demon.diplom.SitActivity;
import com.example.demon.diplom.SquatsActivity;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentPlan.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentPlan#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentPlan extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ImageButton push_button;
    ImageButton dips_button;
    ImageButton pull_button;
    ImageButton plank_button;
    ImageButton sit_button;
    ImageButton squats_button;
    TextView push_week, pull_week, plank_week, dips_week, sit_week, squats_week;
    SharedPreferences pref;


    private OnFragmentInteractionListener mListener;

    public FragmentPlan() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentPlan.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentPlan newInstance(String param1, String param2) {
        FragmentPlan fragment = new FragmentPlan();
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
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        push_button = (ImageButton)getView().findViewById(R.id.start_image);
        push_button.setOnClickListener(this);
        dips_button = (ImageButton)getView().findViewById(R.id.start_image4);
        dips_button.setOnClickListener(this);
        pull_button = (ImageButton)getView().findViewById(R.id.start_image2);
        pull_button.setOnClickListener(this);
        plank_button = (ImageButton)getView().findViewById(R.id.start_image3);
        plank_button.setOnClickListener(this);
        sit_button = (ImageButton)getView().findViewById(R.id.start_image5);
        sit_button.setOnClickListener(this);
        squats_button = (ImageButton)getView().findViewById(R.id.start_image6);
        squats_button.setOnClickListener(this);
        pref = this.getActivity().getSharedPreferences("days", MODE_PRIVATE);
        int savedWeekPush = pref.getInt("week_num_push", 1);
        int savedDayPush = pref.getInt("day_num_push", 1);
        int savedWeekDips = pref.getInt("week_num_dips", 1);
        int savedDayDips = pref.getInt("day_num_dips", 1);
        int savedWeekPlank = pref.getInt("week_num_plank", 1);
        int savedDayPlank = pref.getInt("day_num_plank", 1);
        int savedWeekPull = pref.getInt("week_num_pull", 1);
        int savedDayPull = pref.getInt("day_num_pull", 1);
        int savedWeekSit = pref.getInt("week_num_sit", 1);
        int savedDaySit = pref.getInt("day_num_sit", 1);
        int savedWeekSquats = pref.getInt("week_num_squats", 1);
        int savedDaySquats = pref.getInt("day_num_squats", 1);
        push_week = getView().findViewById(R.id.push_week_text);
        push_week.setText(String.format("Неделя %d - День %d", savedWeekPush, savedDayPush));
        dips_week = getView().findViewById(R.id.dips_week_text);
        dips_week.setText(String.format("Неделя %d - День %d", savedWeekDips, savedDayDips));
        plank_week = getView().findViewById(R.id.plank_week_text);
        plank_week.setText(String.format("Неделя %d - День %d", savedWeekPlank, savedDayPlank));
        pull_week = getView().findViewById(R.id.pull_week_text);
        pull_week.setText(String.format("Неделя %d - День %d", savedWeekPull, savedDayPull));
        sit_week = getView().findViewById(R.id.sit_week_text);
        sit_week.setText(String.format("Неделя %d - День %d", savedWeekSit, savedDaySit));
        squats_week = getView().findViewById(R.id.squats_week_text);
        squats_week.setText(String.format("Неделя %d - День %d", savedWeekSquats, savedDaySquats));
    }

    @Override
    public void onResume() {
        super.onResume();
        pref = this.getActivity().getSharedPreferences("days", MODE_PRIVATE);
        int savedWeekPush = pref.getInt("week_num_push", 1);
        int savedDayPush = pref.getInt("day_num_push", 1);
        int savedWeekDips = pref.getInt("week_num_dips", 1);
        int savedDayDips = pref.getInt("day_num_dips", 1);
        int savedWeekPlank = pref.getInt("week_num_plank", 1);
        int savedDayPlank = pref.getInt("day_num_plank", 1);
        int savedWeekPull = pref.getInt("week_num_pull", 1);
        int savedDayPull = pref.getInt("day_num_pull", 1);
        int savedWeekSit = pref.getInt("week_num_sit", 1);
        int savedDaySit = pref.getInt("day_num_sit", 1);
        int savedWeekSquats = pref.getInt("week_num_squats", 1);
        int savedDaySquats = pref.getInt("day_num_squats", 1);
        push_week.setText(String.format("Неделя %d - День %d", savedWeekPush, savedDayPush));
        dips_week.setText(String.format("Неделя %d - День %d", savedWeekDips, savedDayDips));
        plank_week.setText(String.format("Неделя %d - День %d", savedWeekPlank, savedDayPlank));
        pull_week.setText(String.format("Неделя %d - День %d", savedWeekPull, savedDayPull));
        sit_week.setText(String.format("Неделя %d - День %d", savedWeekSit, savedDaySit));
        squats_week.setText(String.format("Неделя %d - День %d", savedWeekSquats, savedDaySquats));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        push_button = null;
        dips_button = null;
        pull_button = null;
        plank_button = null;
        sit_button = null;
        squats_button = null;
        push_week = null;
        dips_week = null;
        plank_week = null;
        pull_week = null;
        squats_week = null;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.start_image:
                Intent intent = new Intent(getActivity(), PushActivity.class);
                startActivity(intent);
                break;
            case R.id.start_image4:
                Intent intent4 = new Intent(getActivity(), DipsActivity.class);
                startActivity(intent4);
                break;
            case R.id.start_image2:
                Intent intent2 = new Intent(getActivity(), PullActivity.class);
                startActivity(intent2);
                break;
            case R.id.start_image3:
                Intent intent3 = new Intent(getActivity(), PlankActivity.class);
                startActivity(intent3);
                break;
            case R.id.start_image5:
                Intent intent5 = new Intent(getActivity(), SitActivity.class);
                startActivity(intent5);
                break;
            case R.id.start_image6:
                Intent intent6 = new Intent(getActivity(), SquatsActivity.class);
                startActivity(intent6);
                break;
            default: break;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_plan, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    /*@Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }*/

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
