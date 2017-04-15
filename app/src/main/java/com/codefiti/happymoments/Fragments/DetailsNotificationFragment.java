package com.codefiti.happymoments.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.codeifit.happymoments.R;
import de.hdodenhof.circleimageview.CircleImageView;

public class DetailsNotificationFragment extends Fragment {

    CircleImageView profileImage;
    TextView name, thankyou_text, senderName, senderText, senderVoice;
    ImageView thankyou_image, textMessageImage, voiceMessageImage;
    LinearLayout thankyouButton, textMessageLayout, voiceMessageLayout;

    public DetailsNotificationFragment() {
        // Required empty public constructor
    }


    public static DetailsNotificationFragment newInstance() {
        DetailsNotificationFragment fragment = new DetailsNotificationFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_details_notification, container, false);

        profileImage = (CircleImageView) view.findViewById(R.id.profile_image);
        name = (TextView) view.findViewById(R.id.name);
        thankyou_text = (TextView) view.findViewById(R.id.thankyou_text);
        senderName = (TextView) view.findViewById(R.id.senderName);
        senderText = (TextView) view.findViewById(R.id.senderText);
        senderVoice = (TextView) view.findViewById(R.id.senderVoice);
        thankyou_image = (ImageView) view.findViewById(R.id.thankyou_image);
        textMessageImage = (ImageView) view.findViewById(R.id.textMessageImage);
        voiceMessageImage = (ImageView) view.findViewById(R.id.voiceMessageImage);
        thankyouButton = (LinearLayout) view.findViewById(R.id.thankyouButton);
        textMessageLayout = (LinearLayout) view.findViewById(R.id.textMessageLayout);
        voiceMessageLayout = (LinearLayout) view.findViewById(R.id.voiceMessageLayout);

        thankyouButton.setOnClickListener(clickListener);
        voiceMessageImage.setOnClickListener(clickListener);

        return view;
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.thankyouButton: {



                    break;
                }
                case R.id.voiceMessageButton: {



                    break;
                }
            }
        }
    };
}
