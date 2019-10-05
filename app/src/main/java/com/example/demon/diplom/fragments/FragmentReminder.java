package com.example.demon.diplom.fragments;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.demon.diplom.MainActivity;
import com.example.demon.diplom.R;

import java.util.Calendar;

import static android.content.Context.NOTIFICATION_SERVICE;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentReminder.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentReminder#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentReminder extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Button remButton1, delButton;

    private OnFragmentInteractionListener mListener;

    public FragmentReminder() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentReminder.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentReminder newInstance(String param1, String param2) {
        FragmentReminder fragment = new FragmentReminder();
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
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rem_button1:
                // Create PendingIntent
                Intent resultIntent = new Intent(this.getActivity(), MainActivity.class);
                PendingIntent resultPendingIntent = PendingIntent.getActivity(this.getActivity(), 0, resultIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT);
                BitmapFactory.Options options = new BitmapFactory.Options();
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher, options);

// Create Notification
                NotificationCompat.Builder builder =
                        new NotificationCompat.Builder(this.getActivity())
                                .setSmallIcon(R.mipmap.ic_launcher)
                                .setContentTitle("Напоминание от Fitness App")
                                .setContentText("Настало время упражнений!")
                                .setAutoCancel(true)
                                .setLargeIcon(bitmap)
                                .setWhen(System.currentTimeMillis()+60*1000*60)
                                .setContentIntent(resultPendingIntent);

                Notification notification = builder.build();

// Show Notification
                NotificationManager notificationManager =
                        (NotificationManager) this.getActivity().getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(1, notification);
                break;
            case R.id.del_button:
                    notificationManager =
                        (NotificationManager) this.getActivity().getSystemService(NOTIFICATION_SERVICE);
                notificationManager.cancelAll();
                break;
            default: break;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reminder, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        remButton1 = getView().findViewById(R.id.rem_button1);
        remButton1.setOnClickListener(this);
        delButton = getView().findViewById(R.id.del_button);
        delButton.setOnClickListener(this);
    }

    @Override
    public void onDestroyView() {
        remButton1 = null;
        delButton = null;
        super.onDestroyView();
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
